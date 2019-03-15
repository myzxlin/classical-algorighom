package BackTrack;
import java.util.*;

/**Permutations [ȫ����] ��һ�����ظ�������飬������������
 * ���ַ���ȫ���б�����Ҳ��һ���£�ת��Ϊchar[]���� 
 * describe:����
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
			if(item.contains(a[i]))     //���������Ԫ�ؾ�����
				continue;
			item.add(a[i]);
			dfs(a, item, res);
			item.remove(item.size()-1);    //����
		}
	} 
}
