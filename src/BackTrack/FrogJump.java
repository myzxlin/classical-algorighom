package BackTrack; 
import java.util.*;

/** ̨���ܹ���n(n<=50)��������ÿ�ο�����̨����Ϊ1~n��������n��̨���ж���������
 *  describe:����
 */
public class FrogJump {
 
	int count = 0; //������ 
	
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
		if(k<n) {        //��֦
			for(int i=k; i<n; i++) 
				dfs(n, i+1);
		} 	
	}
}
