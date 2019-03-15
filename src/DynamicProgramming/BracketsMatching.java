package DynamicProgramming;

/** 
 * BracketsMatching ����ƥ�䣬�������ж������£�
 * 1.��s���������У���(s)[s]���������У���([])��[()]
 * 2.��A��B���������У���AB���������У���()[]��[]()
 * ������()[]���ɵ��ַ����У���������Ӽ����ַ����ܽ��䲹��Ϊһ����������
 * 
 * describe:����
 */
public class BracketsMatching {

	public static void main(String[] args) { 
		BracketsMatching b = new BracketsMatching();
		System.out.print(b.find("[((])"));
	}
	public int find(String s) {
		int n = s.length();
		char[] x = s.toCharArray();
		int[][] dp = new int[s.length()][s.length()]; 
		for(int i=0; i<n; i++) 
				dp[i][i]=1;              //��ʼ��
		for(int m=1; m<n; m++) { 
			for(int i=0; i+m<n; i++) { 
				int j=i+m;
				dp[i][j]=n;
				if(x[i]=='('&&x[j]==')' || x[i]=='['&&x[j]==']')
					dp[i][j]=Math.min(dp[i][j], dp[i+1][j-1]);
				for(int k=i; k<j; k++)
					dp[i][j]=Math.min(dp[i][j], dp[i][k]+dp[k+1][j]);
				
			}
		}
		return dp[0][n-1];
	}

}
