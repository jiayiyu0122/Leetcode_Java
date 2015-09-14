import java.util.*;
// 超时
public class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        LinkedList<Integer> queue = new LinkedList<Integer>();
        
        if(prerequisites.length==0||numCourses==0) return new int[0];
        int row = prerequisites.length;
        // vertex matrix for i to j
        int[][] matrix = new int[numCourses][numCourses];
        for(int i=0; i<row; i++){
            matrix[prerequisites[i][0]][prerequisites[i][1]]=1;
        }
        // no prerequisites course
        int[] hasPre = new int[numCourses];
        for(int i=0; i<row; i++){
            hasPre[prerequisites[i][0]]++;
        }
        // queue, bfs
        
        for(int i=0; i<numCourses;i++){
            if(hasPre[i]==0){
                 if(res.contains(hasPre[i])) return new int[0];
                 queue.push(hasPre[i]);
            }
        }
        while(!queue.isEmpty()){
            int temp = queue.poll();
            if(res.contains(temp)) return new int[0];
            res.add(temp);
            for(int i=0; i<numCourses; i++){
                if(matrix[i][temp]==1){
                    if(queue.contains(i)){
                        continue;
                    }
                    if(res.contains(i)){
                        return new int[0];
                    }
                }
            }
        }
        int[] result = new int[res.size()];
        for(int i=0; i<res.size();i++){
            result[i] = res.get(i);
        }
        return result;
    }
}