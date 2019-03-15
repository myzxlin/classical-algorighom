package BiTree;
import java.util.*;

import Helpclass.Node; 

/** 
 * ReadLevelMax 打印多叉树每层最大的元素
 * describe:  
 **/ 
public class ReadLevelMax {

	public static void main(String[] args) { 
		ReadLevelMax r = new ReadLevelMax();
		Node root = new Node(0);	
		//List<Integer> ans = r.readLevelMax(root);
	}
	//层次遍历 非递归
	public List<Integer> readLevelMax1(Node root) {
		List<Integer> res = new ArrayList<Integer>();
		LinkedList<Node> list = new LinkedList<>();
		if(root==null)
			return res;
		list.add(root);
		while(!list.isEmpty()) {     //开始层次遍历
			int size = list.size();  //每层元素个数
			int max=0;               //每层元素最大值
			while(size!=0) {
				Node now = list.poll();
				max = Math.max(max, now.val);
				for(Node child:now.children)
					list.add(child);
				size--;
			}
			res.add(max);            //最大值加入list
		}	
		return res;
	}
	
	//递归一棵树 找出每层最大的元素
	//用深搜 带上treeMap深搜每层的元素 
	//时间复杂度o(max(N,MlogM)) 空间复杂度o(M) 其中N为所有节点的数量 M是树的层数
	private List<Integer> level2(Node root){
		List<Integer> res = new ArrayList<Integer>();
		if(root == null) return res;
		Map<Integer,Integer> map = new TreeMap<Integer,Integer>();
		dfs(root,map,1);//按TreeMap 就完成了key排序的任务
		for(Map.Entry<Integer, Integer> entry:map.entrySet()) 
			res.add(entry.getValue());
		return res;
	}
	
	private void dfs(Node now,Map<Integer,Integer> map,int level) {
		//now不可能为空 因为我是指定不为空的孩子遍历的
		Integer before = map.get(level);//企图得到这个层最大的元素
		if(before == null) map.put(level, now.val);//说明还没有
		else 
			if(now.val > before) map.put(level, now.val);//取代
		for(Node child:now.children) 
			dfs(child,map,level+1);//开始深搜 但是参数是非引用类型 无需回溯
	}
}
