package BackTrack;  
import java.util.*; 

/**
 *Queen8 [八皇后] 8X8的棋盘上, 八位皇后不得在同行同列同斜线上，问有几种摆放方案
 *describe:回溯
 **/ 
public class Queen8 { 
	
	public static void main(String[] args) { 
		Queen8 q = new Queen8();  
		System.out.print("7皇后共有" + q.queen(8).size() + "种解法\n");
		System.out.print("8皇后共有" + q.queen2(8) + "种解法\n");
	}
	
	public List<int[]> queen(int n){ 
		List<int[]> res = new ArrayList<>();
		dfs(n, 1, new int[n+1], res);   //从第一个皇后开始
		return res;
	}
	void dfs(int n, int k, int[] item, List<int[]> res){
	    if(k>n){  
	    	int[] now = new int[item.length];
	    	for(int i=0; i<now.length; i++)
	    		now[i]=item[i];
	    	res.add(now);	    	
	    	return;
	    }
	    for(int i=1; i<=n; i++){
	        item[k]=i;
	        if (check(item,k))          //剪枝
	        	dfs(n, k+1, item, res);    
	    } 
	}
	
	boolean check (int a[], int n){     //检查该皇后与之前的皇后有无位置冲突
	    for(int i=1; i<=n-1; i++){
	        if((Math.abs(a[i]-a[n])==n-i)||(a[i]==a[n]))  
	            return false;
	    }      
	    return true;
	}
	
	/*非递归回溯*/
	public int queen2(int n){  	
		int count = 0;  
	    int[] a = new int[n+1]; 
	    int k = 1;   
	    a[1] = 0; 
	    while(k>0){
	        a[k]++;            //对应for循环的1~n
	        while((a[k]<=n)&&(!check(a,k))) //搜索第k个皇后位置
	            a[k]++;   
	        if(a[k]<=n)        //找到了合理的位置
	            if(k==n)       //找到一组解
	                count++;           
	            else{
	                k++;       //继续为第k+1个皇后找到位置，对应下一级for循环 
	                a[k]=0;    //下一个皇后一定要从头开始搜索
	            }
	        else
	            k--;           //回溯    
	      }
	    return count;
	} 

}
