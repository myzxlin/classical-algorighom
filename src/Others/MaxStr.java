package Others; 
import java.util.*;

/** ������#��β���ַ�����������ַ�������������������ִ������俪ʼ���±�
 */
public class MaxStr {
	
	public static void main(String[] args) { 
		MaxStr m = new MaxStr();
		String str = "ashj45hvjd890384nv1#";
		System.out.print(m.find(str));
	}
	
	public String find(String s) { 
		String maxCur = "";
		String maxFinal = "";
		char[] c = s.toCharArray();
		int n = s.length();
		int cur = 0;
		int max = 0;    
		int i=0;
		while(i<n && c[i]!='#') {
			cur = 0;
			maxCur = "";
			while(c[i]>='0' && c[i]<='9' && c[i]!='#' && i<n) {  
				cur++;
				maxCur += String.valueOf(c[i]);
				i++;
			}
			if(cur>max) {
				max = cur;
				maxFinal = maxCur;
			}
			i++;
		}
		return maxFinal;
	}

}
