package DynamicProgramming;

/** 
 * MaximumSubarry 求给定数组(包含负数)的最长连续子数组和
 * describe:动态规划   
 */
public class MaxSubarray {

	public static void main(String[] args) { 
		MaxSubarray m = new MaxSubarray(); 
		System.out.print(m.find(new int[] {1, -2, 3, 4, -1, 7, -8, 2}));
	}

	public int find(int[] a) { 
		int max=a[0];		
		int cur=0;	
 		for(int i=0; i<a.length; i++) {
 			cur = cur>0? cur+a[i]: a[i];
 			max = Math.max(max, cur);
 		} 
 		return max;				
	}

}
