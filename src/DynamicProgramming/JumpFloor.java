package DynamicProgramming;

/** 
 * JumpFloor [��̨������] һֻ����һ�ο�������1����2��̨�ף�������n��̨�׵���������
 * describe:��̬�滮
 **/ 
public class JumpFloor { 
	
	public static void main(String[] args) { 
		JumpFloor j = new JumpFloor(); 
		int n = 10;
		System.out.println(j.jumpFloor(n));   //����� 
		System.out.print(j.jump(n));          //�ݹ��
	}
	public int jumpFloor(int n) {
		if(n<3)
			return n;  		
		int[] dp = new int[n+1];
		dp[0]=0;
		dp[1]=1;
		dp[2]=2; 		
		for (int i=3; i<=n; i++)
			dp[i] = dp[i-1]+dp[i-2]; //���һ����1�� + ���һ����2�� 
		return dp[n];
	}

	/*�ݹ��㷨  ʱ�临�Ӷ�o(2^n)*/
	public int jump(int n) {
		if(n==1)
			return 1;
		if(n==2)
			return 2;
		return jump(n-1)+jump(n-2);
	}
}
