package package300;

/**
 * Created by yinj on 2/7/2017.
 * 372. Super Pow
 * Your task is to calculate ab mod 1337 where a is a positive integer and b is an extremely large positive integer given in the form of an array.

 Example1:

 a = 2
 b = [3]

 Result: 8
 Example2:

 a = 2
 b = [1,0]

 Result: 1024
 */
public class SuperPow {
    private static final int M = 1337;

    public int superPow(int a, int[] b) {
        a = a % M;
        int result =1 ;
        for (int i = b.length - 1; i >= 0; i--) {
            result = result * normalPow(a, b[i]) %M;
            a = normalPow(a, 10);
        }
        return result;
    }

    private int normalPow(int a, int b) {
        int result = 1;
        while (b!= 0) {
//            if (b % 2!=0) {
//                result = result * a % M;
//            }
//            a = a * a % M;
//            b = b/2;
            result = result * a %M;
            b--;
        }
        return result;
    }
}
