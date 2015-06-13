public class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer, Integer> duoMap = new HashMap<Integer, Integer>();
        
        for(int i=0; i<nums.length; i++){
            
            if(duoMap.containsKey(nums[i])){
                if(i-duoMap.get(nums[i])<=k){
                    return true;
                }
                else{
                    duoMap.put(nums[i],i);
                }
            }
            else{
                duoMap.put(nums[i], i);
            }
        }
        return false;
    }
}