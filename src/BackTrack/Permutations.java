package BackTrack;
import java.util.*;

/**Permutations [全排列] 给一个无重复项的数组，给出所有排列
 * 求字符串全排列本质上也是一回事，转换为char[]即可 
 * describe:回溯
 **/ 
public class Permutations { 
	
	public static void main(String[] args) { 
		Permutations a = new Permutations(); 
		Object res = a.permutations(new int[]{1,4,5});
	}
	
	public List<List<Integer>> permutations(int[] a){
		List<List<Integer>> res = new ArrayList<>(); 
		dfs(a, new ArrayList<>(), res);
		return res;
	}
	void dfs(int[] a, List<Integer> item, List<List<Integer>> res) {
		if(item.size()==a.length) {  
			res.add(new ArrayList<>(item));
			return;
		}
		for(int i=0; i<a.length; i++) {
			if(item.contains(a[i]))     //若包含这个元素就跳过
				continue;
			item.add(a[i]);
			dfs(a, item, res);
			item.remove(item.size()-1);    //回退
		}
	} 
}
