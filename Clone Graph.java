/** Clone Graph **/
/*========================================================================================================================
Clone an undirected graph. Each node in the graph contains a label and a list of its neighbors.


OJ's undirected graph serialization:
Nodes are labeled uniquely.

We use # as a separator for each node, and , as a separator for node label and each neighbor of the node.
As an example, consider the serialized graph {0,1,2#1,2#2,2}.

The graph has a total of three nodes, and therefore contains three parts as separated by #.

First node is labeled as 0. Connect node 0 to both nodes 1 and 2.
Second node is labeled as 1. Connect node 1 to node 2.
Third node is labeled as 2. Connect node 2 to node 2 (itself), thus forming a self-cycle.
Visually, the graph looks like the following:

       1
      / \
     /   \
    0 --- 2
         / \
         \_/
========================================================================================================================*/

/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     List<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class Solution {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if(node==null) return null;
        LinkedList<UndirectedGraphNode> queue = new LinkedList<UndirectedGraphNode>();
        HashMap<UndirectedGraphNode,UndirectedGraphNode> hm = new HashMap<UndirectedGraphNode,UndirectedGraphNode>();
        UndirectedGraphNode newHead = new UndirectedGraphNode(node.label);
        hm.put(node,newHead);
        queue.push(node);
        while(!queue.isEmpty()){
            UndirectedGraphNode temp = queue.poll();
            // put nodes in queue
            for(UndirectedGraphNode n : temp.neighbors){
                if(!hm.containsKey(n)){
                    queue.push(n);
                    UndirectedGraphNode copy = new UndirectedGraphNode(n.label);
                    hm.put(n,copy);
                    hm.get(temp).neighbors.add(copy);
                }
                else{
                    hm.get(temp).neighbors.add(hm.get(n));
                }
            }
        }
        return newHead;
        
    }
}