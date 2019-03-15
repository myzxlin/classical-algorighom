package BackTrack;
import java.util.*;

/**5X5�ĵ�ͼ�ϣ�һֻ����������㵽�յ㣬ͼ����һ���ӣ����м��ַ�����������·����̵ķ��� 
 * describe:����
 */
public class CrossRiver { 
	
	int count = 0;     //������
	int path = 0;      //����
	int min = 25;      //��С����
	
	public static void main(String[] args) {
		CrossRiver f = new CrossRiver(); 
		int a[][]= new int[][] {
			{0,0,0,0,0},
			{0,0,0,0,0},
			{1,1,0,1,1},
			{0,0,0,0,0},
			{0,0,0,0,0}   //1��ʾ��ˮ��0��ʾ½��
		}; 
		f.jump(a, 0, 0);
		System.out.println("��������"+f.count);
		System.out.println("���·�����ȣ�" + (f.min-1));  
		f.count=0;
		f.jumpMin(a, 0,0);
	}

	public void jump(int[][] a, int m, int n) {
		if(m<0||m>=5 || n<0||n>=5 || a[m][n]==1)  
			return;
		a[m][n]=1;
		path++;
		if(m==4 && n==4) {
			count++;
			min=Math.min(min, path);
		}
		jump(a, m+1,n);
		jump(a, m-1,n);
		jump(a, m,n+1);
		jump(a, m,n-1);
		path--;               //���� 
		a[m][n]=0;		
	}
	
	void jumpMin(int[][]a, int m, int n) { 
		if(m<0||m>=5 || n<0||n>=5 || a[m][n]==1)  
			return;
		a[m][n]=1;
		path++;
		if(m==4 && n==4 && path==min) { 
			count++;
			System.out.print("----���� "+count+"-----\n");
			for(int[] i:a)
				System.out.print(Arrays.toString(i)+"\n"); 
		}
		jumpMin(a, m+1,n);
		jumpMin(a, m-1,n);
		jumpMin(a, m,n+1);
		jumpMin(a, m,n-1);
		path--;         
		a[m][n]=0;		
	}
	
}
