package DynamicProgramming;

/** 
 * Knapsack [0-1背包问题] n个物品有各自的重量和价值，现给定容量的背包，如何让背包物品价值最大
 * describe: 动态规划   
 */
public class Knapsack {

	public static void main(String[] args) { 
		Knapsack k = new Knapsack();
		int[] w = new int[] {5,3,7,2,3,4};
		int[] v = new int[] {3,6,5,4,3,4};
		int c = 15; 
		System.out.print(k.find(w, v, c));
	}
	/** 
	 * @param w  物品重量
	 * @param v  物品价值
	 * @param c  背包容量 
	 */
	int find(int[] w, int[] v, int c) {
		int max = 0;
		int[][] dp = new int[w.length+1][c+1]; //dp[i][j]：前i个物品放入容量为j的背包 
		
		for(int j=1; j<=c; j++)
			dp[0][j] = (w[0]>j)? 0:v[0];       //初始化只放第一个物品时的价值	  		
		for(int i=1; i<w.length; i++) {
			for(int j=1; j<=c; j++) {
				dp[i][j] = w[i]>j? dp[i-1][j]: Math.max(dp[i-1][j-w[i]]+v[i], dp[i-1][j]);  
				max = Math.max(max, dp[i][j]); 				
			}
		}
		return max;		
	}
}
