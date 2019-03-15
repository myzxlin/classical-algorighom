package Others;

import java.util.*; 

/**打印所有的水仙花数(各位数字立方和=该数本身，这样的三位数)
 * 例：153=1*1*1+5*5*5+3*3*3
 */
public class Narcissus {

	public static void main(String[] args) { 
		Narcissus n = new Narcissus(); 
		System.out.print(n.narci());
	}
	
	public List<Integer> narci() {
		int x1, x2, x3; 
		List<Integer> res = new ArrayList<>();
		for(int i=100; i<1000; i++){
			x1 = i/100;          //百位
			x2 = (i/10)%10;      //十位
			x3 = i%10;           //个位
			if(i == x1*x1*x1 + x2*x2*x2 + x3*x3*x3) 
				res.add(i); 	
		}
		return res;
	}

}
