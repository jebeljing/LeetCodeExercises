package package100;

/**
 * Created by jingshanyin on 12/10/16.
 * 151. Reverse Words in a String
 *
 * Given an input string, reverse the string word by word.

 For example,
 Given s = "the sky is blue",
 return "blue is sky the".

 Update (2015-02-12):
 For C programmers: Try to solve it in-place in O(1) space.
 */
public class ReverseWordsInAString {

    public String reverseWords(String s) {
        if (s == null || s.length() == 0) return "";
        String[] strs = s.trim().split("\\s+");
        StringBuilder sb = new StringBuilder();
        for (int i = strs.length - 1; i >=0; i--) {
            sb.append(strs[i]).append(" ");
        }
        return sb.toString().trim();
    }
}
