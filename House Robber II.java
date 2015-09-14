// House Robber II
public class Solution {
    public int rob(int[] nums) {
        if(nums.length==0){ return 0; }
        int[] maxMoney = new int[nums.length];
        int[] maxMoneyA = new int[nums.length];
        if(nums.length==1){ return nums[0]; }
        else if(nums.length==2){
            return Math.max(nums[0],nums[1]);
        }
        else{
            // rob from the first house, not contain the last element
            maxMoney[0] = 0;
            maxMoney[1] = nums[0];
            for(int i=2; i<nums.length; i++){
                maxMoney[i] = Math.max(maxMoney[i-1],maxMoney[i-2]+nums[i-1]);
            }
            // rob from the second house, contain the last element
            maxMoneyA[0] = 0;
            maxMoneyA[1] = nums[1];
            for(int i=2; i<nums.length; i++){
                maxMoneyA[i] = Math.max(maxMoneyA[i-1],maxMoneyA[i-2]+nums[i]);
            }
            
        } 
        return Math.max(maxMoney[nums.length-1],maxMoneyA[nums.length-1]);
    }
}