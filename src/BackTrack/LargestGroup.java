package BackTrack;
import java.util.*;

/**LargestGroup [最大通信团体] 求无向图的最大完全子图(即包含点数最多的完全图) 
 * 
 * describe: 回溯   
 * 首先设最大团为一个空团，往其中加入一个顶点，然后依次考虑每个顶点，
 * 对于点i，考虑将该其加入团或者舍弃两种情况，然后递归判断下一顶点。
 * 对于无连接或者直接舍弃两种情况，在递归前，可采用剪枝策略来避免无效搜索。
 * 当搜索到叶结点时停止，更新最优解
 */
public class LargestGroup {
 
	int bestn = 0;                          //最大团点数	 
	int count = 0;                          //最大团个数
	
	public static void main(String[] args) {
		LargestGroup l = new LargestGroup();
		int[][] a = {                       
				{-1,-1,-1,-1,-1,-1},
				{-1, 0, 1, 0, 1, 1},
				{-1, 1, 0, 1, 0, 1},
				{-1, 0, 1, 0, 0, 1},
				{-1, 1, 0, 0, 0, 1},
				{-1, 1, 1, 1, 1, 0}     //a的下标从1开始,-1的值无用
		};     	
		List<int[]> res = l.max(a);
		System.out.println("最大团点数："+l.bestn);
		System.out.println("最大团个数："+l.count);
		System.out.println("最大团如下：");
		for(int[] i:res)
			System.out.println(Arrays.toString(i));
	} 
	
	public List<int[]> max(int[][] a){ 
		List<int[]> res = new ArrayList<>();     
		dfs(a, 1, 0, new int[a.length], res); 
		return res;
	}
	/** 
	 * @param a    图的邻接矩阵
	 * @param i    当前节点
	 * @param cn   当前点数
	 * @param x    当前解 x[i]=1表示i点在最大团中, =0表示不在团中 
	 * @param res  记录最大团
	 */
	public void dfs(int[][] a, int i, int cn, int[] x, List<int[]> res){
		int n = a.length-1;
		if(i>n){
			int[] now = new int[x.length];
			for(int j=0; j<x.length; j++)
				now[j]=x[j];
			res.add(now); 
			bestn = cn;
			count++;
			return;
		} 		
		if(check(a, i, x)){           //点i与当前团全部连接,进入左子树(选择该点)		
			x[i]=1;
			dfs(a, i+1, cn+1, x, res);//切勿直接改变cn,否则无法回溯
			x[i]=0;
		}
		if(cn+n-i>=bestn){            //剪枝：无可能更优时放弃右子树 
			x[i]=0;
			dfs(a, i+1, cn, x, res);
		}
	}
	
	//检查点i是否与当前团全部连接
	boolean check(int[][] a, int i, int[] x) {
		for(int j=1; j<i; j++){          
			if(x[j]==1 && a[i][j]==0)
				return false;
		}
		return true;
	}

}
