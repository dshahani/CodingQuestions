package tree;

// Binary Search Tree validation

/*
 *  public class TreeNode
 *	{
 *		TreeNode left;
 *		TreeNode right;
 *		int value;
 *
 *		public TreeNode(int value)
 *		{
 *			this.value = value;
 *		}
 *	}
 */

public class BstValidation
{
	static int lastNumber;

	public static void main(String[] arg)
	{
		Node root = new Node(5);
		Node left = new Node(2);
		Node right = new Node(7);
		root.left = left;
		root.right = right;
		Node l1 = new Node(1);
		Node r1 = new Node(9);
		left.left = l1;
		right.right = r1;
		System.out.println(validate(root));

	}

	public static boolean validate(Node root)
	{
		if (root == null)
		{
			return true;
		}

		if (!validate(root.left))
		{
			return false;
		}
		if (lastNumber > root.value)
		{
			return false;
		} else
		{
			lastNumber = root.value;
		}
		if (!validate(root.right))
		{
			return false;
		}
		return true;
	}

}
