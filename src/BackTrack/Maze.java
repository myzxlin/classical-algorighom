package BackTrack;
import java.util.*;

/** 
 * Maze [迷宫问题] 用二维数组表示一个地图，地图里每个点有三种情况：加分、不可达和不加分
 * 这三种情况分别用正数、-1和0表示，此时有人企图从[0,0]走到[row-1][col-1],请问：
 * 1. 共有多少种不同路线走到目的地
 * 2. 走到目的地能获得的最高分数是多少？如果不能走到 分数为-1
 * 注意：[0,0]处不是-1，且此人只会沿着横坐标和纵坐标增大的位置走
 * describe: 回溯  
 */
public class Maze {

	public static void main(String[] args) { 
		Maze m = new Maze();
		int[][] map = new int[][] {
			{3, 1, 0},
			{2, 1, 2},
			{0,-1, 3}
		};
		//System.out.print("路线总数为："+ m.ways(map) + "\n"); 
		//System.out.print("最高分数为："+ m.score(map) + "\n");
		System.out.print("最高分数为："+ m.score2(map) + "\n");
	}
	
	public int ways(int[][] map) {
		List<List<Integer>> res = new ArrayList<>();
		dfs(map, 0, 0, new ArrayList<>(), res);
		return res.size();
	}

	public int score(int[][] map) {
		List<List<Integer>> res = new ArrayList<>();
		dfs(map, 0, 0, new ArrayList<>(), res);
		
		int[] score = new int[res.size()];	
		for(int i=0; i<res.size(); i++) { 
			for(int j=0; j<res.get(i).size(); j++) {
				score[i] += res.get(i).get(j);				
			}
		}
		Arrays.sort(score);
		return score[score.length-1];
	}
	
	void dfs(int[][] map, int i, int j, List<Integer> cur, List<List<Integer>> res) {	  
		if(i>=map.length || j>=map[0].length || map[i][j]<0)  			
			return;			
		if(i==map.length-1 && j==map[0].length-1) {  
			List<Integer> now = new ArrayList<>(cur);
			now.add(map[i][j]);
			res.add(now); 
			return;
		}	
		cur.add(map[i][j]);
		dfs(map, i+1, j, cur, res);
		dfs(map, i, j+1, cur, res);
		cur.remove(cur.size()-1);
	}
	
	//动态规划	 
	public int score2(int[][] map) {
		int max = map[0][0];
		int[][] dp = new int[map.length][map[0].length];
		for(int i=0; i<map.length; i++) {
			for(int j=0; j<map[0].length; j++) {
				if(map[i][j]<0)
					dp[i][j] = -1;
				else if(i==0 && j==0)
					dp[i][j] = map[0][0];
				else if(i==0 && j!=0)
					dp[i][j] = dp[i][j-1]+map[i][j];
				else if(i!=0 && j==0)
					dp[i][j] = dp[i-1][j]+map[i][j];
				else 
					dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1])+map[i][j];
				max = Math.max(max, dp[i][j]); 
			}
		}
		return max;	 
	} 
}
