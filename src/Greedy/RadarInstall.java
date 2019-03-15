package Greedy;
import java.util.*;
import Helpclass.Point;

/** 
 * RadarInstall [雷达安装]  
 * 海岸线一侧是陆地，另一侧是大海。海中岛屿坐标确定，要在海岸线上安装雷达(覆盖范围是d)，
 * 定义海岸线是x轴，大海在x轴上方，陆地在x轴下方。问至少安装多少个雷达能将所有的岛屿覆盖 
 
 * 思路：对于每一个岛屿，以d为半径画圆，若与x轴没有交点，则该岛无法被监测到，
 * 否则，将其与x轴的两个交点x1,x2存入int[][], 在所有交点存入数组后，以每个岛的左边的交点为关键字排序。
 * 变量pos为雷达的位置，将排序后的place[0][1]赋值给r，从第二个岛屿开始找，
 * 若岛2的x1在pos的监测范围之外，pos更新为岛2的x2，雷达数+1，
 * 若岛2的x1在pos的监测范围之内，pos更新为岛2的x1，依此类推。
 */
public class RadarInstall {

	public static void main(String[] args) { 
		RadarInstall r = new RadarInstall();
		List<Point> res = new ArrayList<>();
		res.add(new Point(13, 2));
		res.add(new Point(9, 4));
		res.add(new Point(3, 3));
		res.add(new Point(-2, 2));
		res.add(new Point(-7, 4.5));
		int d = 5;
		System.out.print(r.radar(res, d));
	}
	
	public int radar(List<Point> res, int d) {
		int n = res.size();               
		res.sort(null);
		double[][] place = new double[n][2]; //岛屿以r为半径与x轴两交点横坐标
		for (int i=0; i<n; i++) {
			double a = Math.sqrt(d*d - res.get(i).y*res.get(i).y) ;
			place[i][0] = res.get(i).x-a;
			place[i][1] = res.get(i).x+a;
		} 
		int count = 1;
		double pos = place[0][1];            //雷达位置
		for(int i=1; i<n; i++) {
			if(place[i][0]>pos) {				
				pos = place[i][1];
				count++;
			}else
				pos = place[i][0];
		} 
		return count;
	} 
		
}
