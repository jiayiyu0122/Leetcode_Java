/** Ugly Number II **/
/*=====================================================================================
Write a program to find the n-th ugly number.

Ugly numbers are positive numbers whose prime factors only include 2, 3, 5. 
For example, 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 is the sequence of the first 10 ugly numbers.

Note that 1 is typically treated as an ugly number.
=====================================================================================*/
// 超时
public class Solution {
    public int nthUglyNumber(int n) {
        // first ugly number
        int x = 1;
        int count = 0;
        while(count<n){
            if(isUgly(x)){
                count++;
            }
            x++;
        }
        return x;
    }
    
    public boolean isUgly(int n){
        if(n==1) return true;
        while(n%2==0){
            n = n/2;
        }
        if(n==1) return true;
        while(n%3==0){
            n = n/3;
        }
        if(n==1) return true;
        while(n%5==0){
            n = n/5;
        }
        if(n==1) return true;
        return false;
    }
}
// ugly number 1*2 2*2 3*2 4*2.....
//             1*3 2*3 3*3 4*3.....
//             1*5 2*5 3*5 4*5.....
// 每个数都是之前的ugly number*{1 or 3 or 5}
// 但是注意，可能结果里面会有相同的数，比如2*3和3*2得到的结果都是6，所以要判断arraylist里面时候包含了重复的数字
public class Solution {
    public int nthUglyNumber(int n) {
        List<Integer> res = new ArrayList<Integer>();
        res.add(1);
        int i2=0, i3=0, i5=0;
        while(res.size()<n){
            int min = Math.min(res.get(i2)*2,res.get(i3)*3);
            min = Math.min(min,res.get(i5)*5);
            if(min==res.get(i2)*2) i2++;
            else if(min==res.get(i3)*3) i3++;
            else i5++;
            if(!res.contains(min)){
                res.add(min);
            }
            
        }
        return res.get(res.size()-1);
    }
}