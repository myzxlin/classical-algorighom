package DynamicProgramming;
import java.util.*;

/** 
 * PickCandies [���ǹ�] ���A��Bÿ��ֻ�ܴ���������ѡ��һ���� �����A�Ƿ��B�ĺʹ�
 * �÷Ǹ������ʾ�ǹ�������[1,2,8,3] AֻҪ������1��������ζ���AӮ
 * describe:���� + ��̬�滮�Ż�
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
	//���ݷ�  AB����֮�mn��ʾʣ�����������±�
	int dfs(int[] array, int m,int n){
		if(m==n) 
	    	return array[m];
	    if(n-m==1) 
	    	return Math.max(array[m],array[n]);	    
	    int t1, t2, a1b1, a1b2, a2b1, a2b2;
	    a1b1 = array[m] - array[m+1] + dfs(array,m+2,n);  //A��B��
	    a1b2 = array[m] - array[n] + dfs(array,m+1,n-1);  //A��B��
	    a2b1 = array[n] - array[m] + dfs(array,m+1,n-1);  //A��B��
	    a2b2 = array[n] - array[n-1] + dfs(array,m,n-2);  //A��B��   
	    t1 = Math.min(a1b1, a1b2);
	    t2 = Math.min(a2b1, a2b2);   //B�ľ���
	    return Math.max(t1, t2);
	}
	
	public boolean canWin2(int[] array) { 
		int[][] dp = new int[array.length][array.length]; //����¼
		int ans = dfs2(array, 0, array.length-1, dp);
		return ans>=0? true:false;
	}
	
	//��̬�滮  �ռ任ʱ�䣬ͨ�������¼���ٱ�������
	int dfs2(int[] array, int m,int n, int[][] dp){
		if(dp[m][n]!=0)
			return dp[m][n];  //����¼���м�¼ ��ֱ������ ����ʱ��
		if(m==n) 
	    	return array[m];
	    if(n-m==1) 
	    	return Math.max(array[m],array[n]);	 
	    int t1, t2, a1b1, a1b2, a2b1, a2b2;
	    a1b1 = array[m] - array[m+1] + dfs2(array,m+2,n,dp);  //A��B��
	    a1b2 = array[m] - array[n] + dfs2(array,m+1,n-1,dp);  //A��B��
	    a2b1 = array[n] - array[m] + dfs2(array,m+1,n-1,dp);  //A��B��
	    a2b2 = array[n] - array[n-1] + dfs2(array,m,n-2,dp);  //A��B��   
	    t1 = Math.min(a1b1, a1b2);
	    t2 = Math.min(a2b1, a2b2);   //B�ľ���
	    dp[m][n] = Math.max(t1, t2);
	    return dp[m][n];
	}
}
