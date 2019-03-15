package BackTrack;
import java.util.*;

/**��һ��MxN�ķ����ʾ�Թ���0��1�ֱ��ʾ�Թ��е�ͨ·���ϰ�
 * ������������Թ������һ������ڵ����ڵ�ͨ·����ó�û��ͨ·�Ľ���
 * describe������
 */
public class CrossMaze { 
	
	boolean flag = false;
			
	public static void main(String[] args) { 
		CrossMaze m = new CrossMaze();
		int[][] a = new int[][] {
			{0,1,0,0,1,0},
			{0,0,0,0,0,1},
			{0,1,0,0,1,1},
			{1,1,0,0,1,0},
			{0,0,1,0,0,0}
		};
		m.jump(a);
	}
	
	void jump(int[][] a) {
		int[][] cur = a.clone();
		dfs(a, cur, 0, 0);
		String ans = flag? "�ҵ���·":"û�г�·";
		System.out.print(ans);
	}
	void dfs(int[][] a, int[][] cur, int m, int n) {
		int x = a.length;
		int y = a[0].length;
		if(m<0||m>=x || n<0||n>=y || a[m][n]==1)
			return;
		cur[m][n]=1;
		if(m==x-1 && n==y-1) { 
			flag = true;
			for(int[] i:cur)
				System.out.print(Arrays.toString(i)+"\n"); 
			return;				
		}
		dfs(a, cur, m+1, n);
		dfs(a, cur, m-1, n);
		dfs(a, cur, m, n+1);
		dfs(a, cur, m, n-1);
		cur[m][n]=0;
	}
}
