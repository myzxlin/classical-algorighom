package Others;
import java.util.*;

/**对字符串所有以空格为分隔的字符进行逆置
 */
public class ReverseBlank { 
	
	public static void main(String[] args) {  
		ReverseBlank r = new ReverseBlank();
		String s = "you are the apple of my eyes";
		System.out.print(r.rever(s));
	}
	
	public String rever(String s) { 
        String[] ss = s.split(" "); 
        String res = "";
		for(int i=0; i<ss.length; i++) {
			String cur = "";
			int len = ss[i].length();
			for(int j=0; j<len; j++) 
				cur += ss[i].charAt(len-j-1); 
			res += cur+" "; 
		}
		return res;
	}
}
