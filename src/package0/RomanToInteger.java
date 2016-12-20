package package0;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Jebeljing on 11/28/2016.
 * 13. Roman to Integer
 *
 * Given a roman numeral, convert it to an integer.

 Input is guaranteed to be within the range from 1 to 3999.
 */
public class RomanToInteger {

    private static Map<Character, Integer> maps = new HashMap<>();
    static {
        maps.put('I', 1);
        maps.put('V', 5);
        maps.put('X', 10);
        maps.put('L', 50);
        maps.put('C', 100);
        maps.put('D', 500);
        maps.put('M', 1000);
    }
    public int romanToInt(String s) {
        int result = 0;
        int preVal = 0;
        for (int i = 0; i < s.length(); i++) {
            int currVal = maps.get(s.charAt(i));
            if (preVal < currVal){
                result = result - 2 * preVal;
            }
            preVal = currVal;
            result = result + currVal;
        }
        return result;
    }
}
