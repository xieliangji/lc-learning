package xieliangji.lc.dp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
 * <p>
 * 示例 1:
 * <p>
 * 输入: s = "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 * <p>
 * 输入: s = "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 * <p>
 * 输入: s = "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 * 请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 */
public class LongestSubstringWithoutRepeatedCharacter {


    // original

    /**
     * DP思路：新增一个字符的字符串，从后面往前找不重复的字串，找到了的话就是这个没找到的化就是未新增字符的字符串的最长子字符串
     * DP方程：f(str<1>) = str<1>, k = 1, f(str<n>) = max{f(str<n-1>), x}, k = n
     *
     * @param arg 源字符串
     * @return 最长无重复字符的子串
     */
    public static String longestSubstringWithoutRepeatedCharacter(String arg) {
        if (null == arg || "".equals(arg)) {
            return "";
        }
        StringBuilder argument = new StringBuilder(arg);
        List<String> longestList = new ArrayList<>();
        longestList.add(argument.substring(0, 1)); // n = 1


        int len = argument.length();
        // 从索引1开始迭代子串
        for (int index = 1; index < len; index++) {
            String current = argument.substring(0, index + 1);
            StringBuilder sb = new StringBuilder();
            // 当前子串从尾往前扫描判断
            for (int currentIndex = current.length() - 1; currentIndex >= 0; currentIndex--) {
                char ch = current.charAt(currentIndex);
                if (sb.indexOf(String.valueOf(ch)) == -1) {
                    sb.insert(0, ch);
                    if (currentIndex != 0) {
                        continue;
                    }
                }
                String currentPre = longestList.get(index - 1);
                if (sb.length() > currentPre.length()) {
                    longestList.add(sb.toString());
                } else {
                    longestList.add(currentPre);
                }
                break;
            }
        }
        return longestList.get(longestList.size() - 1);
    }

    // 如果只是计算最大长度
    // 迭代每个字符，找到该字符重复时的最大长度
    public static int lengthOfLongestSubstringWithoutRepeatedChar(String arg) {
        if (null == arg) {
            return 0;
        }

        Map<Character, Integer> store = new HashMap<>();
        int len = arg.length();
        int max = 0, start = 0;
        for (int index = 0; index < len; index++) {
            char ch = arg.charAt(index);
            if (store.containsKey(ch)) {
                start = Math.max(start, store.get(ch) + 1);
            }
            store.put(ch, index);
            max = Math.max(max, index - start + 1);
        }
        return max;
    }
}
