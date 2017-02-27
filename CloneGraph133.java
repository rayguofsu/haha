
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

public class Solution {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null) return null;
        Map<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<>();
        Queue<UndirectedGraphNode> que = new LinkedList<>();
        que.offer(node);
        UndirectedGraphNode oldNode = node;
        while(!que.isEmpty()){ //bfs + create each new node
            node = que.poll();
           // UndirectedGraphNode newNode = new UndirectedGraphNode(node.label);
            map.put(node, new UndirectedGraphNode(node.label));
            for (int i = 0; i < node.neighbors.size(); i++){
               // System.out.println("newsize is " + i);
                UndirectedGraphNode neighbor = node.neighbors.get(i);
                if (!map.containsKey(neighbor)){
                    que.offer(neighbor);
                }
            }
        }
        //iteratating old node and connect new nodes
        for (UndirectedGraphNode n: map.keySet()){
            //System.out.println("new is " + n.label);
            List<UndirectedGraphNode> newNeighbors = new ArrayList<>();
            List<UndirectedGraphNode> oldNeighbors = n.neighbors;
            for (int i = 0; i < oldNeighbors.size(); i++){
                //System.out.println("oldNeighbor is " + i);
                newNeighbors.add(map.get(oldNeighbors.get(i)));
            }
            map.get(n).neighbors = newNeighbors;
        }
        
        return map.get(oldNode);
        
    }
}
