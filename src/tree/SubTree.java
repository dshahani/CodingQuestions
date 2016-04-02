package tree;

public class SubTree
{
	public static void main(String[] arg)
	{
		Node root = new Node(6);
		Node left = new Node(3);
		Node right = new Node(1);
		Node a = new Node(4);
		Node r1 = new Node(9);
		root.left = left;
		root.right = r1;
		left.left = right;
		left.right = a;

		Node root2 = new Node(3);
		Node left2 = new Node(1);
		Node right2 = new Node(4);
		root2.left = left2;
		root2.right = right2;

		System.out.println(checkSubtree(root, root2));
	}

	public static boolean checkSubtree(Node root1, Node root2)
	{
		if (root1 == null || root2 == null)
		{
			return false;
		}

		if (root1.value == root2.value)
		{
			if (checkTree(root1, root2))
			{
				return true;
			}
		}

		return checkSubtree(root1.left, root2) || checkSubtree(root1.right, root2);
	}

	public static boolean checkTree(Node root1, Node root2)
	{
		if (root1 == null && root2 == null)
		{
			return true;
		}

		if (root1 == null || root2 == null)
		{
			return false;
		}

		if (root1.value != root2.value)
		{
			return false;
		}

		return checkTree(root1.left, root2.left) && checkTree(root1.right, root2.right);
	}
}
