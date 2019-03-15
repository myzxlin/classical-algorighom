package DynamicProgramming;
import java.util.*;

/** 
 * buildTree һ������0��1�����飬����ѡ������λ��Ԫ�ؽ��䷭ת��0��Ϊ1,1��Ϊ0��
 * �� �����鷴ת�ɷǵݼ������ ��С����
 * �磺[00110]->1, [010110]->2
 * describe: ��̬�滮
 **/ 
public class MinFlips {

	public static void main(String[] args) {
		MinFlips m = new MinFlips(); 
		System.out.print(m.flips("101") + "\n");
		System.out.print(m.flips("010110") + "\n"); 
	}
	 
	public int flips(String s) {
		char[] c = s.toCharArray();
		if(s.length()==0)
			return 0;
		int dp0=0;             //��0-iλȫ����תΪ0����Ĵ�������0-iλ1�ĸ���
		int dp=0;              //��ǰ״ֻ̬������һλ�Ƚϣ�������������
		for(int i=0; i<s.length(); i++) {
			dp0 += c[i]-'0';
			dp = Math.min(dp0, dp+1-c[i]+'0');//��֮ǰȫ����0 �� ��s[i]��Ϊ1+֮ǰ����Сֵ 
		}			
		return dp;
	}

}
