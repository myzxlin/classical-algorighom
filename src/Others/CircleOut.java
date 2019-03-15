package Others; 
import java.util.*;

/** 
 * CircleOut [约瑟夫环问题]
 * 一群人围成一圈(排列编号为1-N)，按一定规则出列，规则为：
 * 顺着1-N的方向从1-C计数，编号为C的出列，剩余人重新计数，直到所有人出列，输出出列编号序列
 * 例：N=3,C=2，出列编号为213
 * describe: 循环队列
 **/ 
public class CircleOut {
	
	public static void main(String[] args) { 
		CircleOut x = new CircleOut(); 
		int m = 7;         //人数
		int c = 3;         //报数间隔
		System.out.print("出队序列为：" + Arrays.toString(x.arrange(m, c)));	
	}
	public int[] arrange(int m, int c) {
		List<Integer> res = new ArrayList<>(); //循环队列
		int[] a = new int[m];              //出队序列编号 		
		int num = 1;                           //出队顺序编号			
		for(int i=0; i<m; i++)
			res.add(i);                        //列表初始化
		
		int k = -1;  
		while(res.size()>0) {
			k = (k+c)%res.size();              //循环
			a[res.get(k)] = num;
			res.remove(k);                     //出队
			num++;
			k--;                               //下标回退
		}
		return a;
	}

}
