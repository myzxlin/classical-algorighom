package Helpclass;

public class Point implements Comparable<Point>{
	
	public double x;
	public double y;
	
	public Point(double x, double y){
		this.x = x;
		this.y = y;
	};
	
    //�Զ���sort��������x��������
    @Override
    public int compareTo(Point o) {
        if(this.x > o.x)
            return 1;
        if(this.x == o.x)
            return 0;
        return -1;        
    }
}