package DynamicProgramming;

/** 
 * JumpFloor [跳台阶问题] 一只青蛙一次可以跳上1级或2级台阶，求跳上n级台阶的跳法总数
 * describe:动态规划
 **/ 
public class JumpFloor { 
	
	public static void main(String[] args) { 
		JumpFloor j = new JumpFloor(); 
		int n = 10;
		System.out.println(j.jumpFloor(n));   //动规解 
		System.out.print(j.jump(n));          //递归解
	}
	public int jumpFloor(int n) {
		if(n<3)
			return n;  		
		int[] dp = new int[n+1];
		dp[0]=0;
		dp[1]=1;
		dp[2]=2; 		
		for (int i=3; i<=n; i++)
			dp[i] = dp[i-1]+dp[i-2]; //最后一次跳1步 + 最后一次跳2步 
		return dp[n];
	}

	/*递归算法  时间复杂度o(2^n)*/
	public int jump(int n) {
		if(n==1)
			return 1;
		if(n==2)
			return 2;
		return jump(n-1)+jump(n-2);
	}
}
