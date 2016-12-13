package package400;

import java.util.*;

/**
 * Created by jingshanyin on 12/12/16.
 * 406. Queue Reconstruction by Height
 *
 * Suppose you have a random list of people standing in a queue. Each person is described by a pair of integers (h, k), where h is the height of the person and k is the number of people in front of this person who have a height greater than or equal to h. Write an algorithm to reconstruct the queue.

 Note:
 The number of people is less than 1,100.

 Example

 Input:
 [[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]]

 Output:
 [[5,0], [7,0], [5,2], [6,1], [4,4], [7,1]]
 */
public class QueueReconstructionByHeight {

    /*
     //pick up the tallest guy first
        //when insert the next tall guy, just need to insert him into kth position
        //repeat until all people are inserted into list
     */
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] p1, int[] p2) {
                if (p1[0] == p2[0]) {
                    return p1[1] - p2[1];
                } else {
                    return p2[0] - p1[0];
                }
            }
        });
        List<int[]> res = new ArrayList<>();
        for (int[] elem: people) {
            res.add(elem[1], elem);
        }
        return res.toArray(new int[people.length][]);
    }
}
