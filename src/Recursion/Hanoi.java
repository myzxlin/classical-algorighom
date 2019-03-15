package Recursion;

/** 
 * Hanoi [汉诺塔] 有A,B,C三根相邻的柱子，A上按金字塔状叠放着n个不同大小的圆盘，要把所有盘子移动到B上，
 * 同一根柱子上小盘必须在大盘上方，问至少需要多少次移动
 * describe: 递归   
 */
public class Hanoi {

	int count=0;
	
	public static void main(String[] args) {
		Hanoi h = new Hanoi();
		h.move(4, 'A', 'B', 'C');
		System.out.print("最少步数：" + h.count);
	}
	void move(int n, char A, char B, char C) {
		count++;
		if(n==1) {
			System.out.print(A + "->" + B + "\n");
			return;
		}			
		move(n-1, A, C, B);   //A上方n-1个整体移动到C
		move(1, A, B, C);     //A最后一个移动到B
		move(n-1, C, B, A);	  //C上n-1个整体移动到B
	}
}
