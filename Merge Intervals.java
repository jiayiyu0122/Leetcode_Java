/** Merge Intervals **/
/*==================================================================
Given a collection of intervals, merge all overlapping intervals.

For example,
Given [1,3],[2,6],[8,10],[15,18],
return [1,6],[8,10],[15,18].
==================================================================*/
/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
// 这道题一定要先按照interval的start的数排序。例如[1,2][3,4][5,6][1,10]. 最后一个覆盖了前面所有的。所以要先排序。
public class Solution {
    public List<Interval> merge(List<Interval> intervals) {
        int length = intervals.size();
        List<Interval> res = new ArrayList<Interval>();
        if(length==0) return res;
        Collections.sort(intervals, new Comparator<Interval>(){
            public int compare(Interval i1, Interval i2){
                return i1.start-i2.start;
            }
        });
        int start = intervals.get(0).start;
        int end = intervals.get(0).end;
        for(int i=1; i<length; i++){
            int tempStart = intervals.get(i).start;
            int tempEnd = intervals.get(i).end;
            if(tempStart>end){
                Interval temp = new Interval(start,end);
                res.add(temp);
                start = tempStart;
                end = tempEnd;
            }
            else if(tempEnd<start){
                Interval temp = new Interval(tempStart,tempEnd);
                res.add(temp);
            }
            else{
                if(tempStart<start){
                    start = tempStart;
                }
                if(tempEnd>end){
                    end = tempEnd;
                }
            }
        }
        // add the last start end interval
        res.add(new Interval(start,end));
        
        return res;
        
    }
}