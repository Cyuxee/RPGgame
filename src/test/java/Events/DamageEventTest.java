package Events;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import Entities.Mobs;
import Entities.Players;

class DamageEventTest {

    private static class FakeHPMPView implements HPMPView {
        int playerHp;
        int mobHp;
        boolean playerUpdated;
        boolean mobUpdated;

        @Override
        public void updatePlayer(Players player) {
            playerUpdated = true;
            playerHp = player.getHealth();
        }

        @Override
        public void updateMob(Mobs mob) {
            mobUpdated = true;
            mobHp = mob.getHealth();
        }
    }

    @Test
    @DisplayName("shouldUpdatePlayerHpAndView_whenMobDamagesPlayer")
    void shouldUpdatePlayerHpAndView_whenMobDamagesPlayer() {
        Players player = new Players(true);
        player.setArmor(10);
        int initialHp = player.getHealth();

        Mobs mob = new Mobs();
        mob.setDamage(50);

        FakeHPMPView view = new FakeHPMPView();

        int dealt = DamageEvent.damageTo(mob, player, view, () -> 0.0);

        assertTrue(dealt > 0);
        assertEquals(initialHp - player.getHealth(), dealt,
                "Returned damage should equal HP lost");
        assertTrue(view.playerUpdated);
        assertEquals(player.getHealth(), view.playerHp,
                "View should see the same HP as the model");
    }

    @Test
    @DisplayName("shouldUpdateMobHpAndView_whenPlayerDamagesMob_nonCrit")
    void shouldUpdateMobHpAndView_whenPlayerDamagesMob_nonCrit() {
        Players player = new Players(true);
        player.setDamage(40);
        player.setLevel(10);

        Mobs mob = new Mobs();
        mob.setArmor(5);
        mob.setLevel(5);
        mob.setHealth(200);
        mob.setMaxHealth(200);
        int initialHp = mob.getHealth();

        FakeHPMPView view = new FakeHPMPView();

        int dealt = DamageEvent.damageTo(player, mob, false, view, () -> 0.0);

        assertTrue(dealt > 0);
        assertEquals(initialHp - mob.getHealth(), dealt,
                "Returned damage should equal HP lost");
        assertTrue(view.mobUpdated);
        assertEquals(mob.getHealth(), view.mobHp,
                "View should see the same HP as the model");
    }
}
