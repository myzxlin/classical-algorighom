package BackTrack;

/** 
 * ContinuousPostage [������������] 
 * ��m�ֲ�ͬ��ֵ����Ʊ��ÿ���ŷ������n�ţ��������1��ʼ,����Ϊ1����������������䡣
 * ����m=5, n=4, arr=(1,3,11,15,32), ���70
 * 
 * describe:����
 * ��һ���ѵ㣺��������n����Ʊ���������������ǲ��̶��ģ������ǿ��Թ�����ֵ��0����Ʊ��
 * ��žͼӼ�����ֵΪ0��Ʊ��Ŀ������������Ʊ������Ϊһ����ֵ�����ڽ��.
 * ��Ȼ�ǻ��ݽ������Ȼ��t����ʲô��һ����˵��tҪô������Ʊ������Ҫô���������������ֵ��
 * ���������ֵ�����Ƕ����ǲ�֪���ģ��޷�д��ֹ����;
 * ����Ʊ�������Ѿ�ͨ����ֵ0����Ʊ��һ�ֶ�ʹ�����һ����ֵ��t��ֻ�ܴ�����Ʊ�����ˡ�
 */
public class ContinuousPostage {
	
	int max = 0;                              //�����������ֵ   
	boolean flag;
	
	public static void main(String[] args) { 
		ContinuousPostage c = new ContinuousPostage();
		int[] a = new int[]{0,1,3,11,15,32};  //�����ֵΪ0����Ʊ  
		int m = 4;                            //�����m����Ʊ 
		System.out.print("��������������䣺" + c.postage(a, m));
	}
	public int postage(int[] a, int m){
		int n = a.length;
	    while(true){                          //����ѭ��ȷ�����ֵ 
	        flag = false;
	        dfs(a, m, 0, 0);      
	        if(flag)         
	        	max++;
	        else
	            break;                        //��������Ͽ�ʱ����������
	    }   
	    return max;  
	} 
	/**
	 * @param a   ��Ʊ��ֵ
	 * @param m   �������
	 * @param t   ��ǰ��Ʊ����
	 * @param cur ��ǰ��Ʊ��ֵ
	 */ 
	void dfs(int[] a, int m, int t, int cur){		
		int n = a.length;
	    if(t==m){    	
	        if(cur==max+1)                   //ȷ������Ϊ1
	        	flag = true;          
	        return;
	    }   
	    for(int i=0; i<n; i++){ 
	        if(cur<=max+1)                   //��֦
	            dfs(a, m, t+1, cur+a[i]);    //��ֱ�Ӹı�cur 
	    }   
	}
}
