package Greedy;
import Helpclass.Bag; 

/**Knapsack [��������] ��������ΪK, ��n����Ʒ(����w,��ֵv), ����η����������
 * ע�⣺��0-1�������ⲻͬ���ǣ�����������Ʒ���Բ��(�ֳɼ���װ��)
 * 
 * describe: ̰�Ĳ���,ÿһ�η���������Ʒ���Ǽ�ֵ�����������С�ģ�
 * ����������Ʒ��Ȩ��ֵ����(��ֵ/����),ÿ�ζ�ѡ��Ȩ��ֵ������Ʒ���뱳��
 */
public class Knapsack {
	
	 public static void main(String args[]){
		 Knapsack k = new Knapsack();
         int w = 40;                          //����������
         int n = 7;                           //��Ʒ�ĸ���
         Bag[] p = new Bag[n];   
         
         System.out.print("-----------��Ʒ�嵥-----------\n");
         for(int i=0; i<n; i++) {
        	 p[i] = new Bag(2*i+3, 3*i+2, "bag"+String.valueOf(i));  //������Ʒ����
        	 System.out.println(p[i].name+": weight="+p[i].weight+
        			 ", value="+p[i].value+", wi="+ String.format("%.2f",p[i].wi));
         }         
         k.sort(p);
         System.out.print("\n-----------�������-----------\n");
         k.bq(p, 0, w, 0.0);    
     } 
	 
	 //��������Ȩ�شӴ�С���� - ð��
     public void sort(Bag[] p){
         Bag t;
         for(int i=0; i<p.length; i++) {
             int max=i;
             t=p[i];
             for(int j=i; j<p.length; j++) {
                 if(t.wi<p[j].wi) {
                     t=p[j];
                     max=j;
                 }
             }
             t=p[i];
             p[i]=p[max];
             p[max]=t;            
         }
     }
     
     //k:��Ʒ���  v:��ǰ������ֵ
     public void bq(Bag[] p, int k, int w, double v){ 
         if(p[k].weight<w){
             v += p[k].value;        
             w -= p[k].weight;     //��С�����ģ
             System.out.println(p[k].name+": װ��1, ��ǰ������ֵ"+v+",ʣ��ռ�"+w);
             bq(p, k+1, w, v);
         }else{
        	 System.out.println(p[k].name+": װ��"+ String.format("%.1f",(double)w/p[k].weight)+
        			 ", ��ǰ������ֵ"+String.format("%.1f",v+w*p[k].wi));
         }         
     }    

}
