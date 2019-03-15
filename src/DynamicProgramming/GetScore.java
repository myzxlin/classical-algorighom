package DynamicProgramming;
import java.util.*;

/** 
 * GetScore 一个仅含正整数的数组，可以拿某一个元素累加你的分数，但不可以拿相邻的元素，
 * 问最多拿多少分？ 如：[1231]->4, [27931]->12
 * describe: 动态规划
 **/ 
public class GetScore {

	public static void main(String[] args) { 
		GetScore g = new GetScore();
		int[] arr1 = new int[] {1, 2, 3, 1};
		System.out.print("最多拿" + g.max(arr1) + "分\n");
		int[] arr2 = new int[] {2, 7, 9, 3, 1};
		System.out.print("最多拿" + g.max(arr2) + "分\n");
	}
	
	public int max(int[] a) {
		int n = a.length;
		if(n==0)
			return 0;
		if(n==1)
			return a[0];	
		if(n==2)
			return Math.max(a[0], a[1]);
		
		int max = 0; 
		int dp1 = a[0];                    //即dp[i-2]
		int dp2 = Math.max(a[0], a[1]);    //即dp[i-1]
		int cur = 0;
		for(int i=2; i<n; i++) {
			cur = Math.max(dp2, dp1+a[i]); 
			max = Math.max(max, cur);
			dp1=dp2; dp2=cur;
		} 
		return max;
	}

}
