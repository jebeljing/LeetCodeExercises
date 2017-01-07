package package300;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by jingshanyin on 1/6/17.
 * 347. Top K Frequent Elements
 * Given a non-empty array of integers, return the k most frequent elements.

 For example,
 Given [1,1,1,2,2,3] and k = 2, return [1,2].

 Note:
 You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
 Your algorithm's time complexity must be better than O(n log n), where n is the array's size.
 */
public class TopKFrequentElement {
    public List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer> result = new ArrayList<>();

        Map<Integer, Integer> frequencyMap = new HashMap<>();
        List<Integer>[] buckets = new List[nums.length + 1];

        for (int num: nums) {
            if (!frequencyMap.containsKey(num)) {
                frequencyMap.put(num, 1);
            } else {
                frequencyMap.put(num, frequencyMap.get(num) + 1);
            }
        }

        for (Integer key: frequencyMap.keySet()) {
            Integer value = frequencyMap.get(key);
            if (buckets[value] == null) {
                buckets[value] = new ArrayList<Integer>();
            }
            buckets[value].add(key);
        }

        for (int i = buckets.length - 1; i >=0 && result.size() < k; i--) {
            if (buckets[i] != null)
                result.addAll(buckets[i]);
        }
        return result;
    }
}
