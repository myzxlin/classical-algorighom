package DynamicProgramming;
import java.util.Arrays;

/** 
 * TravelingSalesman [TSP ����������] NP��ȫ����
 * �����̴�ĳ���г������ظ��ؾ���������ÿһ�����У����ص�ԭ�㣬��·����̵���·
 * ������ͼ��Ȩֵ֮����С�Ļ�·
 * 
 * describe: ��̬�滮  
 * ÿ���ڵ���һ����Ԫ��(i,S),i��ʾ��ǰ·�����һ����,S��һ������,��ʾ·���ϵĵ㼯.
 * ÿ��״̬(i,S)������ǰ��(j,S'),һ������:j��S��S=S'+{i}
 * ���Ʒ���Ϊ:dp(i,S)= min[dp(j,S-{i})+cost(i,j)] , j��S��j��i
 * ��, ��i����̾��� = ��j����̾���,����j��i����̾��� 
 * ����S�ھ���ʵ����Ҫӳ�䵽һ������,�����ö����ƴ���״̬ѹ��.
 * һ�������ƴ��ĵ�iλ�ͱ�ʾ��i�����Ƿ���S��,1��ʾ��,0��ʾ����.
 * ʱ�临�Ӷ� o(n^2*2^n) �ռ临�Ӷ���O(n*2^n). 
 */
public class TravelingSalesman {
	
	int max = Integer.MAX_VALUE;
	
	public static void main(String[] args){
		TravelingSalesman t = new TravelingSalesman(); 
		int[][] d = new int[][] {      
			{0, 1, 2, 3},
			{1, 0, 3, 2},
			{2, 3, 0, 1},
			{3, 2, 1, 0}               //d[i][j]=x ��ʾ����i��j֮�����Ϊx
		};  
		System.out.print("���·�̣�" + t.tsp(d));  
	}  
	
	public int tsp(int[][] d) {
		int n = d.length;              //������Ŀ
		int h = (int)Math.pow(2, n-1);
		int min = 0;                   //�ܾ���
		int path[];                    //���·��������������  
		int[][] dp = new int[n][h];    //�׶����·�� 
		int[][] s = new int[n][h];     //�׶����Ų��� 	
		int cur = max;  
		int mink = 0;
				
		for(int i=0; i<n; i++)         //��ʼ��
			dp[i][0]=d[i][0];		
		for(int i=1; i<h; i++){
			for(int j=1; j<n; j++){
				if(judge(i,j,n)==1)    //��j��i����ļ�����ʱ,����
					continue;
				int k=0;
				String a = binary(i,n-1);
				for(int w=a.length(); w>0; w--) {
					k = a.charAt(a.length()-w)-48;  //kΪ0����1
					if(k==1) {
						k=k*w;                      //��ʱ��kΪѡ��ļ����е�ĳ��ֵ
						int y=(d[j][k]+dp[k][(int)(i-Math.pow(2, k-1))]);
						if(y<cur) {
							cur=(d[j][k]+dp[k][(int)(i-Math.pow(2, k-1))]);
							mink=k;
						}
					}
				}
				if(cur<max) {      
					dp[j][i] = cur;
					s[j][i] = mink;
					cur = max;
				}
			}
		}
		cur=max; 
		int i = (int)(Math.pow(2, n-1)-1);     //�������һ��
		for(int k=n-1; k>0; k--) {
			int x = (d[0][k]+dp[k][(int)(i-Math.pow(2, k-1))]);
			if(x<cur) {
				cur=x;
				mink=k;
			}
		}
		dp[0][i]=cur;
		s[0][i]=mink;
		path=new int[n+1];
		path[0]=1;
		int c=1;
		for(int j=0;i>0;) {
			j=s[j][i];
			i=(int)(i-Math.pow(2, j-1));
			path[c++]=j+1;
		}
		path[c++]=1;
		
		System.out.println("���·����"+Arrays.toString(path));
		for(i=0; i<n; i++) 
			min += d[path[i]-1][path[i+1]-1]; 
		return min;
	}
	
	//�ж�j�Ƿ���i��ʾ�ļ�����
	public int judge(int i, int j, int n) {
		String a = binary(i,n-1);
		int b = a.charAt(a.length()-j)-48;
		System.out.println("i="+i+" j="+j+" b="+b+"\n");
		return b;      //b=0���� b=1��
	}
	
	//��ʮ������mת��Ϊnλ���Ķ������ַ���
	public String binary(int m ,int n) {
        String str = "";
        for(int i=n-1; i>=0; i--)  
        	str +=(m>>i)&1; 
        return str;
    }
}