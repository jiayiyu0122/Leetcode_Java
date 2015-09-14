/** Gas Station **/

/*===========================================================================================================================
There are N gas stations along a circular route, where the amount of gas at station i is gas[i].

You have a car with an unlimited gas tank and it costs cost[i] of gas to travel from station i to its next station (i+1). You begin the journey with an empty tank at one of the gas stations.

Return the starting gas station's index if you can travel around the circuit once, otherwise return -1.

===========================================================================================================================*/
// 这道题的关键之处是要知道如果从某一个start 到不了某一个gas station，那么这中间的gas station也没有办法到达， 所以start指针要设置为current后面那个。
public class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        int start = 0;
        int cur = start;
        int remaining = 0;
        while(start<n){
            cur = start;
            while(remaining+gas[cur]>=cost[cur]){
                remaining = remaining+gas[cur]-cost[cur];
                // check if the current pointer is the pointer before start
                if(start==0){
                    if(cur==n-1) return start;
                }
                else{
                    if(cur==start-1) return start;
                }
                // move current pointer
                if(cur==n-1){
                    cur = 0;
                }
                else{
                    cur++;
                }
            }
            if(remaining+gas[cur]<cost[cur]){
                // check if start pointer is the end of the array to quit the loop
                    if(start==n-1) break;
                // if not move start pointer
                    start = cur+1;
                    remaining = 0;
                }
            }
        return -1;
    }
}