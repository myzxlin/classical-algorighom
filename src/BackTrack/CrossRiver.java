package BackTrack;
import java.util.*;

/**5X5的地图上，一只青蛙欲从起点到终点，图中有一条河，问有几种方案，并给出路径最短的方案 
 * describe:回溯
 */
public class CrossRiver { 
	
	int count = 0;     //方案数
	int path = 0;      //步数
	int min = 25;      //最小步数
	
	public static void main(String[] args) {
		CrossRiver f = new CrossRiver(); 
		int a[][]= new int[][] {
			{0,0,0,0,0},
			{0,0,0,0,0},
			{1,1,0,1,1},
			{0,0,0,0,0},
			{0,0,0,0,0}   //1表示河水，0表示陆地
		}; 
		f.jump(a, 0, 0);
		System.out.println("方案数："+f.count);
		System.out.println("最短路径长度：" + (f.min-1));  
		f.count=0;
		f.jumpMin(a, 0,0);
	}

	public void jump(int[][] a, int m, int n) {
		if(m<0||m>=5 || n<0||n>=5 || a[m][n]==1)  
			return;
		a[m][n]=1;
		path++;
		if(m==4 && n==4) {
			count++;
			min=Math.min(min, path);
		}
		jump(a, m+1,n);
		jump(a, m-1,n);
		jump(a, m,n+1);
		jump(a, m,n-1);
		path--;               //回溯 
		a[m][n]=0;		
	}
	
	void jumpMin(int[][]a, int m, int n) { 
		if(m<0||m>=5 || n<0||n>=5 || a[m][n]==1)  
			return;
		a[m][n]=1;
		path++;
		if(m==4 && n==4 && path==min) { 
			count++;
			System.out.print("----方案 "+count+"-----\n");
			for(int[] i:a)
				System.out.print(Arrays.toString(i)+"\n"); 
		}
		jumpMin(a, m+1,n);
		jumpMin(a, m-1,n);
		jumpMin(a, m,n+1);
		jumpMin(a, m,n-1);
		path--;         
		a[m][n]=0;		
	}
	
}
