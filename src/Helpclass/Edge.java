package Helpclass;

public class Edge implements Comparable<Edge>{

    public int u;    //��ʼ��
    public int v;    //������
    public int w;    //�ߵ�Ȩֵ
    
    public Edge(int u, int v, int w) {
        this.u = u;
        this.v = v;
        this.w = w;
    }
    
  //�Զ���sort��������Ȩֵ��������
    @Override
	public int compareTo(Edge o){  
		if(this.w > o.w)
			return 1;			
		if(this.w == o.w) 
			return 0; 
		return -1;
	} 
    
}