package Events;

import Entities.Mobs;
import Entities.Players;
import Objects.Objects;
import Skills.Skills;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Rectangle;

/**
 * Factory for creating battle action events.
 * Reduces coupling between BattleEvent and event implementations.
 * Encapsulates battle action creation logic.
 */
public class BattleActionFactory {
    
    /**
     * Creates a normal attack action.
     */
    public static Runnable createAttackAction(
            AnchorPane combating,
            Rectangle health,
            Label damage1,
            Label damage2,
            Button attack,
            Button propb,
            Button skills,
            Button run,
            Players player,
            Mobs mob,
            Label friends,
            Label enemys) {
        return new BattleMoveEvent(
            combating, health, damage1, damage2, attack, propb, skills, run,
            player, mob, friends, 250, enemys, -250);
    }
    
    /**
     * Creates a run/escape action.
     */
    public static Runnable createRunAction(
            AnchorPane combating,
            Button attack,
            Button propb,
            Button skills,
            Button run,
            Label damage1,
            Label damage2,
            Players player,
            Mobs mob,
            Label friends,
            Label enemys) {
        return new runDamageEvent(
            combating, attack, propb, skills, run, damage1, damage2,
            player, mob, friends, enemys, 250, -250, 1, 10, 20);
    }
    
    /**
     * Creates a prop/item usage action.
     */
    public static Runnable createPropAction(
            AnchorPane combating,
            Objects prop,
            Button attack,
            Button propb,
            Button skills,
            Button run,
            Label damage1,
            Label damage2,
            Players player,
            Mobs mob,
            Label friends,
            Label enemys) {
        return new propsEvent(
            combating, prop, attack, propb, skills, run, damage1, damage2,
            player, mob, friends, enemys, 250, -250, 1, 10, 20);
    }
    
    /**
     * Creates a skill usage action.
     */
    public static Runnable createSkillAction(
            int skillIndex,
            AnchorPane combating,
            Skills skill,
            Rectangle health,
            Label damage1,
            Label damage2,
            Button attack,
            Button propb,
            Button skills,
            Button run,
            Players player,
            Mobs mob,
            Label friends,
            Label enemys) {
        return new BattleSkillMoveEvent(
            skillIndex, combating, skill, health, damage1, damage2, attack, propb, skills, run,
            player, mob, friends, 250, enemys, -250);
    }
}
