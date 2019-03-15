package BackTrack;
import java.util.*;

/** 
 * TravelingSalesman [TSP 旅行商问题] NP完全问题
 * 旅行商从某城市出发不重复地经过区域内每一个城市，最后回到原点，求路程最短的线路
 * 抽象：求图中权值之和最小的回路
 *
 * describe: 回溯   
 */
public class TravelingSalesman {
  
	  int min = Integer.MAX_VALUE;        //最小路径长度 
	  
	  public static void main(String[] args) {
		  TravelingSalesman t = new TravelingSalesman();
		  int d[][] = {
				  { 0, 13, 8, 9 },
			      { 13, 0, 3, 15 },
			      { 8, 3, 0, 20 },
			      { 9, 15, 20, 0 }    
		  };  
		  System.out.print(Arrays.toString(t.tsp(d))); 		  
	  }
	public int[] tsp(int[][] d){
		int res[] = new int[d.length];
		dfs(d, 1, 0, new int[d.length], res);
		return res;
	}
	/** 
	 * @param d     节点间的距离
	 * @param k     当前节点
	 * @param cur   当前路径长度
	 * @param x     当前路径 
	 * @param bestX 最佳路径
	 */
	void dfs(int[][] d, int k, int cur, int[] x, int[] res){
		int n = d.length;
	    if(k==n-1){                                       //走到叶子节点
	        for(int j=1; j<=n; j++){ 
	        	x[k] = j%n;
	        	int len = cur+d[x[k-1]][x[k]]+d[x[k]][0]; //+回到原点的路程
	            if(check(k,x) && len<min) {	            	
	            	min = len; 
	                for(int i=0; i<n; i++) 
	                	res[i] = x[i];	                  //更新res         
	            }
	        }
	        return;
	    }
	    for(int j=1; j<=n; j++){
	    	x[k] = j%n;                           
	        if(check(k,x) && cur+d[x[k-1]][x[k]]<=min) 
	            dfs(d, k+1, cur+d[x[k-1]][x[k]], x, res); //切勿直接改变cur	            
	    }
	}
	
	//判断第k个数是否访问过 
	boolean check(int k, int[] x){
		for(int i=0; i<k; i++) {
			if(x[k]==x[i])
	            return false;
		}
		return true; 
	}
	   	  
}
