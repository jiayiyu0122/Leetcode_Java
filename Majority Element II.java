/** Majority Element II **/
/*========================================================================================
Given an integer array of size n, find all elements that appear more than ⌊ n/3 ⌋ times.
The algorithm should run in linear time and in O(1) space.
=========================================================================================*/
// 用set这个结构，就不会有重复的元素， 最后再转换成list
// 先排序的话，可以只扫一遍。
public class Solution {
    public List<Integer> majorityElement(int[] nums) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        Set<Integer> res = new HashSet<Integer>();
        if(nums.length==0) return result;
        if(nums.length==2){
            res.add(nums[0]);
            res.add(nums[1]);
            result.addAll(res);
            return result;

        }
        Arrays.sort(nums);
        int size = nums.length;
        int appearTimes = size/3;
        int pre = nums[0];
        int count = 0;
        int i = 0;
        for(i=0; i<size; i++){
            
            if(nums[i]==pre){
                count++;
            }
            else{
                count = 1;
                pre = nums[i];
            }
            if(count > appearTimes){
                res.add(nums[i]);
            }
        }
        result.addAll(res);
        return result;
    }
}