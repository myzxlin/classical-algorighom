package DynamicProgramming;
import java.util.*;

/** 
 * MultiGraph [���ͼ����] һ����Ȩ����ͼ�����Դ�㵽�յ�����·��
 * 
 * describe: ��̬�滮  
 * �ӵ�һ���㿪ʼ�����ν�ÿ������Ϊ�յ㣬���㵱ǰdpֵ��dֵ;
 * ֱ�������н�㶼������ϣ����ɵõ����·����
 */
public class MultiGraph {

	public static int m = Integer.MAX_VALUE;   //max��ʾ����Զ

    public static void main(String[] args){
    	MultiGraph t = new MultiGraph();
        int[][] a = {                            //a[i][j]��ʾ��<i,j>��Ȩֵ
                { 0, 5, 4, 6, m, m, m, m },     
                { 5, 0, m, m, 8, 7, m, m },
                { 4, m, 0, m, 7, 9, 8, m },
                { 6, m, m, 0, 9, 7, 6, m },
                { m, 8, 7, 9, 0, m, m, 3 }, 
                { m, 7, 9, 7, m, 0, m, 3 },
                { m, m, 8, 6, m, m, 0, 4 },
                { m, m, m, m, 3, 3, 4, 0 }
        };
        System.out.print("���·�̣�" + t.multiGraph(a));
    }
    
    public int multiGraph(int[][] a) {
    	List<Integer> path = new ArrayList<>();  //���·��
    	int n = a.length;
    	int[] dp = new int[n];                   //dp[i]=x:���iΪ�յ�ʱ���·��Ϊx
    	int[] d = new int[n];                    //d[i]=j:���i��ǰ�����Ϊj 
	    Arrays.fill(dp,m);	                     //��ʼ��Ϊ����Զ	    
	    dp[0] = 0;
	    d[0] = 0;	    
	    for(int i=1; i<n; i++){
	    	int cur = m;                         //Ѱ��ǰ���ڵ�
	        for(int j=0; j<i; j++){              //���������ڽӵ�
	        	if(a[i][j]==m)
	        		continue;
	            if(dp[i]>dp[j]+a[j][i]){
	            	dp[i] = dp[j]+a[j][i];
	                cur = j; 	                 
	            }
	        }
	        d[i] = cur;
	    } 
	    for(int i=n-1; i>0;) {
	    	 path.add(d[i]);
	    	 i=d[i];
	    }	    
	    Collections.reverse(path);               //�������
	    path.add(n);                             //�����յ�
	    System.out.print("���·����" + path + "\n");
	    return dp[n-1];
	}

}