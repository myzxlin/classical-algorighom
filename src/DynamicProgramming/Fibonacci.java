package DynamicProgramming;

/** 
 *Fibonacci [斐波那契数列] F(0)=1，F(1)=1, F(n)=F(n-1)+F(n-2)（n>=2，n∈N*）
 *describe: 动态规划   
 */
public class Fibonacci {

	public static void main(String[] args) {
		Fibonacci f = new Fibonacci(); 
		System.out.print(f.fibonacci(4) +"\n"); 
		System.out.print(f.fibonacci(6) +"\n");
	}
	int fibonacci(int n) {
		if(n==0)
			return 1;
		if(n==1)
			return 1;
		int[] dp = new int[n+1];
		dp[0]=1;
		dp[1]=1;
		for (int i=2; i<=n; i++) 
			dp[i] = dp[i-1]+dp[i-2];			
		return dp[n];
 	}

}
