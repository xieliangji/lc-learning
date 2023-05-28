package xieliangji.lc.dp;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class TestLongestSubstringWithoutRepeatedCharacter {

    @ParameterizedTest
    @DisplayName("测试最长子串")
    @ValueSource(strings = {"abcabcbb", "bbbbb", "pwwkew"})
    void testLongestSubstringWithoutRepeatedCharacter(String argument) {
        String l = LongestSubstringWithoutRepeatedCharacter.longestSubstringWithoutRepeatedCharacter(argument);
        System.out.println();
        System.out.printf("longest: %s \n", l);
    }

    @Test
    void testLoop() {
        for (int index = 0; index < 3; index++) {
            for (int i = 0; i < 3; i++) {
                if (i == 1) {
                    continue;
                }
                System.out.println("i: " + i + ", index: " + index);
            }
        }
    }
}
