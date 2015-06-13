import java.util.*;
// algorithem complexity is O(n).
public class Solution {
    public int[] twoSum(int[] nums, int target) {
        
        Hashtable<Integer, Integer> tsHashtable = new Hashtable<Integer, Integer>();
        int[] ret = new int[2];
        //if the number is in hashtable, then return. 
        //else add it to the two sum.
        for(int i=0; i<nums.length; i++){
            Integer value = tsHashtable.get(nums[i]);
            if (value == null){
                Integer key = new Integer(target-nums[i]);
                Integer val = new Integer(i+1);
                tsHashtable.put(key, val);
            }
            else{
                int temp = (int) value;
                ret[0] = temp;
                ret[1] = i+1;
                break;
            }
        }
        return ret;
    }
}