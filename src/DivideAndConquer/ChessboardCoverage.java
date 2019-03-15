package DivideAndConquer;

import java.util.Arrays;

/** 
 * ChessboardCoverage [棋盘覆盖]   
 * 在一个2^k×2^k (k≥0)个方格组成的棋盘中，有一个特殊方格。
 * 用4种不同形状L型骨牌覆盖棋盘上除特殊方格以外的所有方格，且任何2个骨牌不得重叠覆盖，问如何覆盖
 *
 * describe: 将棋盘划分为4个等大的子棋盘，其中只有一个包含特殊方格，其余3个没有特殊方格
 * 用一个骨牌覆盖3个棋盘会合处，从而将原问题转化为4个较小规模的子问题
 * 递归求解，直至将棋盘分割为1×1的子棋盘
 */
public class ChessboardCoverage {

    int[][] board = new int[4][4];
    int num = 0;  // 记录骨牌的编号

    public static void main(String[] args) {
    	ChessboardCoverage c = new ChessboardCoverage();
    	int m = 3;
    	int n = 3;      //特殊方格坐标
    	int len = 4;    //棋盘尺寸
        c.chess(0, 0, m, n, len);
        System.out.println("覆盖后的棋盘：");
        for(int[] i:c.board)
        	System.out.print(Arrays.toString(i) + "\n"); 
    }

    //[i,j]：棋盘左上角   [m,n]：特殊方格  size：棋盘大小 
    public void chess(int i, int j, int m, int n, int size) {
        if (size==1) 
            return;
        int t = num++;
        int s = size/2;
          
        if (m<i+s && n<j+s)           //左上角               
            chess(i, j, m, n, s);     //特殊方格在此棋盘中
        else {           
            board[i+s-1][j+s-1] = t;  //特殊方格不在此棋盘中，用 t号骨牌覆盖右下角
            chess(i, j, i+s-1, j+s-1, s);
        }
         
        if (m<i+s && n>=j+s)          //右上角
            chess(i, j + s, m, n, s);
        else {
            board[i+s-1][j+s] = t;
            chess(i, j+s, i+s-1, j+s, s);
        }
        
        if (m>=i+s && n<j+s)          //左下角
            chess(i+s, j, m, n, s);
        else {
            board[i+s][j+s-1] = t;
            chess(i+s, j, i+s, j+s-1, s);
        }
        
        if (m>=i+s && n>=j+s)         //右下角
            chess(i+s, j+s, m, n, s);
        else {
            board[i+s][j+s] = t;
            chess(i+s, j+s, i+s, j+s, s);
        }
    }

}
