package Others;
import java.util.*;
import Helpclass.Comp;

/**MostFrequent ���������������k,�������������Ƶ����ߵ�k���� (k<arr.length)
 * describe��Map+������
 */
public class MostFrequent {

	public static void main(String[] args) { 
		MostFrequent m = new MostFrequent();
		int[] a = new int[] {1,1,1,2,2,3,4,4,4,4};
		int k = 2;
		System.out.print(m.topKFrequent(a, k));
	}
	
	public List<Integer> topKFrequent(int[] a, int k) {	    
		HashMap<Integer,Integer> map = new HashMap<>();//ͳ��ÿ�������ֵĴ���
	    for(int i=0; i<a.length; i++){
	    	if(map.containsKey(a[i]))
	    		map.put(a[i], map.get(a[i])+1);
	    	else
	    		map.put(a[i], 1);
	    }	    
	    Queue<Integer> heap = new PriorityQueue<Integer>(k, new Comp(map)); //��СΪk�����ȶ���(С����)   
	    for(int i:map.keySet()){                    //�����ؼ���
    		if(heap.size()<k){                      //��ʼ����
    			heap.offer(i);
    			continue;
    		}
    		if(map.get(i)>map.get(heap.peek())){    //��ǰԪ�ش��ڶ�����С��Ԫ��
    			heap.poll();
    			heap.offer(i);
    		}
    	}  
		return new ArrayList<Integer>(heap);
	}  
	
} 
