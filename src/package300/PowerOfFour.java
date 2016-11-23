package package300;

/**
 * Created by jingshanyin on 11/23/16.
 * 342. Power of Four
 *
 * Given an integer (signed 32 bits), write a function to check whether it is a power of 4.

 Example:
 Given num = 16, return true. Given num = 5, return false.

 Follow up: Could you solve it without loops/recursion?
 */
public class PowerOfFour {

    public boolean isPowerOfFour(int num) {
        double temp = num;
        while (temp >= 4) {
            temp /=4.0;
        }
        return temp == 1.0;
    }
}
