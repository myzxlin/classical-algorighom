package Others; 
import java.util.*;

/**�����ַ��������±�Ϊ������Сд��ĸ(��0��ʼ���)ת��Ϊ��д��ĸ 
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
