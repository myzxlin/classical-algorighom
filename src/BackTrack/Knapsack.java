package BackTrack;
import java.util.*;

/** 
 * Knapsack [0-1��������] ����N����Ʒ��һ������,��Ʒi������Wi ��ֵ��Vi ��������ΪC
 * ���ѡ��װ�뱳������Ʒ��ʹ�ñ�����Ʒ�ܼ�ֵ���
 * describe:����
 **/ 
public class Knapsack {
  
	int vbest = 0;        /*��������ֵ*/ 
	int[] best;           /*���ѡ�񷽰�*/
	
	public static void main(String[] args) { 
		Knapsack k = new Knapsack();
		int[] w = new int[]{15,25,40,20,15,24};
		int[] v = new int[]{10,5,20,2,14,23}; 
		int c = 30; 
		System.out.println("����ֵ��" + k.knapsack(w, v, c));
		System.out.print("��ѷ�����" + Arrays.toString(k.best));
	}
	public int knapsack(int[] w, int[] v, int c) {  
		int n = w.length; 
		best = new int[n];
		dfs(w, v, c, 0, 0, 0, new int[n]); 
		return vbest;
	}
	/** 
	 * @param w   ��Ʒ����
	 * @param v   ��Ʒ��ֵ
	 * @param v   ��������
	 * @param k   ��ǰ�ڵ�
	 * @param cv  ������ǰ��ֵ
	 * @param cw  ������ǰ����
	 * @param cur ��ǰѡ�񷽰�
	 */ 
	void dfs(int[] w, int[] v, int c, int k, int cv, int cw, int[] cur) {
		if(k>=w.length) {
			if(cv>vbest) {
				vbest=cv;
				for(int i=0; i<w.length; i++)
					best[i] = cur[i]; 
			}	
			return;  
		}
		if(cw<c) {        //��֦
			cur[k]=1;
			dfs(w, v, c, k+1, cv+v[k], cw+w[k], cur);    		
			cur[k]=0;      
			dfs(w, v, c, k+1, cv, cw, cur);
		}
	}
}
