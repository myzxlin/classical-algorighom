package BackTrack;
import java.util.*;

/** 
 * BinPacking [装箱问题] n个箱子要装上两艘重量分别为c1和c2的船上，箱子i的重量为Wi,
 * 求是否有一个合理的案将箱子装上这两艘船
 *
 * describe:递归回溯
 * 将第一艘轮船尽可能装满，将剩余的箱子装上第二艘轮船。
 * 第一步等价于选取全体集装箱的一个子集，使该子集中箱子重量之和最接近c1。
 * 由此可知，装箱问题等价于特殊的0-1背包问题, 时间复杂度o(2^n)
 **/ 
public class BinPacking {

	static int bestw = 0;                      //船1最优装载重量  
	
	public static void main(String[] args) { 
		BinPacking b = new BinPacking();
		int[] w = {0, 20, 30, 60, 40, 40};
		int c1 = 100;                          //船1容量
		int c2 = 100;                          //船2容量	
		b.binPacking(w, c1, c2);			
	} 
	
	public void binPacking(int[] w, int c1, int c2) { 
		int n = w.length-1;                    //箱子数量
		int[] res = new int[n+1];              //记录当前最优解,res[i]=1表示箱i装入船1
		int r = 0;                             //剩余货箱的重量	
		for(int i=1; i<=n; i++)      
			r += w[i];		
		dfs(w, 1, r, c1, 0, new int[n+1], res);//从第一个箱子开始装
		
		int w2 = 0;                            //统计船2重量
		for(int i=1; i<=n; i++) 
			w2 += w[i]*(1-res[i]);     		
		if(w2>c2) {
			System.out.println("轮船超重，装箱失败！");
			return;
		}			
		for(int i=1; i<=n; i++)
			System.out.println("箱"+i+"("+w[i]+")"+"装入船"+(res[i]==1?1:2));	
	}
	
	/** 
	 * @param w    箱子重量
	 * @param k    当前节点
	 * @param rw   剩余箱子重量
	 * @param c1      船1容量
	 * @param cw   船1当前重量 
	 * @param item 当前解
	 * @param res  历史最优解
	 */
	void dfs(int[] w, int k, int rw, int c1, int cw, int[] item, int[] res) {
		int n = w.length-1;
		if(k>n){                                    //到达叶结点
			if(cw>bestw) {
				for(int i=1;i<=n;i++) 
					res[i] = item[i];               //当前解保存至最优解
				bestw = cw;
			}
			return;
		}	
		rw -= w[k];
		if(cw+w[k]<c1) {                            //还能装, 搜索左子树
			item[k] = 1;                            //箱k放入船1
			dfs(w, k+1, rw, c1, cw+w[k], item, res);//继续装箱k+1,不改变cw才能回溯
		}		
		if(cw+rw>bestw) {                           //此时有可能出现更优解,搜索右子树  
			item[k] = 0;     
			dfs(w, k+1, rw, c1, cw, item, res);
		}		
		rw += w[k];                                 //恢复现场		
	}
	
}