public class Solution {
    public boolean containsDuplicate(int[] nums) {
        HashMap<Integer, Integer> duoMap = new HashMap<Integer, Integer>();
        // check if key is in the hashmap
        for(int i=0; i<nums.length; i++){
            if (duoMap.containsKey(nums[i])){ return true; }
            else{
                duoMap.put(nums[i], 1);
            }
        }
        // no duplicate element
        return false;
        
    }
}