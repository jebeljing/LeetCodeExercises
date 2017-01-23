package package300;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by yinj on 1/23/2017.
 * 395. Longest Substring with At Least K Repeating Characters.
 * Find the length of the longest substring T of a given string (consists of lowercase letters only) such that every character in T appears no less than k times.

 Example 1:

 Input:
 s = "aaabb", k = 3

 Output:
 3

 The longest substring is "aaa", as 'a' is repeated 3 times.
 Example 2:

 Input:
 s = "ababbc", k = 2

 Output:
 5

 The longest substring is "ababb", as 'a' is repeated 2 times and 'b' is repeated 3 times.
 */
public class LongestSubstringWithAtLeastKRepeatingCharacters {
    //divide and conquer
    public int longestSubstring(String s, int k) {

        return helper(s, k);
    }

    private int helper(String s, int k) {
        if (s == null || s.length() == 0) return 0;
        if (k > s.length()) return 0;
        Map<Character, Integer> map = new HashMap<>();
        for (char c: s.toCharArray()) {
            Character character = new Character(c);
            if (!map.containsKey(character)) {
                map.put(character, 1);
            } else {
                map.put(character, map.get(character) + 1);
            }
        }

        Character breakCharacter = null;
        for (Character key: map.keySet()) {
            if (map.get(key) < k) {
                breakCharacter = key;
            }
        }
        if (breakCharacter == null) {
            return s.length();
        }
        int index = s.indexOf(breakCharacter.charValue());
        return Math.max(helper(s.substring(0, index), k), helper(s.substring(index + 1), k));
    }
}
