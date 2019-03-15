package BackTrack;
import java.util.*;

/**LargestGroup [���ͨ������] ������ͼ�������ȫ��ͼ(����������������ȫͼ) 
 * 
 * describe: ����   
 * �����������Ϊһ�����ţ������м���һ�����㣬Ȼ�����ο���ÿ�����㣬
 * ���ڵ�i�����ǽ���������Ż����������������Ȼ��ݹ��ж���һ���㡣
 * ���������ӻ���ֱ����������������ڵݹ�ǰ���ɲ��ü�֦������������Ч������
 * ��������Ҷ���ʱֹͣ���������Ž�
 */
public class LargestGroup {
 
	int bestn = 0;                          //����ŵ���	 
	int count = 0;                          //����Ÿ���
	
	public static void main(String[] args) {
		LargestGroup l = new LargestGroup();
		int[][] a = {                       
				{-1,-1,-1,-1,-1,-1},
				{-1, 0, 1, 0, 1, 1},
				{-1, 1, 0, 1, 0, 1},
				{-1, 0, 1, 0, 0, 1},
				{-1, 1, 0, 0, 0, 1},
				{-1, 1, 1, 1, 1, 0}     //a���±��1��ʼ,-1��ֵ����
		};     	
		List<int[]> res = l.max(a);
		System.out.println("����ŵ�����"+l.bestn);
		System.out.println("����Ÿ�����"+l.count);
		System.out.println("��������£�");
		for(int[] i:res)
			System.out.println(Arrays.toString(i));
	} 
	
	public List<int[]> max(int[][] a){ 
		List<int[]> res = new ArrayList<>();     
		dfs(a, 1, 0, new int[a.length], res); 
		return res;
	}
	/** 
	 * @param a    ͼ���ڽӾ���
	 * @param i    ��ǰ�ڵ�
	 * @param cn   ��ǰ����
	 * @param x    ��ǰ�� x[i]=1��ʾi�����������, =0��ʾ�������� 
	 * @param res  ��¼�����
	 */
	public void dfs(int[][] a, int i, int cn, int[] x, List<int[]> res){
		int n = a.length-1;
		if(i>n){
			int[] now = new int[x.length];
			for(int j=0; j<x.length; j++)
				now[j]=x[j];
			res.add(now); 
			bestn = cn;
			count++;
			return;
		} 		
		if(check(a, i, x)){           //��i�뵱ǰ��ȫ������,����������(ѡ��õ�)		
			x[i]=1;
			dfs(a, i+1, cn+1, x, res);//����ֱ�Ӹı�cn,�����޷�����
			x[i]=0;
		}
		if(cn+n-i>=bestn){            //��֦���޿��ܸ���ʱ���������� 
			x[i]=0;
			dfs(a, i+1, cn, x, res);
		}
	}
	
	//����i�Ƿ��뵱ǰ��ȫ������
	boolean check(int[][] a, int i, int[] x) {
		for(int j=1; j<i; j++){          
			if(x[j]==1 && a[i][j]==0)
				return false;
		}
		return true;
	}

}
