package Others;
import java.util.*;

/**
 * ����λ����(100-999)��Ѱ�ҷ�����������������,�����δ�С�������
 * ����ȫƽ����������λ������ͬ
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
		while(i*i<100)              //Ѱ�ҵ�һ����ȫƽ����
			i++;  
		while (i*i>=100 && i*i<=999) { 
			x1 = i*i/100;           //��λ
			x2 = (i*i/10)%10;       //ʮλ
			x3 = (i*i)%10;          //��λ
			if(x1==x2 || x1==x3 || x2==x3)
				res.add(i*i);				
			i++;
		}
		return res;
	}
}
