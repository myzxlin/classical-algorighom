package Others; 
import java.util.*;

/**输入字符串，按如下规则计分，并返回最后的得分结果
 * 数字：当轮比赛得分 
 * "+"：当轮比赛得分=上两轮之和
 * "C"：上一轮得分无效
 * "D"：当轮比赛得分=上一轮x2
 */
public class Score {  
	
	public static void main(String[] args) {  
		Score s = new Score(); 
		System.out.println(s.score("23+3C1D+4"));
	}
	public int score(String s) {
		int n = s.length();
		int[] dp = new int[n];     //每场得分记录
		for (int i=0,j=0; i<n; i++,j++) {
			switch (s.charAt(i)) {
				case '+':
					dp[j] = dp[j-1]+dp[j-2];
					break;
				case 'C':
					dp[j-1] = 0;
					j=j-2;          //回退2个 
					break; 
				case 'D':
					dp[j] = dp[j-1]*2;
					break;
				default:            //为数字
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
