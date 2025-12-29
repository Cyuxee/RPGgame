package Maps;

import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class AreaTest {

    @Test
    @DisplayName("shouldReturnExpectedLevelRange_whenAreaLevelIs1")
    void shouldReturnExpectedLevelRange_whenAreaLevelIs1() {
        for (int i = 0; i < 200; i++) {
            int level = Area.level(1);
            assertTrue(level >= 1 && level <= 9, "area1 level should be between 1 and 9 but was " + level);
        }
    }

    @Test
    @DisplayName("shouldReturnExpectedLevelRange_whenAreaLevelIs2")
    void shouldReturnExpectedLevelRange_whenAreaLevelIs2() {
        for (int i = 0; i < 200; i++) {
            int level = Area.level(2);
            assertTrue(level >= 10 && level <= 19, "area2 level should be between 10 and 19 but was " + level);
        }
    }

    @Test
    @DisplayName("shouldReturnExpectedLevelRange_whenAreaLevelIs3")
    void shouldReturnExpectedLevelRange_whenAreaLevelIs3() {
        for (int i = 0; i < 200; i++) {
            int level = Area.level(3);
            assertTrue(level >= 20 && level <= 29, "area3 level should be between 20 and 29 but was " + level);
        }
    }

    @Test
    @DisplayName("shouldReturnExpectedLevelRange_whenAreaLevelIs4")
    void shouldReturnExpectedLevelRange_whenAreaLevelIs4() {
        for (int i = 0; i < 200; i++) {
            int level = Area.level(4);
            assertTrue(level >= 30 && level <= 39, "area4 level should be between 30 and 39 but was " + level);
        }
    }

    @Test
    @DisplayName("shouldReturnExpectedLevelRange_whenAreaLevelIs5")
    void shouldReturnExpectedLevelRange_whenAreaLevelIs5() {
        for (int i = 0; i < 200; i++) {
            int level = Area.level(5);
            assertTrue(level >= 40 && level <= 49, "area5 level should be between 40 and 49 but was " + level);
        }
    }

    @Test
    @DisplayName("shouldReturnExpectedLevelRange_whenAreaLevelIs6")
    void shouldReturnExpectedLevelRange_whenAreaLevelIs6() {
        for (int i = 0; i < 200; i++) {
            int level = Area.level(6);
            assertTrue(level >= 50 && level <= 59, "area6 level should be between 50 and 59 but was " + level);
        }
    }

    @Test
    @DisplayName("shouldReturnExpectedLevelRange_whenAreaLevelIs7")
    void shouldReturnExpectedLevelRange_whenAreaLevelIs7() {
        for (int i = 0; i < 200; i++) {
            int level = Area.level(7);
            assertTrue(level >= 60 && level <= 69, "area7 level should be between 60 and 69 but was " + level);
        }
    }

    @Test
    @DisplayName("shouldReturnExpectedLevelRange_whenAreaLevelIs8")
    void shouldReturnExpectedLevelRange_whenAreaLevelIs8() {
        for (int i = 0; i < 200; i++) {
            int level = Area.level(8);
            assertTrue(level >= 70 && level <= 79, "area8 level should be between 70 and 79 but was " + level);
        }
    }

    @Test
    @DisplayName("shouldPickNameFromBucket_whenAreaNameIs1")
    void shouldPickNameFromBucket_whenAreaNameIs1() {
        String[] expected = {"哥布林", "草原狼", "史萊姆"};
        for (int i = 0; i < 200; i++) {
            String name = Area.name(1);
            assertTrue(name.equals(expected[0]) || name.equals(expected[1]) || name.equals(expected[2]),
                    "area1 name should be one of the first three entries but was " + name);
        }
    }

    @Test
    @DisplayName("shouldPickNameFromBucket_whenAreaNameIs2")
    void shouldPickNameFromBucket_whenAreaNameIs2() {
        String[] expected = {"領風鴞", "巨食哥布林", "厚皮野豬"};
        for (int i = 0; i < 200; i++) {
            String name = Area.name(2);
            assertTrue(name.equals(expected[0]) || name.equals(expected[1]) || name.equals(expected[2]),
                    "area2 name should be within its bucket but was " + name);
        }
    }

    @Test
    @DisplayName("shouldPickNameFromBucket_whenAreaNameIs3")
    void shouldPickNameFromBucket_whenAreaNameIs3() {
        String[] expected = {"精靈怨念", "樹妖", "狂暴蜈蚣"};
        for (int i = 0; i < 200; i++) {
            String name = Area.name(3);
            assertTrue(name.equals(expected[0]) || name.equals(expected[1]) || name.equals(expected[2]),
                    "area3 name should be within its bucket but was " + name);
        }
    }

    @Test
    @DisplayName("shouldPickNameFromBucket_whenAreaNameIs4")
    void shouldPickNameFromBucket_whenAreaNameIs4() {
        String[] expected = {"食屍鬼", "爬行者", "幽谷守衛"};
        for (int i = 0; i < 200; i++) {
            String name = Area.name(4);
            assertTrue(name.equals(expected[0]) || name.equals(expected[1]) || name.equals(expected[2]),
                    "area4 name should be within its bucket but was " + name);
        }
    }

    @Test
    @DisplayName("shouldPickNameFromBucket_whenAreaNameIs5")
    void shouldPickNameFromBucket_whenAreaNameIs5() {
        String[] expected = {"海盜", "浮空水母", "無回獅虎"};
        for (int i = 0; i < 200; i++) {
            String name = Area.name(5);
            assertTrue(name.equals(expected[0]) || name.equals(expected[1]) || name.equals(expected[2]),
                    "area5 name should be within its bucket but was " + name);
        }
    }

    @Test
    @DisplayName("shouldPickNameFromBucket_whenAreaNameIs6")
    void shouldPickNameFromBucket_whenAreaNameIs6() {
        String[] expected = {"魔族衛兵", "賞金獵人", "魔源幼獸"};
        for (int i = 0; i < 200; i++) {
            String name = Area.name(6);
            assertTrue(name.equals(expected[0]) || name.equals(expected[1]) || name.equals(expected[2]),
                    "area6 name should be within its bucket but was " + name);
        }
    }

    @Test
    @DisplayName("shouldPickNameFromBucket_whenAreaNameIs7")
    void shouldPickNameFromBucket_whenAreaNameIs7() {
        String[] expected = {"魔源幼龍", "魔族隊長", "魔源巨獸"};
        for (int i = 0; i < 200; i++) {
            String name = Area.name(7);
            assertTrue(name.equals(expected[0]) || name.equals(expected[1]) || name.equals(expected[2]),
                    "area7 name should be within its bucket but was " + name);
        }
    }

    @Test
    @DisplayName("shouldPickNameFromBucket_whenAreaNameIs8")
    void shouldPickNameFromBucket_whenAreaNameIs8() {
        String[] expected = {"魔王近衛", "魔源巨龍", "魔王分身"};
        for (int i = 0; i < 200; i++) {
            String name = Area.name(8);
            assertTrue(name.equals(expected[0]) || name.equals(expected[1]) || name.equals(expected[2]),
                    "area8 name should be within its bucket but was " + name);
        }
    }
}
