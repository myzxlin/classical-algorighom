package DynamicProgramming;
import java.util.Arrays;

/** 
 * Coins [硬币找零] 有面值为1,3,5的硬币若干枚，如何用最少的硬币凑够n元
 * describe:动态规划
 **/ 
public class Coins {

	public static void main(String[] args) { 
		Coins c = new Coins(); 
		System.out.println(c.coins(8));
	}

	public int coins(int n) {
		if(n==0)
			return 0;
		if(n==1)
			return 1;
		if(n==2)
			return 2;
		if(n==3)
			return 1;
		if(n==4)
			return 2;
		if(n==5)
			return 1;      //底层边界
		
		int[] dp = new int[n+1];
		dp[0] = 0;
		dp[1] = 1;
		dp[2] = 2;
		dp[3] = 1;
		dp[4] = 2;
		dp[5] = 1;	
		for(int i=6; i<=n; i++) {
			int[] val = new int[] {dp[i-1]+1, dp[i-3]+1, dp[i-5]+1};
			Arrays.sort(val);
			dp[i]=val[0];
		}
		return dp[n];
	}
}
