package Greedy;
import java.util.*;
import Helpclass.Point;

/** 
 * RadarInstall [�״ﰲװ]  
 * ������һ����½�أ���һ���Ǵ󺣡����е�������ȷ����Ҫ�ں������ϰ�װ�״�(���Ƿ�Χ��d)��
 * ���庣������x�ᣬ����x���Ϸ���½����x���·��������ٰ�װ���ٸ��״��ܽ����еĵ��츲�� 
 
 * ˼·������ÿһ�����죬��dΪ�뾶��Բ������x��û�н��㣬��õ��޷�����⵽��
 * ���򣬽�����x�����������x1,x2����int[][], �����н�������������ÿ��������ߵĽ���Ϊ�ؼ�������
 * ����posΪ�״��λ�ã���������place[0][1]��ֵ��r���ӵڶ������쿪ʼ�ң�
 * ����2��x1��pos�ļ�ⷶΧ֮�⣬pos����Ϊ��2��x2���״���+1��
 * ����2��x1��pos�ļ�ⷶΧ֮�ڣ�pos����Ϊ��2��x1���������ơ�
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
		double[][] place = new double[n][2]; //������rΪ�뾶��x�������������
		for (int i=0; i<n; i++) {
			double a = Math.sqrt(d*d - res.get(i).y*res.get(i).y) ;
			place[i][0] = res.get(i).x-a;
			place[i][1] = res.get(i).x+a;
		} 
		int count = 1;
		double pos = place[0][1];            //�״�λ��
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
