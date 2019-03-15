package Helpclass;

public class Work implements Comparable<Work>{

	public int name;     //���
	public int val;      //Ч��
	public int ddl;      //��ֹ����
	
	public Work(int name, int val, int ddl) {
		this.name = name;
		this.val = val;
		this.ddl = ddl;
	} 
    
	//�Զ���sort����������ֹ��������
    @Override
    public int compareTo(Work o) {
        if(this.ddl > o.ddl)
            return 1;
        if(this.ddl == o.ddl)
            return 0;
        return -1;        
    }
}
