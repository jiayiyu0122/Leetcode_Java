/** The Skyline Problem **/
// MAX HEAP
public class Solution {
    public List<int[]> getSkyline(int[][] buildings) {
        // 把每个edge相对应的高度排序
        // 先按照x position的位置排序
        // 当x postion 的位置相同按高度排序
        List<int[]> edge = new ArrayList<int[]>();
        for(int[] i:buildings){
            edge.add(new int[]{i[0],i[2]});
            edge.add(new int[]{i[1],-i[2]});
        }
        
        Collections.sort(edge, new Comparator<int[]>(){
            public int compare(int[] a, int[] b){
                if(a[0]!=b[0]){
                    return a[0]-b[0];
                }
                else{
                    return b[1] - a[1];
                }
            }
        });
        
        // 用maxheap存取最大值
        // 从大到小
        List<int[]> res = new ArrayList<int[]>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(11,Collections.reverseOrder());
        for(int[] i: edge){
            if(i[1]>0){
                if(maxHeap.isEmpty() || i[1]>maxHeap.peek()){
                res.add(new int[]{i[0],i[1]});
                }
                maxHeap.add(i[1]);
            }
            else{
                maxHeap.remove(-i[1]);
                if(maxHeap.isEmpty() || -i[1]>maxHeap.peek()){
                    res.add(maxHeap.isEmpty()? new int[]{i[0],0}: new int[]{i[0],maxHeap.peek()});
                }
            }
            
        }
        
        return res;
        
    }
}