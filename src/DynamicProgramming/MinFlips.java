package DynamicProgramming;
import java.util.*;

/** 
 * buildTree 一个仅含0和1的数组，可以选择任意位置元素将其翻转，0变为1,1变为0，
 * 求 把数组反转成非递减数组的 最小次数
 * 如：[00110]->1, [010110]->2
 * describe: 动态规划
 **/ 
public class MinFlips {

	public static void main(String[] args) {
		MinFlips m = new MinFlips(); 
		System.out.print(m.flips("101") + "\n");
		System.out.print(m.flips("010110") + "\n"); 
	}
	 
	public int flips(String s) {
		char[] c = s.toCharArray();
		if(s.length()==0)
			return 0;
		int dp0=0;             //将0-i位全部翻转为0所需的次数，即0-i位1的个数
		int dp=0;              //当前状态只需与上一位比较，所以无需数组
		for(int i=0; i<s.length(); i++) {
			dp0 += c[i]-'0';
			dp = Math.min(dp0, dp+1-c[i]+'0');//将之前全部置0 或 将s[i]变为1+之前的最小值 
		}			
		return dp;
	}

}
