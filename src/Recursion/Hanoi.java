package Recursion;

/** 
 * Hanoi [��ŵ��] ��A,B,C�������ڵ����ӣ�A�ϰ�������״������n����ͬ��С��Բ�̣�Ҫ�����������ƶ���B�ϣ�
 * ͬһ��������С�̱����ڴ����Ϸ�����������Ҫ���ٴ��ƶ�
 * describe: �ݹ�   
 */
public class Hanoi {

	int count=0;
	
	public static void main(String[] args) {
		Hanoi h = new Hanoi();
		h.move(4, 'A', 'B', 'C');
		System.out.print("���ٲ�����" + h.count);
	}
	void move(int n, char A, char B, char C) {
		count++;
		if(n==1) {
			System.out.print(A + "->" + B + "\n");
			return;
		}			
		move(n-1, A, C, B);   //A�Ϸ�n-1�������ƶ���C
		move(1, A, B, C);     //A���һ���ƶ���B
		move(n-1, C, B, A);	  //C��n-1�������ƶ���B
	}
}
