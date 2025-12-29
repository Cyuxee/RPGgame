package Events;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import Entities.Mobs;
import Entities.Players;

class DamageGoldenMasterTest {

    @Test
    @DisplayName("shouldMatchKnownDamageOutput_whenMobAttacksPlayer_fixedRng")
    void shouldMatchKnownDamageOutput_whenMobAttacksPlayer_fixedRng() {
        Players player = new Players(true);
        player.setPlayer("P");
        player.setArmor(10);
        player.setMaxHealth(100);
        player.setHealth(100);

        Mobs mob = new Mobs();
        mob.setName("M");
        mob.setDamage(50);

        int dealt = DamageEvent.damageTo(mob, player, null, () -> 0.0);

        assertEquals(41, dealt);
        assertEquals(59, player.getHealth());
    }

    @Test
    @DisplayName("shouldMatchKnownDamageOutput_whenPlayerAttacksMob_fixedRng")
    void shouldMatchKnownDamageOutput_whenPlayerAttacksMob_fixedRng() {
        Players player = new Players(true);
        player.setPlayer("P");
        player.setLevel(10);
        player.setDamage(40);

        Mobs mob = new Mobs();
        mob.setName("M");
        mob.setLevel(5);
        mob.setArmor(5);
        mob.setMaxHealth(200);
        mob.setHealth(200);

        int dealt = DamageEvent.damageTo(player, mob, false, null, () -> 0.0);

        assertEquals(35, dealt);
        assertEquals(165, mob.getHealth());
    }
}
