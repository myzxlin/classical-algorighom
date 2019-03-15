package Greedy;
import java.util.*;
import Helpclass.Active;

/** 
 * ActiveTime [活动选择] 有n个需要在同一天使用同一个教室的活动a1,a2,…,an, 
 * 教室同一时刻只能由一个活动使用, 每个活动都有开始时间和结束时间，若两个活动的时间不重叠，
 * 则可以被安排在同一天, 问如何安排这些活动，使得尽量多的活动能不冲突的举行
 * 
 * describe: 贪心策略
 * 活动越早结束，剩余时间越多，那就找最早结束的那个活动，再在剩下的活动中再找最早结束的
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
        res.sort(null);                       //按最早结束时间排序    
        int now = start;                      //now 记录上次活动结束时间
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
