package Graph;
import java.util.*;

/** 
 * bfs [广度优先遍历] Breadth First Search 
 * 从起点开始，将其所有邻接点都加到一个队列中去，标记这些点离起点的距离为1,再将起点标记为已访问
 * 然后从队头取点，将其邻接点加入队尾，将这些点的相对距离加1，依次下去直到队列为空。
 * 由于每个顶点被访问的次数最多一次(已访问的节点不会再访问)，
 * 对于连通图来说，每个顶点都会被访问, 且每个顶点的邻接链表都会被遍历，
 * 因此时间复杂度是o(V+E)，V是顶点个数，E是边数(邻接表中元素个数)
 * 
 * dfs [深度优先遍历] Depth First Search 
 * 从起点开始，递归访问其所有邻近节点，比如A节点是其第一个邻近节点，而B节点又是A的一个邻近节点，
 * 则dfs访问A节点后再访问B节点，如果B节点有未访问的邻近节点的话将继续访问其邻近节点，
 * 否则继续访问A的未访问邻近节点，当所有从A节点出去的路径都访问完之后，继续递归访问除A以外未被访问的邻近节点。
 **/ 
public class GraphSearch {

	int count = 0;
	
	public static void main(String[] args) {
		GraphSearch g = new GraphSearch();
	        
		//邻接表构造各顶点
	    LinkedList<Character> list_a = new LinkedList<Character>();
	    list_a.add('b');
	    list_a.add('c');
	    LinkedList<Character> list_b = new LinkedList<Character>();
	    list_b.add('a'); 
	    list_b.add('d');
	    LinkedList<Character> list_c = new LinkedList<Character>();
	    list_c.add('a');
	    list_c.add('d');
	    LinkedList<Character> list_d = new LinkedList<Character>();
	    list_d.add('b');
	    list_d.add('c'); 
	        
	    //构造图
	    HashMap<Character, LinkedList<Character>> graph = new HashMap<>();
	    graph.put('a', list_a);
	    graph.put('b', list_b);
	    graph.put('c', list_c);
	    graph.put('d', list_d); 
	        
	    char start = 'a';                                       //起始顶点	     
	    g.bfs(graph, start);                                    //广度优先遍历
	    g.dfs(graph,new HashMap<Character, Boolean>(), start);  //深度优先遍历
	}
 
	public void bfs(HashMap<Character, LinkedList<Character>> graph, char start){
		HashMap<Character, Integer> dist = new HashMap<>();     //记录每个顶点离起点的最短距离
		Queue<Character> q = new LinkedList<>();
	    q.add(start);                                           //起点入队
	    dist.put(start, 0);
	    int i=0;
	    while(!q.isEmpty()){
	        char top = q.poll();                                //取出队首元素
	        i++;
	        System.out.println("The "+i+"th element:"+top+"  Distance from a is:"+dist.get(top));
	        int d = dist.get(top)+1;                            //得出未访问邻接点的距离 
	        for (Character c : graph.get(top)) {
	            if(!dist.containsKey(c)){
	                dist.put(c, d);
	                q.add(c);
	            }
	        }
	    }
	} 
	
	void dfs(HashMap<Character , LinkedList<Character>> graph, HashMap<Character, Boolean> visited, char start) {
	    if(!visited.containsKey(start)) {
	        count++;
	        System.out.println("The "+count+"th element:" +start); 
	        visited.put(start, true);
	        for (char c : graph.get(start)) {
	        	if(!visited.containsKey(c))  
	        		dfs(graph,visited,c);                      //递归访问其邻近节点 
	        }
	        count++; 
	    }
	}

}
