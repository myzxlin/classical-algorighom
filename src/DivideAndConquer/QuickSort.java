package DivideAndConquer;
import java.util.*;

/** 
 * QuickSort [��������] ƽ��ʱ�临�Ӷ�o(nlogn)   
 * 1.��׼���ڴ���������ѡ����Ԫ����Ϊ ��׼
 * 2.�ָ�û�׼�����зֳ����������У�ʹ��׼���Ԫ��<��׼����׼�ұ�Ԫ��>��׼
 * 3.�ݹ�ض��������н��п��ţ�ֱ������Ϊ��orֻ��һ��Ԫ��  
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
			while(m<n && a[n]>=temp)  //���������ұȻ�׼С����
				n--;
			a[m]=a[n];
			while(m<n && a[m]<=temp)  //���������ұȻ�׼�����
				m++;
			a[n]=a[m];			
		}
		a[m]=temp;
		return m;                     //���ػ�׼�±�
	}

}
