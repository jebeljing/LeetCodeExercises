package package300;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jingshanyin on 1/7/17.
 * 386. Lexicographical Numbers
 * Given an integer n, return 1 - n in lexicographical order.

 For example, given 13, return: [1,10,11,12,13,2,3,4,5,6,7,8,9].

 Please optimize your algorithm to use less time and space. The input size may be as large as 5,000,000.


 */
public class LexicographicalNumbers {
    public List<Integer> lexicalOrder(int n) {

        List<Integer> result = new ArrayList<>();
        for (int i = 1; i <= 9; i++) {
            dfs(i, n, result);
        }
        return result;
        /*List<String> list = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            list.add(String.valueOf(i));
        }
        Collections.sort(list);

        List<Integer> result = new ArrayList<>();
        for (String str: list) {
            result.add(Integer.parseInt(str));
        }
        return result;*/
    }

    private void dfs(int i, int n, List<Integer> result) {
        if (i > n) {
            return;
        } else {
            result.add(i);
            for(int idx = 0; idx < 10; idx++) {
                dfs(i*10 + idx, n, result);
            }
        }
    }
}
