package package300;

/**
 * Created by jingshanyin on 11/23/16.
 * 326. Power of Three
 * Given an integer, write a function to determine if it is a power of three.

 Follow up:
 Could you do it without using any loop / recursion?


 */
public class PowerOfThree {

    public boolean isPowerOfThree(int n) {
        double temp = n;
        while (temp >= 3) {
            temp /= 3.0;
        }
        return temp == 1.0;
    }
}
