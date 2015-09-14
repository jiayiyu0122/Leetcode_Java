/** Contains Duplicate III **/
/* ================================================================================
Given an array of integers, find out whether there are two distinct indices i and j 
in the array such that the difference between nums[i] and nums[j] is at most t 
and the difference between i and j is at most k.
=================================================================================*/

import java.util.*;
public class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if(nums.length==0||k<1||t<0) return false;
        // 维护一个长度为k的窗口
        SortedSet<Long> set = new TreeSet<Long>();
        for(int j=0; j<nums.length; j++){
            SortedSet<Long> window = new TreeSet<Long>();
            window = set.subSet((long)nums[j]-t,(long)nums[j]+t+1);
            
            if(!window.isEmpty()){
                return true;
            }
            if(j>=k){
                set.remove((long)nums[j-k]);
            }
            set.add((long)nums[j]);
        }
        return false;
    }
}