package BiTree;
import java.util.*;
import Helpclass.TreeNode;

/** 
 * Traversal 非递归实现二叉树的前序/后序遍历
 * describe: 利用栈
 **/ 
public class Traversal {

	public static void main(String[] args) { 
		Traversal t = new Traversal();
		TreeNode r = new TreeNode(0);
		TreeNode root = r.createBiTree(new int[]{1,2,3,4,5,6,7});	
		System.out.print("前序遍历：" + t.pre(root) +"\n");
		System.out.print("后序遍历：" + t.post(root) +"\n");
	}

	/*前序遍历*/
	public List<Integer> pre(TreeNode root) {
		List<Integer> list = new ArrayList<>(); 
		Stack<TreeNode> stack = new Stack<>();
		if(root==null)
			return list;		
		stack.push(root);
		while(!stack.isEmpty()) {
			TreeNode now = stack.pop();
			list.add(now.val);
			if(now.right!=null)
				stack.push(now.right);
			if(now.left!=null)
				stack.push(now.left);
		} 
		return list;
	}
	
	/*后序遍历*/
	public List<Integer> post(TreeNode root) {
		List<Integer> list = new ArrayList<>(); 
		Stack<TreeNode> stack = new Stack<>();
		if(root==null)
			return list;		
		stack.push(root);
		while(!stack.isEmpty()) {
			TreeNode now = stack.pop();
			list.add(now.val);
			if(now.left!=null)
				stack.push(now.left);
			if(now.right!=null)
				stack.push(now.right);
		}
		Collections.reverse(list);        //倒序输出
		return list;
	}
}
