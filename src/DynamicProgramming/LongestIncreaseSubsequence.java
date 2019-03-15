package DynamicProgramming;
import java.util.*;

/** 
 * LongestIncreaseSubsequence [最长递减子序列/ 导弹拦截] 
 * 某国为了防御敌国的导弹袭击，发展出一种导弹拦截系统。但是这种系统有一个缺陷：
 * 它的第一发炮弹能够到达任意高度，但以后每一发炮弹高度都<=前一发的高度，
 * 某天敌国导弹来袭，而该系统只有一套，问最多能拦截的导弹数目
 * 例：输入 380 260 300 200 187 112  输出 5
 * describe: 动态规划 - 转换为求最长公共子序列     
 */
public class LongestIncreaseSubsequence {

	public static void main(String[] args) { 
		LongestIncreaseSubsequence l = new LongestIncreaseSubsequence();
		System.out.println(l.find(new int[] {24,15,18,12}));
	}
	int find (int[] a) {
		int n = a.length;
		int[] arr1 = a.clone();
		int[] arr2 = new int[n];
		Arrays.sort(a);
		for(int i=0; i<n; i++)
			arr2[i]=a[n-i-1];        //降序排列
		
		int[][] dp = new int[n+1][n+1];
		for(int i=1; i<=n; i++) {
			for(int j=1; j<=n; j++) {
				if(arr1[i-1]==arr2[j-1])
					dp[i][j]=dp[i-1][j-1]+1;
				else
					dp[i][j]=Math.max(dp[i-1][j], dp[i][j-1]);
			}
		}
		return dp[n][n];
	}
}
