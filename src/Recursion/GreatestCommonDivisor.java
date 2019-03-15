package Recursion;

/** 
 * GreatestCommonDivisor [最大公约数] 欧几里得算法 辗转相除
 * describe:递归/非递归
 **/ 
public class GreatestCommonDivisor {

	public static void main(String[] args) { 
		GreatestCommonDivisor g = new GreatestCommonDivisor();
		int a = 50;
		int b = 75;
		System.out.print("["+a+", "+b+"] = "+g.gcd(a, b)+"\n");
		System.out.print("["+a+", "+b+"] = "+g.gcd2(a, b));
	}
	
	/*递归*/
	public int gcd(int a, int b) {
		if(a<b)
			return gcd(b, a);
		if(b==0)
			return a;
		return gcd(b, a%b);
	}
	
	/*非递归*/
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
