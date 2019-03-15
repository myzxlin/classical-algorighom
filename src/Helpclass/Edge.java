package Helpclass;

public class Edge implements Comparable<Edge>{

    public int u;    //起始点
    public int v;    //结束点
    public int w;    //边的权值
    
    public Edge(int u, int v, int w) {
        this.u = u;
        this.v = v;
        this.w = w;
    }
    
  //自定义sort方法，按权值降序排序
    @Override
	public int compareTo(Edge o){  
		if(this.w > o.w)
			return 1;			
		if(this.w == o.w) 
			return 0; 
		return -1;
	} 
    
}