package DynamicProgramming;

/** 
 * LongestPalindromic 找出最长回文子串(左右对称)
 * describe:动态规划   
 */
public class LongestPalindromic {

	public static void main(String[] args) {  
		LongestPalindromic l = new LongestPalindromic();  
		System.out.print(l.longest("abb")+ "\n");
		System.out.print(l.longest("abcda")+ "\n");
	}
	
	public String longest(String s) {
		int n = s.length();	
		if(n==0)
			return "";
		if(n==1)
			return s; 
		if(n==2)
			if(s.charAt(0)==s.charAt(1))
				return s;
			else
				return s.substring(0,1);
						
		boolean[][] dp = new boolean[n][n]; //dp[i][j]:string中i-j位置的子串(覆盖ij)是否为回文串
		String max = s.substring(0,1);
		for(int j=0; j<n; j++) {	
			dp[j][j] = true;  //每个字符本身是回文的
			for(int i=0; i<j; i++) {
				if((dp[i+1][j-1] || j-i==1) && s.charAt(i)==s.charAt(j)) {
					dp[i][j]=true; 
					if((j-i+1)>max.length()) 
						max=s.substring(i, j+1);		
					}				
				else
					dp[i][j]=false;
			}	
		}				
		return max;
	}

}
