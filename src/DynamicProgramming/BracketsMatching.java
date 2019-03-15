package DynamicProgramming;

/** 
 * BracketsMatching 括号匹配，正则序列定义如下：
 * 1.若s是正则序列，则(s)[s]是正则序列；如([])、[()]
 * 2.若A和B是正则序列，则AB是正则序列；如()[]、[]()
 * 给定由()[]构成的字符序列，问至少添加几个字符，能将其补充为一个正则序列
 * 
 * describe:动规
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
				dp[i][i]=1;              //初始化
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
