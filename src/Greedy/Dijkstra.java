package Greedy;

/** 
 * Dijkstra [�Ͻ�˹�����㷨] ��Դ���·�����ҳ�Դ�������������̾���
 * 
 * describe: ̰�Ĳ���
 * �����ж��㻮�ֳ��������ϣ�S���ѵ���Ķ��㣬V��δ����Ķ��㣬S+V�������ж��㡣
 * ��ʼ��S����ֻ����Դ���㣬Ȼ���ҳ�V�о���S�����һ������(̰��ѡ��),
 * dist[]��¼ÿ�����㵽Դ�ľ���, dist[2]=x ��ʾ����2��Դ����̾�����x;
 * prev[]��¼·��, prev[2]=y ��ʾ����2��Դ�����·���У�����2��ǰһ�������Ƕ���y;
 * s[] ���ö������S����
 */
public class Dijkstra {

    static float m = Float.MAX_VALUE;           //����Զ

    public static void main(String[] args) {
    	Dijkstra d = new Dijkstra();
        float[][] a = {                           //a[i][j]��ʾ��i����j�ľ��� 
        		{ m, m, m, m, m, m }, //i=0�����壬��i=1��ʼ���
                { m, 0, 10, m, 30, 100 }, 
                { m, m, 0, 50, m, m },
                { m, m, m, 0, m, 10 }, 
                { m, m, m, 20, 0, 60 },
                { m, m, m, m, m, 0 }    
        };
        int n = a.length;
        float[] dist = new float[n];
        int[] prev = new int[n];
        d.dijkstra(1, a, dist, prev);
        
        System.out.println("����1��5�����·����");
        d.trace(prev, 5);
        System.out.println("\n����1��3�����·����");
        d.trace(prev, 3);
    }
    
    /**
     * @param v Դ
     * @param a ͼ
     * @param dist ·������, dist[i]��ʾ��ǰ��Դ������i���������·������
     * @param prev ·��, prev[i]=j�����·���ж���i��ǰһ��������j����������
     */
    public void dijkstra(int v, float[][] a, float[] dist, int[] prev){
        int n = dist.length-1;              //�ڵ����
        if(v<1 || v>n)
            return;
        boolean[] s = new boolean[n+1];     //s���� ͳ�Ʒ��ʹ��ĵ�
        for(int i=1; i<=n; i++) {           //��ʼ��dist[]��prev[]
            dist[i] = a[v][i];              //a[v][i]��ʾ��v����i�ľ���
            s[i] = false;
            if(dist[i] == m)
                prev[i] = 0;
            else
                prev[i] = v;
        }
        dist[v] = 0;
        s[v] = true;

        for(int i=1; i<n; i++) { 
            float temp = m;
            int u = v;
            for(int j=1; j<=n; j++){        //Ѱ�Ҳ���s�������Ҿ���s��������Ľڵ�,��Ϊu
                if((!s[j]) && (dist[j]<temp)){
                    u = j;                  //��¼�ڵ�
                    temp = dist[j];         //��¼�������·������
                }
            }
            s[u] = true;                    //��u����s����
            for(int j=1; j<=n; j++) {       //����dist[], prev[]
                if((!s[j]) && (a[u][j]<m)) { 
                    float now = dist[u] + a[u][j];
                    if (now<dist[j]) {      //������Сֵ
                        dist[j] = now;
                        prev[j] = u;
                    }
                }
            }
        }
    }

    void trace(int[] prev, int n){
        if(n==1){
            System.out.print(n + " ");
            return;
        }
        trace(prev, prev[n]);
        System.out.print(n + " ");
    } 
}
