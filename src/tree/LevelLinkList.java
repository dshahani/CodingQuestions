package tree;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class LevelLinkList
{
	public static void main(String[] args)
	{
		Node root = new Node(1);
		Node a = new Node(2);
		Node b = new Node(3);
		Node c = new Node(4);
		Node d = new Node(5);
		Node e = new Node(6);
		root.left = a;
		root.right = b;
		a.left = c;
		a.right = d;
		b.right = e;
		ArrayList<LinkedList<Node>> result = createLevelLink(root);
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

	public static ArrayList<LinkedList<Node>> createLevelLink(Node root)
	{
		if (root == null)
		{
			return null;
		}
		ArrayList<LinkedList<Node>> result = new ArrayList<LinkedList<Node>>();
		LinkedList<Node> current = new LinkedList<Node>();
		current.add(root);
		while (!current.isEmpty())
		{
			result.add(current);
			LinkedList<Node> parents = current;
			current = new LinkedList<Node>();
			for (Node node : parents)
			{
				if (node.left != null)
				{
					current.push(node.left);
				}
				if (node.right != null)
				{
					current.push(node.right);
				}

			}
			// result.add(current);
		}
		return result;
	}

	static ArrayList<LinkedList<Node>> resultDFS = new ArrayList<LinkedList<Node>>();

}
