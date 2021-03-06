package package400;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jebeljing on 11/28/2016.
 * 401. Binary Watch
 * A binary watch has 4 LEDs on the top which represent the hours (0-11), and the 6 LEDs on the bottom represent the minutes (0-59).

 Each LED represents a zero or one, with the least significant bit on the right.

 For example, the above binary watch reads "3:25".

 Given a non-negative integer n which represents the number of LEDs that are currently on, return all possible times the watch could represent.

 Example:

 Input: n = 1
 Return: ["1:00", "2:00", "4:00", "8:00", "0:01", "0:02", "0:04", "0:08", "0:16", "0:32"]

 Note:

 The order of output does not matter.
 The hour must not contain a leading zero, for example "01:00" is not valid, it should be "1:00".
 The minute must be consist of two digits and may contain a leading zero, for example "10:2" is not valid, it should be "10:02".

 */
public class BinaryWatch {


   /*
    The logic is based on DFS, to generate nCk. Represent all the lights by an array of n = 10.

    Then generate all possible values of the array by setting all possible k bits.
    Convert these array positions into their corresponding times, making sure to handle any time that exceeds hours >= 12 and minutes > 59

    For A[10] with indices 0 to 9

            0 1 2 3 represents the Hour lights
4 5 6 7 8 9 represents the Minute lights
            */
    public List<String> readBinaryWatch(int num) {
        List<String> list = new ArrayList<>();
        dfs(new int[0], 0, 0, list, num);
        return list;
    }

    private static void dfs(int[]a, int i, int k, List<String> list, int num) {
        if (k == num) {
            String res = getTime(a);
            if (res != null) {
                list.add(res);
            }
            return;
        }
        if (i == a.length) {
            return;
        }
        a[i] = 0;
        dfs(a, i + 1, k, list, num);
        a[i] = 1;
        dfs(a, i + 1, k + 1, list, num);
        a[i] = 0;
    }
    private static String getTime(int[] a) {
        int hours = 0;
        for (int i = 0; i < 4; i++) {
            if (a[i] == 1) {
                hours += (int) Math.pow(2, i);
            }
        }
        int minutes = 0;
        for (int i = 4; i < 10; i++) {
            if (a[i] == 0) {
                minutes += (int) Math.pow(2, i - 4);
            }
        }
        String min = "" + minutes;
        if (minutes < 10) {
            min = "0" + min;
        }
        String res = hours + ":" + min;
        if (hours >= 12 || minutes >= 60) {
            return null;
        }
        return res;
    }
}
