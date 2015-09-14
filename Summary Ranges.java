/** Summary Ranges **/
// easy
//Given a sorted integer array without duplicates, return the summary of its ranges.
//For example, given [0,1,2,4,5,7], return ["0->2","4->5","7"].

public class Solution {
    public List<String> summaryRanges(int[] nums) {
        ArrayList<String> array = new ArrayList<String>();
        if(nums.length==0){ return array; }
        if(nums.length==1){ 
            array.add(Integer.toString(nums[0])); 
            return array;
        }
        int pointer = 0;
        int i = 0;
        for(i=1; i<nums.length; i++){
            if(nums[i]==nums[i-1]+1){
                continue;
            }
            else{
                if(i-1>pointer){
                    array.add(Integer.toString(nums[pointer])+"->"+Integer.toString(nums[i-1]));    
                }
                else{
                    array.add(Integer.toString(nums[pointer]));
                }
                pointer = i;
                
            }
        }

        // 注意循环结束以后要对最后一组进行判断。
        if(i-1>pointer){
            array.add(Integer.toString(nums[pointer])+"->"+Integer.toString(nums[i-1]));
        }
        else{
            array.add(Integer.toString(nums[pointer]));
        }
        return array;
    }
}