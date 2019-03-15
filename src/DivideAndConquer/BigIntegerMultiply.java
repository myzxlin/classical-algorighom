package DivideAndConquer;

/** 
 * BigIntegerMultiply [大整数乘法]  
 * X = AB, Y = CD (XY均为n位数)
 * XY = (A*10*n/2 + B)(C*10*n/2 + D)
 *   = AC*10*n + BD + (AD+BC)*10*n/2             计算AC,BD,AD,BC      4个乘量
 *   = AC*10*n + BD + [(A-B)(D-C)+AC+BD]*10*n/2  计算AC,BD,(A-B)(D-C) 3个乘量  更优
 * describe: 分治  
 */
public class BigIntegerMultiply {

	public static void main(String[] args) { 
		BigIntegerMultiply b = new BigIntegerMultiply();
		System.out.print(b.f(1234, 5678, 4));				
	}

	public double f(double x, double y, int n) {  
		if(x==0 || y==0)
			return 0;
		if(n==1)
			return x*y;
		
		double a = x / (Math.pow(10, n/2));
		double b = x % (Math.pow(10, n/2));
		double c = y / (Math.pow(10, n/2));
		double d = y % (Math.pow(10, n/2));
		double ac = f(a,c,n/2);
		double bd = f(b,d,n/2);
		double abcd = f(a-b,d-c,n/2)+f(a,c,n/2)+f(b,d,n/2);
		
		return ac*(Math.pow(10, n)) + bd + abcd*(Math.pow(10, n/2));						
	}
}
