package Helpclass;

public class Work implements Comparable<Work>{

	public int name;     //编号
	public int val;      //效益
	public int ddl;      //截止日期
	
	public Work(int name, int val, int ddl) {
		this.name = name;
		this.val = val;
		this.ddl = ddl;
	} 
    
	//自定义sort方法，按截止日期排序
    @Override
    public int compareTo(Work o) {
        if(this.ddl > o.ddl)
            return 1;
        if(this.ddl == o.ddl)
            return 0;
        return -1;        
    }
}
