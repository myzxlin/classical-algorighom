package Greedy;
import java.util.*;

/** 
 * SetCovering [集合覆盖] 假设存在如下表的需要付费的广播台，以及广播台信号可以覆盖的地区。 
 * 问如何选择最少的广播台，让所有的地区都可以接收到信号 
 * 广播台       覆盖城市
 * k1       1,2
 * k2       1,3,4
 * k3       2,4
 * k4       3
 * describe: 贪心策略, 选出一个覆盖了最多地区的广播台，重复这一步直到覆盖了全部的地区
 * 这是一种近似算法(未必是最优解)，在获取到精确的最优解需要的时间太长时，便可以使用近似算法
 */
public class SetCovering {

	public static void main(String[] args){ 
		SetCovering s = new SetCovering();
		HashMap<String,HashSet<String>> map = new HashMap<>();
		map.put("K1", new HashSet(Arrays.asList(new String[] {"A","B","C","E"})));    
		map.put("K2", new HashSet(Arrays.asList(new String[] {"A","C","E"})));
		map.put("K3", new HashSet(Arrays.asList(new String[] {"B","D"})));
		map.put("K4", new HashSet(Arrays.asList(new String[] {"D","E"})));
 		HashSet<String> area = new HashSet(Arrays.asList(new String[]{"A","B","C","D","E"}));				
		
 		List<String> res = s.covering(map, area);
		System.out.print("选择的广播台为:" + res);
	}
	
	public List<String> covering(HashMap<String,HashSet<String>> map, HashSet<String> area){
		List<String> res = new ArrayList<String>();            		
		HashSet<String> temp = new HashSet<String>();
		String max;                             //表示每次搜寻到的覆盖面最大的站点
		while(area.size()!=0){                  //循环查找, 直到全集被全部覆盖为止
			max = null;                         //重置max为0
			for(String key : map.keySet()) {    //找覆盖面最大的站点, 保存为max
				temp.clear();
				temp.addAll(map.get(key));				
				temp.retainAll(area);           //该站点与area取交集保存至temp		
				if(temp.size()>0 && (max==null || temp.size()>map.get(max).size())) 
					max = key;                  
			}			
			if (max!=null) {
				res.add(max);
				area.removeAll(map.get(max));   //将已覆盖到的区域从全集中剔除
			}
		}
		return res;
	}

} 