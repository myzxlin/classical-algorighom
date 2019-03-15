package BiTree;
import java.util.*;
import Helpclass.TreeNode; 

/** 
 * buildTree ����һ�����������������������������ع���ζ�����
 * describe: ����
 **/ 
public class buildTree {
	
	int index = 0;     //��ǰ�ڵ�
	
	public static void main(String[] args) {
		buildTree b = new buildTree();
		int[] pre = new int[] {1,2,4,5,3,6,7};
		int[] in = new int[] {4,2,5,1,6,3,7};
		TreeNode t = new TreeNode(0); 
		t.LayerTraverse(b.build1(pre, in));  
		System.out.println();
 		t.LayerTraverse(b.build2(pre, in, 0, pre.length-1)); 
	}
	//��ͨ�ݹ�
	public TreeNode build1(int[] pre, int[] in) {
		TreeNode root = new TreeNode(pre[0]);		
		if(pre.length==1 && in.length==1)
			return root;
		
		int mid = Arrays.binarySearch(in, pre[0]);
		int[] left1 = new int[mid];
		int[] left2 = new int[mid];
		int[] right1 = new int[in.length-mid-1];
		int[] right2 = new int[in.length-mid-1];
		
		for(int i=0; i<left1.length; i++) {
			left1[i] = pre[1+i];
			left2[i] = in[i];
		} 
		for(int i=0; i<left2.length; i++) {
			right1[i] = pre[mid+1+i];
			right2[i] = in[mid+1+i];
		} 	
		root.left = build1(left1, left2);
		root.right = build1(right1, right2);
		return root;
	} 
	
	//����
	public TreeNode build2(int[] s1, int[] s2, int start, int end) {
		int flag = 0;                 //���������ֽ���
		if(index>=s1.length)
			return null;
		TreeNode root = new TreeNode(s1[index]);  
		for(int i=0; i<s2.length; i++)
			if(s1[index]==s2[i])
				flag=i;
		index++;
		if(flag>start)
			root.left = build2(s1, s2, start, flag-1);
		if(flag<end)
			root.right = build2(s1, s2, flag+1, end);	
		return root;  
	} 

}
