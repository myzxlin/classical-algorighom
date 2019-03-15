package BiTree;
import java.util.*;
import Helpclass.TreeNode;

/** 
 * Traversal �ǵݹ�ʵ�ֶ�������ǰ��/�������
 * describe: ����ջ
 **/ 
public class Traversal {

	public static void main(String[] args) { 
		Traversal t = new Traversal();
		TreeNode r = new TreeNode(0);
		TreeNode root = r.createBiTree(new int[]{1,2,3,4,5,6,7});	
		System.out.print("ǰ�������" + t.pre(root) +"\n");
		System.out.print("���������" + t.post(root) +"\n");
	}

	/*ǰ�����*/
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
	
	/*�������*/
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
		Collections.reverse(list);        //�������
		return list;
	}
}
