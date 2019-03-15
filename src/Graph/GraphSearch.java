package Graph;
import java.util.*;

/** 
 * bfs [������ȱ���] Breadth First Search 
 * ����㿪ʼ�����������ڽӵ㶼�ӵ�һ��������ȥ�������Щ�������ľ���Ϊ1,�ٽ������Ϊ�ѷ���
 * Ȼ��Ӷ�ͷȡ�㣬�����ڽӵ�����β������Щ�����Ծ����1��������ȥֱ������Ϊ�ա�
 * ����ÿ�����㱻���ʵĴ������һ��(�ѷ��ʵĽڵ㲻���ٷ���)��
 * ������ͨͼ��˵��ÿ�����㶼�ᱻ����, ��ÿ��������ڽ������ᱻ������
 * ���ʱ�临�Ӷ���o(V+E)��V�Ƕ��������E�Ǳ���(�ڽӱ���Ԫ�ظ���)
 * 
 * dfs [������ȱ���] Depth First Search 
 * ����㿪ʼ���ݹ�����������ڽ��ڵ㣬����A�ڵ������һ���ڽ��ڵ㣬��B�ڵ�����A��һ���ڽ��ڵ㣬
 * ��dfs����A�ڵ���ٷ���B�ڵ㣬���B�ڵ���δ���ʵ��ڽ��ڵ�Ļ��������������ڽ��ڵ㣬
 * �����������A��δ�����ڽ��ڵ㣬�����д�A�ڵ��ȥ��·����������֮�󣬼����ݹ���ʳ�A����δ�����ʵ��ڽ��ڵ㡣
 **/ 
public class GraphSearch {

	int count = 0;
	
	public static void main(String[] args) {
		GraphSearch g = new GraphSearch();
	        
		//�ڽӱ��������
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
	        
	    //����ͼ
	    HashMap<Character, LinkedList<Character>> graph = new HashMap<>();
	    graph.put('a', list_a);
	    graph.put('b', list_b);
	    graph.put('c', list_c);
	    graph.put('d', list_d); 
	        
	    char start = 'a';                                       //��ʼ����	     
	    g.bfs(graph, start);                                    //������ȱ���
	    g.dfs(graph,new HashMap<Character, Boolean>(), start);  //������ȱ���
	}
 
	public void bfs(HashMap<Character, LinkedList<Character>> graph, char start){
		HashMap<Character, Integer> dist = new HashMap<>();     //��¼ÿ��������������̾���
		Queue<Character> q = new LinkedList<>();
	    q.add(start);                                           //������
	    dist.put(start, 0);
	    int i=0;
	    while(!q.isEmpty()){
	        char top = q.poll();                                //ȡ������Ԫ��
	        i++;
	        System.out.println("The "+i+"th element:"+top+"  Distance from a is:"+dist.get(top));
	        int d = dist.get(top)+1;                            //�ó�δ�����ڽӵ�ľ��� 
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
	        		dfs(graph,visited,c);                      //�ݹ�������ڽ��ڵ� 
	        }
	        count++; 
	    }
	}

}
