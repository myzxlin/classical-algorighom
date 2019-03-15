package Others; 
import java.util.*;

/**输入字符串，把下标为奇数的小写字母(从0开始编号)转换为大写字母 
 */
public class TranStr { 
	
	public static void main(String[] args) {
		TranStr t = new TranStr(); 
		System.out.print(t.tran("abnzbcbvkshk")); 
	}
	
	public String tran(String s) {
		char[] c = s.toCharArray();
		String res = "";
		for (int i=0; i<s.length(); i++) {
			if(i%2==0)
				res += (char)(c[i]-32);
			else
				res += c[i];
		} 
		return res;
	}
}
