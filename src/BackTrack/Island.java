package BackTrack;

import java.util.Arrays;

/**Island [数岛] 二维数组里只有1和0，分别表示土地和海水
 * 1. 问有几个岛
 * 2. 允许最多改变一个0为1，问在哪里改变可以获得最大面积的岛，返回这个最大面积
 * describe: 回溯+上色   
 */
public class Island {

	public static void main(String[] args) { 
		Island x = new Island();
		int[][] map = new int[][] {
			{1,1,0,0,1},
			{0,1,1,0,1},
			{1,0,1,1,0},
			{1,1,0,1,0}			
		};
		System.out.print("岛数：" + x.sum(map) + "\n");
		for(int[] i:map)
			System.out.print(Arrays.toString(i)+"\n"); 					
		//System.out.print("最大面积为：" + i.max(map) +"\n");
	}
	
	public int sum(int[][] map) {
		int res = 0;
		for (int i=0; i<map.length; i++) 
			for (int j=0; j<map[0].length; j++) 
				if (map[i][j]==1) {
					res++;
					dfs(map,i,j, res+1);
				}		
		return res;
	}
	void dfs(int[][] map, int i, int j, int color){ 
		if(i<0 || i>=map.length || j<0 || j>=map[0].length || map[i][j]!=1)
			return;		
		map[i][j]=color;
		dfs(map, i+1, j, color);
		dfs(map, i-1, j, color);
		dfs(map, i, j+1, color);
		dfs(map, i, j-1, color);
	}
	
	int max(int[][] map) {
		int max=0;
		for(int i=0; i<map.length; i++) 
			for(int j=0; j<map[0].length; j++) {
				max=Math.max(max, dfs2(map,i,j));
			}
		return max;
	}
	int dfs2(int[][] map, int i, int j) {
		if(i<0 || i>=map.length || j<0 || j>=map[0].length || map[i][j]!=1)
			return 0;
		map[i][j]=0;
		return dfs2(map,i+1,j) + dfs2(map,i-1,j) +
			   dfs2(map,i,j+1) + dfs2(map,i,j-1) + 1;
	} 
}
