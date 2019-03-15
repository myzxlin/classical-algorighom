package DynamicProgramming;

/** 
 * Yachting [��ͧ����] ��������n����ͧ����վ���οͿ��ڳ���վ������ͧ���������ε��κ�վ��黹��ͧ��
 * ����վi������վj֮������Ϊr(i,j)����ӳ���վ1������վn����Ҫ���������  
 * describe:����
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
