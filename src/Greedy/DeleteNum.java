package Greedy;

/** 
 * DeleteNum [ɾ������Ϸ] ����������m, ȥ����������k�����ֺ�ʹ��ʣ�µ�����С, 
 * �磺m=5027539, k=3, ���239(����0����λ�������֣���ȥ��0)   
 * 
 * ����1��ÿһ������ѡ��һ��ʹʣ�µ�����С������ɾ��(̰��)��
 * ������λ����λ��˳������������λ���ֵ�������ɾ��ĩβ����
 * ����ɾ����һ�������(�ݼ�����)�����ַ���Ȼ��ص����ף��������������
 * 
 * ����2�� ����������λ���ض�������m[0]-m[k]��Χ�ڣ�����λ��������
 * ���������Χ��Ѱ����С����Ϊ�����Ԫ�أ�Ȼ�����
 */
public class DeleteNum {

	public static void main(String[] args) { 
		DeleteNum d = new DeleteNum();
		int m = 50267539;
		int k = 4;
		System.out.print(d.func1(m, k) +"\n");
		System.out.print(d.func2(m, k) +"\n"); 
	}
	/*����һ*/
	public String func1(int m, int k) {
		String s = String.valueOf(m);
		int n = s.length(); 
		while(s.length()>n-k) { 
			for(int i=1; i<s.length(); i++) {
				if(s.charAt(i)>=s.charAt(i-1))
					continue;
				if(i==s.length()-1) {  //��ĩԪ����
					s = s.substring(0, i)+s.substring(i+1, s.length()); 
					break;
				}					
				s = s.substring(0, i-1)+s.substring(i, s.length());
			}
		}
		while(s.charAt(0)=='0')
			s=s.substring(1, s.length());   //ȥ����0
		return s;
	} 
	
	/*������ ���޴�*/
	public String func2(int m, int k) {
		String s = String.valueOf(m);
		String res = "";
		int start = 0;
		int end = k; 
		while(res.length()<s.length()-k && end<s.length()) {
			int min = s.charAt(start)-'0';
			int flag = start;
			for(int i=start; i<=end; i++) {
				if(s.charAt(i)-'0'<min) {
					min = s.charAt(i)-'0';
					flag = i; 
				}					
			}
			res += s.charAt(flag);
			k -= flag-start;
			start = flag+1;		
			end = start+k; 
		}
		while(res.charAt(0)=='0')
			res=res.substring(1, res.length());   //ȥ����0
		return res;
	}

}
