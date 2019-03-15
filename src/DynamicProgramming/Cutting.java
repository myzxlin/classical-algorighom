package DynamicProgramming;

/** 
 * Cutting [割绳子问题] 把一根长度为n的绳子剪成m段 (m和n都是整数，n>1 m>1)
 * 每段绳子的长度记为k[0],k[1],…,k[m].求k[0]k[1]…*k[m]的最大乘积
 * describe:动态规划
 **/ 
public class Cutting {

	public static void main(String[] args) { 
		Cutting c = new Cutting(); 
		System.out.println(c.cutting(7));
	}

	public int cutting(int n) {
		if(n==1)
			return 1;
		if(n==2)
			return 2;
		if(n==3)
			return 3;    //底层边界
		
		int[] dp = new int[n+1];
		dp[1] = 1;
		dp[2] = 2;
		dp[3] = 3;      //dp[n]：长度为n的绳子的最大乘积		
		for(int i=4; i<=n; i++) {  
			int max=0;
			for(int j=1;j<=i/2; j++) {
				int val = dp[j]*dp[i-j];
				max = (val>max)?val:max;				
			}
			dp[i]=max;
		}
		return dp[n];
	}
}
