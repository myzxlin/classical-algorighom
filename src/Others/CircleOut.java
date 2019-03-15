package Others; 
import java.util.*;

/** 
 * CircleOut [Լɪ������]
 * һȺ��Χ��һȦ(���б��Ϊ1-N)����һ��������У�����Ϊ��
 * ˳��1-N�ķ����1-C���������ΪC�ĳ��У�ʣ�������¼�����ֱ�������˳��У�������б������
 * ����N=3,C=2�����б��Ϊ213
 * describe: ѭ������
 **/ 
public class CircleOut {
	
	public static void main(String[] args) { 
		CircleOut x = new CircleOut(); 
		int m = 7;         //����
		int c = 3;         //�������
		System.out.print("��������Ϊ��" + Arrays.toString(x.arrange(m, c)));	
	}
	public int[] arrange(int m, int c) {
		List<Integer> res = new ArrayList<>(); //ѭ������
		int[] a = new int[m];              //�������б�� 		
		int num = 1;                           //����˳����			
		for(int i=0; i<m; i++)
			res.add(i);                        //�б��ʼ��
		
		int k = -1;  
		while(res.size()>0) {
			k = (k+c)%res.size();              //ѭ��
			a[res.get(k)] = num;
			res.remove(k);                     //����
			num++;
			k--;                               //�±����
		}
		return a;
	}

}
