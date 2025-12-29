package Events;

import Entities.Mobs;
import Entities.Players;
import GUI.GUI;
import javafx.application.Platform;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

/**
 * Shared combat helpers to keep turn resolution logic consistent between
 * different battle event implementations.
 */
public final class CombatFlowHelper {

    private CombatFlowHelper() {
    }

    public static void disableControls(Button attack, Button props, Button skills, Button run) {
        Platform.runLater(() -> {
            if (attack != null) {
                attack.setDisable(true);
            }
            if (props != null) {
                props.setDisable(true);
            }
            if (skills != null) {
                skills.setDisable(true);
            }
            if (run != null) {
                run.setDisable(true);
            }
        });
    }

    public static void enableControls(Button attack, Button props, Button skills, Button run) {
        Platform.runLater(() -> {
            if (attack != null) {
                attack.setDisable(false);
            }
            if (props != null) {
                props.setDisable(false);
            }
            if (skills != null) {
                skills.setDisable(false);
            }
            if (run != null) {
                run.setDisable(false);
            }
        });
    }

    public static void resetMobFreeze(Mobs mob) {
        if (mob != null) {
            mob.setIsIced(false);
        }
    }

    public static void updateSkillCooldowns(Players player) {
        if (player == null) {
            return;
        }
        for (int i = 0; i < player.getSkills().size(); i++) {
            if (!player.getSkills().get(i).isCanBeApply()) {
                if (player.getSkills().get(i).getNowCooldown() >= player.getSkills().get(i).getCool() - 1) {
                    player.getSkills().get(i).setCanBeApply(true);
                    player.getSkills().get(i).setNowCooldown(-1);
                } else {
                    player.getSkills().get(i).setNowCooldown(player.getSkills().get(i).getNowCooldown() + 1);
                }
            }
        }
    }

    public static void performMobAttack(AnchorPane ap, Players player, Mobs mob, Label mobSprite,
                                        double distance, int preReturnDelayMs, int postDamageDelayMs) {
        if (ap == null || player == null || mob == null || mobSprite == null) {
            return;
        }
        if (mob.getHealth() <= 0 || mob.getIsIced()) {
            return;
        }

        double originX = mobSprite.getLayoutX();
        Platform.runLater(() -> GUI.move2(mobSprite, distance));
        sleep(preReturnDelayMs);
        Platform.runLater(() -> mobSprite.setLayoutX(originX));

        if ((int) (Math.random() * 99) <= player.getEscape()) {
            startDisplayThread(new damageDisplayEvent(ap, damageDisplayEvent.DisplayType.MOB_MISS, 0));
        } else {
            startDisplayThread(new damageDisplayEvent(ap, damageDisplayEvent.DisplayType.MOB_DAMAGE,
                    DamageEvent.damageTo(mob, player)));
        }

        sleep(postDamageDelayMs);
    }

    public static void resolveStatusOrEnable(Players player, Mobs mob, Button attack, Button props, Button skills,
                                             Button run, int times, double distance) {
        if (player != null && mob != null && (!player.getBuffs().isEmpty() || !mob.getBuffs().isEmpty())) {
            statusThread stt = new statusThread(attack, props, skills, run, times, distance, mob);
            stt.run();
            return;
        }
        BattleEvent.updateCombatCount();
        enableControls(attack, props, skills, run);
    }

    private static void startDisplayThread(Runnable runnable) {
        Thread t = new Thread(runnable);
        t.start();
    }

    private static void sleep(int millis) {
        if (millis <= 0) {
            return;
        }
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
