package BackTrack;
import java.util.*;

/**
 * SubsetSum [子集和问题] 给定int[]和正整数m n,问m是否可以为数集中最多n个数的和(可以重复取)
 * describe:回溯
 **/ 
public class SubsetSum {

	public static void main(String[] args) { 
		SubsetSum s = new SubsetSum();
		int[] a = new int[] {4,3,2};
		int m = 9;
		int n = 3;
		s.judge(a, m, n);
	}
	
	public void judge(int[] a, int m, int n) {
		List<List<Integer>> res = new ArrayList<>();
		Arrays.sort(a);
		dfs(a, m, n, 0, new ArrayList<>(), res);
		if(res.size()==0)
			System.out.print("不可能");
		else {
			System.out.print("可能\n");
			for(List<Integer> i:res)
				System.out.print(i+"\n");
		}
				
	}
	public void dfs(int[] a, int m, int n, int k, List<Integer> item, List<List<Integer>> res) {
		if(sum(item)==m) {
			res.add(new ArrayList<>(item));
			return;
		}
		if(sum(item)<m && item.size()<n) {     //剪枝
			for(int i=k; i<a.length; i++) {
				item.add(a[i]);
				dfs(a, m, n, i, item, res);
				item.remove(item.size()-1);    //回溯
			}
		}
	}
	//列表元素求和
	public int sum(List<Integer> a) {
		int sum = 0;
		for(int i:a)
			sum += i;
		return sum;
	}

}
