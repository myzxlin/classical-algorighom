package BackTrack;

/**
 * Debrujin [德布鲁金环/相异数字序列] 对于整数n，找出长度为2^n的序列(找最小的)，
 * 使得将序列连成环状后，依次取长为n的串时，得到的2^n个长为n的0-1串，分别代表不同的十进制数.
 * 例：n=2, 输出0011, 因为00,01,11,10 分别代表0,1,3,2, 它们是相异的
 * 
 * describ：非递归回溯
 * n阶德布鲁序列共2^n位，待确定n=2^n-n-2位，当中应当有n/2-n个0，n/2-2个1，且没有重复的n位二进制序列。
 * 设置数组a[N]保存，回溯法探求a[n+1,N-2]，取值为0、1
 * 元素初值a[0,n-1] = 0, a[n] = 1,a[N-1] = 1, a[i=n+1] = 0
 * 取值点：a[i] = 0
 * 回溯点：a[i] = 1
 * 约束条件1：i == N-2，且 a[n+1,N-2]有N/2-n个0
 * 约束条件2：没有重复的n位二进制序列
 **/
public class Debrujin {
	
	public static void main(String[] args) { 
		Debrujin x = new Debrujin();
		System.out.print(x.debrujin(3)); 
	}
	
	public String debrujin(int n){
		int j, k, g;
		int c = 0;     //1的个数，预计有n/2-2个
		int i = n+1;
		int s = 0;
		int len = 1<<n;            //即2^n         
		int[] d = new int[len];
		int[] dd = new int[len];   //标记2^n个二进制序列是否已经出现过，出现过为1,否则为0
		int gvp = 0;   
		String ans = String.valueOf(Integer.toBinaryString(1<<len));  	
		if(n<1)
			return "";
		if(n==1)
			return "0";
		if(n==2)
			return "0011";

		d[n] = 1;           //前0 ~ n-1位均为0
		d[len-1] = 1;       //最后一位为0
		//比如还未到最后一位，但是1的个数已经超过预定数目
		//或剩余位置不可能放下还需要的1的个数
		while(true){	
			g = 1;	
			c = 0;
			for(j=n+1; j<=i; ++j){
				if(d[j]==1)
					++c;
		} 		
		if(c>len/2-2 ||(len-2-i<len/2-2-c)) //1的个数大于规定，或0的个数大于规定
			g = 0;
		++gvp;
		if(g==1 && i==len-2){               //进一步判断是否可行 标志位
			for(j = 0; j < len; ++j)
				dd[j] = 0;
			for(j = 0; j < len; ++j){  		//计算d[j]d[j+1]...d[j+n-1]
				for(c = 0,k = j; k < j+n; ++k)
					c += (d[k>=len?k-len:k]<<(n-1-(k-j)));		
				if(dd[c]==1){
					c = -1;
					break;
				}else
					dd[c] = 1;
			}
			String now = "";
			if(c >= 0){
				++s;
				for(j = 0; j < len; ++j)
					now += String.valueOf(d[j]);
				ans = min(now, ans); 
			}
		}
		if(g==1 && i<len-2){
			++i;
			d[i] = 0; 
		}
		while(d[i]==1 && i>n) 
			i--; 
			if(i<n+1)
				break;
			else
				++d[i];//前向搜索，统计1的个数：修改1个数计数器
		} 
		return String.valueOf(ans);
	}
	
	//返回两个二进制字符串中数值较小的那个
	String min(String s1, String s2) {
		int m = Integer.parseInt(s1);
		int n = Integer.parseInt(s2);
		return m<n? s1:s2;
	}
}
