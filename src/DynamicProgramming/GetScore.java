package DynamicProgramming;
import java.util.*;

/** 
 * GetScore һ�����������������飬������ĳһ��Ԫ���ۼ���ķ������������������ڵ�Ԫ�أ�
 * ������ö��ٷ֣� �磺[1231]->4, [27931]->12
 * describe: ��̬�滮
 **/ 
public class GetScore {

	public static void main(String[] args) { 
		GetScore g = new GetScore();
		int[] arr1 = new int[] {1, 2, 3, 1};
		System.out.print("�����" + g.max(arr1) + "��\n");
		int[] arr2 = new int[] {2, 7, 9, 3, 1};
		System.out.print("�����" + g.max(arr2) + "��\n");
	}
	
	public int max(int[] a) {
		int n = a.length;
		if(n==0)
			return 0;
		if(n==1)
			return a[0];	
		if(n==2)
			return Math.max(a[0], a[1]);
		
		int max = 0; 
		int dp1 = a[0];                    //��dp[i-2]
		int dp2 = Math.max(a[0], a[1]);    //��dp[i-1]
		int cur = 0;
		for(int i=2; i<n; i++) {
			cur = Math.max(dp2, dp1+a[i]); 
			max = Math.max(max, cur);
			dp1=dp2; dp2=cur;
		} 
		return max;
	}

}
