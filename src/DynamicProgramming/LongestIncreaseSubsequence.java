package DynamicProgramming;
import java.util.*;

/** 
 * LongestIncreaseSubsequence [��ݼ�������/ ��������] 
 * ĳ��Ϊ�˷����й��ĵ���Ϯ������չ��һ�ֵ�������ϵͳ����������ϵͳ��һ��ȱ�ݣ�
 * ���ĵ�һ���ڵ��ܹ���������߶ȣ����Ժ�ÿһ���ڵ��߶ȶ�<=ǰһ���ĸ߶ȣ�
 * ĳ��й�������Ϯ������ϵͳֻ��һ�ף�����������صĵ�����Ŀ
 * �������� 380 260 300 200 187 112  ��� 5
 * describe: ��̬�滮 - ת��Ϊ�������������     
 */
public class LongestIncreaseSubsequence {

	public static void main(String[] args) { 
		LongestIncreaseSubsequence l = new LongestIncreaseSubsequence();
		System.out.println(l.find(new int[] {24,15,18,12}));
	}
	int find (int[] a) {
		int n = a.length;
		int[] arr1 = a.clone();
		int[] arr2 = new int[n];
		Arrays.sort(a);
		for(int i=0; i<n; i++)
			arr2[i]=a[n-i-1];        //��������
		
		int[][] dp = new int[n+1][n+1];
		for(int i=1; i<=n; i++) {
			for(int j=1; j<=n; j++) {
				if(arr1[i-1]==arr2[j-1])
					dp[i][j]=dp[i-1][j-1]+1;
				else
					dp[i][j]=Math.max(dp[i-1][j], dp[i][j-1]);
			}
		}
		return dp[n][n];
	}
}
