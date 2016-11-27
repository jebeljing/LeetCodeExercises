package package400;

/**
 * Created by Jebeljing on 11/27/2016.
 * 459. Repeated Substring Pattern
 *
 * Given a non-empty string check if it can be constructed by taking a substring of it and appending multiple copies of the substring together. You may assume the given string consists of lowercase English letters only and its length will not exceed 10000.

 Example 1:

 Input: "abab"

 Output: True

 Explanation: It's the substring "ab" twice.

 Example 2:

 Input: "aba"

 Output: False

 Example 3:

 Input: "abcabcabcabc"

 Output: True

 Explanation: It's the substring "abc" four times. (And the substring "abcabc" twice.)

 */
public class RepeatedSubstringPattern {

    public boolean repeatedSubstringPattern(String str) {
        int len = str.length();
        for (int i = len/2; i>=1; i--) {
            if (len%i == 0) {
                int m = len / i;
                String subString = str.substring(0, i);
                int j = 1;
                for (; j < m; j++) {
                    if (!subString.equals(str.substring(j*i, j*i + i))) break;
                }
                if (j == m) return true;
            }
        }
        return false;
    }
}
