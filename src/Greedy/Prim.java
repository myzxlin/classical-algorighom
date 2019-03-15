package Greedy;

/** 
 * Prim [����ķ�㷨] ����С������ 
 * describe: ̰�Ĳ��� 
 * ������ֳɼ���S��V����ʼS����ֻ��������1��Ȼ���ҳ�V�����о���S���Ͼ�����̵Ķ���(̰��)��
 * dist[] ���涥�㵽����S�ľ���, dist[2]=x ��ʾ����2���뼯��S����̾�����x;
 * prev[] ��¼·��, prev[2]=y ��ʾ����2���뼯��S������Ķ�����y;
 * s[] ���ö������S���� 
 */
public class Prim {
	
	static float m = Float.MAX_VALUE;           //max��ʾ����Զ
	
	public static void main(String[] args){
		Prim p = new Prim();
		float [][] a = {
				{ m, m, m, m, m, m, m },
				{ m, m, 6, 1, 5, m, m },
	            { m, 6, m, 5, m, 3, m },
	            { m, 1, 5, m, 5, 6, 4 },
	            { m, 5, m, 5, m, m, 2 },
	            { m, m, 3, 6, m, m, 6 },
	            { m, m, m, 4, 2, 6, m }
	    };
	    p.prim(6,a);
	 }  
	
    public void prim(int n, float [][] a){
        float[] dist = new float[n+1];
        int[] prev = new int[n+1];
        boolean[] s = new boolean[n+1];
 
        s[1]=true;        
        for(int i=2; i<=n; i++){             //��ʼ��
        	dist[i] = a[1][i]; 
        	prev[i] = 1;
            s[i] = false;
        }
        for(int i=1; i<n; i++){              //�����ҳ�ʣ��n-1���ڵ�
            float temp = m;
            int u = 1;         
            for(int j=2; j<=n; j++){         //����s��������Ľڵ�
                if((!s[j]) && (dist[j]<temp)){
                	u = j;
                	temp = dist[j];                  
                }
            }
            System.out.println("�ҵ��� " + u + "-" + prev[u]);
            s[u] = true;                     //��u����s����     
            for(int j=2; j<=n; j++){         //����dist[], prev[] 
                if((!s[j]) && (a[u][j]<dist[j])){
                	dist[j] = a[u][j];       //��¼Ȩֵ
                	prev[j] = u;             //��¼�ڵ�
                }
            }
        }
    }  

}
