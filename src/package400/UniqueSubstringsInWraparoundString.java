package package400;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by jingshanyin on 12/16/16.
 * 467. Unique Substring in Wraparound String
 * Consider the string s to be the infinite wraparound string of "abcdefghijklmnopqrstuvwxyz", so s will look like this: "...zabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcd....".

 Now we have another string p. Your job is to find out how many unique non-empty substrings of p are present in s. In particular, your input is the string p and you need to output the number of different non-empty substrings of p in the string s.

 Note: p consists of only lowercase English letters and the size of p might be over 10000.

 Example 1:
 Input: "a"
 Output: 1

 Explanation: Only the substring "a" of string "a" is in the string s.
 Example 2:
 Input: "cac"
 Output: 2
 Explanation: There are two substrings "a", "c" of string "cac" in the string s.
 Example 3:
 Input: "zab"
 Output: 6
 Explanation: There are six substrings "z", "a", "b", "za", "ab", "zab" of string "zab" in the string s.
 */
public class UniqueSubstringsInWraparoundString {

    public int findSubstringInWraproundString2(String p) {
        int[] count = new int[26];
        int len = 0;

        for (int i = 0; i < p.length(); i++) {
            if (i > 0 && (p.charAt(i) - p.charAt(i - 1) == 1 || p.charAt(i) - p.charAt(i - 1) == -25)) {
                len++;
            } else {
                len = 1;
            }
            int index = p.charAt(i) - 'a';
            count[index] = Math.max(count[index], len);
        }

        int sum = 0;
        for (int idx = 0; idx < 26; idx++) {
            sum+=count[idx];
        }
        return sum;
    }

    //Bruce Force
    public int findSubstringInWraproundString(String p) {
        if (p == null || p.length() == 0) return 0;
        if (p.length() == 1) return 1;
        Set<String> subStrs = new HashSet<>();
        for (int i = 0; i < p.length(); i++) {
            for (int j = i + 1; j <= p.length(); j++) {

                String tempStr = p.substring(i, j);
                if (tempStr.length() == 1) {
                    subStrs.add(tempStr);
                    continue;
                }
                boolean nextOne = false;
                char[] chars = tempStr.toCharArray();

                for (int idx = 1; idx < chars.length; idx++) {
                    if (chars[idx] - chars[idx - 1] != 1 && chars[idx] - chars[idx - 1] != -25) {
                        nextOne = true;
                        break;
                    }
                }
                if (nextOne) {
                    break;
                } else {
                    subStrs.add(tempStr);
                }
            }
        }
        return subStrs.size();
    }
}
