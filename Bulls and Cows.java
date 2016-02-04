/* Bulls and Cows */
/*==================================================================
You are playing the following Bulls and Cows game with your friend: You write a 4-digit secret number and ask your friend to guess it, each time your friend guesses a number, you give a hint, the hint tells your friend how many digits are in the correct positions (called "bulls") and how many digits are in the wrong positions (called "cows"), your friend will use those hints to find out the secret number.

For example:

Secret number:  1807
Friend's guess: 7810
Hint: 1 bull and 3 cows. (The bull is 8, the cows are 0, 1 and 7.)
==================================================================*/
public class Solution {
    public String getHint(String secret, String guess) {
        int bull = 0;
        int cows = 0;
        int[] count = new int[10];
        for(int i=0; i<secret.length(); i++){
            if(secret.charAt(i)==guess.charAt(i)){
                bull++;
            }
            else{
                count[secret.charAt(i)-'0']++;
                if(count[secret.charAt(i)-'0']<=0){
                    cows++;
                }
                count[guess.charAt(i)-'0']--;
                if(count[guess.charAt(i)-'0']>=0){
                    cows++;
                }
            }
        }
        
        String s = String.valueOf(bull) + "A" + String.valueOf(cows) + "B";
        return s;
        
    }
}