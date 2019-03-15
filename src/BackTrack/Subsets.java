package BackTrack;
import java.util.*;

/** 
 * Subsets [�Ӽ���] ����һ�������ظ�Ԫ�ص����飬����ȫ���Ӽ�(�����ռ�)  
 * describe: ����
 **/ 
public class Subsets {
	
	public static void main(String[] args) {
		Subsets s = new Subsets();
		List<List<Integer>> res = s.subsets(new int[] {1,2,3,4}); 
		for(List<Integer> i:res)
			System.out.print(i+"\n");
			
	}
	
	public List<List<Integer>> subsets(int[] a){ 
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		dfs(a, 0, new ArrayList<Integer>(), res);
		return res;
	}
	void dfs(int[] a, int k, List<Integer> item, List<List<Integer>> res) { 
		res.add(new ArrayList<Integer>(item));
		for(int i=k; i<a.length; i++) {
			item.add(a[i]);
			dfs(a, i+1, item, res);
			item.remove(item.size()-1);  //����
		}
			
	}
}
