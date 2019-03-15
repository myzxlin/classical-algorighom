package DivideAndConquer;

/** 
 * MutipleMatrix [矩阵相乘]  
 * 1. 常规思路：8次乘法
 * |a11  a12| * |b11  b12| = |a11*b11+a12*b21  a11*b12+a12*b22|
 * |a21  a22|   |b21  b22|   |a21*b11+a22*b21  a21*b12+a22*b22| 
 * 2. Strassen算法：7次乘法 优化性能
 */
public class MutipleMatrix {

	public static void main(String[] args) { 

	}
	//常规思路 时间复杂度o(n^3) 爆炸
	int[][] f1(int[][] m, int[][] n) {
		int[][] res = new int[m.length][n[0].length];
		for(int i=0; i<m.length; i++) {
			for(int j=0; j<n[0].length; j++)
				for(int x=0; x<m[0].length; x++)
					res[i][j]+=m[i][x]*n[x][j];
		}
		return res;
	}
	//Strassen算法 (二阶矩阵)
	int[][] f2(int[][] x, int[][] y){
		int p1, p2, p3, p4, p5, p6, p7;
		int[][] res = new int[x.length][y[0].length];
		p1 = (y[0][1] - y[1][1]) * x[0][0];   
		p2 = y[1][1] * (x[0][0] + x[0][1]);   
		p3 = (x[1][0] + x[1][1]) * y[0][0];   
		p4 = x[1][1] * (y[1][0] - y[0][0]);   
		p5 = (x[0][0] + x[1][1]) * (y[0][0] + y[1][1]);   
		p6 = (x[0][1] - x[1][1]) * (y[1][0] + y[1][1]);   
		p7 = (x[0][0] - x[1][0]) * (y[0][0] + y[0][1]);   
		res[0][0] = p5 + p4 - p2 + p6;   
		res[0][1] = p1 + p2;   
		res[1][0] = p3 + p4;
		res[1][1] = p5 + p1 - p3 - p7;
		return res;  
	}

}
