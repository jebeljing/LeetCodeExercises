package package300;

/**
 * Created by jingshanyin on 11/18/16.
 * 371. Sum of Two Integer.
 *
 * Calculate the sum of two integers a and b, but you are not allowed to use the operator + and -.

 Example:
 Given a = 1 and b = 2, return 3.
 */
public class SumOfTwoIntegers {

    public int getSum(int a, int b) {
        int carry = a & b;
        return carry == 0 ? a^b : getSum(a^b, carry<<1);
    }

    public int getSum2(int a, int b) {
        if (a == 0) return b;
        if (b == 0) return a;

        while (b!= 0) {
            int carry = a&b;
            a = a^b;
            b = carry<<1;
        }
        return a;
    }
}
