package Greedy;
import java.util.*;
import Helpclass.Work;

/** 
 * Schedule [����������ҵ���� ] Ҫ��һ̨�����ϴ���n����ҵ��ÿ����ҵ���ڵ�λʱ�������,
 * ÿ����ҵ����һ������ֵddl��������ֵǰ��ɾͿ��Ի��Ч��val�����ܲ������Ч�����ҵ�Ӽ�  
 * 
 * describe�� ����ҵ��Ч��ֵ�������У�ÿ��ѡȡЧ��������ҵ(̰��)�����жϸ���ҵ��֮ǰ�Ŀ��н�����ddl��ͻ��
 * �޳�ͻ������Ӽ����г�ͻ���������ҵ��Ѱ����һ��
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
			for(int j=0; j<res.size(); j++)   //��鵱ǰ��ҵ��֮ǰ��ҵ����ʱ���ͻ
				if(res.get(j).ddl==work.get(i).ddl)				
					flag = false; 
			if(flag)
				res.add(work.get(i));
		}
		return res;		
	} 
}
