/** Candy **/
/*=================================================================================
There are N children standing in a line. Each child is assigned a rating value.

You are giving candies to these children subjected to the following requirements:

Each child must have at least one candy.
Children with a higher rating get more candies than their neighbors.
What is the minimum candies you must give?
=================================================================================*/
public class Solution {
    public int candy(int[] ratings) {
        int len = ratings.length;
        int[] res = new int[len];
        res[0] = 1;
        // 递增递减
        int i= 1;
        for(i=1;i<len; i++){
            // 递增
            if(ratings[i]>ratings[i-1]){
                res[i] = res[i-1]+1;    
                
            }
            // 递减
            else if(ratings[i]<ratings[i-1]){
                res[i] = res[i-1]-1; 
            }
            else if(ratings[i]==ratings[i-1]){
                res[i] = 1;
            }
            if(i<len-1 && ratings[i]<ratings[i-1] && ratings[i]<=ratings[i+1]){
                int k=i;
                int diff = 1-res[i];
                while(k>0 && ratings[k-1]>ratings[k]){
                    res[k] += diff;
                    k--;
                }
                if(diff>0){
                    res[k]+= diff;
                }
                
            }
        }
        
        if(i-2>=0 && ratings[i-1]<ratings[i-2]){
            int k=i-1;
            int diff = 1-res[i-1];
            while(k>0 && ratings[k-1]>ratings[k]){
                res[k] += diff;
                k--;
            }
            if(diff>0){
                res[k]+=diff;
            }
        }
        // 求sum
        int sum = 0;
        for(i=0; i<len; i++){
            sum += res[i];
        }
        
        
        return sum;
    }
}