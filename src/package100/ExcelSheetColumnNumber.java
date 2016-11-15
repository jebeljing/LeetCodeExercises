package package100;

/**
 * Created by jingshanyin on 11/14/16.
 * 171. Excel Sheet Column Number
 *
 * Related to question Excel Sheet Column Title

 Given a column title as appear in an Excel sheet, return its corresponding column number.

 For example:

 A -> 1
 B -> 2
 C -> 3
 ...
 Z -> 26
 AA -> 27
 AB -> 28
 */
public class ExcelSheetColumnNumber {
    public int titleToNumber(String s) {
        int result = 0;
        for (int i = 0; i < s.length() - 1; i++) {
            result = result * 26 + (s.charAt(i) - 'A' + 1) * 26;
        }
        result += s.charAt(s.length() - 1) - 'A' + 1;
        return result;
    }
}
