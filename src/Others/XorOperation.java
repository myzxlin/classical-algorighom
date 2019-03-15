package Others;
import java.util.*;

/**XorOperation 一个正整数数组(长度很大)，求其中两异或小于K的组合有多少
 * (此题不会)
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
        	max = Math.max(max, a[i]);   //找到a中的最大值
        int top = Integer.toBinaryString(max).length();  //后获取最大数最高位
        
        for (int i=top; i>=0; i--){
            // 从最高位试着找a的前缀
            mask = mask | (1 << i);
            HashSet<Integer> set = new HashSet<Integer>();
            for (int num : a) {
                set.add(mask & num);
            }
            //判断最大异或结果的当前位是否为1
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
