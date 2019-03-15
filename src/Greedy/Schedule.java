package Greedy;
import java.util.*;
import Helpclass.Work;

/** 
 * Schedule [带有限期作业排序 ] 要在一台机器上处理n个作业，每个作业可在单位时间内完成,
 * 每个作业都有一个期限值ddl，在期限值前完成就可以获得效益val，求能产生最大效益的作业子集  
 * 
 * describe： 把作业按效益值降序排列，每次选取效益最大的作业(贪心)，并判断该作业与之前的可行解有无ddl冲突，
 * 无冲突则加入子集，有冲突则放弃该作业，寻找下一个
 */
public class Schedule {

	public static void main(String[] args) { 
		Schedule s = new Schedule();
    	List<Work> work = new ArrayList<>();     
    	work.add(new Work(1, 15, 2));
    	work.add(new Work(2, 12, 3));
    	work.add(new Work(3, 11, 1));
    	work.add(new Work(4, 10, 3));
    	work.add(new Work(5, 8, 4));
    	work.add(new Work(6, 5, 5));
    	work.add(new Work(7, 4, 2));   
    	List<Work> res = s.func(work);
    	for(Work i:res)
    		System.out.print(i.name + " ");
	} 
	
	public List<Work> func(List<Work> work){ 
		List<Work> res = new ArrayList<>(); 
		work.sort(null);	
		res.add(work.get(0));
		for(int i=1; i<work.size(); i++) { 
			Boolean flag = true; 
			for(int j=0; j<res.size(); j++)   //检查当前作业与之前作业有无时间冲突
				if(res.get(j).ddl==work.get(i).ddl)				
					flag = false; 
			if(flag)
				res.add(work.get(i));
		}
		return res;		
	} 
}
