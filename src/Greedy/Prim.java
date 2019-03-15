package Greedy;

/** 
 * Prim [普利姆算法] 求最小生成树 
 * describe: 贪心策略 
 * 将顶点分成集合S和V。初始S集合只包含顶点1，然后找出V集合中距离S集合距离最短的顶点(贪心)，
 * dist[] 保存顶点到集合S的距离, dist[2]=x 表示顶点2距离集合S的最短距离是x;
 * prev[] 记录路径, prev[2]=y 表示顶点2距离集合S中最近的顶点是y;
 * s[] 将该顶点加入S集合 
 */
public class Prim {
	
	static float m = Float.MAX_VALUE;           //max表示无穷远
	
	public static void main(String[] args){
		Prim p = new Prim();
		float [][] a = {
				{ m, m, m, m, m, m, m },
				{ m, m, 6, 1, 5, m, m },
	            { m, 6, m, 5, m, 3, m },
	            { m, 1, 5, m, 5, 6, 4 },
	            { m, 5, m, 5, m, m, 2 },
	            { m, m, 3, 6, m, m, 6 },
	            { m, m, m, 4, 2, 6, m }
	    };
	    p.prim(6,a);
	 }  
	
    public void prim(int n, float [][] a){
        float[] dist = new float[n+1];
        int[] prev = new int[n+1];
        boolean[] s = new boolean[n+1];
 
        s[1]=true;        
        for(int i=2; i<=n; i++){             //初始化
        	dist[i] = a[1][i]; 
        	prev[i] = 1;
            s[i] = false;
        }
        for(int i=1; i<n; i++){              //依次找出剩余n-1个节点
            float temp = m;
            int u = 1;         
            for(int j=2; j<=n; j++){         //找与s集合最近的节点
                if((!s[j]) && (dist[j]<temp)){
                	u = j;
                	temp = dist[j];                  
                }
            }
            System.out.println("找到边 " + u + "-" + prev[u]);
            s[u] = true;                     //点u放入s集合     
            for(int j=2; j<=n; j++){         //更新dist[], prev[] 
                if((!s[j]) && (a[u][j]<dist[j])){
                	dist[j] = a[u][j];       //记录权值
                	prev[j] = u;             //记录节点
                }
            }
        }
    }  

}
