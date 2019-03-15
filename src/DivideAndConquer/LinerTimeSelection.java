package DivideAndConquer;
import java.util.*;

/** 
 * LinerTimeSelection [线性时间选择]     
 * 给定线性无序集中n个元素和一个整数k，1≤k≤n，要求找出这n个元素中第k小的元素
 *
 * describe: 对输入数组进行递归划分，与快排不同的是，它只对划分出的子数组之一进行递归处理
 * 1. 随机划分 
 * if(n<20) 直接将a中的元素排序后输出第k个元素,结束; 否则
 * 利用随机函数产生划分基准i，将数组a[p:r]划分成两个子数组，使左边数组的元素<右边数组的元素，
 * 计算a[p:i]中元素个数j.若k<=j，则第k小元素在子数组a[p:i]中; 不然则在a[i+1:r]中
 * 然而，该算法没有考虑实际产生随机数的开销，接下来介绍的中值划分可以继续优化该算法
 * 
 * 2. 中值划分
 * 将a划分为n/5个分组，每组5个元素，第 i个组记为Si，最后一组<5个的不处理;
 * 用插入排序算法求得每组的中位数 mi，递归求得mi的中位数M, M为快排的划分基准pivot;
 * 此算法能保证每次快排的基准都是最佳基准，即基本均分父集，从而使时间复杂度达到最优
 */
public class LinerTimeSelection {

	public static void main(String[] args) { 
		LinerTimeSelection l = new LinerTimeSelection();
		int[] arr = new int[] {5,4,1,6,3};
		int k = 2;
		int ans = l.sort1(arr, k, 0, arr.length-1);
		System.out.print("第"+ k +"小的元素：" + ans);
	}
	
	public int sort1(int[] a, int k, int m, int n) {
		if(m==n)
			return a[m];
		//int key = random(m,n);          //随机划分 
		int key = middle(a,m,n);          //中值划分
		swap(a[key], a[m]);               //将随机元素换至第一位
		int p = pivot(a, m, n);
		int len = p-m+1;                  //左边数组元素个数
		if(len>=k)
			return sort1(a, k, m, p);
		return sort1(a, k-len, p+1, n);
	}
	
	public int pivot(int[] a, int m, int n) {
		int temp = a[m];
		while(m<n) {
			while(m<n && a[n]>=temp)
				n--;
			a[m]=a[n];
			while(m<n && a[m]<=temp)
				m++;
			a[n]=a[m];			
		}
		a[m]=temp;
		return m;		
	}
	
	/*选择随机基准*/
	int random (int x, int y) {
		Random random = new Random();
		int num = random.nextInt(y)%(y-x+1) + x; //产生(x,y)之间的随机数		
		return num;
	}		
	void swap(int x, int y) {
	    int temp = x;
	    x = y;
	    y = temp;
	  }
	
	/*选择中值基准*/
	int middle(int a[], int m, int n) {                          
	    if(n-m<=5){     
	    	Arrays.sort(a);
	    	return a[a.length/2]; 
	    }
	    int s1[][]=new int[a.length/5][5];    //划分为5个一组的子集
	    for(int i=0; i<a.length; i++)         //填充子集
	    	for(int j=0; j<5; j++) 
	    		s1[i][j] = a[i*5+j];	        	
 	        
	    int s2[]=new int[s1.length];                      
	    for(int i=0; i<s1.length; i++){ 
	        Arrays.sort(s1[i]);                //对每个子集排序
	        s2[i]=s1[i][2];	                   //ss[i][2]为该子集中位数，存入sss[]           
	    }
	    Arrays.sort(s2);
	    return s2[s2.length/2];                //返回整个序列的中位数	        	      
	}

}
