package Others;
import java.util.*;
import Helpclass.Comp;

/**MostFrequent 给定数组和正整数k,返回数组里出现频率最高的k个数 (k<arr.length)
 * describe：Map+堆排序
 */
public class MostFrequent {

	public static void main(String[] args) { 
		MostFrequent m = new MostFrequent();
		int[] a = new int[] {1,1,1,2,2,3,4,4,4,4};
		int k = 2;
		System.out.print(m.topKFrequent(a, k));
	}
	
	public List<Integer> topKFrequent(int[] a, int k) {	    
		HashMap<Integer,Integer> map = new HashMap<>();//统计每个数出现的次数
	    for(int i=0; i<a.length; i++){
	    	if(map.containsKey(a[i]))
	    		map.put(a[i], map.get(a[i])+1);
	    	else
	    		map.put(a[i], 1);
	    }	    
	    Queue<Integer> heap = new PriorityQueue<Integer>(k, new Comp(map)); //大小为k的优先队列(小顶堆)   
	    for(int i:map.keySet()){                    //遍历关键词
    		if(heap.size()<k){                      //初始化堆
    			heap.offer(i);
    			continue;
    		}
    		if(map.get(i)>map.get(heap.peek())){    //当前元素大于堆中最小的元素
    			heap.poll();
    			heap.offer(i);
    		}
    	}  
		return new ArrayList<Integer>(heap);
	}  
	
} 
