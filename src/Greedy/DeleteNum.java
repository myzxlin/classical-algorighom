package Greedy;

/** 
 * DeleteNum [删数字游戏] 输入正整数m, 去掉其中任意k个数字后使得剩下的数最小, 
 * 如：m=5027539, k=3, 输出239(若比0更高位上无数字，则去掉0)   
 * 
 * 方案1：每一步总是选择一个使剩下的数最小的数字删除(贪心)，
 * 即按高位到低位的顺序搜索，若各位数字递增，则删除末尾数；
 * 否则删除第一个逆序对(递减区间)的首字符，然后回到串首，按上述规则递推
 * 
 * 方案2： 所得数的首位数必定出现在m[0]-m[k]范围内，否则位数不够，
 * 则在这个范围内寻找最小数作为结果首元素，然后递推
 */
public class DeleteNum {

	public static void main(String[] args) { 
		DeleteNum d = new DeleteNum();
		int m = 50267539;
		int k = 4;
		System.out.print(d.func1(m, k) +"\n");
		System.out.print(d.func2(m, k) +"\n"); 
	}
	/*方案一*/
	public String func1(int m, int k) {
		String s = String.valueOf(m);
		int n = s.length(); 
		while(s.length()>n-k) { 
			for(int i=1; i<s.length(); i++) {
				if(s.charAt(i)>=s.charAt(i-1))
					continue;
				if(i==s.length()-1) {  //到末元素了
					s = s.substring(0, i)+s.substring(i+1, s.length()); 
					break;
				}					
				s = s.substring(0, i-1)+s.substring(i, s.length());
			}
		}
		while(s.charAt(0)=='0')
			s=s.substring(1, s.length());   //去除首0
		return s;
	} 
	
	/*方案二 略愚蠢*/
	public String func2(int m, int k) {
		String s = String.valueOf(m);
		String res = "";
		int start = 0;
		int end = k; 
		while(res.length()<s.length()-k && end<s.length()) {
			int min = s.charAt(start)-'0';
			int flag = start;
			for(int i=start; i<=end; i++) {
				if(s.charAt(i)-'0'<min) {
					min = s.charAt(i)-'0';
					flag = i; 
				}					
			}
			res += s.charAt(flag);
			k -= flag-start;
			start = flag+1;		
			end = start+k; 
		}
		while(res.charAt(0)=='0')
			res=res.substring(1, res.length());   //去除首0
		return res;
	}

}
