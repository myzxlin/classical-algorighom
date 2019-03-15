package BackTrack;
import java.util.*;

/** 
 * Knapsack [0-1背包问题] 给定N个物品和一个背包,物品i重量是Wi 价值是Vi 背包容量为C
 * 如何选择装入背包的物品，使得背包物品总价值最大
 * describe:回溯
 **/ 
public class Knapsack {
  
	int vbest = 0;        /*背包最大价值*/ 
	int[] best;           /*最佳选择方案*/
	
	public static void main(String[] args) { 
		Knapsack k = new Knapsack();
		int[] w = new int[]{15,25,40,20,15,24};
		int[] v = new int[]{10,5,20,2,14,23}; 
		int c = 30; 
		System.out.println("最大价值：" + k.knapsack(w, v, c));
		System.out.print("最佳方案：" + Arrays.toString(k.best));
	}
	public int knapsack(int[] w, int[] v, int c) {  
		int n = w.length; 
		best = new int[n];
		dfs(w, v, c, 0, 0, 0, new int[n]); 
		return vbest;
	}
	/** 
	 * @param w   物品重量
	 * @param v   物品价值
	 * @param v   背包容量
	 * @param k   当前节点
	 * @param cv  背包当前价值
	 * @param cw  背包当前重量
	 * @param cur 当前选择方案
	 */ 
	void dfs(int[] w, int[] v, int c, int k, int cv, int cw, int[] cur) {
		if(k>=w.length) {
			if(cv>vbest) {
				vbest=cv;
				for(int i=0; i<w.length; i++)
					best[i] = cur[i]; 
			}	
			return;  
		}
		if(cw<c) {        //剪枝
			cur[k]=1;
			dfs(w, v, c, k+1, cv+v[k], cw+w[k], cur);    		
			cur[k]=0;      
			dfs(w, v, c, k+1, cv, cw, cur);
		}
	}
}
