package DynamicProgramming;
import java.util.Arrays;

/** 
 * TravelingSalesman [TSP 旅行商问题] NP完全问题
 * 旅行商从某城市出发不重复地经过区域内每一个城市，最后回到原点，求路程最短的线路
 * 抽象：求图中权值之和最小的回路
 * 
 * describe: 动态规划  
 * 每个节点是一个二元组(i,S),i表示当前路径最后一个点,S是一个集合,表示路径上的点集.
 * 每个状态(i,S)的所有前驱(j,S'),一定满足:j∈S且S=S'+{i}
 * 递推方程为:dp(i,S)= min[dp(j,S-{i})+cost(i,j)] , j∈S且j≠i
 * 即, 到i的最短距离 = 到j的最短距离,加上j到i的最短距离 
 * 集合S在具体实现上要映射到一个数字,可以用二进制串的状态压缩.
 * 一个二进制串的第i位就表示第i个点是否在S里,1表示在,0表示不在.
 * 时间复杂度 o(n^2*2^n) 空间复杂度是O(n*2^n). 
 */
public class TravelingSalesman {
	
	int max = Integer.MAX_VALUE;
	
	public static void main(String[] args){
		TravelingSalesman t = new TravelingSalesman(); 
		int[][] d = new int[][] {      
			{0, 1, 2, 3},
			{1, 0, 3, 2},
			{2, 3, 0, 1},
			{3, 2, 1, 0}               //d[i][j]=x 表示城市i与j之间距离为x
		};  
		System.out.print("最短路程：" + t.tsp(d));  
	}  
	
	public int tsp(int[][] d) {
		int n = d.length;              //城市数目
		int h = (int)Math.pow(2, n-1);
		int min = 0;                   //总距离
		int path[];                    //存放路径，方便计算距离  
		int[][] dp = new int[n][h];    //阶段最短路程 
		int[][] s = new int[n][h];     //阶段最优策略 	
		int cur = max;  
		int mink = 0;
				
		for(int i=0; i<n; i++)         //初始化
			dp[i][0]=d[i][0];		
		for(int i=1; i<h; i++){
			for(int j=1; j<n; j++){
				if(judge(i,j,n)==1)    //当j在i代表的集合中时,跳过
					continue;
				int k=0;
				String a = binary(i,n-1);
				for(int w=a.length(); w>0; w--) {
					k = a.charAt(a.length()-w)-48;  //k为0或者1
					if(k==1) {
						k=k*w;                      //此时的k为选择的集合中的某个值
						int y=(d[j][k]+dp[k][(int)(i-Math.pow(2, k-1))]);
						if(y<cur) {
							cur=(d[j][k]+dp[k][(int)(i-Math.pow(2, k-1))]);
							mink=k;
						}
					}
				}
				if(cur<max) {      
					dp[j][i] = cur;
					s[j][i] = mink;
					cur = max;
				}
			}
		}
		cur=max; 
		int i = (int)(Math.pow(2, n-1)-1);     //更新最后一列
		for(int k=n-1; k>0; k--) {
			int x = (d[0][k]+dp[k][(int)(i-Math.pow(2, k-1))]);
			if(x<cur) {
				cur=x;
				mink=k;
			}
		}
		dp[0][i]=cur;
		s[0][i]=mink;
		path=new int[n+1];
		path[0]=1;
		int c=1;
		for(int j=0;i>0;) {
			j=s[j][i];
			i=(int)(i-Math.pow(2, j-1));
			path[c++]=j+1;
		}
		path[c++]=1;
		
		System.out.println("最短路径："+Arrays.toString(path));
		for(i=0; i<n; i++) 
			min += d[path[i]-1][path[i+1]-1]; 
		return min;
	}
	
	//判断j是否在i表示的集合中
	public int judge(int i, int j, int n) {
		String a = binary(i,n-1);
		int b = a.charAt(a.length()-j)-48;
		System.out.println("i="+i+" j="+j+" b="+b+"\n");
		return b;      //b=0不在 b=1在
	}
	
	//将十进制数m转换为n位数的二进制字符串
	public String binary(int m ,int n) {
        String str = "";
        for(int i=n-1; i>=0; i--)  
        	str +=(m>>i)&1; 
        return str;
    }
}