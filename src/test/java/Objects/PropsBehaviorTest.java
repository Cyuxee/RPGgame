package Objects;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import Entities.Players;
import Objects.PropsPackage.healer10;
import Objects.PropsPackage.mpHealer10;

class PropsBehaviorTest {

    @BeforeAll
    static void enableHeadlessMode() {
        // Prevent JavaFX Image/Background creation in Objects.makeBG
        System.setProperty("rpg.headless", "true");
    }

    @Test
    @DisplayName("shouldRestoreHpToMax_whenUsingHealer10")
    void shouldRestoreHpToMax_whenUsingHealer10() {
        Players p = new Players(true);
        p.setMaxHealth(123);
        p.setHealth(1);

        healer10 potion = new healer10(p);
        assertEquals(123, potion.getHealAmount());

        potion.Heal();
        assertEquals(123, p.getHealth());
    }

    @Test
    @DisplayName("shouldRestoreMpToMax_whenUsingMpHealer10")
    void shouldRestoreMpToMax_whenUsingMpHealer10() {
        Players p = new Players(true);
        p.setMaxMana(77);
        p.setMana(0);

        mpHealer10 potion = new mpHealer10(p);
        assertEquals(77, potion.getHealAmount());

        potion.Heal();
        assertEquals(77, p.getMana());
    }
}
