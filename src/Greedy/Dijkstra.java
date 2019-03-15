package Greedy;

/** 
 * Dijkstra [迪杰斯特拉算法] 求单源最短路径，找出源到其他顶点的最短距离
 * 
 * describe: 贪心策略
 * 将所有顶点划分成两个集合，S是已到达的顶点，V是未到达的顶点，S+V就是所有顶点。
 * 初始，S集合只包含源顶点，然后找出V中距离S最近的一个顶点(贪心选择),
 * dist[]记录每个顶点到源的距离, dist[2]=x 表示顶点2到源的最短距离是x;
 * prev[]记录路径, prev[2]=y 表示顶点2到源的最短路径中，顶点2的前一个顶点是顶点y;
 * s[] 将该顶点加入S集合
 */
public class Dijkstra {

    static float m = Float.MAX_VALUE;           //无穷远

    public static void main(String[] args) {
    	Dijkstra d = new Dijkstra();
        float[][] a = {                           //a[i][j]表示点i到点j的距离 
        		{ m, m, m, m, m, m }, //i=0无意义，从i=1开始算点
                { m, 0, 10, m, 30, 100 }, 
                { m, m, 0, 50, m, m },
                { m, m, m, 0, m, 10 }, 
                { m, m, m, 20, 0, 60 },
                { m, m, m, m, m, 0 }    
        };
        int n = a.length;
        float[] dist = new float[n];
        int[] prev = new int[n];
        d.dijkstra(1, a, dist, prev);
        
        System.out.println("顶点1到5的最短路径：");
        d.trace(prev, 5);
        System.out.println("\n顶点1到3的最短路径：");
        d.trace(prev, 3);
    }
    
    /**
     * @param v 源
     * @param a 图
     * @param dist 路径长度, dist[i]表示当前从源到顶点i的最短特殊路径长度
     * @param prev 路径, prev[i]=j：最短路径中顶点i的前一个顶点是j，类似链表
     */
    public void dijkstra(int v, float[][] a, float[] dist, int[] prev){
        int n = dist.length-1;              //节点个数
        if(v<1 || v>n)
            return;
        boolean[] s = new boolean[n+1];     //s集合 统计访问过的点
        for(int i=1; i<=n; i++) {           //初始化dist[]与prev[]
            dist[i] = a[v][i];              //a[v][i]表示点v到点i的距离
            s[i] = false;
            if(dist[i] == m)
                prev[i] = 0;
            else
                prev[i] = v;
        }
        dist[v] = 0;
        s[v] = true;

        for(int i=1; i<n; i++) { 
            float temp = m;
            int u = v;
            for(int j=1; j<=n; j++){        //寻找不在s集合内且距离s集合最近的节点,记为u
                if((!s[j]) && (dist[j]<temp)){
                    u = j;                  //记录节点
                    temp = dist[j];         //记录最短特殊路径长度
                }
            }
            s[u] = true;                    //点u放入s集合
            for(int j=1; j<=n; j++) {       //更新dist[], prev[]
                if((!s[j]) && (a[u][j]<m)) { 
                    float now = dist[u] + a[u][j];
                    if (now<dist[j]) {      //保留较小值
                        dist[j] = now;
                        prev[j] = u;
                    }
                }
            }
        }
    }

    void trace(int[] prev, int n){
        if(n==1){
            System.out.print(n + " ");
            return;
        }
        trace(prev, prev[n]);
        System.out.print(n + " ");
    } 
}
