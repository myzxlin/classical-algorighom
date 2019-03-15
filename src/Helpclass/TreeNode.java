package Helpclass;
import java.util.*; 

public class TreeNode {
	public int val;
	public TreeNode left;
	public TreeNode right;
	public TreeNode(int x) { val = x; }

	/*创建二叉树*/
	public TreeNode createBiTree(int[] array) {  
		LinkedList<TreeNode> list = new LinkedList<>();  
        for (int i=0; i<array.length; i++)  
            list.add(new TreeNode(array[i]));    
        for (int i=0; i<array.length/2-1; i++) {  
        	list.get(i).left = list.get(i*2+1);   
        	list.get(i).right = list.get(i*2+2);  
        }   
        //单独处理最后一个父节点
        int i = array.length/2-1;   
        list.get(i).left = list.get(i*2+1);  
        if (array.length%2 == 1)  
        	list.get(i).right = list.get(i*2+2); 
        return list.get(0);
    }  
	
	/*层次遍历*/
	public void LayerTraverse(TreeNode root) {
		LinkedList<TreeNode> list = new LinkedList<>(); //队列
		TreeNode now;	
		if(root==null)
			return;
		list.add(root);
		while(!list.isEmpty()) {
			now = list.poll();       //取出队列头结点 并删除
			System.out.print(now.val);
			if(now.left!=null)
				list.add(now.left);  //先加入左孩子
			if(now.right!=null)
				list.add(now.right); //再加入右孩子	 		
		}
	}
	
	/*先序遍历*/
	public void PreOrderTraverse(TreeNode root) {
		if(root==null)
			return;
		System.out.print(root.val);
		PreOrderTraverse(root.left);
		PreOrderTraverse(root.right);
	}
	
	/*中序遍历*/
	public void InOrderTraverse(TreeNode root) {
		if(root==null)
			return;
		InOrderTraverse(root.left);
		System.out.print(root.val);		
		InOrderTraverse(root.right);
	}
	
	/*后序遍历*/
	public void PostOrderTraverse(TreeNode root) {
		if(root==null)
			return;		
		PostOrderTraverse(root.left);
		PostOrderTraverse(root.right);
		System.out.print(root.val);
	}
	
	/*求深度*/
	public int depth(TreeNode root) {
		if(root==null)
			return 0;
		int ld = depth(root.left);
		int rd = depth(root.right);
		return (ld>rd)?ld+1:rd+1;
	}
	
	/*求节点个数*/
	public int getNodes(TreeNode root) {
		if(root==null)
			return 0;
		return getNodes(root.left) + getNodes(root.right) + 1;
	}
	
	/*测试*/
	public static void main(String[] args) { 
		TreeNode t = new TreeNode(0);
		TreeNode test = t.createBiTree(new int[]{1,2,3,4,5,6,7,8});
		System.out.print("节点个数为： " + t.getNodes(test));
	}
}
