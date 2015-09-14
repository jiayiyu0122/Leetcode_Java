//Integer to Roman
public class Solution {
    public String intToRoman(int num) {
        String[] Roman = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        int[] Int = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
        String IntToRoman = new String();
        for(int i=0; num != 0; i++){
            while(num>=Int[i]){
                num = num - Int[i];
                IntToRoman = IntToRoman + Roman[i];
            }
            
        }
        return IntToRoman;
}
}