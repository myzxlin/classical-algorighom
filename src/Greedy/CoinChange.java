package Greedy;

/** 
 * CoinChange [Ӳ������] ����1Ԫ,2Ԫ,5Ԫ,10Ԫ,20Ԫ,50Ԫ,100Ԫ��ֽ�ҷֱ���
 * c0, c1, c2, c3, c4, c5, c6��, ����ЩǮ��֧��KԪ������Ҫ�ö�����ֽ�ң� 
 * describe: ̰�Ĳ���, ÿһ������������ֵ���ֽ�Ҽ���
 */
public class CoinChange {

	 public static void main(String[] args) {
		 CoinChange x = new CoinChange();
		 int[] v = {1, 2, 5, 10, 20, 50, 100};  //��ֵ
	     int[] c = {3, 1, 2, 1, 1, 3, 5};       //����
	     int k = 212;
	     int[] num = x.change(k, v, c); 
	     
	     System.out.println("֧��" + k + "Ԫ�Ĳ���Ϊ��");
	     for(int i=0; i<v.length; i++) 
	    	 if(num[i]!=0) 
	    		 System.out.println(v[i] + "Ԫ��" + num[i] + "��");	            	       
	 }

	 public int[] change(int k, int[] v, int[] c){
	     int[] res = new int[v.length];
	     for(int i=v.length-1; i>=0; i--){          //�������ֵ��ʼ��       
	    	 res[i] = Math.min(k/v[i], c[i]);  //��Ҫ����ֵ���������	        
	         k -= res[i]*v[i];                      //ʣ�µ�Ǯ��	    
	     }
	     return res;
	 }

}
