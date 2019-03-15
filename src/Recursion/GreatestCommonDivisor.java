package Recursion;

/** 
 * GreatestCommonDivisor [���Լ��] ŷ������㷨 շת���
 * describe:�ݹ�/�ǵݹ�
 **/ 
public class GreatestCommonDivisor {

	public static void main(String[] args) { 
		GreatestCommonDivisor g = new GreatestCommonDivisor();
		int a = 50;
		int b = 75;
		System.out.print("["+a+", "+b+"] = "+g.gcd(a, b)+"\n");
		System.out.print("["+a+", "+b+"] = "+g.gcd2(a, b));
	}
	
	/*�ݹ�*/
	public int gcd(int a, int b) {
		if(a<b)
			return gcd(b, a);
		if(b==0)
			return a;
		return gcd(b, a%b);
	}
	
	/*�ǵݹ�*/
	public int gcd2(int a, int b) {
		int temp = 0;
		if(a<b) {      
			temp=a; 
			a=b;
			b=temp;
		} 
		while(b>0) {
			temp=a%b;
			a=b;
			b=temp; 
		}
		return a;
	}

}
