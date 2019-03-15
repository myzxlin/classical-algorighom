package DivideAndConquer;
import java.util.*;

/** 
 * LinerTimeSelection [����ʱ��ѡ��]     
 * ��������������n��Ԫ�غ�һ������k��1��k��n��Ҫ���ҳ���n��Ԫ���е�kС��Ԫ��
 *
 * describe: ������������еݹ黮�֣�����Ų�ͬ���ǣ���ֻ�Ի��ֳ���������֮һ���еݹ鴦��
 * 1. ������� 
 * if(n<20) ֱ�ӽ�a�е�Ԫ������������k��Ԫ��,����; ����
 * ������������������ֻ�׼i��������a[p:r]���ֳ����������飬ʹ��������Ԫ��<�ұ������Ԫ�أ�
 * ����a[p:i]��Ԫ�ظ���j.��k<=j�����kСԪ����������a[p:i]��; ��Ȼ����a[i+1:r]��
 * Ȼ�������㷨û�п���ʵ�ʲ���������Ŀ��������������ܵ���ֵ���ֿ��Լ����Ż����㷨
 * 
 * 2. ��ֵ����
 * ��a����Ϊn/5�����飬ÿ��5��Ԫ�أ��� i�����ΪSi�����һ��<5���Ĳ�����;
 * �ò��������㷨���ÿ�����λ�� mi���ݹ����mi����λ��M, MΪ���ŵĻ��ֻ�׼pivot;
 * ���㷨�ܱ�֤ÿ�ο��ŵĻ�׼������ѻ�׼�����������ָ������Ӷ�ʹʱ�临�Ӷȴﵽ����
 */
public class LinerTimeSelection {

	public static void main(String[] args) { 
		LinerTimeSelection l = new LinerTimeSelection();
		int[] arr = new int[] {5,4,1,6,3};
		int k = 2;
		int ans = l.sort1(arr, k, 0, arr.length-1);
		System.out.print("��"+ k +"С��Ԫ�أ�" + ans);
	}
	
	public int sort1(int[] a, int k, int m, int n) {
		if(m==n)
			return a[m];
		//int key = random(m,n);          //������� 
		int key = middle(a,m,n);          //��ֵ����
		swap(a[key], a[m]);               //�����Ԫ�ػ�����һλ
		int p = pivot(a, m, n);
		int len = p-m+1;                  //�������Ԫ�ظ���
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
	
	/*ѡ�������׼*/
	int random (int x, int y) {
		Random random = new Random();
		int num = random.nextInt(y)%(y-x+1) + x; //����(x,y)֮��������		
		return num;
	}		
	void swap(int x, int y) {
	    int temp = x;
	    x = y;
	    y = temp;
	  }
	
	/*ѡ����ֵ��׼*/
	int middle(int a[], int m, int n) {                          
	    if(n-m<=5){     
	    	Arrays.sort(a);
	    	return a[a.length/2]; 
	    }
	    int s1[][]=new int[a.length/5][5];    //����Ϊ5��һ����Ӽ�
	    for(int i=0; i<a.length; i++)         //����Ӽ�
	    	for(int j=0; j<5; j++) 
	    		s1[i][j] = a[i*5+j];	        	
 	        
	    int s2[]=new int[s1.length];                      
	    for(int i=0; i<s1.length; i++){ 
	        Arrays.sort(s1[i]);                //��ÿ���Ӽ�����
	        s2[i]=s1[i][2];	                   //ss[i][2]Ϊ���Ӽ���λ��������sss[]           
	    }
	    Arrays.sort(s2);
	    return s2[s2.length/2];                //�����������е���λ��	        	      
	}

}
