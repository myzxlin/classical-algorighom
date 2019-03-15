package BiTree;
import java.util.*;
import Helpclass.TreeNode;

/** 
 * ReadLevelLeft 给定一个二叉树，打印每层最左边节点的值
 * describe: 层次遍历 + 判断深度
 **/ 
public class ReadLevelLeft {

	public static void main(String[] args) { 
		ReadLevelLeft r = new ReadLevelLeft();
		TreeNode t = new TreeNode(0);
		TreeNode test = t.createBiTree(new int[]{1,2,3,4,5,6,7,8});	 
		r.readLevelLeft(test);
	}

	public void readLevelLeft(TreeNode root) {
		if (root==null) 
			return;
		int dp = root.depth(root);		
		for (int i=1; i<=dp; i++) 
			System.out.print(help(root,i));
	}

	String help(TreeNode root, int i) {
		String res = "";
		if (root == null||i<1) 
			return res;
		if (i==1) 
			return root.val+" ";
		
		res += help(root.left, i-1);
		if (res.equals ("")) 
			res += help(root.right, i-1); //左子树为空 则到右边来
		return res;
	}  
	
}
