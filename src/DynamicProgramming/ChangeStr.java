package DynamicProgramming;

/** 
 * ChangeStr 对于A,B两个字符串，通过一定字符操作(删除/插入/修改)将A转换为B，问最小操作次数  
 * describe:动态规划
 */
public class ChangeStr {

	public static void main(String[] args) { 
		ChangeStr c = new ChangeStr();
		System.out.print(c.change("abcdf","acbde"));
	}
	
	public int change(String s1, String s2) {	
		char[] x1 = s1.toCharArray();
		char[] x2 = s2.toCharArray();
		int m = x1.length;
		int n = x2.length;
		int[][] dp = new int[m+1][n+1];

		for(int i=0; i<=m; i++) {
			for(int j=0; j<=n; j++) {
				if(i==0||j==0) {
					dp[i][j]=i+j;
					continue;
				}					
				int flag = x1[i-1]==x2[j-1]? 0:1;
				dp[i][j]= Math.min(Math.min(dp[i-1][j]+1, dp[i][j-1]+1), dp[i-1][j-1]+flag);  
			}
		}
		return dp[m][n];  
	}

}
