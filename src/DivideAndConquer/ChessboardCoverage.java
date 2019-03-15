package DivideAndConquer;

import java.util.Arrays;

/** 
 * ChessboardCoverage [���̸���]   
 * ��һ��2^k��2^k (k��0)��������ɵ������У���һ�����ⷽ��
 * ��4�ֲ�ͬ��״L�͹��Ƹ��������ϳ����ⷽ����������з������κ�2�����Ʋ����ص����ǣ�����θ���
 *
 * describe: �����̻���Ϊ4���ȴ�������̣�����ֻ��һ���������ⷽ������3��û�����ⷽ��
 * ��һ�����Ƹ���3�����̻�ϴ����Ӷ���ԭ����ת��Ϊ4����С��ģ��������
 * �ݹ���⣬ֱ�������̷ָ�Ϊ1��1��������
 */
public class ChessboardCoverage {

    int[][] board = new int[4][4];
    int num = 0;  // ��¼���Ƶı��

    public static void main(String[] args) {
    	ChessboardCoverage c = new ChessboardCoverage();
    	int m = 3;
    	int n = 3;      //���ⷽ������
    	int len = 4;    //���̳ߴ�
        c.chess(0, 0, m, n, len);
        System.out.println("���Ǻ�����̣�");
        for(int[] i:c.board)
        	System.out.print(Arrays.toString(i) + "\n"); 
    }

    //[i,j]���������Ͻ�   [m,n]�����ⷽ��  size�����̴�С 
    public void chess(int i, int j, int m, int n, int size) {
        if (size==1) 
            return;
        int t = num++;
        int s = size/2;
          
        if (m<i+s && n<j+s)           //���Ͻ�               
            chess(i, j, m, n, s);     //���ⷽ���ڴ�������
        else {           
            board[i+s-1][j+s-1] = t;  //���ⷽ���ڴ������У��� t�Ź��Ƹ������½�
            chess(i, j, i+s-1, j+s-1, s);
        }
         
        if (m<i+s && n>=j+s)          //���Ͻ�
            chess(i, j + s, m, n, s);
        else {
            board[i+s-1][j+s] = t;
            chess(i, j+s, i+s-1, j+s, s);
        }
        
        if (m>=i+s && n<j+s)          //���½�
            chess(i+s, j, m, n, s);
        else {
            board[i+s][j+s-1] = t;
            chess(i+s, j, i+s, j+s-1, s);
        }
        
        if (m>=i+s && n>=j+s)         //���½�
            chess(i+s, j+s, m, n, s);
        else {
            board[i+s][j+s] = t;
            chess(i+s, j+s, i+s, j+s, s);
        }
    }

}
