package tree;

import java.util.ArrayList;

public class RouteBtwnNodes
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
		System.out.println(checkRoute(a, h));

	}

	public static boolean checkRoute(Node node1, Node node2)
	{
		if (node1 == node2)
		{
			return true;
		} else if (node1 == null || node1.nodeLst == null)
		{
			return false;
		}

		for (Node node : node1.nodeLst)
		{
			if (!node.visited)
			{
				node.visited = true;
				if (checkRoute(node, node2))
				{
					return true;
				}
			}
		}
		return false;
	}

}
