package DivideAndConquer;
import java.util.*;

/**MergeSort [�鲢����] ��һ�����ظ�������飬������������   
 * �ֽ�: �Ѵ������ n ��Ԫ�ص����зֽ������������, ÿ�������а��� n/2 ��Ԫ��
 * ����: ��ÿ�������зֱ���ù鲢����MergeSort, ���еݹ�
 * �ϲ�: �ϲ������ź����������, ����������
 * describe: ����  
 */
public class MergeSort {

	public static void main(String[] args) { 
		MergeSort m = new MergeSort();
		int[] res = new int[]{8,3,5,2,4,6,7,1};
		m.sort(res, 0, res.length-1);
		System.out.print(Arrays.toString(res));
	}

	public void sort(int[] arr, int l, int r) {
		if(l>=r)
			return;         
		int mid = (l+r)/2;
		sort(arr, l, mid);     
		sort(arr, mid+1, r);  
		merge(arr, l, mid, r); 
	} 
	void merge(int[] a, int l, int m, int r) {
		int[] cur = new int[r-l+1];
		int i=l;
		int j=m+1;
		int k=0;
		while(i<=m && j<=r){
			if(a[i]<a[j])
				cur[k++]=a[i++];
			else
				cur[k++]=a[j++];
		}
		while(i<=m)
			cur[k++]=a[i++];
		while(j<=r)
			cur[k++]=a[j++];
		
		for(int x=0; x<cur.length; x++)
			a[l+x]=cur[x];     //����ԭ����
	}
}
