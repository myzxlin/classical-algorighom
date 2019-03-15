package Recursion;

/** 
 * IntegerPartition [整数划分] 将正整数n表示成一系列正整数之和，问有多少种划分方法。例：
 * 最大加数为 5 时，有 1 种划分： 5
 * 最大加数为 4 时，有 1 种划分： 4+1
 * 最大加数为 3 时，有 2 种划分： 3+2, 3+1+1
 * 最大加数为 2 时，有 3 种划分： 2+2+1, 2+1+1+1
 * 最大加数为 1 时，有 1 种划分： 1+1+1+1+1
 * describe: 递归   
 */
public class IntegerPartition {

	public static void main(String[] args) { 
		IntegerPartition i = new IntegerPartition();
		System.out.print(i.find(8, 8));
	}
	//m的n划分
	int find(int m, int n) {
		if(m==1 || n==1)
			return 1; 
		if(m==n)
			return find(m,m-1)+1;
		if(m<n)
			return find(m,m);		
		return find(m,n-1)+find(m-n,n);
	}
}
