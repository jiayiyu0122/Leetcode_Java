/* Rectangle Area */
public class Solution {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int dupArea = 0;
        int area = 0;
        int areaA = Math.abs(A-C)*Math.abs(B-D);
        int areaB = Math.abs(E-G)*Math.abs(F-H);
        // 一个长方形在另一个长方形里面。
        if(((E>=A) && (G<=C)) && ((F>=B)&&(H<=D))){ 
            return areaA;
        }
        if(((E<=A) && (G>=C)) && ((F<=B)&&(H>=D))){
            return areaB;
        }
        //两个长方形没有重合的区域
        if(H<=B || F>=D){
           area = areaA + areaB;
        }
        else if(E>=C || G<=A){
            area = areaA + areaB;
        }
        //两个长方形有重合的区域
        else{
                dupArea = Math.abs(Math.max(A,E)-Math.min(C,G))*Math.abs(Math.min(D,H)-Math.max(B,F));
                area = areaA + areaB - dupArea;
	            
            
        }
        
        return area;
    }
}