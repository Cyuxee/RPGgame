package Entities;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PlayersTest {

    @Test
    @DisplayName("shouldRecalculateDerivedStats_whenUpdatePlayerStatusCalled")
    void shouldRecalculateDerivedStats_whenUpdatePlayerStatusCalled() {
        Players p = new Players(true);

        // Act
        p.updataPlayerStatus();

        // Assert core derived stats (rounded where casting is used in production)
        assertEquals(117, p.getMaxHealth());
        assertEquals(117, p.getHealth()); // clamped down from initial 200
        assertEquals(72, p.getMaxMana());
        assertEquals(72, p.getMana());    // clamped down from initial 200

        assertEquals(0, p.getArmor());
        assertEquals(11, p.getDamage());
        assertEquals(22, p.getMagicDamage());
        assertEquals(11, p.getTotalDamage());

        assertEquals(5, p.getBoom());
        assertEquals(5, p.getEscape());
        assertEquals(95, p.getHit());
        assertEquals(18, p.getMaxExp());

        assertEquals(0, p.getTotalSTR());
        assertEquals(0, p.getTotalINT());
        assertEquals(0, p.getTotalLUK());
        assertEquals(0, p.getTotalAGI());

        // boomAttackRate is double; allow tiny epsilon
        assertTrue(Math.abs(p.getBoomAttackRate() - 1.501) < 1e-6,
                "boomAttackRate should be ~1.501 but was " + p.getBoomAttackRate());
    }

    @Test
    @DisplayName("shouldRestoreHpAndMpToMax_whenHealMethodsCalled")
    void shouldRestoreHpAndMpToMax_whenHealMethodsCalled() {
        Players p = new Players(true);
        p.updataPlayerStatus();

        // simulate damage and mana usage
        p.setHealth(p.getMaxHealth() - 50);
        p.setMana(p.getMaxMana() - 30);

        p.heal();
        p.mpHeal();

        assertEquals(p.getMaxHealth(), p.getHealth());
        assertEquals(p.getMaxMana(), p.getMana());
    }

    @Test
    @DisplayName("shouldSetAndGetLevelAndExp_whenUsingSetters")
    void shouldSetAndGetLevelAndExp_whenUsingSetters() {
        Players p = new Players(true);
        p.setLevel(10);
        p.setExp(123.45);
        p.setMaxExp(999.0);

        assertEquals(10, p.getLevel());
        assertEquals(123.45, p.getExp());
        assertEquals(999.0, p.getMaxExp());
    }
}
