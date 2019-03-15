package DynamicProgramming;

/** 
 * Yachting [游艇租用] 长江边有n个游艇出租站，游客可在出租站租用游艇，并在下游的任何站点归还游艇。
 * 出租站i到出租站j之间的租金为r(i,j)，求从出租站1到出租站n所需要的最少租金  
 * describe:动规
 */
public class Yachting {

	public static void main(String[] args) {
		Yachting y = new Yachting();
		int[][] r = new int[][] {
			{0, 2, 4, 6, 11},
			{0, 0, 3, 4, 7},
			{0, 0, 0, 3, 5},
			{0, 0, 0, 0, 3},
		};
		System.out.print(y.yachting(r));
	}
	public int yachting(int[][] r) {
		int n = r.length;
		int[][] dp = r.clone();  
		for(int m=2; m<=n; m++) {
			for(int i=0; i+m<=n; i++) {
				int j=i+m; 
				for(int k=1; k<j; k++)
					dp[i][j] = Math.min(dp[i][j], dp[i][k]+dp[k][j]); 
			}
		}	
		return dp[0][n];
	}

}
