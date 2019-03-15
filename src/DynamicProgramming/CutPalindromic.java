package DynamicProgramming;

/** 
 * CutPalindromic �и�����Ӵ���С���� 
 * ����"abba cdc b a" ans=4
 * describe:��̬�滮   
 */
public class CutPalindromic {

	public static void main(String[] args) { 
		CutPalindromic c = new CutPalindromic(); 
		System.out.print(c.cut("aab") + "\n");
		System.out.print(c.cut("abbacdca") + "\n");
	}
	
	public int cut(String s) {
		int n = s.length();
		if(n==0)
			return 0;
		if(n==1)
			return 1;
		
		int[] dp = new int[n];
		dp[0]=1;
		for(int i=1; i<n; i++) {
			dp[i]=i+1;     
			for(int j=0; j<=i; j++) {			
				if (isPalin(s,j,i)) {
					if(j==0)
						dp[i]=1;
					else
						dp[i] = Math.min(dp[j-1]+1, dp[i]); //״̬ת�Ʒ���
				}			
			}		
		}
		return dp[n-1];
	}
	//�ж�s.substring(l,r+1)�Ƿ�Ϊ���Ĵ�
	boolean isPalin(String s, int l, int r) {
		while(l<r) {
			if(s.charAt(l)!=s.charAt(r))
				return false;
			l++;
			r--;
		}
		return true;
	}

}
