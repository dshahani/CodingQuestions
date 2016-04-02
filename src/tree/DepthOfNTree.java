package tree;

import java.util.ArrayList;

public class DepthOfNTree
{
	static ArrayList<Node> depLst = new ArrayList<Node>();

	public static void main(String[] arg)
	{
		Node root = new Node(1);
		Node a = new Node(2);
		Node b = new Node(3);
		Node c = new Node(4);
		Node d = new Node(5);
		Node e = new Node(6);
		Node f = new Node(7);
		Node g = new Node(8);
		Node h = new Node(9);
		depLst.add(a);
		depLst.add(b);
		depLst.add(c);
		root.nodeLst = depLst;
		depLst = new ArrayList<Node>();
		depLst.add(d);
		depLst.add(e);
		a.nodeLst = depLst;
		depLst = new ArrayList<Node>();
		depLst.add(f);
		b.nodeLst = depLst;
		depLst = new ArrayList<Node>();
		depLst.add(g);
		b.nodeLst = depLst;
		depLst = new ArrayList<Node>();
		depLst.add(h);
		c.nodeLst = depLst;

		System.out.println(calcDepth(root, 1));
		System.out.println(calcDepthUsingBFS(root));

	}

	static Integer[] arr = new Integer[3];
	static int maxDepth = 0;

	public static int calcDepth(Node root, int level)
	{
		if (root == null || root.nodeLst == null)
		{
			if (maxDepth < level)
			{
				maxDepth = level;
			}
			return level;
		}

		for (Node node : root.nodeLst)
		{
			calcDepth(node, level + 1);

		}
		return maxDepth;
	}

	public static int calcDepthUsingBFS(Node root)
	{
		int level = 0;
		ArrayList<Node> current = new ArrayList<Node>();
		current.add(root);
		ArrayList<Node> parent;
		while (!current.isEmpty() && current != null)
		{
			level++;
			parent = current;
			current = new ArrayList<Node>();
			for (Node node : parent)
			{
				if (node.nodeLst != null)
				{
					for (Node child : node.nodeLst)
					{
						current.add(child);
					}
				}
			}
		}
		return level;
	}
}
