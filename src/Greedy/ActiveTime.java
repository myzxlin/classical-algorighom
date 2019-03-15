package Greedy;
import java.util.*;
import Helpclass.Active;

/** 
 * ActiveTime [�ѡ��] ��n����Ҫ��ͬһ��ʹ��ͬһ�����ҵĻa1,a2,��,an, 
 * ����ͬһʱ��ֻ����һ���ʹ��, ÿ������п�ʼʱ��ͽ���ʱ�䣬���������ʱ�䲻�ص���
 * ����Ա�������ͬһ��, ����ΰ�����Щ���ʹ�þ�����Ļ�ܲ���ͻ�ľ���
 * 
 * describe: ̰�Ĳ���
 * �Խ�������ʣ��ʱ��Խ�࣬�Ǿ�������������Ǹ��������ʣ�µĻ���������������
 */
public class ActiveTime {

    public static void main(String[] args) { 
    	ActiveTime a = new ActiveTime();
    	List<Active> res = new ArrayList<Active>();     
    	res.add(new Active(1, 4));
    	res.add(new Active(3, 5));
    	res.add(new Active(0, 6));
    	res.add(new Active(5, 7));
    	res.add(new Active(3, 8));
    	res.add(new Active(5, 9));
    	res.add(new Active(6, 10)); 
        
        List<Active> best = a.getBest(res, 0, 12);
        for(Active i:best) 
            System.out.println(i);
    } 
    
    public List<Active> getBest(List<Active> res, int start, int end) {
        List<Active> best = new ArrayList<>();   
        res.sort(null);                       //���������ʱ������    
        int now = start;                      //now ��¼�ϴλ����ʱ��
        for(int i=0; i<res.size(); i++) {
            Active a = res.get(i);
            if(a.getStartTime()>=now && a.getEndTime()<=end){
                best.add(a);
                now = a.getEndTime();
            }
        }
        return best;
    }

}
