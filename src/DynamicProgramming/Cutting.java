package DynamicProgramming;

/** 
 * Cutting [����������] ��һ������Ϊn�����Ӽ���m�� (m��n����������n>1 m>1)
 * ÿ�����ӵĳ��ȼ�Ϊk[0],k[1],��,k[m].��k[0]k[1]��*k[m]�����˻�
 * describe:��̬�滮
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
			return 3;    //�ײ�߽�
		
		int[] dp = new int[n+1];
		dp[1] = 1;
		dp[2] = 2;
		dp[3] = 3;      //dp[n]������Ϊn�����ӵ����˻�		
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
