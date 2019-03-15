package BackTrack;
import java.util.*;

/** 
 * Parentheses [��������] ����n�����ţ����������е����п�����
 * describe:����
 **/ 
public class Parentheses {
	
	public static void main(String[] args) { 
		Parentheses p = new Parentheses(); 
		System.out.print(p.parentheses(3));
	}
	
	public List<String> parentheses(int a){
		List<String> res = new ArrayList<String>();
		dfs("", a, a, res);
		return res;
	}
	void dfs(String ans, int m, int n, List<String> res) {
		if(m==0 && n==0) {        
			res.add(ans); 
			return;
		}
		if(m>0) 
			dfs(ans+"(", m-1, n, res);  //�мǵݹ�ʱ��ı��ݴ��(ans)�����ǻ��ݵĹؼ�
		if(m<n)
			dfs(ans+")", m, n-1, res);	
	}

}
