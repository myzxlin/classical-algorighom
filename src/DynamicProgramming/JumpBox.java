package DynamicProgramming;

/** 
 * JumpBox [跳箱子] 数组里的数表明此时最大能跳多远，问从0出发能否跳到终点
 * 如：[1,2,3,0,6] 返回true [1,1,0,1]返回false
 * 数据用例：10000 < arr.length <= Integer.max  (数组很长！注意复杂度 少遍历)
 * describe:  
 */
public class JumpBox {

	public static void main(String[] args) { 
		JumpBox j = new JumpBox();
		Boolean ans1 = j.jump2(new int[] {1,2,3,0,2}); 
		Boolean ans2 = j.jump2(new int[] {1,3,0,1,0,2});
	}
	//动态规划
	public boolean jump(int[] arr) {
		int[] dp = new int[arr.length];   
		dp[0] = arr[0]>0 ? 1:0; 
		for(int i=1; i<arr.length; i++) {
			for(int j=0; j<i; j++)
				if(dp[j]+arr[j]>i-j) {
					dp[i]=1;	
					break;
				} 
		}
		return dp[arr.length-1]>0? true:false;
	}
	 
	//优化  不到一次遍历
	public boolean jump2(int[] a) {
		int max = 1;              //哨兵记录最大步数
		for(int i=0; i<a.length; i++) {
			if(a[i]==0 && max-1==0)
				return false;
			max = Math.max(max-1, a[i]); 
			if(max>=a.length-i-1)
				return true;
		}
		return false;
	} 
}
