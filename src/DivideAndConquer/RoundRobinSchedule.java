package DivideAndConquer;

/** 
 * RoundRobinSchedule [循环赛日程表] 有n = 2^k个运动员要进行网球循环赛，赛程表满足：
 * 每个选手必须与其他n-1个选手各赛一次；每个选手一天只能参赛一次；循环赛在n-1天内结束
 * 
 * describe: a[i][j]表示第i个选手在第j天所遇到的选手
 * 分治思想：将所有区域均分为4块，递归执行区域1拷贝到区域4，区域2拷贝到区域3 
 * 1 2 | 3 4 
 * 2 1 | 4 3 
 * ————|————
 * 3 4 | 1 2 
 * 4 3 | 2 1  
 */
public class RoundRobinSchedule {

	public static void main(String[] args) { 
		RoundRobinSchedule r = new RoundRobinSchedule();
		int k = 3;                       //2^k个运动员
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
	    	t[0][i] = i+1;                  //初始化第一行    
	    for (int i=1; i<n; i*=2) {          //从左上角开始辐射，以2为倍数扩散
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
