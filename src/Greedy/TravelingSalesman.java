package Greedy;

/** 
 * TravelingSalesman [TSP 旅行商问题] NP完全问题
 * 旅行商从某城市出发不重复地经过区域内每一个城市，最后回到原点，求路程最短的线路
 * 抽象：求图中权值之和最小的回路
 * 
 * describe: 贪心策略  
 * 1. 从某个城市开始，每次选择一个城市，直到所有的城市被走完； 
 * 2. 每次选择城市时，只考虑当前情况，保证迄今为止经过的路程最短。  
 * s[] 记录访问过的路径  s[i]=1表示城市i已走过，s[i]=0表示城市i未走过
 */
public class TravelingSalesman {
	
	public static void main(String[] args){
		TravelingSalesman t = new TravelingSalesman(); 
		int[][] d = new int[][] {      
			{0, 1, 2, 3},
			{1, 0, 3, 2},
			{2, 3, 0, 1},
			{3, 2, 1, 0}                //d[i][j]=x 表示城市i与j之间距离为x
		};   
		System.out.println("最短路程:" + t.tsp(d));
	}  
	
	public int tsp(int[][] d){		 
		int[] s = new int[d.length];    //代表城市,走过置1
		int min = 0;                    //最短路程
		int cur = 0;                    //当前城市
		int next = 0;                   //下个城市				
		while(s[cur]==0){
			s[cur] = 1;                 //置1,表示已经走过 			
			next = search(d, cur, s);    	
			System.out.println(cur + "->" + next);
			min += d[cur][next];
			cur = next;                 //指针后移
		}
		return min;		
	}
	//寻找cur的下一个最优城市 
	public int search(int[][] d, int cur, int[] s){
		int best = 0;	                //最优城市的下标序号
		int min = d[cur][0];            //到下个城市的最短距离
		int i = 0;	      
		while(i<d.length-1 && s[i]==1)  //寻找第一个可用节点i
			min = d[cur][++i];		
		for(; i<d.length; i++){         //从节点i开始往后扫描，找出距离最小点
			if(s[i]==1)                 //访问过，则跳过
				continue;
			if(d[cur][i]<=min){
				min = d[cur][i];
				best = i;
			}
		}
		return best;
	}
	
}