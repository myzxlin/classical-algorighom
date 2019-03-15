package Helpclass;

public class Active implements Comparable<Active>{
	
    private int startTime;     //活动开始时间
    private int endTime;       //活动结束时间

    public Active(int startTime, int endTime) {
        super();
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public int getStartTime() {
        return startTime;
    }

    public void setStartTime(int startTime) {
        this.startTime = startTime;
    }

    public int getEndTime() {
        return endTime;
    }

    public void setEndTime(int endTime) {
        this.endTime = endTime;
    }
    
    @Override
    public String toString() {
        return "Active [startTime=" + startTime + ", endTime=" + endTime + "]";
    }
    
    //自定义sort方法，按结束时间升序排序
    @Override
    public int compareTo(Active o) {
        if(this.endTime > o.getEndTime())
            return 1;
        if(this.endTime == o.endTime)
            return 0;
        return -1;        
    }

}
