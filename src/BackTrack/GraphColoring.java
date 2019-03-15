package BackTrack;
import java.util.*;

/**GraphColoring [GCP ͼ����ɫ����] NP��ȫ����
 * Ϊһ��������ͨͼ�Ķ�����ɫ��ʹÿ����������ɫ��ͬ��������������ɫ��m ��������ɫ����
 * 
 * ˼·��ͨ�����ݵķ���������Ϊÿһ���ڵ���ɫ����ǰ��n-1���ڵ㶼�Ϸ�����ɫ֮�󣬿�ʼ�Ե�n���ڵ������ɫ��
 * ��ʱ��ö�ٿ��õ�m����ɫ��ͨ���͵�n���ڵ����ڵĽڵ����ɫ�����ж������ɫ�Ƿ�Ϸ���
 * ����ҵ���ôһ����ɫʹ�õ�n���ڵ��ܹ���ɫ����ô˵��m����ɫ�ķ����ǿ��еġ�
 */
public class GraphColoring { 
	 
	 public static void main(String[] args) {
		 GraphColoring g = new GraphColoring(); 	     
	     int[][] a = {
	    		 {-1,-1,-1,-1,-1,-1},
	    		 {-1, 0, 1, 1, 1, 0},
	    		 {-1, 1, 0, 1, 1, 1},
	    		 {-1, 1, 1, 0, 1, 0},
	    		 {-1, 1, 1, 1, 0, 1},
	    		 {-1, 0, 1, 0, 1, 0}
	    };
	    int m = 5;
	    List<int[]> res = g.coloring(a, m);
	    System.out.println("������ɫ������" + res.size() + "��");
	    System.out.println("��ɫ�������£�");
	    for(int[] i:res)
	    	System.out.println(Arrays.toString(i));   
	 }
	 
	 public List<int[]> coloring(int[][] a, int m){
		 List<int[]> res = new ArrayList<>(); 
	     dfs(a, m, 1, new int[a.length], res);
	     return res;
	 }
	 
	 /** 
	  * @param a   ͼ���ڽӾ���
	  * @param m   ��ɫ��
	  * @param t   ��ǰ�ڵ�
	  * @param cur ��ǰ��
	  * @param res ȫ����
	  */
	public void dfs(int[][] a, int m, int t, int[] cur, List<int[]> res){
		int n = a.length-1;
	    if(t>n){
	    	int[] now = new int[n+1]; 
	        for(int i=0; i<=n; i++)
	            now[i] = cur[i];
	        res.add(now); 
	        return;
	    }
	    for(int i=1; i<=m; i++){                  //���γ������е���ɫ
	    	cur[t] = i;                           //������ɫ,i��ʾ��ɫ
	    	boolean flag = true;
	    	for(int j=1; j<a.length; j++){
		        if(a[t][j]==1 && cur[t]==cur[j])  //������ڱ��Ƿ���ɫ��ͬ 
		            flag = false;
		    }
	        if(flag)                              //��֦ 
	        	dfs(a, m, t+1, cur, res);
	        cur[t] = 0;                           //����
	    }
	}

}
