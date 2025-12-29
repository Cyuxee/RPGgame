package Events;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import Entities.Mobs;
import Entities.Players;

class BattleOutcomeBehaviorTest {

    @Test
    @DisplayName("shouldReduceTargetHp_whenApplyingOneAttack")
    void shouldReduceTargetHp_whenApplyingOneAttack() {
        Players attacker = new Players(true);
        attacker.setLevel(10);
        attacker.setDamage(60);

        Mobs target = new Mobs();
        target.setName("測試怪物");
        target.setLevel(5);
        target.setArmor(5);
        target.setMaxHealth(200);
        target.setHealth(200);

        int beforeHp = target.getHealth();

        int dealt = DamageEvent.damageTo(attacker, target, false, null, () -> 0.0);

        assertTrue(dealt > 0);
        assertEquals(beforeHp - dealt, target.getHealth());
    }

    @Test
    @DisplayName("shouldGrantExpToPlayer_whenMobKilled")
    void shouldGrantExpToPlayer_whenMobKilled() {
        Players p = new Players(true);
        p.setExp(0);

        Mobs mob = new Mobs();
        mob.setHealth(0);
        mob.setExp(321);

        GetExpEvent.combatGetExp(p, mob);

        assertEquals(321.0, p.getExp());
    }

    @Test
    @DisplayName("shouldRemainDead_whenAttackingAlreadyDeadTarget")
    void shouldRemainDead_whenAttackingAlreadyDeadTarget() {
        Players attacker = new Players(true);
        attacker.setLevel(10);
        attacker.setDamage(60);

        Mobs dead = new Mobs();
        dead.setName("已死亡怪物");
        dead.setLevel(1);
        dead.setArmor(0);
        dead.setMaxHealth(10);
        dead.setHealth(0);

        assertTrue(DeathEvent.mobDeath(dead));

        DamageEvent.damageTo(attacker, dead, false, null, () -> 0.0);

        assertTrue(DeathEvent.mobDeath(dead));
    }
}
