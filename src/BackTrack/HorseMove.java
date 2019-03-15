package BackTrack;
import java.text.*;
import java.util.*;

/**HorseMove [������] 5x5�������������Ӵ�(0,0)��ʼ������Ҫ�����и��Ӳ��ظ�����һ��  
 * describe: �ݹ����
 **/ 
public class HorseMove {

	public static void main(String[] args) {
		HorseMove h = new HorseMove();
		List<int[][]> res = h.horse();
		System.out.print("�ܹ���" + res.size() + "���\n");
		System.out.print("����һ������£�\n");
		DecimalFormat f = new DecimalFormat("00");
		for(int i=0; i<5; i++) {
			for(int j=0; j<5; j++) 				
				System.out.print(f.format(res.get(0)[i][j]) + " ");			
			System.out.print("\n");
		}
	}
	public List<int[][]> horse(){
		List<int[][]> res = new ArrayList<int[][]>();
		dfs(0,0,1,new int[5][5], res);	
		return res;
	}
	void dfs(int m, int n, int path, int[][] item, List<int[][]> res) {	
		if(m<0||m>=5 || n<0||n>=5 || item[m][n]!=0)
			return;  		
		if(path==25) {
			int[][] now = new int[5][5];
			for(int i=0; i<5; i++)
				for(int j=0; j<5; j++)
					now[i][j]=item[i][j];
			res.add(now);
		}
		item[m][n] = path;
		dfs(m+2, n-1, path+1, item, res);
		dfs(m+2, n+1, path+1, item, res);
		dfs(m+1, n+2, path+1, item, res);
		dfs(m+1, n-2, path+1, item, res);
		dfs(m-1, n-2, path+1, item, res);
		dfs(m-1, n+2, path+1, item, res);
		dfs(m-2, n+1, path+1, item, res);
		dfs(m-2, n-1, path+1, item, res);
		item[m][n] = 0;            //����		
	}
}
