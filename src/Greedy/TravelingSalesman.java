package Greedy;

/** 
 * TravelingSalesman [TSP ����������] NP��ȫ����
 * �����̴�ĳ���г������ظ��ؾ���������ÿһ�����У����ص�ԭ�㣬��·����̵���·
 * ������ͼ��Ȩֵ֮����С�Ļ�·
 * 
 * describe: ̰�Ĳ���  
 * 1. ��ĳ�����п�ʼ��ÿ��ѡ��һ�����У�ֱ�����еĳ��б����ꣻ 
 * 2. ÿ��ѡ�����ʱ��ֻ���ǵ�ǰ�������֤����Ϊֹ������·����̡�  
 * s[] ��¼���ʹ���·��  s[i]=1��ʾ����i���߹���s[i]=0��ʾ����iδ�߹�
 */
public class TravelingSalesman {
	
	public static void main(String[] args){
		TravelingSalesman t = new TravelingSalesman(); 
		int[][] d = new int[][] {      
			{0, 1, 2, 3},
			{1, 0, 3, 2},
			{2, 3, 0, 1},
			{3, 2, 1, 0}                //d[i][j]=x ��ʾ����i��j֮�����Ϊx
		};   
		System.out.println("���·��:" + t.tsp(d));
	}  
	
	public int tsp(int[][] d){		 
		int[] s = new int[d.length];    //�������,�߹���1
		int min = 0;                    //���·��
		int cur = 0;                    //��ǰ����
		int next = 0;                   //�¸�����				
		while(s[cur]==0){
			s[cur] = 1;                 //��1,��ʾ�Ѿ��߹� 			
			next = search(d, cur, s);    	
			System.out.println(cur + "->" + next);
			min += d[cur][next];
			cur = next;                 //ָ�����
		}
		return min;		
	}
	//Ѱ��cur����һ�����ų��� 
	public int search(int[][] d, int cur, int[] s){
		int best = 0;	                //���ų��е��±����
		int min = d[cur][0];            //���¸����е���̾���
		int i = 0;	      
		while(i<d.length-1 && s[i]==1)  //Ѱ�ҵ�һ�����ýڵ�i
			min = d[cur][++i];		
		for(; i<d.length; i++){         //�ӽڵ�i��ʼ����ɨ�裬�ҳ�������С��
			if(s[i]==1)                 //���ʹ���������
				continue;
			if(d[cur][i]<=min){
				min = d[cur][i];
				best = i;
			}
		}
		return best;
	}
	
}