package Greedy;

/** 
 * CoinChange [硬币找零] 假设1元,2元,5元,10元,20元,50元,100元的纸币分别有
 * c0, c1, c2, c3, c4, c5, c6张, 用这些钱来支付K元，至少要用多少张纸币？ 
 * describe: 贪心策略, 每一步尽可能用面值大的纸币即可
 */
public class CoinChange {

	 public static void main(String[] args) {
		 CoinChange x = new CoinChange();
		 int[] v = {1, 2, 5, 10, 20, 50, 100};  //价值
	     int[] c = {3, 1, 2, 1, 1, 3, 5};       //张数
	     int k = 212;
	     int[] num = x.change(k, v, c); 
	     
	     System.out.println("支付" + k + "元的策略为：");
	     for(int i=0; i<v.length; i++) 
	    	 if(num[i]!=0) 
	    		 System.out.println(v[i] + "元：" + num[i] + "张");	            	       
	 }

	 public int[] change(int k, int[] v, int[] c){
	     int[] res = new int[v.length];
	     for(int i=v.length-1; i>=0; i--){          //从最大面值开始拿       
	    	 res[i] = Math.min(k/v[i], c[i]);  //需要该面值人民币张数	        
	         k -= res[i]*v[i];                      //剩下的钱数	    
	     }
	     return res;
	 }

}
