package DynamicProgramming;

/** 
 * Knapsack [0-1��������] n����Ʒ�и��Ե������ͼ�ֵ���ָ��������ı���������ñ�����Ʒ��ֵ���
 * describe: ��̬�滮   
 */
public class Knapsack {

	public static void main(String[] args) { 
		Knapsack k = new Knapsack();
		int[] w = new int[] {5,3,7,2,3,4};
		int[] v = new int[] {3,6,5,4,3,4};
		int c = 15; 
		System.out.print(k.find(w, v, c));
	}
	/** 
	 * @param w  ��Ʒ����
	 * @param v  ��Ʒ��ֵ
	 * @param c  �������� 
	 */
	int find(int[] w, int[] v, int c) {
		int max = 0;
		int[][] dp = new int[w.length+1][c+1]; //dp[i][j]��ǰi����Ʒ��������Ϊj�ı��� 
		
		for(int j=1; j<=c; j++)
			dp[0][j] = (w[0]>j)? 0:v[0];       //��ʼ��ֻ�ŵ�һ����Ʒʱ�ļ�ֵ	  		
		for(int i=1; i<w.length; i++) {
			for(int j=1; j<=c; j++) {
				dp[i][j] = w[i]>j? dp[i-1][j]: Math.max(dp[i-1][j-w[i]]+v[i], dp[i-1][j]);  
				max = Math.max(max, dp[i][j]); 				
			}
		}
		return max;		
	}
}
