package tree;

import java.util.ArrayList;

public class Node
{
	public Node left;
	public Node right;
	public Node parent;
	public int value;
	boolean visited;
	ArrayList<Node> nodeLst;
	public int height;
	public int size;

	public static Node newNode(int data)
	{
		return new Node(data);
	}

	public Node(int value)
	{
		this.value = value;
		nodeLst = null;
		visited = false;
	}

	public void setNodeLst(ArrayList<Node> nodeLst)
	{
		this.nodeLst = nodeLst;
	}
}
