package Greedy;
import java.util.*;

/** 
 * IntervalCoverage [区间覆盖]
 * i来表示x轴上坐标为[i-1，i]的长度为1的区间，并给出n(1≤n≤200)个不同的整数，表示n个这样的区间。 
 * 要求最多画m(1≤m≤50)条线段覆盖所有区间， 每条线段可以任意长，求所画线段最小长度之和
 * 
 * 思路：先用一条最长的线段把整个区间覆盖起来，然后把区间点之间的空隔线段按照先长后短的顺序一一去掉，
 * 也就是贪心地使总线段长度尽可能短，直到线段的数量增加到到规定的数目停止.
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
		int d = a[a.length-1]-a[0]+1;              //初始化为最大值 
		List<Integer> blank = new ArrayList<>();
		for(int i=1; i<a.length; i++) {
			if(a[i]-a[i-1]-1>0)
				blank.add(a[i]-a[i-1]-1);
		}
		Collections.sort(blank);
		Collections.reverse(blank);                //使空白线段降序排列
		for(int i=0; i<m-1; i++)
			d -= blank.get(i);                     //每次减去最长的空白段
		return d;
	}
}
