//Maximum Product Subarray 
public class Solution {
    public static int maxProduct(int[] nums) {
	        int maxEndingHere = 1, minEndingHere = 1, maxSoFar = nums[0];
	        for(int i=0; i<nums.length; i++){
	         if(nums[i] == 0){
	          maxEndingHere = 0;
	          minEndingHere = 0;
	          maxSoFar = Math.max(maxSoFar,maxEndingHere);
	          maxEndingHere = 1;
	          minEndingHere = 1;
	         }
	         else{
	             if(nums[i]<0){
	                 int tempMax = nums[i]*minEndingHere;
	                 int tempMin = nums[i]*maxEndingHere;
	                 // the maxSoFar is likely to be 0, so can not update maxsoFar after set maxEndingHere to 1.
	                 maxSoFar = Math.max(maxSoFar,tempMax);
	                 if(tempMax <0){ maxEndingHere=1; }
	                 else{ maxEndingHere = tempMax; }
	                 minEndingHere = tempMin;
	             }
	             if(nums[i]>0){
	            	int tempMax = nums[i]*maxEndingHere;
	                int tempMin = nums[i]*minEndingHere;
	                maxEndingHere = tempMax;
	                minEndingHere = tempMin;
	                maxSoFar = Math.max(maxSoFar,maxEndingHere);
	             }
	             
	         }
	    }
	        return maxSoFar;
	    }
}