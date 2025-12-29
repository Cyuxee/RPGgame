package Events;

import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import Entities.Mobs;
import Entities.Players;

class DamageMonotonicityTest {

    @Test
    @DisplayName("shouldNotDecreaseDamage_whenAttackerDamageIncreases")
    void shouldNotDecreaseDamage_whenAttackerDamageIncreases() {
        Mobs mob = new Mobs();
        mob.setArmor(5);
        mob.setLevel(5);
        mob.setHealth(1000);
        mob.setMaxHealth(1000);

        Players low = new Players(true);
        low.setLevel(10);
        low.setDamage(40);

        Players high = new Players(true);
        high.setLevel(10);
        high.setDamage(60);

        int dealtLow = DamageEvent.damageTo(low, mob, false, null, () -> 0.0);

        // reset mob HP for the second measurement
        mob.setHealth(1000);
        int dealtHigh = DamageEvent.damageTo(high, mob, false, null, () -> 0.0);

        assertTrue(dealtHigh >= dealtLow,
                "Expected higher attack to not reduce damage (low=" + dealtLow + ", high=" + dealtHigh + ")");
    }

    @Test
    @DisplayName("shouldNotIncreaseDamage_whenDefenderArmorIncreases")
    void shouldNotIncreaseDamage_whenDefenderArmorIncreases() {
        Players p = new Players(true);
        p.setLevel(10);
        p.setDamage(60);

        Mobs lowArmor = new Mobs();
        lowArmor.setArmor(5);
        lowArmor.setLevel(5);
        lowArmor.setHealth(1000);
        lowArmor.setMaxHealth(1000);

        Mobs highArmor = new Mobs();
        highArmor.setArmor(30);
        highArmor.setLevel(5);
        highArmor.setHealth(1000);
        highArmor.setMaxHealth(1000);

        int dealtLowArmor = DamageEvent.damageTo(p, lowArmor, false, null, () -> 0.0);
        int dealtHighArmor = DamageEvent.damageTo(p, highArmor, false, null, () -> 0.0);

        assertTrue(dealtHighArmor <= dealtLowArmor,
                "Expected higher armor to not increase damage (lowArmor=" + dealtLowArmor + ", highArmor=" + dealtHighArmor + ")");
    }
}
