package DynamicProgramming;

/** 
 * LongestCommonSubsequence [LCS]求最长公共子序列长度(注意与子串的区别，子序列不要求相邻)
 * describe: 动态规划   
 */
public class LongestCommonSubsequence {

	public static void main(String[] args) { 
		LongestCommonSubsequence l = new LongestCommonSubsequence();
		System.out.print(l.find("abcd", "aebd"));
	}
	
	public int find(String s1, String s2) {	
		int m = s1.length();
		int n = s1.length();
		int[][] dp = new int[m+1][n+1]; //dp[i][j]：s1前i位与s2前j位的LCS
		for(int i=1; i<=m; i++)
			for(int j=1; j<=n; j++) {
				if(s1.charAt(i-1)==s2.charAt(j-1)) 
					dp[i][j] = dp[i-1][j-1]+1;
				else
					dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
			}	
		return dp[m][n];
	}

}
