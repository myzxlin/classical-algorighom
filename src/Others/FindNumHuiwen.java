package Others;

import java.util.ArrayList;
import java.util.List;

/** ���100-1000������ƽ��������������
 *  ���������Ҷ���һ���ģ�Ϊ��ȫƽ����
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
			x1 = i*i/100;        //��λ
			x2 = (i*i/10)%10;    //ʮλ
			x3 = (i*i)%10;       //��λ
			if(x1==x3)
				res.add(i*i);
			i++;
		}
		return res;
	}

}
