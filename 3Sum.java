/** 3Sum **/
/*=================================================================================================
GGiven an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.

Note:
Elements in a triplet (a,b,c) must be in non-descending order. (ie, a ≤ b ≤ c)
The solution set must not contain duplicate triplets.
    For example, given array S = {-1 0 1 2 -1 -4},

    A solution set is:
    (-1, 0, 1)
    (-1, -1, 2)
=================================================================================================*/
// 超时
public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
       
        HashSet<List<Integer>> set = new HashSet<List<Integer>>();
        if(nums==null||nums.length<3) return new ArrayList<List<Integer>>();
        for(int i=0; i<nums.length; i++){
            if(i>0 && nums[i]==nums[i-1]){
                continue;
            }
            int target = 0-nums[i];
            if(target<nums[i]){
                break;
            }
            HashMap<Integer,Integer> hm = new HashMap<Integer,Integer>();
            for(int j=i+1; j<nums.length; j++){
                if(hm.containsKey(nums[j])){
                    List<Integer> cur = new ArrayList<Integer>();
                    cur.add(nums[i]);
                    cur.add(hm.get(nums[j]));
                    cur.add(nums[j]);
                    set.add(cur);
                    hm.remove(nums[j]);
                }
                else{
                        if(target-nums[j]<nums[j]){
                            continue;
                        }
                        hm.put(target-nums[j],nums[j]);
                    }
                }
            
        }
        List<List<Integer>> res = new ArrayList<List<Integer>>(set);
        return res;
        
    }


// two pointers

public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
       
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        
        if(nums==null||nums.length<3) return new ArrayList<List<Integer>>();
        for(int i=0; i<nums.length; i++){
            if(i>0 && nums[i]==nums[i-1]){
                continue;
            }
            int target = 0-nums[i];
            int j = i+1;
            int k = nums.length-1;
            while(j<k){
                if(nums[j]+nums[k]==target){
                    List<Integer> temp = new ArrayList<Integer>();
                    temp.add(nums[i]);
                    temp.add(nums[j]);
                    temp.add(nums[k]);
                    res.add(temp);
                    j++;
                    k--;
                    while(j<k&&nums[j-1]==nums[j]){
                        j++;
                    }
                    while(j<k&&nums[k]==nums[k+1]){
                        k--;
                    }
                }
                else if(nums[j]+nums[k]<target){
                    j++;
                }
                else{
                    k--;
                }
            }
                
            
        }
        
        return res;
        
    }
}
}