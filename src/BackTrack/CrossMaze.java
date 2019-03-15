package BackTrack;
import java.util.*;

/**以一个MxN的方阵表示迷宫，0和1分别表示迷宫中的通路和障碍
 * 对任意输入的迷宫，输出一条从入口到出口的通路，或得出没有通路的结论
 * describe：回溯
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
		String ans = flag? "找到出路":"没有出路";
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
