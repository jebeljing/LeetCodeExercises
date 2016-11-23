package package400;

/**
 * Created by jingshanyin on 11/23/16.
 * 415. Add Strings
 *
 * Given two non-negative numbers num1 and num2 represented as string, return the sum of num1 and num2.

 Note:

 The length of both num1 and num2 is < 5100.
 Both num1 and num2 contains only digits 0-9.
 Both num1 and num2 does not contain any leading zero.
 You must not use any built-in BigInteger library or convert the inputs to integer directly.
 */
public class AddStrings {

    public String addStrings(String num1, String num2) {
        int len1 = num1 == null ? 0 : num1.length();
        int len2 = num2 == null ? 0 : num2.length();
        StringBuilder sb = new StringBuilder();
        int i = len1 - 1;
        int j = len2 - 1;
        int temp = 0;
        boolean carry = false;

        while (i >=0 || j >=0) {
            if (carry) temp = 1;
            else temp = 0;

            int value1 = i >=0 ? num1.charAt(i) - '0' : 0;
            int value2 = j >= 0 ? num2.charAt(j) - '0' : 0;
            if (value1 + value2 + temp >= 10) {
                carry = true;
                temp = (value1 + value2 + temp) %10;
            } else {
                carry = false;
                temp = value1 + value2 + temp;
            }
            sb.append(temp);
            i--;
            j--;
        }
        if (carry) sb.append(1);
        return sb.reverse().toString();
    }
}
