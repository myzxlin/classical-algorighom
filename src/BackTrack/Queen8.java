package BackTrack;  
import java.util.*; 

/**
 *Queen8 [�˻ʺ�] 8X8��������, ��λ�ʺ󲻵���ͬ��ͬ��ͬб���ϣ����м��ְڷŷ���
 *describe:����
 **/ 
public class Queen8 { 
	
	public static void main(String[] args) { 
		Queen8 q = new Queen8();  
		System.out.print("7�ʺ���" + q.queen(8).size() + "�ֽⷨ\n");
		System.out.print("8�ʺ���" + q.queen2(8) + "�ֽⷨ\n");
	}
	
	public List<int[]> queen(int n){ 
		List<int[]> res = new ArrayList<>();
		dfs(n, 1, new int[n+1], res);   //�ӵ�һ���ʺ�ʼ
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
	        if (check(item,k))          //��֦
	        	dfs(n, k+1, item, res);    
	    } 
	}
	
	boolean check (int a[], int n){     //���ûʺ���֮ǰ�Ļʺ�����λ�ó�ͻ
	    for(int i=1; i<=n-1; i++){
	        if((Math.abs(a[i]-a[n])==n-i)||(a[i]==a[n]))  
	            return false;
	    }      
	    return true;
	}
	
	/*�ǵݹ����*/
	public int queen2(int n){  	
		int count = 0;  
	    int[] a = new int[n+1]; 
	    int k = 1;   
	    a[1] = 0; 
	    while(k>0){
	        a[k]++;            //��Ӧforѭ����1~n
	        while((a[k]<=n)&&(!check(a,k))) //������k���ʺ�λ��
	            a[k]++;   
	        if(a[k]<=n)        //�ҵ��˺����λ��
	            if(k==n)       //�ҵ�һ���
	                count++;           
	            else{
	                k++;       //����Ϊ��k+1���ʺ��ҵ�λ�ã���Ӧ��һ��forѭ�� 
	                a[k]=0;    //��һ���ʺ�һ��Ҫ��ͷ��ʼ����
	            }
	        else
	            k--;           //����    
	      }
	    return count;
	} 

}
