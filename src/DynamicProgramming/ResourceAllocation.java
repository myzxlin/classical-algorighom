package DynamicProgramming;
import java.util.*;

/** 
 * ResourceAllocation [资源分配] 
 * m份相同的资源分配给n个工程, c[i][j]表示i份资源分配给j号工程的利润, 如何分配利润最大
 * 抽象：x1+x2+...+xm = n (xi为整数), 求max z=g1(x1)+g2(x2)+...+gm(xm)
 * 
 * describe: 动态规划   
 * dp[i][j]:前i个工程拥有j份资源的最大利润, dp[i][j]有以下两种情况：
 * 1. 不分配给第i号工程，dp[i][j]=dp[i-1][j]; 
 * 2. 分配k份资源给第i号车间，剩下的j-k份资源分配给前i-1个工程，此时dp[i][j]=dp[i-1][j-k]+c[i][k];
 * 因此, dp[i][j]=max{dp[i-1][j], dp[i-1][j-k]+c[i][k]}, 其中1≤k≤j. 
 * 自底向上构造表即可计算出dp[m][n]，时间复杂度为o(m^2*n)
 */
public class ResourceAllocation {

    public static void main(String[] args) {
    	ResourceAllocation r = new ResourceAllocation(); 
        int[][] c = new int[][] {
        	{ 0, 4, 26, 40, 45 },
        	{ 0, 5, 15, 40, 60 },
        	{ 0, 3, 15, 40, 80 }          //3个工程 4份资源
        };  
        System.out.println("最大利润：" + r.maxProfit(c));
    } 
    
	public int maxProfit(int[][] c){ 
        int[][] dp = c.clone();  
	    for(int i=1; i<c.length; i++){
	        for(int j=1; j<c[0].length; j++){ 
	            for(int k=1; k<=j; k++)
	            	dp[i][j] = Math.max(Math.max(dp[i-1][j], dp[i-1][j-k]+c[i][k]), dp[i][j]);  
	        }
	    } 
	    return dp[c.length-1][c[0].length-1]; 
	}

}