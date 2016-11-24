package package300;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by jingshanyin on 11/23/16.
 * 345. Reverse Vowels of a String
 *
 * Write a function that takes a string as input and reverse only the vowels of a string.

 Example 1:
 Given s = "hello", return "holle".

 Example 2:
 Given s = "leetcode", return "leotcede".

 Note:
 The vowels does not include the letter "y".
 */
public class ReverseVowelsOfAString {

    public String reverseVowels(String s) {
        Set<Character> set = new HashSet<>();
        set.add('A'); set.add('a');
        set.add('E'); set.add('e');
        set.add('I'); set.add('i');
        set.add('O'); set.add('o');
        set.add('U'); set.add('u');
        int i = 0;
        int j = s.length() - 1;
        char temp = '0';
        char[] chars = s.toCharArray();
        while (i < j) {
            if (set.contains(chars[i]) && set.contains(chars[j])) {
                temp = chars[j];
                chars[j] = chars[i];
                chars[i] = temp;
                i++; j--;
            } else if (!set.contains(chars[i]) && set.contains(chars[j])) {
                i++;
            } else if (set.contains(chars[i]) && !set.contains(chars[j])) {
                j--;
            } else {
                i++; j--;
            }
        }
        return new String(chars);
    }
}
