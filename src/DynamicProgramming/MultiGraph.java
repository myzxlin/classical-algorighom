package DynamicProgramming;
import java.util.*;

/** 
 * MultiGraph [多段图问题] 一个带权有向图，求从源点到终点的最短路径
 * 
 * describe: 动态规划  
 * 从第一个点开始，依次将每个点作为终点，计算当前dp值和d值;
 * 直到将所有结点都计算完毕，即可得到最短路径。
 */
public class MultiGraph {

	public static int m = Integer.MAX_VALUE;   //max表示无穷远

    public static void main(String[] args){
    	MultiGraph t = new MultiGraph();
        int[][] a = {                            //a[i][j]表示边<i,j>的权值
                { 0, 5, 4, 6, m, m, m, m },     
                { 5, 0, m, m, 8, 7, m, m },
                { 4, m, 0, m, 7, 9, 8, m },
                { 6, m, m, 0, 9, 7, 6, m },
                { m, 8, 7, 9, 0, m, m, 3 }, 
                { m, 7, 9, 7, m, 0, m, 3 },
                { m, m, 8, 6, m, m, 0, 4 },
                { m, m, m, m, 3, 3, 4, 0 }
        };
        System.out.print("最短路程：" + t.multiGraph(a));
    }
    
    public int multiGraph(int[][] a) {
    	List<Integer> path = new ArrayList<>();  //最短路径
    	int n = a.length;
    	int[] dp = new int[n];                   //dp[i]=x:结点i为终点时最短路径为x
    	int[] d = new int[n];                    //d[i]=j:结点i的前驱结点为j 
	    Arrays.fill(dp,m);	                     //初始化为无穷远	    
	    dp[0] = 0;
	    d[0] = 0;	    
	    for(int i=1; i<n; i++){
	    	int cur = m;                         //寻找前驱节点
	        for(int j=0; j<i; j++){              //遍历所有邻接点
	        	if(a[i][j]==m)
	        		continue;
	            if(dp[i]>dp[j]+a[j][i]){
	            	dp[i] = dp[j]+a[j][i];
	                cur = j; 	                 
	            }
	        }
	        d[i] = cur;
	    } 
	    for(int i=n-1; i>0;) {
	    	 path.add(d[i]);
	    	 i=d[i];
	    }	    
	    Collections.reverse(path);               //倒序输出
	    path.add(n);                             //加入终点
	    System.out.print("最短路径：" + path + "\n");
	    return dp[n-1];
	}

}