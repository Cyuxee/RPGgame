package Events;

import Entities.Mobs;
import Entities.Players;

/**
 * Small abstraction for updating HP/MP-related UI state.
 *
 * Production code can implement this using real JavaFX controls,
 * while tests can provide fake implementations that only track values.
 */
public interface HPMPView {

    void updatePlayer(Players player);

    void updateMob(Mobs mob);
}
