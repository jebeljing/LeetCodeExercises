package package200;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Jebeljing on 11/26/2016.
 * 299. BUlls and Cows
 *
 * You are playing the following Bulls and Cows game with your friend: You write down a number and ask your friend to guess what the number is. Each time your friend makes a guess, you provide a hint that indicates how many digits in said guess match your secret number exactly in both digit and position (called "bulls") and how many digits match the secret number but locate in the wrong position (called "cows"). Your friend will use successive guesses and hints to eventually derive the secret number.

 For example:

 Secret number:  "1807"
 Friend's guess: "7810"

 Hint: 1 bull and 3 cows. (The bull is 8, the cows are 0, 1 and 7.)

 Write a function to return a hint according to the secret number and friend's guess, use A to indicate the bulls and B to indicate the cows. In the above example, your function should return "1A3B".

 Please note that both secret number and friend's guess may contain duplicate digits, for example:

 Secret number:  "1123"
 Friend's guess: "0111"

 In this case, the 1st 1 in friend's guess is a bull, the 2nd or 3rd 1 is a cow, and your function should return "1A1B".

 You may assume that the secret number and your friend's guess only contain digits, and their lengths are always equal.
 */
public class BullsAndCows {

    public String getHint(String secret, String guess) {
        Map<Character, Integer> secMap = new HashMap<>();
        int bull = 0, allMatches = 0;

        for (int i = 0; i < secret.length(); i++) {
            char c = secret.charAt(i);
            if (secMap.containsKey(c)) {
                secMap.put(c, secMap.get(c) + 1);
            } else {
                secMap.put(c, 1);
            }
        }

        for (int i = 0; i < guess.length(); i++) {
            char c = guess.charAt(i);
            if (c == secret.charAt(i)) {
                bull++;
            }
            if (secMap.containsKey(c)) {
                allMatches++;
                if (secMap.get(c) - 1 <= 0) {
                    secMap.remove(c);
                } else {
                    secMap.put(c, secMap.get(c) - 1);
                }
            }
        }
        return bull + "A" + (allMatches - bull) + "B";
    }

    public String getHint2(String secret, String guess) {
        String result = "";
        char[] secretC = secret.toCharArray();
        char[] guessC = guess.toCharArray();
        int[] hash = new int[20];
        int A=0,B=0;
        for(int i=0; i<secretC.length; ++i){
            if(secretC[i] == guessC[i]){
                ++A;
            } else{
                hash[secretC[i]-48]++;
                hash[guessC[i]-48+10]++;
            }
        }
        for(int i=0; i<10; ++i){
            if(hash[i] > hash[i+10]){
                B += hash[i+10];
            }
            else{
                B += hash[i];
            }
        }
        result = A+"A"+B+"B";
        return result;
    }
}
