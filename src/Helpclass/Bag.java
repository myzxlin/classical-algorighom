package Helpclass;

public class Bag {
	
	public int weight;   //����
	public int value;    //��ֵ
	public double wi;    //Ȩ��
	public String name;   //��������
	
	public Bag(int w, int v, String name){
		this.weight = w;
		this.value = v;
		this.name = name;
		this.wi = (double)value/weight;
	}
}
