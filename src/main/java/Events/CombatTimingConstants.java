package Events;

/**
 * Centralized timing constants for combat animations and delays.
 * Modify these values to adjust game feel and pacing globally.
 */
public final class CombatTimingConstants {
    private CombatTimingConstants() {
        // Prevent instantiation
    }
    
    /** Initial delay before combat action (ms) */
    public static final int COMBAT_ACTION_DELAY = 200;
    
    /** Delay for movement animation (ms) */
    public static final int MOVEMENT_ANIMATION_DELAY = 300;
    
    /** Delay for damage display animation (ms) */
    public static final int DAMAGE_DISPLAY_DELAY = 10;
    
    /** Delay for status update (ms) */
    public static final int STATUS_UPDATE_DELAY = 300;
    
    /** Delay for level up animation (ms) */
    public static final int LEVEL_UP_ANIMATION_DELAY = 70;
    
    /** Delay for player status display (ms) */
    public static final int PLAYER_STATUS_DISPLAY_DELAY = 20;
    
    /** Short delay for status updates (ms) */
    public static final int STATUS_SHORT_DELAY = 10;
}
