package DynamicProgramming;
import java.util.*;

/** ����һ��ѭ�����飬���δ�ӡ������������Ԫ�ص���һ�������Ԫ�ظ����ֵ�������������ӡ-1
 *  ��������121634  ���266(-1)46
 *  describe:��̬�滮+ջ
 */
public class NextBiggerNum {

	public static void main(String[] args) {
		NextBiggerNum f = new NextBiggerNum();  
		int[] a = new int[] {1,2,1,6,3,4}; 
		System.out.print(Arrays.toString(f.find2(a)));	

	} 
	public int[] find2(int[] a) {
		int n = a.length;
		int[] dp = new int[n];
		Arrays.fill(dp, -1);               //��ʼ��Ϊ-1
		Stack<Integer> stack = new Stack<>();
		for(int i=0; i<n*2; i++) {
			int num = a[i%n];
			while(!stack.empty() && num>a[stack.peek()]) 
				dp[stack.pop()] = num;     //�ҵ����� ��ջ��ֵ
			if(i<n)
				stack.push(i); 
		}
		return dp;
	}
}
