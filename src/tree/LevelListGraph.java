package tree;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class LevelListGraph
{
	static ArrayList<LinkedList<Node>> resultDFS = new ArrayList<LinkedList<Node>>();
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
		depLst.add(g);
		b.nodeLst = depLst;
		// depLst = new ArrayList<TreeNode>();
		// depLst.add(g);
		// b.nodeLst = depLst;
		depLst = new ArrayList<Node>();
		depLst.add(h);
		c.nodeLst = depLst;

		ArrayList<LinkedList<Node>> result = createLevelLinkDFS(root, 0);
		for (LinkedList list : result)
		{
			Iterator<Node> it = list.iterator();
			Node temp;
			while (it.hasNext())
			{
				temp = it.next();
				System.out.print(temp.value);
			}
			System.out.println();

		}
	}

	public static ArrayList<LinkedList<Node>> createLevelLinkDFS(Node root, int level)
	{
		if (root == null)
		{
			return null;
		}
		LinkedList<Node> current;
		if (resultDFS != null && resultDFS.size() > level)
		{
			current = resultDFS.get(level);
		} else
		{
			current = new LinkedList<Node>();
			resultDFS.add(current);
		}
		current.add(root);
		root.visited = true;

		if (root.nodeLst == null)
		{
			return null;
		}

		for (Node node : root.nodeLst)
		{
			if (!node.visited)
			{
				createLevelLinkDFS(node, level + 1);
			}
		}

		return resultDFS;
	}
}
