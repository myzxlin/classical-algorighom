package DivideAndConquer;

/** 
 * RoundRobinSchedule [ѭ�����ճ̱�] ��n = 2^k���˶�ԱҪ��������ѭ���������̱����㣺
 * ÿ��ѡ�ֱ���������n-1��ѡ�ָ���һ�Σ�ÿ��ѡ��һ��ֻ�ܲ���һ�Σ�ѭ������n-1���ڽ���
 * 
 * describe: a[i][j]��ʾ��i��ѡ���ڵ�j����������ѡ��
 * ����˼�룺�������������Ϊ4�飬�ݹ�ִ������1����������4������2����������3 
 * 1 2 | 3 4 
 * 2 1 | 4 3 
 * ��������|��������
 * 3 4 | 1 2 
 * 4 3 | 2 1  
 */
public class RoundRobinSchedule {

	public static void main(String[] args) { 
		RoundRobinSchedule r = new RoundRobinSchedule();
		int k = 3;                       //2^k���˶�Ա
		int[][] a = r.table(k);
        for(int i=0; i<a.length; i++){
            for(int j = 0;j<a[0].length;j++)
                System.out.print(a[i][j] + " ");
            System.out.println();
        }
	}
	public int[][] table(int k){
	    int n = (int)Math.pow(2,k);
	    int[][] t = new int[n][n];	   
	    for (int i=0; i<n; i++)
	    	t[0][i] = i+1;                  //��ʼ����һ��    
	    for (int i=1; i<n; i*=2) {          //�����Ͻǿ�ʼ���䣬��2Ϊ������ɢ
	        for(int j=0; j<n; j+=2*i){
	            copy(t, i, i+j, 0, j, i);
	            copy(t, i, j, 0 ,i+j, i);
	        }
	    }
	    return t;
	}
	    
	void copy(int[][] a, int tox, int toy, int fromx, int fromy, int range){
	    for(int i=0; i<range; i++){
	        for(int j=0; j<range; j++)
	            a[tox+i][toy+j] = a[fromx+i][fromy+j];	            
	    }	        
	}
}
