package Others;
import java.util.*;

/**����ÿ2k�����ȵ��ַ���������ǰk���ַ���
 * �����ĩβ�ַ�<=k��������ʣ�������ַ����� k<���ĩβ�ַ�<2k��������ǰk���ַ�
 * ���磺����abcdefg��k=2�����bacdfeg
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
		for(; i<n/(k*2)*k*2; i+=k*2) {         //�ȴ���ǰiλ2k������
			String s = str.substring(i, i+k);
			for(int j=i; j<i+k; j++) {				
				res += c[i*2+k-j-1]; 
			}				
			for(int j=i+k; j<i+k*2; j++)
				res += c[j]; 
		} 
		
		if(n-i<k)                              //����ĩβ
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
