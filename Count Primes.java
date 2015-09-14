/** Count Primes **/
/*====================================================================
Description:

Count the number of prime numbers less than a non-negative number, n.
====================================================================*/
// 思路： 一个数时候是prime，看这个数能否整除比这个数小的prime. 假如可以整出那么得到的数是prime
// 超时，o(n)
public class Solution {
    public int countPrimes(int n) {
        if(n==0) return 0;
        if(n==1) return 0;
        if(n==2) return 1;
        List<Integer> prime = new ArrayList<Integer>();
        prime.add(2);
        for(int i=3; i<=n; i++){
            if(isPrime(i,prime)){
                prime.add(i);
            }
        }
        return prime.size();
    }
    
    public boolean isPrime(int n, List<Integer> prime){
        for(int i:prime){
            if(n%i==0){
                return false;
            }
        }
        return true;
    }
}