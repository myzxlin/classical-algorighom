package DivideAndConquer;
import java.util.*;

/** 
 * QuickSort [快速排序] 平均时间复杂度o(nlogn)   
 * 1.基准：在待排序列中选出首元素作为 基准
 * 2.分割：该基准将序列分成两个子序列，使基准左边元素<基准，基准右边元素>基准
 * 3.递归地对两个序列进行快排，直到序列为空or只有一个元素  
 */
public class QuickSort {

	public static void main(String[] args) { 
		QuickSort q = new QuickSort();
		int[] arr = new int[] {1,4,5,2,7,6,3,9};
		q.sort(arr, 0, arr.length-1);
		System.out.print(Arrays.toString(arr));
	}
	
	public void sort(int[] a, int m, int n) {
		if(m>=n)
			return;
		int pivot = pivot(a, m, n);
		sort(a, m, pivot-1);
		sort(a, pivot+1, n);
	}
	int pivot(int[] a, int m, int n) { 
		int temp = a[m];
		while(m<n) {
			while(m<n && a[n]>=temp)  //从右往左找比基准小的数
				n--;
			a[m]=a[n];
			while(m<n && a[m]<=temp)  //从左往右找比基准大的数
				m++;
			a[n]=a[m];			
		}
		a[m]=temp;
		return m;                     //返回基准下标
	}

}
