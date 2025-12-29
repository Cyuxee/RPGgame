package Entities;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import Events.DamageEvent;
import Events.DeathEvent;

class DeathAndHpBehaviorTest {

    @Test
    @DisplayName("shouldDecreaseHp_whenPlayerTakesDamage")
    void shouldDecreaseHp_whenPlayerTakesDamage() {
        Players player = new Players(true);
        player.setArmor(10);
        player.setHealth(100);

        Mobs mob = new Mobs();
        mob.setName("測試怪物");
        mob.setDamage(50);

        int before = player.getHealth();
        int dealt = DamageEvent.damageTo(mob, player, null, () -> 0.0);

        assertTrue(dealt > 0);
        assertEquals(before - dealt, player.getHealth());
    }

    @Test
    @DisplayName("shouldReportDead_whenHpAtOrBelowZero")
    void shouldReportDead_whenHpAtOrBelowZero() {
        Players player = new Players(true);
        player.setHealth(0);
        assertTrue(DeathEvent.playerDeath(player));

        player.setHealth(-1);
        assertTrue(DeathEvent.playerDeath(player));
    }
}
