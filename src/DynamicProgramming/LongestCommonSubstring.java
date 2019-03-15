package DynamicProgramming;

/** 
 * LongestCommonSubsequence [LCS]��������Ӵ�(ע���������е������Ӵ�Ҫ������)
 * describe: ��̬�滮   
 */
public class LongestCommonSubstring {

	public static void main(String[] args) { 
		LongestCommonSubstring l = new LongestCommonSubstring();
		System.out.print(l.find("abaabc","acaabca"));
	}

	public int find(String s1, String s2) {
		int m = s1.length();
		int n = s1.length();
		int[] dp = new int[m>n?m:n];    //һλ��������ά����
		int max=0;
		for(int i=0; i<m; i++) {
			for(int j=0; j<n; j++) {
				if(s1.charAt(i)==s2.charAt(j)) {
					if(j==0)
						dp[j]=1;
					else 
						dp[j]=dp[j-1]+1; //����б�Խ�Ԫ��ֵ+1
					max = Math.max(dp[j], max);
				}
			}
		}
		return max;
	}
}
