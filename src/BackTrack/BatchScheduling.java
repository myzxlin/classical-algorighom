package BackTrack;
import java.util.*;

/** 
 * BatchScheduling [��������ҵ����] ����n����ҵ��ÿ����ҵ�������ɻ���1�������ɻ���2����
 * t[i][j]��ʾ��ҵi��Ҫ����j�Ĵ���ʱ�䣬 ������ҵ�ڻ���2����ɴ����ʱ��ͳ�Ϊ����ҵ���ȵ����ʱ��͡�
 * �������ҵ���ȷ�����ʹ�����ʱ��ʹﵽ��С������
 *        ��ҵ1  ��ҵ2  ��ҵ3
 * ����1    2     3      3
 * ����2    1     1      3
 * ��3����ҵ��6�ֿ��ܵĵ��ȷ����� 123,132,213,231,312,321,������Ӧ�����ʱ��ͷֱ���19,18,20,21,19,19��
 * �׼�����ѵ��ȷ����� 132�������ʱ���Ϊ18��(����ͼ�Ͷ���)
 * 
 * ˼·�� ��������ҵ��������Ҫ��n����ҵ�������������ҳ�������С���ʱ��͵���ҵ���ȣ���ռ���һ����������
 * ��ǰ��ҵi�ڻ���2�����ʱ��, ����ҵi-1�ڻ���2�����ʱ�����ҵi�ڻ���1����ɵ�ʱ��Ľϴ��߾���������
 * f2[i] = Math.max(f2[i-1], f1) + t[cur[j]][1];
 */
public class BatchScheduling { 
              
	int bestf = Integer.MAX_VALUE;       //��ǰ����ֵ 
	int[] bestx;                         //��ǰ������ҵ���� 

	public static void main(String[] args) {
		BatchScheduling b = new BatchScheduling();		
		int[][] t = { 
				{ 0, 0 },
				{ 2, 1 }, 
				{ 3, 1 }, 
				{ 2, 3 }     
			};		
		System.out.println("��ǰ����ֵ:" + b.batch(t));
		System.out.println("��ǰ������ҵ���ȣ�" + Arrays.toString(b.bestx));
	}
	public int batch(int[][] t) {  
		int n = t.length;   
		bestx = new int[n]; 
		int[] cur = new int[n];
		for(int i=0; i<n; i++)            //�����ʼ��һ��·��
			cur[i]=i;	
		dfs(t, 1, 0, new int[n], 0, cur); //�ӵ�һ����ҵ��ʼ
		return bestf;
	}
	/** 
	 * @param t   ����ҵ����Ĵ���ʱ��
	 * @param i   ��ǰ�ڵ�
	 * @param f1    ����1��ɴ���ʱ��
	 * @param f2    ����2��ɴ���ʱ��
	 * @param f   ��ǰ���ʱ���
	 * @param cur ��ǰ��ҵ����
	 */
	public void dfs(int[][] t, int i, int f1, int[] f2, int f, int[] cur) {
		int n = t.length-1;
		if(i>n){
			if(f<bestf) {
				for(int j=1; j<=n; j++) 
					bestx[j] = cur[j]; 
				bestf = f; 
			}
			return;
		}  
		for(int j=i; j<=n; j++){
			f1 += t[cur[j]][0];
			f2[i] = Math.max(f2[i-1],f1) + t[cur[j]][1];		
			if(f<bestf) {                 //��֦ �п��ܸ���ʱ�Ž���
				swap(cur, i, j);
				dfs(t, i+1, f1, f2, f+f2[i], cur);
				swap(cur, i, j);
			}			 
			f1 -= t[cur[j]][0];			
		}
	}
	public int[] swap(int[] x, int i, int j) {
		int t = x[j];
		x[j] = x[i];
		x[i] = t;
		return x;
	}
	
}
