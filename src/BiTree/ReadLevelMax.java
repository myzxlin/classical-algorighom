package BiTree;
import java.util.*;

import Helpclass.Node; 

/** 
 * ReadLevelMax ��ӡ�����ÿ������Ԫ��
 * describe:  
 **/ 
public class ReadLevelMax {

	public static void main(String[] args) { 
		ReadLevelMax r = new ReadLevelMax();
		Node root = new Node(0);	
		//List<Integer> ans = r.readLevelMax(root);
	}
	//��α��� �ǵݹ�
	public List<Integer> readLevelMax1(Node root) {
		List<Integer> res = new ArrayList<Integer>();
		LinkedList<Node> list = new LinkedList<>();
		if(root==null)
			return res;
		list.add(root);
		while(!list.isEmpty()) {     //��ʼ��α���
			int size = list.size();  //ÿ��Ԫ�ظ���
			int max=0;               //ÿ��Ԫ�����ֵ
			while(size!=0) {
				Node now = list.poll();
				max = Math.max(max, now.val);
				for(Node child:now.children)
					list.add(child);
				size--;
			}
			res.add(max);            //���ֵ����list
		}	
		return res;
	}
	
	//�ݹ�һ���� �ҳ�ÿ������Ԫ��
	//������ ����treeMap����ÿ���Ԫ�� 
	//ʱ�临�Ӷ�o(max(N,MlogM)) �ռ临�Ӷ�o(M) ����NΪ���нڵ������ M�����Ĳ���
	private List<Integer> level2(Node root){
		List<Integer> res = new ArrayList<Integer>();
		if(root == null) return res;
		Map<Integer,Integer> map = new TreeMap<Integer,Integer>();
		dfs(root,map,1);//��TreeMap �������key���������
		for(Map.Entry<Integer, Integer> entry:map.entrySet()) 
			res.add(entry.getValue());
		return res;
	}
	
	private void dfs(Node now,Map<Integer,Integer> map,int level) {
		//now������Ϊ�� ��Ϊ����ָ����Ϊ�յĺ��ӱ�����
		Integer before = map.get(level);//��ͼ�õ����������Ԫ��
		if(before == null) map.put(level, now.val);//˵����û��
		else 
			if(now.val > before) map.put(level, now.val);//ȡ��
		for(Node child:now.children) 
			dfs(child,map,level+1);//��ʼ���� ���ǲ����Ƿ��������� �������
	}
}
