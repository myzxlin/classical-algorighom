package BackTrack;
import java.util.*;

/**
 * SetDecomposition [集合分解问题] 
 * 给定集合int[] s，问能否将s中的数分成6个集合，使所有集合中数的和相等  
 * describe:回溯
 * (不会做)
 **/ 
public class SetDecomposition  {

	public static void main(String[] args) { 
		SetDecomposition s = new SetDecomposition();
		int[] a = new int[] {1,2,3,4,5,6};
		s.de(a);
	}
	boolean de(int[] a) {
		List<List<Integer>> res = new ArrayList<>();
		dfs(a, 0, new ArrayList<>(), res);
		System.out.print(res.size());
		if(res.size()>=6)
			return true;
		return false;
		
		/*while(res.size()<6) {
			dfs(a, 0, res);
		}			
		if(res.size()==6)
			return true;
		return false;*/
	}

	void dfs(int[] a, int k, List<Integer> item, List<List<Integer>> res) {
		if(sum(item)==6) {
			res.add(new ArrayList<>(item));
			return;
		}
		if(sum(item)<6) {
			
		}
	}
	int sum(List<Integer> a) {
		int sum = 0;
		for(int i:a)
			sum += i;
		return sum;
	}
}
