package BackTrack;
import java.util.*;

/**
 * SubsetSum [�Ӽ�������] ����int[]��������m n,��m�Ƿ����Ϊ���������n�����ĺ�(�����ظ�ȡ)
 * describe:����
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
			System.out.print("������");
		else {
			System.out.print("����\n");
			for(List<Integer> i:res)
				System.out.print(i+"\n");
		}
				
	}
	public void dfs(int[] a, int m, int n, int k, List<Integer> item, List<List<Integer>> res) {
		if(sum(item)==m) {
			res.add(new ArrayList<>(item));
			return;
		}
		if(sum(item)<m && item.size()<n) {     //��֦
			for(int i=k; i<a.length; i++) {
				item.add(a[i]);
				dfs(a, m, n, i, item, res);
				item.remove(item.size()-1);    //����
			}
		}
	}
	//�б�Ԫ�����
	public int sum(List<Integer> a) {
		int sum = 0;
		for(int i:a)
			sum += i;
		return sum;
	}

}
