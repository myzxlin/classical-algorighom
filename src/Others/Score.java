package Others; 
import java.util.*;

/**�����ַ����������¹���Ʒ֣����������ĵ÷ֽ��
 * ���֣����ֱ����÷� 
 * "+"�����ֱ����÷�=������֮��
 * "C"����һ�ֵ÷���Ч
 * "D"�����ֱ����÷�=��һ��x2
 */
public class Score {  
	
	public static void main(String[] args) {  
		Score s = new Score(); 
		System.out.println(s.score("23+3C1D+4"));
	}
	public int score(String s) {
		int n = s.length();
		int[] dp = new int[n];     //ÿ���÷ּ�¼
		for (int i=0,j=0; i<n; i++,j++) {
			switch (s.charAt(i)) {
				case '+':
					dp[j] = dp[j-1]+dp[j-2];
					break;
				case 'C':
					dp[j-1] = 0;
					j=j-2;          //����2�� 
					break; 
				case 'D':
					dp[j] = dp[j-1]*2;
					break;
				default:            //Ϊ����
					dp[j] = s.charAt(i)-'0'; 
					break;
			}
		}  
		int sum = 0;
		for (int k=0; k<n; k++) 
			sum += dp[k];
		return sum;
	}

}
