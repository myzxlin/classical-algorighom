package DynamicProgramming;

/** 
 * JumpBox [������] ���������������ʱ���������Զ���ʴ�0�����ܷ������յ�
 * �磺[1,2,3,0,6] ����true [1,1,0,1]����false
 * ����������10000 < arr.length <= Integer.max  (����ܳ���ע�⸴�Ӷ� �ٱ���)
 * describe:  
 */
public class JumpBox {

	public static void main(String[] args) { 
		JumpBox j = new JumpBox();
		Boolean ans1 = j.jump2(new int[] {1,2,3,0,2}); 
		Boolean ans2 = j.jump2(new int[] {1,3,0,1,0,2});
	}
	//��̬�滮
	public boolean jump(int[] arr) {
		int[] dp = new int[arr.length];   
		dp[0] = arr[0]>0 ? 1:0; 
		for(int i=1; i<arr.length; i++) {
			for(int j=0; j<i; j++)
				if(dp[j]+arr[j]>i-j) {
					dp[i]=1;	
					break;
				} 
		}
		return dp[arr.length-1]>0? true:false;
	}
	 
	//�Ż�  ����һ�α���
	public boolean jump2(int[] a) {
		int max = 1;              //�ڱ���¼�����
		for(int i=0; i<a.length; i++) {
			if(a[i]==0 && max-1==0)
				return false;
			max = Math.max(max-1, a[i]); 
			if(max>=a.length-i-1)
				return true;
		}
		return false;
	} 
}
