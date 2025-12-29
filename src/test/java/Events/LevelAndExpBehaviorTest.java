package Events;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import Entities.Mobs;
import Entities.Players;

class LevelAndExpBehaviorTest {

    @Test
    @DisplayName("shouldAddExp_whenMobIsDead")
    void shouldAddExp_whenMobIsDead() {
        Players p = new Players(true);
        p.setExp(0);

        Mobs mob = new Mobs();
        mob.setHealth(0);
        mob.setExp(123);

        GetExpEvent.combatGetExp(p, mob);

        assertEquals(123.0, p.getExp());
    }

    @Test
    @DisplayName("shouldNotAddExp_whenMobIsAlive")
    void shouldNotAddExp_whenMobIsAlive() {
        Players p = new Players(true);
        p.setExp(10);

        Mobs mob = new Mobs();
        mob.setHealth(1);
        mob.setExp(999);

        GetExpEvent.combatGetExp(p, mob);

        assertEquals(10.0, p.getExp());
    }

    @Test
    @DisplayName("shouldLevelUpOnceAndKeepOverflowExp_whenExpIsBelowNextThreshold")
    void shouldLevelUpOnceAndKeepOverflowExp_whenExpIsBelowNextThreshold() {
        Players p = new Players(true);
        p.setLevel(1);
        p.updataPlayerStatus();

        double thresholdL1 = p.getMaxExp();

        // Compute the next threshold via public API (no hardcoded formula)
        Players probe = new Players(true);
        probe.setLevel(2);
        probe.updataPlayerStatus();
        double thresholdL2 = probe.getMaxExp();

        // Choose an overflow that is guaranteed to be < next threshold
        double overflow = Math.max(1.0, Math.floor(thresholdL2) - 1.0);

        p.setExp(thresholdL1 + overflow);
        int beforeLevel = p.getLevel();
        int beforeStatusPoint = p.getStatusPoint();

        int ups = LevelChangeEvent.applyLevelUpsNoUi(p);

        assertEquals(1, ups);
        assertEquals(beforeLevel + 1, p.getLevel());
        assertEquals(beforeStatusPoint + 5, p.getStatusPoint());
        assertEquals(overflow, p.getExp());
        assertTrue(p.getExp() < p.getMaxExp());
    }

    @Test
    @DisplayName("shouldLevelUpTwiceAndKeepOverflowExp_whenExpCoversTwoThresholds")
    void shouldLevelUpTwiceAndKeepOverflowExp_whenExpCoversTwoThresholds() {
        Players p = new Players(true);
        p.setLevel(1);
        p.updataPlayerStatus();

        double thresholdL1 = p.getMaxExp();

        Players probe = new Players(true);
        probe.setLevel(2);
        probe.updataPlayerStatus();
        double thresholdL2 = probe.getMaxExp();

        double overflow = 10.0;
        p.setExp(thresholdL1 + thresholdL2 + overflow);

        int beforeLevel = p.getLevel();
        int beforeStatusPoint = p.getStatusPoint();

        int ups = LevelChangeEvent.applyLevelUpsNoUi(p);

        assertEquals(2, ups);
        assertEquals(beforeLevel + 2, p.getLevel());
        assertEquals(beforeStatusPoint + 10, p.getStatusPoint());
        assertEquals(overflow, p.getExp());
        assertTrue(p.getExp() < p.getMaxExp());
    }

    @Test
    @DisplayName("shouldAllowMultipleLevelUps_whenGainingLargeExp")
    void shouldAllowMultipleLevelUps_whenGainingLargeExp() {
        Players p = new Players(true);
        p.setLevel(1);
        p.updataPlayerStatus();

        p.setExp(10_000);
        int beforeLevel = p.getLevel();

        int ups = LevelChangeEvent.applyLevelUpsNoUi(p);

        assertTrue(ups >= 2, "Expected multiple level-ups but got: " + ups);
        assertEquals(beforeLevel + ups, p.getLevel());
        assertTrue(p.getExp() >= 0);
        assertTrue(p.getExp() < p.getMaxExp());
    }
}
