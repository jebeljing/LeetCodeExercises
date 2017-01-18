package package400;

/**
 * Created by yinj on 1/18/2017.
 * 416. Partition Equal Subset Sum.
 * Given a non-empty array containing only positive integers, find if the array can be partitioned into two subsets such that the sum of elements in both subsets is equal.

 Note:
 Each of the array element will not exceed 100.
 The array size will not exceed 200.
 Example 1:

 Input: [1, 5, 11, 5]

 Output: true

 Explanation: The array can be partitioned as [1, 5, 5] and [11].
 Example 2:

 Input: [1, 2, 3, 5]

 Output: false

 Explanation: The array cannot be partitioned into equal sum subsets.
 */
public class PartitionEqualSubsetSum {
    public boolean canPartition(int[] nums) {
        if(nums==null || nums.length==0){
            return false;
        }
        int sum=0;
        for(int i=0; i<nums.length; i++){
            sum+=nums[i];
        }
        if(sum%2!=0) return false;
        int[] dp=new int[sum/2];
        return doDp(sum/2,0,0,nums,dp);

    }
    public boolean doDp(int max,int cur, int index,int[] nums, int[] dp){
        if(cur>max || index>=nums.length){
            return false;
        }else if(cur==max){
            return true;
        }
        if(dp[cur]==1){
            return true;
        }else if(dp[cur]==-1){
            return false;
        }
        boolean res = doDp(max, cur+nums[index],index+1,nums,dp) || doDp(max, cur,index+1,nums,dp);
        dp[cur]=res?1:-1;
        return res;
    }

    public boolean canPartition2(int[] nums) {
        int total = 0;
        for(int i : nums) total+=i; // compute the total sum of the input array
        if(total%2 != 0) return false; // if the array sum is not even, we cannot partition it into 2 equal subsets
        int max = total/2; // the maximum for a subset is total/2
        int[][] results = new int[nums.length][max]; // integer matrix to store the results, so we don't have to compute it more than one time
        return isPartitionable(max,0,0,nums,results);
    }

    public boolean isPartitionable(int max,int curr, int index, int[] nums, int[][] results) {
        if(curr>max || index>nums.length-1) return false; // if we passed the max, or we reached the end of the array, return false
        if(curr==max) return true; // if we reached the goal (total/2) we found a possible partition
        if(results[index][curr]==1) return true; // if we already computed teh result for the index i with the sum current, we retrieve this result (1 for true)
        if(results[index][curr]==2) return false; // if we already computed teh result for the index i with the sum current, we retrieve this result (2 for false)
        boolean res = isPartitionable(max, curr+nums[index], index+1, nums, results) || isPartitionable(max, curr, index+1, nums, results); // else try to find the equal partiion, taking this element, or not taking it
        results[index][curr] = res ? 1 : 2; // store the result for this index and this current sum, to use it in dynamic programming
        return res;
    }
}
