/** Maximum Gap **/
/*===============================================================================================================
Given an unsorted array, find the maximum difference between the successive elements in its sorted form.

Try to solve it in linear time/space.

Return 0 if the array contains less than 2 elements.

You may assume all elements in the array are non-negative integers and fit in the 32-bit signed integer range.

===============================================================================================================*/
public class Solution {
    public int maximumGap(int[] nums) {
        if(nums==null || nums.length==0 || nums.length==1) return 0;
        // bucket sort
        int MaxVal = Integer.MIN_VALUE;
        int MinVal = Integer.MAX_VALUE;
        for(int i=0; i<nums.length; i++){
            MaxVal = Math.max(MaxVal,nums[i]);
            MinVal = Math.min(MinVal,nums[i]);
        }
        // N-1 bucket
        int gap = (int)Math.ceil((double)(MaxVal - MinVal)/(nums.length - 1));
        int[] bucketMax = new int[nums.length-1];
        int[] bucketMin = new int[nums.length-1];
        Arrays.fill(bucketMax,Integer.MIN_VALUE);
        Arrays.fill(bucketMin,Integer.MAX_VALUE);
        for(int i=0; i<nums.length; i++){
            if(nums[i]!=MaxVal && nums[i]!=MinVal){
                int bucktID = (nums[i]-MinVal)/gap;
                bucketMax[bucktID] = Math.max(nums[i],bucketMax[bucktID]);
                bucketMin[bucktID] = Math.min(nums[i],bucketMin[bucktID]);
            }
        }
        
        // 计算gap
        int MaxGap = Integer.MIN_VALUE;
        int pre = MinVal;
        for(int i=0; i<nums.length-1; i++){
            if(bucketMin[i]==Integer.MAX_VALUE && bucketMax[i]==Integer.MIN_VALUE){
                // EMPTY
                continue;
            }
            MaxGap = Math.max(bucketMin[i]-pre,MaxGap);
            pre = bucketMax[i];
        }
        MaxGap = Math.max(MaxVal-pre,MaxGap);

        return MaxGap;
        
    }
}