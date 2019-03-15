package Helpclass;
import java.util.*;

public class Comp implements Comparator<Integer>{
	 
	HashMap<Integer,Integer> map;
	
	public Comp(HashMap<Integer,Integer> map){
		this.map = map;
	}
	 
	@Override  //通过key的value来排序
	public int compare(Integer o1, Integer o2) {
		return map.get(o1)-map.get(o2);
	}
	
} 
