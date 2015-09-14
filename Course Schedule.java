/** Course Schedule  **/
/*==================================================================================================================================
There are a total of n courses you have to take, labeled from 0 to n - 1.
Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]
Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all courses?
For example:
2, [[1,0]]
There are a total of 2 courses to take. To take course 1 you should have finished course 0. So it is possible.
2, [[1,0],[0,1]]
There are a total of 2 courses to take. To take course 1 you should have finished course 0, and to take course 0 you should also have finished course 1.
So it is impossible.
===================================================================================================================================*/
// dfs
public class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if(prerequisites.length==0||numCourses==0) return true;
       // if(prerequisites.length<numCourses) return false;
        int row = prerequisites.length;
        int[][] matrix = new int[numCourses][numCourses];
        // set matrix, v(i,j)=1 means from node i to j 
        for(int i=0; i<row; i++){
            matrix[prerequisites[i][0]][prerequisites[i][1]]=1;
        }
        // array for visit
        int[] visit = new int[numCourses];//0 not visited, 1 visiting, 2 visited
        
        for(int i=0; i<numCourses; i++){
            if(visit[i]==0){
                if(dfs(i,matrix,visit)){
                    continue;   
                }
                return false;
            }
        }
        
        return true;
        
    }
    
    public boolean dfs(int node, int[][] matrix, int[] visit){
        
        visit[node] = 1;
        for(int i=0; i<matrix.length; i++){
            if(matrix[node][i]==1){
                if(visit[i]==1){
                    // cycle
                    return false;
                }
                if(visit[i]==0 && !dfs(i,matrix,visit)){
                    return false;
                }
            }
        }
        visit[node] = 2;
        return true;
    }
}