package package0;

/**
 * Created by Jebeljing on 11/28/2016.
 * 12. Integer to Roman
 *
 * Given an integer, convert it to a roman numeral.

 Input is guaranteed to be within the range from 1 to 3999.

 Subscribe to see which companies asked this question

 */
public class IntegerToRoman {


    public String intToRoman2(int num) {
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] strs = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < values.length; i++) {
            while(num >= values[i]) {
                num -= values[i];
                sb.append(strs[i]);
            }

        }
        return sb.toString();
    }

    public String intToRoman(int num) {
        StringBuilder sb = new StringBuilder();
        int temp1 = num/1000;
        if (temp1 == 3) sb.append("MMM");
        else if (temp1 == 2) sb.append("MM");
        else if (temp1 == 1) sb.append("M");

        int temp2 = (num%1000)/100;
        if (temp2 == 9) sb.append("CM");
        else if (temp2 == 8) sb.append("DCCC");
        else if (temp2 == 7) sb.append("DCC");
        else if (temp2 == 6) sb.append("DC");
        else if (temp2 == 5) sb.append("D");
        else if (temp2 == 4) sb.append("CD");
        else if (temp2 == 3) sb.append("CCC");
        else if (temp2 == 2) sb.append("CC");
        else if (temp2 == 1) sb.append("C");

        int temp3 = (num%100) / 10;
        if (temp3 == 9) sb.append("XC");
        else if (temp3 == 8) sb.append("LXXX");
        else if (temp3 == 7) sb.append("LXX");
        else if (temp3 == 6) sb.append("LX");
        else if (temp3 == 5) sb.append("L");
        else if (temp3 == 4) sb.append("XL");
        else if (temp3 == 3) sb.append("XXX");
        else if (temp3 == 2) sb.append("XX");
        else if (temp3 == 1) sb.append("X");

        int temp4 = (num%10);
        if (temp4 == 9) sb.append("IX");
        else if (temp4 == 8) sb.append("VIII");
        else if (temp4 == 7) sb.append("VII");
        else if (temp4 == 6) sb.append("VI");
        else if (temp4 == 5) sb.append("V");
        else if (temp4 == 4) sb.append("IV");
        else if (temp4 == 3) sb.append("III");
        else if (temp4 == 2) sb.append("II");
        else if (temp4 == 1) sb.append("I");

        return sb.toString();
    }
}
