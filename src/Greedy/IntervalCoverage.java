package Greedy;
import java.util.*;

/** 
 * IntervalCoverage [���串��]
 * i����ʾx��������Ϊ[i-1��i]�ĳ���Ϊ1�����䣬������n(1��n��200)����ͬ����������ʾn�����������䡣 
 * Ҫ����໭m(1��m��50)���߶θ����������䣬 ÿ���߶ο������ⳤ���������߶���С����֮��
 * 
 * ˼·������һ������߶ΰ��������串��������Ȼ��������֮��Ŀո��߶ΰ����ȳ���̵�˳��һһȥ����
 * Ҳ����̰�ĵ�ʹ���߶γ��Ⱦ����̣ܶ�ֱ���߶ε��������ӵ����涨����Ŀֹͣ.
 */
public class IntervalCoverage {

	public static void main(String[] args) {
		IntervalCoverage i = new IntervalCoverage();      
        int a[] = new int[] {1,3,8,5,11}; 
        int m = 3;
        System.out.print(i.func(a, m));        
    } 
 
	int func(int[] a, int m) {
		Arrays.sort(a);
		int d = a[a.length-1]-a[0]+1;              //��ʼ��Ϊ���ֵ 
		List<Integer> blank = new ArrayList<>();
		for(int i=1; i<a.length; i++) {
			if(a[i]-a[i-1]-1>0)
				blank.add(a[i]-a[i-1]-1);
		}
		Collections.sort(blank);
		Collections.reverse(blank);                //ʹ�հ��߶ν�������
		for(int i=0; i<m-1; i++)
			d -= blank.get(i);                     //ÿ�μ�ȥ��Ŀհ׶�
		return d;
	}
}
