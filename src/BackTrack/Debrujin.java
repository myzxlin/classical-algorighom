package BackTrack;

/**
 * Debrujin [�²�³��/������������] ��������n���ҳ�����Ϊ2^n������(����С��)��
 * ʹ�ý��������ɻ�״������ȡ��Ϊn�Ĵ�ʱ���õ���2^n����Ϊn��0-1�����ֱ����ͬ��ʮ������.
 * ����n=2, ���0011, ��Ϊ00,01,11,10 �ֱ����0,1,3,2, �����������
 * 
 * describ���ǵݹ����
 * n�׵²�³���й�2^nλ����ȷ��n=2^n-n-2λ������Ӧ����n/2-n��0��n/2-2��1����û���ظ���nλ���������С�
 * ��������a[N]���棬���ݷ�̽��a[n+1,N-2]��ȡֵΪ0��1
 * Ԫ�س�ֵa[0,n-1] = 0, a[n] = 1,a[N-1] = 1, a[i=n+1] = 0
 * ȡֵ�㣺a[i] = 0
 * ���ݵ㣺a[i] = 1
 * Լ������1��i == N-2���� a[n+1,N-2]��N/2-n��0
 * Լ������2��û���ظ���nλ����������
 **/
public class Debrujin {
	
	public static void main(String[] args) { 
		Debrujin x = new Debrujin();
		System.out.print(x.debrujin(3)); 
	}
	
	public String debrujin(int n){
		int j, k, g;
		int c = 0;     //1�ĸ�����Ԥ����n/2-2��
		int i = n+1;
		int s = 0;
		int len = 1<<n;            //��2^n         
		int[] d = new int[len];
		int[] dd = new int[len];   //���2^n�������������Ƿ��Ѿ����ֹ������ֹ�Ϊ1,����Ϊ0
		int gvp = 0;   
		String ans = String.valueOf(Integer.toBinaryString(1<<len));  	
		if(n<1)
			return "";
		if(n==1)
			return "0";
		if(n==2)
			return "0011";

		d[n] = 1;           //ǰ0 ~ n-1λ��Ϊ0
		d[len-1] = 1;       //���һλΪ0
		//���绹δ�����һλ������1�ĸ����Ѿ�����Ԥ����Ŀ
		//��ʣ��λ�ò����ܷ��»���Ҫ��1�ĸ���
		while(true){	
			g = 1;	
			c = 0;
			for(j=n+1; j<=i; ++j){
				if(d[j]==1)
					++c;
		} 		
		if(c>len/2-2 ||(len-2-i<len/2-2-c)) //1�ĸ������ڹ涨����0�ĸ������ڹ涨
			g = 0;
		++gvp;
		if(g==1 && i==len-2){               //��һ���ж��Ƿ���� ��־λ
			for(j = 0; j < len; ++j)
				dd[j] = 0;
			for(j = 0; j < len; ++j){  		//����d[j]d[j+1]...d[j+n-1]
				for(c = 0,k = j; k < j+n; ++k)
					c += (d[k>=len?k-len:k]<<(n-1-(k-j)));		
				if(dd[c]==1){
					c = -1;
					break;
				}else
					dd[c] = 1;
			}
			String now = "";
			if(c >= 0){
				++s;
				for(j = 0; j < len; ++j)
					now += String.valueOf(d[j]);
				ans = min(now, ans); 
			}
		}
		if(g==1 && i<len-2){
			++i;
			d[i] = 0; 
		}
		while(d[i]==1 && i>n) 
			i--; 
			if(i<n+1)
				break;
			else
				++d[i];//ǰ��������ͳ��1�ĸ������޸�1����������
		} 
		return String.valueOf(ans);
	}
	
	//���������������ַ�������ֵ��С���Ǹ�
	String min(String s1, String s2) {
		int m = Integer.parseInt(s1);
		int n = Integer.parseInt(s2);
		return m<n? s1:s2;
	}
}
