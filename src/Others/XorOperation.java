package Others;
import java.util.*;

/**XorOperation һ������������(���Ⱥܴ�)�������������С��K������ж���
 * (���ⲻ��)
 **/
public class XorOperation {
	
	public static void main(String[] args) { 
		XorOperation x = new XorOperation();
		int[] a = new int[] {5,3,8};
		int k = 8;
		System.out.print(x.find(a,k));
	} 
	public int find(int[] a, int k) {		
		int count = 0;
        int flag = Integer.parseInt(Integer.toBinaryString(k));
        int mask = 0;
        int max = a[0];
        
        for(int i=1; i<a.length; i++)
        	max = Math.max(max, a[i]);   //�ҵ�a�е����ֵ
        int top = Integer.toBinaryString(max).length();  //���ȡ��������λ
        
        for (int i=top; i>=0; i--){
            // �����λ������a��ǰ׺
            mask = mask | (1 << i);
            HashSet<Integer> set = new HashSet<Integer>();
            for (int num : a) {
                set.add(mask & num);
            }
            //�ж����������ĵ�ǰλ�Ƿ�Ϊ1
            int temp=flag|(1<<i);
            for (int prefix: set){
                if (set.contains(prefix^temp)) {
                    count++;
                }
            }
        }
        return count;
    }   

}
