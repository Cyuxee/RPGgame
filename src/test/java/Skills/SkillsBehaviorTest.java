package Skills;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import Entities.Players;
import Skills.SkillPackage.FireBall;
import Skills.SkillPackage.NormalAttack;

class SkillsBehaviorTest {

    @Test
    @DisplayName("shouldCreateNormalAttackWithExpectedStats_whenConstructed")
    void shouldCreateNormalAttackWithExpectedStats_whenConstructed() {
        Players p = new Players(true);
        p.setLevel(2);

        NormalAttack s = new NormalAttack(p);

        assertEquals("普通攻擊", s.getName());
        assertEquals(0, s.getMpCost());
        assertEquals(0, s.getCool());
        assertTrue(Math.abs(s.getDamage() - (2 * 20.4)) < 1e-9);
    }

    @Test
    @DisplayName("shouldCreateFireBallWithExpectedMetadata_whenConstructed")
    void shouldCreateFireBallWithExpectedMetadata_whenConstructed() {
        Players p = new Players(true);
        p.setPlayer("測試玩家");

        FireBall s = new FireBall(p);

        assertEquals("火球術", s.getName());
        assertEquals(10, s.getMpCost());
        assertEquals(3, s.getCool());
        assertEquals(80.0, s.getSkillHit());
        assertEquals(1.2, s.getDamage());
    }

    @Test
    @DisplayName("shouldCreateCorrectSkillById_whenUsingFactory")
    void shouldCreateCorrectSkillById_whenUsingFactory() {
        Players p = new Players(true);

        Skills s0 = Skills.getDataSkillsCreate(p, 0);
        Skills s1 = Skills.getDataSkillsCreate(p, 1);

        assertEquals("普通攻擊", s0.getName());
        assertEquals("火球術", s1.getName());
    }
}
