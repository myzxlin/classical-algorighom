package Others;
import java.util.Arrays;

/**NextBiggerArray 给一个正整数，返回所有全排列中下一个比它大的,如：给125643，返回126543
 */
public class NextBiggerArray {

	public static void main(String[] args) { 
		NextBiggerArray n = new NextBiggerArray();
		int[] arr = new int[] {1,2,3,6,5,4};
		System.out.print(Arrays.toString(arr)+"\n");
		System.out.print(Arrays.toString(n.findNext(arr)));
	}

	public int[] findNext(int[] a) {
		int n = a.length;
		int temp = 0;
		int flag1 = 0;
        int flag2 = n-1;
		int min = a[n-1];
		
		for(int i=n-2; i>=0; i--) {       //寻找交换点A
			if(a[i]<a[i+1]) {
				flag1=i;
				break;
			}
		} 
		for(int i=n-1; i>flag1; i--) {     //寻找交换点B
			if(a[i]>a[flag1] &&a[i]<min) {
				min=a[i];
				flag2=i;
			}			
		} 
		temp=a[flag1];                     //交换AB
		a[flag1]=a[flag2]; 
		a[flag2]=temp;  
		
		arrange(a, flag1+1);               //对A之后的元素升序排列
		return a;
	}
	
	void arrange(int[] a, int m) {
		int t=0;
		for(int i=m; i<a.length; i++) {
			for(int j=i+1; j<a.length; j++) {
				if(a[j]<a[i]) {
					t=a[j]; a[j]=a[i]; a[i]=t;
				}
			}
		}
	}
	
}
