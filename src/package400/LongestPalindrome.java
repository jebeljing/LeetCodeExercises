package package400;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by jingshanyin on 11/23/16.
 * 409. Longest Palindrome
 *
 * Given a string which consists of lowercase or uppercase letters, find the length of the longest palindromes that can be built with those letters.

 This is case sensitive, for example "Aa" is not considered a palindrome here.

 Note:
 Assume the length of given string will not exceed 1,010.

 Example:

 Input:
 "abccccdd"

 Output:
 7

 Explanation:
 One longest palindrome that can be built is "dccaccd", whose length is 7.
 */
public class LongestPalindrome {

    public int longestPalindrome(String s) {
        if (s == null || s.length() == 0) return 0;
        if (s.length() == 1) return 1;
        Map<Character, Integer> map = new HashMap<>();

        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.keySet().contains(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }
        int result = 0;
        int temp= 0;
        boolean plus = false;
        for (Character key: map.keySet()) {
            temp = map.get(key);
            if (temp % 2 == 0) {
                result += temp;
            } else {
                result += temp/2 * 2;
                plus = true;
            }
        }
        if (plus){
            result++;
        }
        return result;
    }
}
