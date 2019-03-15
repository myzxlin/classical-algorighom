package Helpclass;

public class Bag {
	
	public int weight;   //重量
	public int value;    //价值
	public double wi;    //权重
	public String name;   //背包名称
	
	public Bag(int w, int v, String name){
		this.weight = w;
		this.value = v;
		this.name = name;
		this.wi = (double)value/weight;
	}
}
