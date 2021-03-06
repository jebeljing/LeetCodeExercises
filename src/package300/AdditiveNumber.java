package package300;

import java.math.BigInteger;

/**
 * Created by jingshanyin on 1/4/17.
 * 306. Additive Number
 * Additive number is a string whose digits can form additive sequence.

 A valid additive sequence should contain at least three numbers. Except for the first two numbers, each subsequent number in the sequence must be the sum of the preceding two.

 For example:
 "112358" is an additive number because the digits can form an additive sequence: 1, 1, 2, 3, 5, 8.

 1 + 1 = 2, 1 + 2 = 3, 2 + 3 = 5, 3 + 5 = 8
 "199100199" is also an additive number, the additive sequence is: 1, 99, 100, 199.
 1 + 99 = 100, 99 + 100 = 199
 Note: Numbers in the additive sequence cannot have leading zeros, so sequence 1, 2, 03 or 1, 02, 3 is invalid.

 Given a string containing only digits '0'-'9', write a function to determine if it's an additive number.

 Follow up:
 How would you handle overflow for very large input integers?

 */
public class AdditiveNumber {


    //The idea is quite straight forward. Generate the first and second of the sequence,
    // check if the rest of the string match the sum recursively. i and j are length
    // of the first and second number. i should in the range of [0, n/2].
    // The length of their sum should >= max(i,j)

    //recursive
    public boolean isAdditiveNumber(String num) {
        int n = num.length();
        for (int i = 1; i <= n/2; i++) {
            if (num.charAt(0) == '0' && i > 1) return false;
            BigInteger x1 = new BigInteger(num.substring(0, i));
            for (int j = 1; Math.max(j, i) <=n - i -j; ++j) {
                if (num.charAt(i) == '0' && j > 1) break;
                BigInteger x2 = new BigInteger(num.substring(i, i + j));
                if (isValid(x1, x2, j + i, num)) return true;
            }
        }
        return false;
    }

    private boolean isValid(BigInteger x1, BigInteger x2, int start, String num) {
        if (start == num.length()) return true;
        x2 = x2.add(x1);
        x1 = x2.subtract(x1);
        String sum = x2.toString();
        return num.startsWith(sum, start) && isValid(x1, x2, start + sum.length(), num);
    }

    //Iterative
    public boolean isAditiveNumber(String num) {
        int n = num.length();
        for (int i = 1; i <= n/2; i++) {
            for (int j = 1; Math.max(j, i) <= n - j - i; j++) {
                if (isValid2(i, j, num)) return true;
            }
        }
        return false;
    }

    private boolean isValid2(int i , int j, String num) {
        if (num.charAt(0) == '0' && i > 1) return false;
        if (num.charAt(i) == '0' && j > 1) return false;
        String sum;
        BigInteger x1 = new BigInteger(num.substring(0, i));
        BigInteger x2 = new BigInteger(num.substring(i, i + j));
        for (int start = i + j; start != num.length(); start += sum.length()) {
            x2 = x2.add(x1);
            x1 = x2.subtract(x1);
            sum = x2.toString();
            if (!num.startsWith(sum, start)) return false;
        }
        return true;
    }

    //If no overflow, instead of BigInteger we can consider to use Long which is a lot faster.

    //Java Iterative Using Long

        public boolean isAdditiveNumber3(String num) {
            int n = num.length();
            for (int i = 1; i <= n / 2; ++i)
                for (int j = 1; Math.max(j, i) <= n - i - j; ++j)
                    if (isValid(i, j, num)) return true;
            return false;
        }
        private boolean isValid(int i, int j, String num) {
            if (num.charAt(0) == '0' && i > 1) return false;
            if (num.charAt(i) == '0' && j > 1) return false;
            String sum;
            Long x1 = Long.parseLong(num.substring(0, i));
            Long x2 = Long.parseLong(num.substring(i, i + j));
            for (int start = i + j; start != num.length(); start += sum.length()) {
                x2 = x2 + x1;
                x1 = x2 - x1;
                sum = x2.toString();
                if (!num.startsWith(sum, start)) return false;
            }
            return true;
        }
}
