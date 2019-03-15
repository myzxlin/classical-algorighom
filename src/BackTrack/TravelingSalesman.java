package BackTrack;
import java.util.*;

/** 
 * TravelingSalesman [TSP ����������] NP��ȫ����
 * �����̴�ĳ���г������ظ��ؾ���������ÿһ�����У����ص�ԭ�㣬��·����̵���·
 * ������ͼ��Ȩֵ֮����С�Ļ�·
 *
 * describe: ����   
 */
public class TravelingSalesman {
  
	  int min = Integer.MAX_VALUE;        //��С·������ 
	  
	  public static void main(String[] args) {
		  TravelingSalesman t = new TravelingSalesman();
		  int d[][] = {
				  { 0, 13, 8, 9 },
			      { 13, 0, 3, 15 },
			      { 8, 3, 0, 20 },
			      { 9, 15, 20, 0 }    
		  };  
		  System.out.print(Arrays.toString(t.tsp(d))); 		  
	  }
	public int[] tsp(int[][] d){
		int res[] = new int[d.length];
		dfs(d, 1, 0, new int[d.length], res);
		return res;
	}
	/** 
	 * @param d     �ڵ��ľ���
	 * @param k     ��ǰ�ڵ�
	 * @param cur   ��ǰ·������
	 * @param x     ��ǰ·�� 
	 * @param bestX ���·��
	 */
	void dfs(int[][] d, int k, int cur, int[] x, int[] res){
		int n = d.length;
	    if(k==n-1){                                       //�ߵ�Ҷ�ӽڵ�
	        for(int j=1; j<=n; j++){ 
	        	x[k] = j%n;
	        	int len = cur+d[x[k-1]][x[k]]+d[x[k]][0]; //+�ص�ԭ���·��
	            if(check(k,x) && len<min) {	            	
	            	min = len; 
	                for(int i=0; i<n; i++) 
	                	res[i] = x[i];	                  //����res         
	            }
	        }
	        return;
	    }
	    for(int j=1; j<=n; j++){
	    	x[k] = j%n;                           
	        if(check(k,x) && cur+d[x[k-1]][x[k]]<=min) 
	            dfs(d, k+1, cur+d[x[k-1]][x[k]], x, res); //����ֱ�Ӹı�cur	            
	    }
	}
	
	//�жϵ�k�����Ƿ���ʹ� 
	boolean check(int k, int[] x){
		for(int i=0; i<k; i++) {
			if(x[k]==x[i])
	            return false;
		}
		return true; 
	}
	   	  
}
