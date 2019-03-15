package BackTrack;
import java.util.*;

/**GraphColoring [GCP 图的着色问题] NP完全问题
 * 为一个无向连通图的顶点上色，使每条边两点颜色不同，求所需最少颜色数m 和所有上色方案
 * 
 * 思路：通过回溯的方法，不断为每一个节点着色，在前面n-1个节点都合法的着色之后，开始对第n个节点进行着色，
 * 这时候枚举可用的m个颜色，通过和第n个节点相邻的节点的颜色，来判断这个颜色是否合法，
 * 如果找到那么一种颜色使得第n个节点能够着色，那么说明m种颜色的方案是可行的。
 */
public class GraphColoring { 
	 
	 public static void main(String[] args) {
		 GraphColoring g = new GraphColoring(); 	     
	     int[][] a = {
	    		 {-1,-1,-1,-1,-1,-1},
	    		 {-1, 0, 1, 1, 1, 0},
	    		 {-1, 1, 0, 1, 1, 1},
	    		 {-1, 1, 1, 0, 1, 0},
	    		 {-1, 1, 1, 1, 0, 1},
	    		 {-1, 0, 1, 0, 1, 0}
	    };
	    int m = 5;
	    List<int[]> res = g.coloring(a, m);
	    System.out.println("可行着色方案：" + res.size() + "个");
	    System.out.println("着色方案如下：");
	    for(int[] i:res)
	    	System.out.println(Arrays.toString(i));   
	 }
	 
	 public List<int[]> coloring(int[][] a, int m){
		 List<int[]> res = new ArrayList<>(); 
	     dfs(a, m, 1, new int[a.length], res);
	     return res;
	 }
	 
	 /** 
	  * @param a   图的邻接矩阵
	  * @param m   着色数
	  * @param t   当前节点
	  * @param cur 当前解
	  * @param res 全部解
	  */
	public void dfs(int[][] a, int m, int t, int[] cur, List<int[]> res){
		int n = a.length-1;
	    if(t>n){
	    	int[] now = new int[n+1]; 
	        for(int i=0; i<=n; i++)
	            now[i] = cur[i];
	        res.add(now); 
	        return;
	    }
	    for(int i=1; i<=m; i++){                  //依次尝试所有的颜色
	    	cur[t] = i;                           //给点上色,i表示颜色
	    	boolean flag = true;
	    	for(int j=1; j<a.length; j++){
		        if(a[t][j]==1 && cur[t]==cur[j])  //检查相邻边是否颜色不同 
		            flag = false;
		    }
	        if(flag)                              //剪枝 
	        	dfs(a, m, t+1, cur, res);
	        cur[t] = 0;                           //回溯
	    }
	}

}
