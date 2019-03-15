package Greedy;
import java.util.*;

/** 
 * SetCovering [���ϸ���] ����������±����Ҫ���ѵĹ㲥̨���Լ��㲥̨�źſ��Ը��ǵĵ����� 
 * �����ѡ�����ٵĹ㲥̨�������еĵ��������Խ��յ��ź� 
 * �㲥̨       ���ǳ���
 * k1       1,2
 * k2       1,3,4
 * k3       2,4
 * k4       3
 * describe: ̰�Ĳ���, ѡ��һ���������������Ĺ㲥̨���ظ���һ��ֱ��������ȫ���ĵ���
 * ����һ�ֽ����㷨(δ�������Ž�)���ڻ�ȡ����ȷ�����Ž���Ҫ��ʱ��̫��ʱ�������ʹ�ý����㷨
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
		System.out.print("ѡ��Ĺ㲥̨Ϊ:" + res);
	}
	
	public List<String> covering(HashMap<String,HashSet<String>> map, HashSet<String> area){
		List<String> res = new ArrayList<String>();            		
		HashSet<String> temp = new HashSet<String>();
		String max;                             //��ʾÿ����Ѱ���ĸ���������վ��
		while(area.size()!=0){                  //ѭ������, ֱ��ȫ����ȫ������Ϊֹ
			max = null;                         //����maxΪ0
			for(String key : map.keySet()) {    //�Ҹ���������վ��, ����Ϊmax
				temp.clear();
				temp.addAll(map.get(key));				
				temp.retainAll(area);           //��վ����areaȡ����������temp		
				if(temp.size()>0 && (max==null || temp.size()>map.get(max).size())) 
					max = key;                  
			}			
			if (max!=null) {
				res.add(max);
				area.removeAll(map.get(max));   //���Ѹ��ǵ��������ȫ�����޳�
			}
		}
		return res;
	}

} 