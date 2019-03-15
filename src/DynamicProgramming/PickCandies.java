package DynamicProgramming;
import java.util.*;

/** 
 * PickCandies [挑糖果] 玩家A和B每次只能从数组两端选择一个数 看最后A是否比B的和大
 * 用非负数组表示糖果数，如[1,2,8,3] A只要先挑走1，无论如何都是A赢
 * describe:回溯 + 动态规划优化
 **/
public class PickCandies {

	public static void main(String[] args) { 
		PickCandies p = new PickCandies();
		Object res1 = p.canWin(new int[] {1,2,8,3}); 
		Object res2 = p.canWin2(new int[] {1,2,8,3}); 
	}

	public boolean canWin(int[] array) { 
		int ans = dfs(array, 0, array.length-1);
		return ans>0? true:false;
	}
	//回溯法  AB分数之差，mn表示剩余数组两端下标
	int dfs(int[] array, int m,int n){
		if(m==n) 
	    	return array[m];
	    if(n-m==1) 
	    	return Math.max(array[m],array[n]);	    
	    int t1, t2, a1b1, a1b2, a2b1, a2b2;
	    a1b1 = array[m] - array[m+1] + dfs(array,m+2,n);  //A左B左
	    a1b2 = array[m] - array[n] + dfs(array,m+1,n-1);  //A左B右
	    a2b1 = array[n] - array[m] + dfs(array,m+1,n-1);  //A右B左
	    a2b2 = array[n] - array[n-1] + dfs(array,m,n-2);  //A右B右   
	    t1 = Math.min(a1b1, a1b2);
	    t2 = Math.min(a2b1, a2b2);   //B的决策
	    return Math.max(t1, t2);
	}
	
	public boolean canWin2(int[] array) { 
		int[][] dp = new int[array.length][array.length]; //备忘录
		int ans = dfs2(array, 0, array.length-1, dp);
		return ans>=0? true:false;
	}
	
	//动态规划  空间换时间，通过数组记录减少遍历次数
	int dfs2(int[] array, int m,int n, int[][] dp){
		if(dp[m][n]!=0)
			return dp[m][n];  //备忘录中有记录 则直接跳过 减少时间
		if(m==n) 
	    	return array[m];
	    if(n-m==1) 
	    	return Math.max(array[m],array[n]);	 
	    int t1, t2, a1b1, a1b2, a2b1, a2b2;
	    a1b1 = array[m] - array[m+1] + dfs2(array,m+2,n,dp);  //A左B左
	    a1b2 = array[m] - array[n] + dfs2(array,m+1,n-1,dp);  //A左B右
	    a2b1 = array[n] - array[m] + dfs2(array,m+1,n-1,dp);  //A右B左
	    a2b2 = array[n] - array[n-1] + dfs2(array,m,n-2,dp);  //A右B右   
	    t1 = Math.min(a1b1, a1b2);
	    t2 = Math.min(a2b1, a2b2);   //B的决策
	    dp[m][n] = Math.max(t1, t2);
	    return dp[m][n];
	}
}
