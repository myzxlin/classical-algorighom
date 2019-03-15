package BackTrack;

/** 
 * ContinuousPostage [连续邮资问题] 
 * 有m种不同面值的邮票，每张信封最多贴n张，求从邮资1开始,增量为1的最大连续邮资区间。
 * 例：m=5, n=4, arr=(1,3,11,15,32), 输出70
 * 
 * describe:回溯
 * 有一个难点：最多可以贴n张邮票，究竟贴多少张是不固定的，但我们可以构造面值是0的邮票，
 * 差几张就加几张面值为0的票，目的是让贴的邮票数量成为一个定值，便于解答.
 * 既然是回溯解决，自然想t代表什么。一般来说，t要么代表邮票数量，要么代表增长的区间的值，
 * 但区间最大值究竟是多少是不知道的，无法写终止条件;
 * 贴邮票的数量已经通过面值0的邮票这一手段使它变成一个定值，t就只能代表邮票数量了。
 */
public class ContinuousPostage {
	
	int max = 0;                              //连续区间最大值   
	boolean flag;
	
	public static void main(String[] args) { 
		ContinuousPostage c = new ContinuousPostage();
		int[] a = new int[]{0,1,3,11,15,32};  //添加面值为0的邮票  
		int m = 4;                            //最多贴m张邮票 
		System.out.print("最大连续邮资区间：" + c.postage(a, m));
	}
	public int postage(int[] a, int m){
		int n = a.length;
	    while(true){                          //不断循环确定最大值 
	        flag = false;
	        dfs(a, m, 0, 0);      
	        if(flag)         
	        	max++;
	        else
	            break;                        //连续区间断开时，搜索结束
	    }   
	    return max;  
	} 
	/**
	 * @param a   邮票面值
	 * @param m   最大张数
	 * @param t   当前邮票张数
	 * @param cur 当前邮票面值
	 */ 
	void dfs(int[] a, int m, int t, int cur){		
		int n = a.length;
	    if(t==m){    	
	        if(cur==max+1)                   //确保增量为1
	        	flag = true;          
	        return;
	    }   
	    for(int i=0; i<n; i++){ 
	        if(cur<=max+1)                   //剪枝
	            dfs(a, m, t+1, cur+a[i]);    //勿直接改变cur 
	    }   
	}
}
