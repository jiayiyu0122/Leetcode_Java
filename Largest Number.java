/** Largest Number 
/* Given a list of non negative integers, arrange them such that they form the largest number.
/* For example, given [3, 30, 34, 5, 9], the largest formed number is 9534330.
*/
//译错例子： input [0,0], the output should be "0" not "00".
// 解题思路： 思路比较tricky, 如果通过比较每个数字的某一位， 特例太多， 不宜比较。 而把数列里面的某两个数转换成string的形式，
// 再把两个string按照相反的顺序concat起来， 例如， ‘3’ 和 ‘30’， 通过‘330’ 和‘303’ 来比较得出这两个数哪个大。 可以通过改写
// array.sort 里面的 comparator这个方法来实现。
public class Solution {
    public String largestNumber(int[] nums) {
            int numLen = nums.length;
            String[] array = new String[numLen];
            for(int i=0; i<numLen; i++){
                array[i] = Integer.toString(nums[i]);
            }
            Arrays.sort(array, new Comparator<String>(){
                public int compare(String s1, String s2){
                    String i = s1+s2;
                    String j = s2+s1;
                    return j.compareTo(i);
                }
            });
            
            StringBuffer sb = new StringBuffer();
            for(int i=0; i<numLen; i++){
                sb.append(array[i]);
            }
            
            while(sb.charAt(0)=='0' && sb.length()>1){
                sb.deleteCharAt(0);
            }
            return sb.toString();
        }
        
        
    }
