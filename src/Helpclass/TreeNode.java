package Helpclass;
import java.util.*; 

public class TreeNode {
	public int val;
	public TreeNode left;
	public TreeNode right;
	public TreeNode(int x) { val = x; }

	/*����������*/
	public TreeNode createBiTree(int[] array) {  
		LinkedList<TreeNode> list = new LinkedList<>();  
        for (int i=0; i<array.length; i++)  
            list.add(new TreeNode(array[i]));    
        for (int i=0; i<array.length/2-1; i++) {  
        	list.get(i).left = list.get(i*2+1);   
        	list.get(i).right = list.get(i*2+2);  
        }   
        //�����������һ�����ڵ�
        int i = array.length/2-1;   
        list.get(i).left = list.get(i*2+1);  
        if (array.length%2 == 1)  
        	list.get(i).right = list.get(i*2+2); 
        return list.get(0);
    }  
	
	/*��α���*/
	public void LayerTraverse(TreeNode root) {
		LinkedList<TreeNode> list = new LinkedList<>(); //����
		TreeNode now;	
		if(root==null)
			return;
		list.add(root);
		while(!list.isEmpty()) {
			now = list.poll();       //ȡ������ͷ��� ��ɾ��
			System.out.print(now.val);
			if(now.left!=null)
				list.add(now.left);  //�ȼ�������
			if(now.right!=null)
				list.add(now.right); //�ټ����Һ���	 		
		}
	}
	
	/*�������*/
	public void PreOrderTraverse(TreeNode root) {
		if(root==null)
			return;
		System.out.print(root.val);
		PreOrderTraverse(root.left);
		PreOrderTraverse(root.right);
	}
	
	/*�������*/
	public void InOrderTraverse(TreeNode root) {
		if(root==null)
			return;
		InOrderTraverse(root.left);
		System.out.print(root.val);		
		InOrderTraverse(root.right);
	}
	
	/*�������*/
	public void PostOrderTraverse(TreeNode root) {
		if(root==null)
			return;		
		PostOrderTraverse(root.left);
		PostOrderTraverse(root.right);
		System.out.print(root.val);
	}
	
	/*�����*/
	public int depth(TreeNode root) {
		if(root==null)
			return 0;
		int ld = depth(root.left);
		int rd = depth(root.right);
		return (ld>rd)?ld+1:rd+1;
	}
	
	/*��ڵ����*/
	public int getNodes(TreeNode root) {
		if(root==null)
			return 0;
		return getNodes(root.left) + getNodes(root.right) + 1;
	}
	
	/*����*/
	public static void main(String[] args) { 
		TreeNode t = new TreeNode(0);
		TreeNode test = t.createBiTree(new int[]{1,2,3,4,5,6,7,8});
		System.out.print("�ڵ����Ϊ�� " + t.getNodes(test));
	}
}
