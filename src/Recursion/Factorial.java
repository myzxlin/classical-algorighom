package Recursion;

/** 
 * Factorial [Çó½×³Ë]  
 * describe:µÝ¹é
 **/
public class Factorial {

	public static void main(String[] args) { 
		Factorial f = new Factorial(); 	
		System.out.print(f.find(3) + "\n");
		System.out.print(f.find(4) + "\n");
	}
	int find(int n) {
		if(n==0 || n==1)
			return 1;
		return find(n-1)*n;
	}
}
