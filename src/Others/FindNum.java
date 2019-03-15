package Others;
import java.util.*;

/**
 * 在三位整数(100-999)中寻找符合下列条件的整数,并依次从小到大输出
 * 是完全平方数；含两位数字相同
 **/
public class FindNum {

	public static void main(String[] args) {
		FindNum f = new FindNum(); 
		System.out.print(f.find());
	}

	public List<Integer> find() {
		List<Integer> res = new ArrayList<>();
		int x1, x2, x3; 
		int i=1;
		while(i*i<100)              //寻找第一个完全平方数
			i++;  
		while (i*i>=100 && i*i<=999) { 
			x1 = i*i/100;           //百位
			x2 = (i*i/10)%10;       //十位
			x3 = (i*i)%10;          //个位
			if(x1==x2 || x1==x3 || x2==x3)
				res.add(i*i);				
			i++;
		}
		return res;
	}
}
