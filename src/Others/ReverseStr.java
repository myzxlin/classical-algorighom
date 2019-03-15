package Others;
import java.util.*;

/**对于每2k个长度的字符串，逆置前k个字符串
 * 若最后末尾字符<=k，则逆置剩余所有字符；若 k<最后末尾字符<2k，则逆置前k个字符
 * 例如：输入abcdefg，k=2，输出bacdfeg
 */
public class ReverseStr {

	public static void main(String[] args) {
		ReverseStr r = new ReverseStr();	
		String str = "abcdefg";
		int k = 2; 
		System.out.print(r.rever(str, k));
	}
	
	public String rever(String str, int k) {
		char[] c = str.toCharArray();
		String res = "";
		int n = str.length();
		int i = 0;
		for(; i<n/(k*2)*k*2; i+=k*2) {         //先处理前i位2k整数段
			String s = str.substring(i, i+k);
			for(int j=i; j<i+k; j++) {				
				res += c[i*2+k-j-1]; 
			}				
			for(int j=i+k; j<i+k*2; j++)
				res += c[j]; 
		} 
		
		if(n-i<k)                              //处理末尾
			for(int j=i; j<n; j++)  			
				res += c[n-j-1];
		else {
			for(int j=i; j<i+k; j++)  			
				res += c[i*2+k-j-1];
			for(int j=i+k; j<n; j++)
				res += c[j];
		}
		return res;
	}

}
