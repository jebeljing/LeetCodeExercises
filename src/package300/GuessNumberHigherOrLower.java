package package300;

import base.GuessGame;

/**
 * Created by Jebeljing on 11/26/2016.
 * 374. Guess Number Higher or Lower
 *
 * We are playing the Guess Game. The game is as follows:

 I pick a number from 1 to n. You have to guess which number I picked.

 Every time you guess wrong, I'll tell you whether the number is higher or lower.

 You call a pre-defined API guess(int num) which returns 3 possible results (-1, 1, or 0):

 -1 : My number is lower
 1 : My number is higher
 0 : Congrats! You got it!

 Example:

 n = 10, I pick 6.

 Return 6.

 */
public class GuessNumberHigherOrLower  extends GuessGame {

    public int guessNumber(int n) {
        int start = 1;
        int end = n;
        int middle = start + (end - start) /2;

        while (start < end) {
            int result = guess(middle);
            if (result == 0) {
                return middle;
            } else if (result == 1) {
                start = middle + 1;
                middle = start + (end - start) /2;
            } else {
                end = middle - 1;
                middle = start + (end - start) /2;
            }
        }
        return start;
    }

    //Recursive solution
    public int guessNumber2(int n) {
        return helper(1, n);
    }

    private int helper(int start, int end) {
        if (start >= end) {
            return start;
        }
        int middle = start + (end - start)/2;
        int result = guess(middle);
        if (result == 0) {
            return middle;
        } else if (result > 0) {
            return helper(middle + 1, end);
        } else {
            return helper(start, middle -1 );
        }
    }
}
