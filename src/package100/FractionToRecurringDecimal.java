package package100;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by jingshanyin on 12/11/16.
 * 166. Fraction to Recurring Decimal
 *Given two integers representing the numerator and denominator of a fraction, return the fraction in string format.

 If the fractional part is repeating, enclose the repeating part in parentheses.

 For example,

 Given numerator = 1, denominator = 2, return "0.5".
 Given numerator = 2, denominator = 1, return "2".
 Given numerator = 2, denominator = 3, return "0.(6)".
 */
public class FractionToRecurringDecimal {

    public String fractionToDecimal(int numerator, int denominator) {
        if (denominator == 0) {
            throw new RuntimeException("The denominator cannot be zero.");
        }
        if (numerator == 0) return "0";

        StringBuilder sb = new StringBuilder();
        boolean negative = (numerator > 0) ^ (denominator > 0);
        if (negative) sb.append("-");

        long numer = Math.abs((long) numerator);
        long denom = Math.abs((long) denominator);
        sb.append(numer/denom);
        numer = numer % denom;
        if (numer == 0) return sb.toString();

        sb.append(".");
        Map<Long, Integer> map = new HashMap<>();
        map.put(numer, sb.length());
        while(numer != 0) {
            numer = numer * 10;
            sb.append(numer/denom);
            numer = numer% denom;
            if (map.containsKey(numer)) {
                int idx = map.get(numer);
                sb.insert(idx, "(");
                sb.append(")");
                break;
            } else {
                map.put(numer, sb.length());
            }
        }
        return sb.toString();
    }
}
