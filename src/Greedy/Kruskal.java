package Greedy;
import java.util.*;
import Helpclass.Edge;

/** 
 * Kruskal [��³˹�����㷨] ����С������ 
 * describe: ̰�Ĳ��� 
 * �ֱ���Ϊ �ӱ߷�, ����Ȩ��ͨͼ����С���������ɾ���V-1���ߵ��޻���ͼ���ұߵ�Ȩ�غ���С��
 * �㷨��ʼʱ������Ȩ�صĵ���˳���ͼ�еı�����֮���������̰�ĵķ�ʽ�������� 
 * ʱ�临�Ӷ���Ҫȡ���ڶԱ߽���Ȩֵ����������㷨Ч�ʣ����ɴ�O(nlogn)
 */
public class Kruskal { 
	 
	 public static void main(String[] args) {
		 Kruskal k = new Kruskal(); 
		 int n = 6;		                          //����   
		 LinkedList<Edge> a = new LinkedList<>(); //�߼� 		 
		 a.add(new Edge(1, 2, 3));
		 a.add(new Edge(1, 5, 6));
		 a.add(new Edge(1, 6, 5));
		 a.add(new Edge(2, 6, 5));
		 a.add(new Edge(2, 3, 1));
		 a.add(new Edge(3, 6, 4));
		 a.add(new Edge(3, 4, 6));
		 a.add(new Edge(4, 6, 5));
		 a.add(new Edge(4, 5, 8));
		 a.add(new Edge(5, 6, 2)); 
	     
	     a.sort(null);                //��Ȩֵ��������
	     k.kruskal(a, n);
	 }  
	 
	public boolean kruskal(LinkedList<Edge> a, int n){
		Edge[] res = new Edge[n];     //��������ͨ�ı�
		int[] u = new int[n+1];       //u[i]=x ��ʾ����i���ڼ���x
		for(int i=1; i<=n; i++)       //��ʼ��ÿ��������������=�ö�����
			u[i]=i;			 

		int i = 0;
		while(i<n-1){                 //n���������С����������๲n-1���� 
			Edge x = a.peek(); 
			if(u[x.u]!=u[x.v]){       //�Ƚϱߵ����Ҷ�����������
				res[i++] = x;
				u[x.v]=u[x.u];        //��v����u�ļ���
			}
			a.pop();
		}
		for(int j=0; j<i; j++)
			System.out.println(res[j].u + "-" + res[j].v + ": Ȩֵ=" + res[j].w);
		return (i==n-1);              //return �Ƿ���������С������
	}  
	
}