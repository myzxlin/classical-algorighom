package DivideAndConquer;
import java.util.*;
import java.awt.*;
import java.io.*;
import Helpclass.Point;

/** 
 * ClosetPointPair [最接近点对] 二维空间里n个点，找其中距离最小的一对点 
 *
 * describe: 划分集合S为SL和SR, 使得SL中每一个点位于SR中每一个点的左边, 并且SL和SR中点数相同。
 * 分别在SL和SR中解决最近点对问题, 得到DL和DR, 分别表示SL和SR中的最近点对的距离,令d=min(DL,DR), 
 * 如果最近点对(P1,P2)两点一个在SL和一个在SR中，那么P1和P2一定在以L为中心的间隙内，以L-d和L+d为界
 *
 * 1：根据点的x值和y值对S中的点排序
 * 2：找出中线L将S划分为SL和SR
 * 3：递归解决SL和SR的最近点对问题，令d=min(dL,dR)
 * 4：将L-d~L+d内的点以y值排序，对于每一个点(x1,y1)找出y值在y1-d~y1+d内的所有点，计算距离为d'。                 
 * 5: 如果d'<d, 令d=d', return d
 */
public class ClosetPointPair {  
 
	public Comparator<Point> com = new Comparator<Point>() {	
		public int compare(Point a1, Point a2) {			
			return a1.x>a2.x? 1:-1;
		}
	};
		
	public static void main(String[] args) throws IOException {		
		ClosetPointPair c = new ClosetPointPair(); 
		int n = 10;                       //点数 
	    Point no[] = new Point[n];	        
	    for(int i=0; i<n; i++){          //生成一组点
	        double x = i*2+3;
	        double y = i*3+2;
	        no[i] = new Point(x,y);
	        System.out.print("[" + x +", " + y + "]" + "\n"); 
	    }
	    Arrays.sort(no, c.com);
	    double min= c.search(no, 0, n-1);
	    System.out.print("最短距离为：" + String.format("%.2f", Math.sqrt(min)/2));         
	}
	
	public double search(Point[] p, int m, int n) {
		int mid = (m+n)/2; 
	    double d = 0;                     //最短距离
	    if(m==n)                          //只有一点 
	    	return -1;   	        
	    if(m+1==n)                        //两点相邻 
	        d = distance(p[m], p[n]); 
	    else                              //左右侧小的那个
	    	d = Math.min(search(p,m,mid), search(p,mid,n));
	       
	    int l = mid;                      //左右子集各含一点的情况
	    int r = mid+1;                    //寻找边界宽度    
	    while(p[mid].x-p[l].x <= d && l>=m+1) 
	        l--;                          //找左边界
	    while(p[r].x-p[mid].x <= d && r<=n-1) 
	        r++;                          //找右边界	    
	    for(int i=l; i<r; i++){           //边界内一一比对查找
	        for(int j=i+1; j<r+1; j++){  
	            if(distance(p[i],p[j])>d) //超出最短距离，剔除
	                continue; 
	            d = Math.min(d, distance(p[i],p[j]));            
	        }
	    }
	    return d;	
	}
	//计算两点距离
	double distance(Point a, Point b) {
		double d = Math.pow(a.x-b.x, 2) + Math.pow(a.y-b.y, 2);
		return Math.sqrt(d);
	}

}
