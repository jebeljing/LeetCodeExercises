package package100;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jingshanyin on 11/23/16.
 * 118. Pascal's Triangle
 * Given numRows, generate the first numRows of Pascal's triangle.

 For example, given numRows = 5,
 Return

 [
 [1],
 [1,1],
 [1,2,1],
 [1,3,3,1],
 [1,4,6,4,1]
 ]
 */

public class PascalsTriangle {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (numRows < 1) {
            return result;
        }
        List<Integer> firstRow = new ArrayList<>();
        firstRow.add(1);
        result.add(firstRow);

        for (int i = 1; i < numRows; i++) {
            List<Integer> preRow = result.get(i - 1);
            List<Integer> temp = new ArrayList<>();
            temp.add(1);
            for (int j = 1; j < preRow.size(); j++) {
                temp.add(preRow.get(j -1) + preRow.get(j));
            }
            temp.add(1);
            result.add(temp);
        }
        return result;
    }


}
