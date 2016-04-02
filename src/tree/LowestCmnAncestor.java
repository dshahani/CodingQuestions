package tree;

public class LowestCmnAncestor
{
	public static void main(String[] arg)
	{
		Node root = new Node(5);
		root.parent = null;
		Node left = new Node(2);
		Node right = new Node(7);
		root.left = left;
		root.right = right;
		left.parent = root;
		right.parent = root;
		Node l1 = new Node(1);
		Node r1 = new Node(9);
		left.left = l1;
		left.right = r1;
		l1.parent = left;
		r1.parent = left;
		System.out.println(getAncestor(l1, r1).value);
	}

	public static Node getAncestor(Node n1, Node n2)
	{
		Node parent = n1.parent;
		while (parent != null)
		{
			if (isOnPath(parent, n2))
			{
				return parent;
			}
			parent = parent.parent;
		}
		return null;
	}

	public static boolean isOnPath(Node ref, Node toCheck)
	{
		while (toCheck != null)
		{
			if (toCheck == ref)
			{
				return true;
			} else
			{
				toCheck = toCheck.parent;
			}
		}
		return false;
	}

}
