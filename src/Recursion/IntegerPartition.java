package Recursion;

/** 
 * IntegerPartition [��������] ��������n��ʾ��һϵ��������֮�ͣ����ж����ֻ��ַ���������
 * ������Ϊ 5 ʱ���� 1 �ֻ��֣� 5
 * ������Ϊ 4 ʱ���� 1 �ֻ��֣� 4+1
 * ������Ϊ 3 ʱ���� 2 �ֻ��֣� 3+2, 3+1+1
 * ������Ϊ 2 ʱ���� 3 �ֻ��֣� 2+2+1, 2+1+1+1
 * ������Ϊ 1 ʱ���� 1 �ֻ��֣� 1+1+1+1+1
 * describe: �ݹ�   
 */
public class IntegerPartition {

	public static void main(String[] args) { 
		IntegerPartition i = new IntegerPartition();
		System.out.print(i.find(8, 8));
	}
	//m��n����
	int find(int m, int n) {
		if(m==1 || n==1)
			return 1; 
		if(m==n)
			return find(m,m-1)+1;
		if(m<n)
			return find(m,m);		
		return find(m,n-1)+find(m-n,n);
	}
}
