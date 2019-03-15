package DivideAndConquer;

/** 
 * BinarySearch [���ֲ���] �ֳ��۰����
 * describe: ����  
 */
public class BinarySearch {

	public static void main(String[] args) { 
		BinarySearch b = new BinarySearch();
		int[] arr = new int[] {1,2,5,7,8}; 
		int ans = b.find(arr, 7, 0, arr.length-1);
		System.out.print("7��λ��Ϊ��" + ans);
	}
	public int find(int[] a, int key, int m, int n) {
		int mid = (m+n)/2; 
		if(m>=n || key<a[0] || key>a[a.length-1])
			return -1;	 
		if(key>a[mid])
			return find(a, key, mid+1, n);
		if (key<a[mid])
			return find(a, key, m, mid-1);
		return mid; 		
	}
}
