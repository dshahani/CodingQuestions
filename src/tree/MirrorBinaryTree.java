package tree;

import java.util.ArrayList;

public class MirrorBinaryTree
{

	public static void main(String[] args)
	{
		Node root = new Node(-4);
		Node a = new Node(2);
		Node b = new Node(3);
		Node c = new Node(3);
		Node d = new Node(1);
		Node e = new Node(2);
		Node f = new Node(3);
		root.left = a;
		root.right = b;
		a.left = c;
		a.right = d;
		b.left = e;
		b.right = f;
		// printBTree(root);
		//// reverseBTree(root);
		// printBTree(root);

		Node rootN = new Node(10);
		Node a1 = new Node(2);
		Node s1 = new Node(34);
		Node d1 = new Node(56);
		Node f1 = new Node(100);
		Node g1 = new Node(1);
		Node h1 = new Node(7);
		Node j1 = new Node(8);
		Node k1 = new Node(9);

		ArrayList<Node> lst = new ArrayList<Node>();
		lst.add(a1);
		lst.add(s1);
		lst.add(d1);
		lst.add(f1);
		rootN.nodeLst = lst;

		lst = new ArrayList<Node>();
		lst.add(g1);
		s1.nodeLst = lst;

		lst = new ArrayList<Node>();
		lst.add(h1);
		lst.add(j1);
		lst.add(k1);
		f1.nodeLst = lst;

		printNTree(rootN);
		reverseNTree(rootN);
		printNTree(rootN);

	}

	public static void reverseBTree(Node root)
	{
		Node tmp;
		ArrayList<Node> prnt = new ArrayList<Node>();
		ArrayList<Node> lst = new ArrayList<Node>();
		lst.add(root);
		while (!lst.isEmpty())
		{
			prnt = lst;
			lst = new ArrayList<Node>();
			for (Node node : prnt)
			{
				tmp = (node.left != null ? node.left : new Node(0));
				node.left = (node.right != null ? node.right : new Node(0));
				node.right = tmp;
			}
		}
	}

	public static void reverseNTree(Node root)
	{
		ArrayList<Node> prnt = new ArrayList<Node>();
		ArrayList<Node> lst = new ArrayList<Node>();
		lst.add(root);
		while (lst != null && !lst.isEmpty())
		{
			prnt = lst;
			lst = new ArrayList<Node>();
			for (Node node : prnt)
			{
				node.nodeLst = reverse(node.nodeLst);
				lst = node.nodeLst;
			}
		}
	}

	public static ArrayList<Node> reverse(ArrayList<Node> lst)
	{
		if (lst == null)
		{
			return lst;
		}
		int len = lst.size();
		if (len < 2)
		{
			return lst;
		}
		ArrayList<Node> lstNew = new ArrayList<Node>();

		int index = 0;
		for (int i = len - 1; i >= 0; i--)
		{
			lstNew.add(index, lst.get(i));
			index++;
		}
		return lstNew;
	}

	public static void printBTree(Node root)
	{
		ArrayList<Node> prnt = new ArrayList<Node>();
		ArrayList<Node> lst = new ArrayList<Node>();
		lst.add(root);
		System.out.println(root.value);
		while (!lst.isEmpty())
		{
			prnt = lst;
			lst = new ArrayList<Node>();
			for (Node node : prnt)
			{
				System.out.print(node.left != null ? node.left.value + "   " : 0 + "   ");
				System.out.print(node.right != null ? node.right.value + "   " : 0 + "   ");
				if (node.left != null)
				{
					lst.add(node.left);
				}
				if (node.right != null)
				{
					lst.add(node.right);
				}

			}
			System.out.println("");
		}
	}

	public static void printNTree(Node root)
	{
		ArrayList<Node> prnt = new ArrayList<Node>();
		ArrayList<Node> lst = new ArrayList<Node>();
		lst.add(root);
		System.out.println(root.value);
		while (!lst.isEmpty())
		{
			prnt = lst;
			lst = new ArrayList<Node>();
			for (Node node : prnt)
			{
				if (node.nodeLst == null)
				{
					continue;
				}
				for (Node child : node.nodeLst)
				{
					if (child == null)
					{
						continue;
					}
					System.out.print(child != null ? node.value + ":" + child.value + "   " : 0 + "   ");
					lst.add(child);
				}
			}
			System.out.println("");
		}
	}

}
