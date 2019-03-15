package Helpclass;
import java.util.*;

public class Node {

	public int val;
	public List<Node> children;
	
	public Node(int val) {
		this.val = val;
		this.children = new ArrayList<Node>();
	}
}
