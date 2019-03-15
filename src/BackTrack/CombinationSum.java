package BackTrack;
import java.util.*;

/** 
 * CombinationSum [��������] ����int[] a��k,��a��������ϵĺ�=k �����
 * ����[2,3,4] target=8 ans=[2,2,2,2] [2,2,4] [4,4] [2,3,3]
 * describe:����
 **/ 
public class CombinationSum { 
	
	public static void main(String[] args) { 
		CombinationSum c = new CombinationSum(); 
		Object res = c.combinationSum(new int[]{1,2,5}, 5);	
	}
	
	public List<List<Integer>> combinationSum(int[] a, int n){
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		dfs(a, n, 0, new ArrayList<Integer>(), res);
		return res;				
	}
	void dfs(int[] a, int n, int k, List<Integer> item, List<List<Integer>> res){
		if(n==0) {
			List<Integer> now = new ArrayList<Integer>(item);
			res.add(now);
			return;
		}
		if(a[k]>n)                       //��֦
			return;
		for(int i=k; i<a.length; i++) {
			item.add(a[i]);
			dfs(a, n-a[i], i, item, res);
			item.remove(item.size()-1);  //����
		}	
	}

}
