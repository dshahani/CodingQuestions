package tree;

public class InorderSuccessor
{

	public static void main(String[] args)
	{
		Node root = new Node(6);
		Node a = new Node(3);
		Node b = new Node(9);
		Node c = new Node(1);
		Node d = new Node(4);
		Node e = new Node(5);
		Node f = new Node(7);
		Node g = new Node(10);
		root.left = a;
		root.right = b;
		a.parent = root;
		b.parent = root;

		a.left = c;
		a.right = d;
		c.parent = a;
		d.parent = a;

		d.right = e;
		e.parent = d;

		b.left = f;
		b.right = g;
		f.parent = b;
		g.parent = b;

		System.out.println((inOrderSucc(g) != null ? inOrderSucc(g).value : "last element"));
	}

	public static Node inOrderSucc(Node node)
	{
		if (node.right != null)
		{
			Node child = node.right;
			while (child.left != null)
			{
				child = child.left;
			}
			return child;
		} else
		{
			Node parent = node.parent;
			while (parent != null)
			{
				if (parent.left == node)
				{
					return parent;
				} else
				{
					node = parent;
					parent = parent.parent;
				}
			}
			return parent;
		}
	}

}
