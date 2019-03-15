package Recursion;

/** Fibonacci [ì³²¨ÄÇÆõÊýÁÐ] F(0)=1£¬F(1)=1, F(n)=F(n-1)+F(n-2) 
 *  describe: µÝ¹é   
 */
public class Fibonacci {
 
	public static void main(String[] args) { 
		Fibonacci f = new Fibonacci(); 
		System.out.print(f.f(3) + "\n");
		System.out.print(f.f(4) + "\n");
		System.out.print(f.f(5) + "\n");
	}
	public int f(int n) {
		if(n==0 || n==1)
			return 1;
		return f(n-1) + f(n-2);
	}

}
