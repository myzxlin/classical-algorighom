package Greedy;
import Helpclass.Bag; 

/**Knapsack [背包问题] 背包容量为K, 有n个物品(重量w,价值v), 问如何放置收益最大
 * 注意：与0-1背包问题不同的是，此问题下物品可以拆分(分成几份装入)
 * 
 * describe: 贪心策略,每一次放入的最佳物品都是价值最大且质量最小的，
 * 这里引入物品的权重值属性(价值/质量),每次都选出权重值最大的物品放入背包
 */
public class Knapsack {
	
	 public static void main(String args[]){
		 Knapsack k = new Knapsack();
         int w = 40;                          //背包的容量
         int n = 7;                           //物品的个数
         Bag[] p = new Bag[n];   
         
         System.out.print("-----------物品清单-----------\n");
         for(int i=0; i<n; i++) {
        	 p[i] = new Bag(2*i+3, 3*i+2, "bag"+String.valueOf(i));  //设置物品参数
        	 System.out.println(p[i].name+": weight="+p[i].weight+
        			 ", value="+p[i].value+", wi="+ String.format("%.2f",p[i].wi));
         }         
         k.sort(p);
         System.out.print("\n-----------解决方案-----------\n");
         k.bq(p, 0, w, 0.0);    
     } 
	 
	 //将背包按权重从大到小排序 - 冒泡
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
     
     //k:物品序号  v:当前背包价值
     public void bq(Bag[] p, int k, int w, double v){ 
         if(p[k].weight<w){
             v += p[k].value;        
             w -= p[k].weight;     //缩小问题规模
             System.out.println(p[k].name+": 装入1, 当前背包价值"+v+",剩余空间"+w);
             bq(p, k+1, w, v);
         }else{
        	 System.out.println(p[k].name+": 装入"+ String.format("%.1f",(double)w/p[k].weight)+
        			 ", 当前背包价值"+String.format("%.1f",v+w*p[k].wi));
         }         
     }    

}
