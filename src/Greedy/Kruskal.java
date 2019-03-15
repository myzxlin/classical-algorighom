package Greedy;
import java.util.*;
import Helpclass.Edge;

/** 
 * Kruskal [克鲁斯卡尔算法] 求最小生成树 
 * describe: 贪心策略 
 * 又被称为 加边法, 将加权连通图的最小生成树看成具有V-1条边的无环子图，且边的权重和最小。
 * 算法开始时，按照权重的递增顺序对图中的边排序，之后迭代的以贪心的方式添加其余边 
 * 时间复杂度主要取决于对边进行权值排序的排序算法效率，最快可达O(nlogn)
 */
public class Kruskal { 
	 
	 public static void main(String[] args) {
		 Kruskal k = new Kruskal(); 
		 int n = 6;		                          //点数   
		 LinkedList<Edge> a = new LinkedList<>(); //边集 		 
		 a.add(new Edge(1, 2, 3));
		 a.add(new Edge(1, 5, 6));
		 a.add(new Edge(1, 6, 5));
		 a.add(new Edge(2, 6, 5));
		 a.add(new Edge(2, 3, 1));
		 a.add(new Edge(3, 6, 4));
		 a.add(new Edge(3, 4, 6));
		 a.add(new Edge(4, 6, 5));
		 a.add(new Edge(4, 5, 8));
		 a.add(new Edge(5, 6, 2)); 
	     
	     a.sort(null);                //按权值降次排序
	     k.kruskal(a, n);
	 }  
	 
	public boolean kruskal(LinkedList<Edge> a, int n){
		Edge[] res = new Edge[n];     //保存逐步连通的边
		int[] u = new int[n+1];       //u[i]=x 表示顶点i属于集合x
		for(int i=1; i<=n; i++)       //初始化每个顶点所属集合=该顶点编号
			u[i]=i;			 

		int i = 0;
		while(i<n-1){                 //n个顶点的最小生成树，最多共n-1条边 
			Edge x = a.peek(); 
			if(u[x.u]!=u[x.v]){       //比较边的左右顶点所属集合
				res[i++] = x;
				u[x.v]=u[x.u];        //将v归入u的集合
			}
			a.pop();
		}
		for(int j=0; j<i; j++)
			System.out.println(res[j].u + "-" + res[j].v + ": 权值=" + res[j].w);
		return (i==n-1);              //return 是否生成了最小生成树
	}  
	
}