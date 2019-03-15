package DynamicProgramming;
import java.util.*;

/** 输入一个循环数组，依次打印出数组中所有元素的下一个比这个元素更大的值，若不存在则打印-1
 *  例：输入121634  输出266(-1)46
 *  describe:动态规划+栈
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
		Arrays.fill(dp, -1);               //初始化为-1
		Stack<Integer> stack = new Stack<>();
		for(int i=0; i<n*2; i++) {
			int num = a[i%n];
			while(!stack.empty() && num>a[stack.peek()]) 
				dp[stack.pop()] = num;     //找到大数 出栈赋值
			if(i<n)
				stack.push(i); 
		}
		return dp;
	}
}
