// Integer to English Words
//
// Convert a non-negative integer to its english words representation. Given input is guaranteed to be less than 231 - 1.

// For example,
// 123 -> "One Hundred Twenty Three"
// 12345 -> "Twelve Thousand Three Hundred Forty Five"
// 1234567 -> "One Million Two Hundred Thirty Four Thousand Five Hundred Sixty Seven"


//注意⚠️： 1000 要表示成“One Thousand” 而不是 “One Thousand ”

public class Solution {
    public String numberToWords(int num){
		String[] arr = {"Thousand","Million","Billion"};
		String res = convertHundred(num%1000);
		for(int i=0; i<3; i++){
			num = num/1000;
			res = (num%1000==0? res : convertHundred(num%1000) + " " + arr[i] + (res==""? "" : " " + res));
		}
		if(res=="") return "Zero";
		return res;
	}
	public String convertHundred(int num){
        String[] arr1 = {"","One","Two","Three","Four","Five","Six","Seven","Eight","Nine","Ten","Eleven","Twelve","Thirteen","Fourteen","Fifteen","Sixteen","Seventeen","Eighteen","Nineteen"};
        String[] arr2 = {"Twenty","Thirty","Forty","Fifty","Sixty","Seventy","Eighty","Ninety"};
        // 百位数
        int a = num/100; 
        // 最后两位数
        int b = num%100;
        // 最后一位数
        int c = num%10;
        String res = new String();
        if(b<20){
            res = arr1[b];
        }
        else{
            res = arr2[b/10-2] + (c==0? "" : " " + arr1[c]);
        }
        if(a>0){
           res =  arr1[a] + " Hundred" + (b==0? "" : " " + res);
        }
        
        return res;
    }
}