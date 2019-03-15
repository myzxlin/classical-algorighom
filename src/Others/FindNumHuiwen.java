package Others;

import java.util.ArrayList;
import java.util.List;

/** 输出100-1000的所有平方回文数，即：
 *  从左读与从右读是一样的；为完全平方数
 */
public class FindNumHuiwen {

	public static void main(String[] args) { 
		FindNumHuiwen f = new FindNumHuiwen();
		System.out.print(f.find());
	}
	public List<Integer> find() {
		List<Integer> res = new ArrayList<>();
		int i = 1;
		int x1, x2, x3;
		while(i*i<100)
			i++; 
		while(i*i>=100 && i*i<1000) {
			x1 = i*i/100;        //百位
			x2 = (i*i/10)%10;    //十位
			x3 = (i*i)%10;       //个位
			if(x1==x3)
				res.add(i*i);
			i++;
		}
		return res;
	}

}
