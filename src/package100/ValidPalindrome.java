package package100;

/**
 * Created by Jebeljing on 11/28/2016.
 * 125. Valid Palindrome
 *
 *  Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

 For example,
 "A man, a plan, a canal: Panama" is a palindrome.
 "race a car" is not a palindrome.

 Note:
 Have you consider that the string might be empty? This is a good question to ask during an interview.

 For the purpose of this problem, we define empty string as valid palindrome.
 */
public class ValidPalindrome {

    public boolean isPalindrome(String s) {
        if (s == null || s.isEmpty()) return true;

        s = s.toLowerCase();
        int head = 0, tail = s.length() - 1;
        while (head < tail) {
            char c1 = s.charAt(head);
            char c2 = s.charAt(tail);
            if (Character.isLetterOrDigit(c1) && Character.isLetterOrDigit(c2)) {
                if (c1 != c2){
                    return false;
                } else {
                    head++;
                    tail--;
                }
            } else if (!Character.isLetterOrDigit(c1)) {
                head++;
            } else  {
                tail--;
            }

        }
        return true;
    }
}
