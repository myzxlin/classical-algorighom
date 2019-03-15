package BackTrack;
import java.util.*;

/** 
 * Parentheses [括号排列] 给出n对括号，求括号排列的所有可能性
 * describe:回溯
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
			dfs(ans+"(", m-1, n, res);  //切记递归时勿改变暂存解(ans)，这是回溯的关键
		if(m<n)
			dfs(ans+")", m, n-1, res);	
	}

}
