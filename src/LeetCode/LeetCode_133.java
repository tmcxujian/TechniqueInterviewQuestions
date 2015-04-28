package LeetCode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class LeetCode_133 {
	
	//below is using DFS
	public static UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
		if(node == null){
			return node;
		}
		Map<UndirectedGraphNode, UndirectedGraphNode> map = 
				new HashMap<UndirectedGraphNode, UndirectedGraphNode>();
        return DFS(node,map);
    }
	
	public static UndirectedGraphNode DFS(UndirectedGraphNode node, 
			Map<UndirectedGraphNode, UndirectedGraphNode> map){
		if(map.containsKey(node)){
			return map.get(node);
		}
		UndirectedGraphNode nodeCopy = new UndirectedGraphNode(node.label);
		map.put(node,nodeCopy);
		for(UndirectedGraphNode neighbor : node.neighbors){
			nodeCopy.neighbors.add(DFS(neighbor,map));
		}
		return nodeCopy;
	}
	
	//Below is BFS
	public static UndirectedGraphNode cloneGraph2(UndirectedGraphNode node){
		if(node == null){
			return node;
		}
		Map<UndirectedGraphNode, UndirectedGraphNode> map = 
				new HashMap<UndirectedGraphNode, UndirectedGraphNode>();
		Queue<UndirectedGraphNode> queue = new LinkedList<UndirectedGraphNode>();
		queue.add(node);
		UndirectedGraphNode graphCopy = new UndirectedGraphNode(node.label);
		map.put(node,graphCopy);
		while(!queue.isEmpty()){
			UndirectedGraphNode graph = queue.poll();
			for(UndirectedGraphNode neighbor : graph.neighbors){
				if(map.containsKey(neighbor)){
					map.get(neighbor).neighbors.add(map.get(graph));
				}
				else{
					UndirectedGraphNode neighborCopy = new UndirectedGraphNode(neighbor.label);
					map.get(graph).neighbors.add(neighborCopy);
					map.put(neighbor,neighborCopy);
					queue.add(neighbor);
				}
			}
		}
		return graphCopy;
	}
	
}
