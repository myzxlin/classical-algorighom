package BackTrack; 
import java.util.*;

/** 台阶总共有n(n<=50)级，青蛙每次可跳的台阶数为1~n，问跳到n层台阶有多少种跳法
 *  describe:回溯
 */
public class FrogJump {
 
	int count = 0; //跳法数 
	
	public static void main(String[] args) { 
		FrogJump f = new FrogJump();  
		System.out.print(f.jump(8));
	}
	
	public int jump(int n) {
		dfs(n, 0);
		return count;
	}
	void dfs(int n, int k) {
		if(k==n) {
			count++;
			return;
		}			
		if(k<n) {        //剪枝
			for(int i=k; i<n; i++) 
				dfs(n, i+1);
		} 	
	}
}
