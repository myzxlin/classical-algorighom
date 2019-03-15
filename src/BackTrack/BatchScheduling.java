package BackTrack;
import java.util.*;

/** 
 * BatchScheduling [批处理作业调度] 给定n个作业，每个作业必须先由机器1处理，再由机器2处理。
 * t[i][j]表示作业i需要机器j的处理时间， 所有作业在机器2上完成处理的时间和称为该作业调度的完成时间和。
 * 求最佳作业调度方案，使其完成时间和达到最小。例：
 *        作业1  作业2  作业3
 * 机器1    2     3      3
 * 机器2    1     1      3
 * 这3个作业的6种可能的调度方案是 123,132,213,231,312,321,它们相应的完成时间和分别是19,18,20,21,19,19。
 * 易见，最佳调度方案是 132，其完成时间和为18。(画画图就懂了)
 * 
 * 思路： 批处理作业调度问题要从n个作业的所有排列中找出具有最小完成时间和的作业调度，解空间是一颗排列树。
 * 当前作业i在机器2上完成时间, 由作业i-1在机器2上完成时间和作业i在机器1上完成的时间的较大者决定，即：
 * f2[i] = Math.max(f2[i-1], f1) + t[cur[j]][1];
 */
public class BatchScheduling { 
              
	int bestf = Integer.MAX_VALUE;       //当前最优值 
	int[] bestx;                         //当前最优作业调度 

	public static void main(String[] args) {
		BatchScheduling b = new BatchScheduling();		
		int[][] t = { 
				{ 0, 0 },
				{ 2, 1 }, 
				{ 3, 1 }, 
				{ 2, 3 }     
			};		
		System.out.println("当前最优值:" + b.batch(t));
		System.out.println("当前最优作业调度：" + Arrays.toString(b.bestx));
	}
	public int batch(int[][] t) {  
		int n = t.length;   
		bestx = new int[n]; 
		int[] cur = new int[n];
		for(int i=0; i<n; i++)            //任意初始化一条路径
			cur[i]=i;	
		dfs(t, 1, 0, new int[n], 0, cur); //从第一项作业开始
		return bestf;
	}
	/** 
	 * @param t   各作业所需的处理时间
	 * @param i   当前节点
	 * @param f1    机器1完成处理时间
	 * @param f2    机器2完成处理时间
	 * @param f   当前完成时间和
	 * @param cur 当前作业调度
	 */
	public void dfs(int[][] t, int i, int f1, int[] f2, int f, int[] cur) {
		int n = t.length-1;
		if(i>n){
			if(f<bestf) {
				for(int j=1; j<=n; j++) 
					bestx[j] = cur[j]; 
				bestf = f; 
			}
			return;
		}  
		for(int j=i; j<=n; j++){
			f1 += t[cur[j]][0];
			f2[i] = Math.max(f2[i-1],f1) + t[cur[j]][1];		
			if(f<bestf) {                 //剪枝 有可能更优时才进入
				swap(cur, i, j);
				dfs(t, i+1, f1, f2, f+f2[i], cur);
				swap(cur, i, j);
			}			 
			f1 -= t[cur[j]][0];			
		}
	}
	public int[] swap(int[] x, int i, int j) {
		int t = x[j];
		x[j] = x[i];
		x[i] = t;
		return x;
	}
	
}
