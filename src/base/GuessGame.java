package base;

/**
 * Created by Jebeljing on 11/26/2016.
 * For 374. Guess Number Higher or Lower
 *
 */
public class GuessGame {

    public int target;
   /* The guess API is defined in the parent class GuessGame.
   @param num, your guess
   @return -1 if my number is lower, 1 if my number is higher, otherwise return 0
      int guess(int num); */

   public int guess(int num) {
       if (num == target) {
           return 0;
       } else if (num < target) {
           return 1;
       } else {
           return -1;
       }
   }
}
