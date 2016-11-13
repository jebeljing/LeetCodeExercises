package package100;

/**
 * Created by jingshanyin on 11/13/16.
 * 168. Excel Sheet Column Title
 *
 * Given a positive integer, return its corresponding column title as appear in an Excel sheet.

 For example:

 1 -> A
 2 -> B
 3 -> C
 ...
 26 -> Z
 27 -> AA
 28 -> AB
 */
public class ExcelSheetColumnTitle {

    public String convertToTitle(int n) {
        StringBuilder sb = new StringBuilder();
        int len = 1;

        //Use double here instead of int
        double temp = n;
        while (temp > 26) {
            len++;
            temp = (temp - 26) /26;
        }

        while (len > 0) {
            int digit = n % 26;
            if (digit == 0) digit = 26;
            sb.append((char)('A' + digit - 1));
            len--;
            n = (n - digit) /26;
        }
        return sb.reverse().toString();
    }
}
