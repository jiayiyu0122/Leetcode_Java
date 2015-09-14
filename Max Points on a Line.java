/** Max Points on a Line **/

/*================================================================================================
Given n points on a 2D plane, find the maximum number of points that lie on the same straight line.
================================================================================================*/
/**
 * Definition for a point.
 * class Point {
 *     int x;
 *     int y;
 *     Point() { x = 0; y = 0; }
 *     Point(int a, int b) { x = a; y = b; }
 * }
 */
// 指定某一个点，斜率和这个点一样的点在同一条直线上
public class Solution {
    public int maxPoints(Point[] points) {
        if(points==null || points.length==0) return 0;
        int max = 0;
        for(int i=0; i<points.length; i++){
            HashMap<Double, Integer> hm = new HashMap<Double, Integer>();
            int duplicates = 1;
            int vertical = 0;
            for(int j=i+1; j<points.length; j++){
                // 注意特殊的点：1. duplicate, 2. vertical, 3. horizen
                if(points[i].x==points[j].x){
                    if(points[i].y==points[j].y){
                        duplicates++;
                    }
                    else{
                        vertical++;
                    }
                }
                else{
                    double k = (points[i].y==points[j].y)? 0.0:(1.0*(points[i].y-points[j].y)/(points[i].x-points[j].x));
                    if(hm.containsKey(k)){
                        hm.put(k,hm.get(k)+1);
                    }
                    else{
                        hm.put(k,1);
                    }
                    
                }
            }
                
                
            for(Integer temp:hm.values()){
                if(temp+duplicates>max){
                    max = temp+duplicates;
                }
            }
            
            if(vertical+duplicates>max){
                max = vertical+duplicates;
            }
                
                
            
        }
        
        return max;
    }
    
    
}