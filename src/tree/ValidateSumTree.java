package tree;

public class ValidateSumTree
{

	public static void main(String[] args)
	{
		Node root = new Node(26);
		Node a = new Node(10);
		Node b = new Node(3);
		Node c = new Node(4);
		Node d = new Node(1);
		Node e = new Node(3);
		// TreeNode f = new TreeNode(3);
		root.left = a;
		root.right = b;
		a.left = c;
		a.right = d;
		b.left = e;
		// b.right = f;

		if (validateSumTree1(root) == (2 * root.value))
		{
			System.out.println("true");
		} else
		{
			System.out.println("false");
		}

		System.out.println(validateSumTree(root));
	}

	public static int validateSumTree1(Node node)
	{
		if (node == null)
		{
			return 0;
		}

		int oldValue = node.value;
		int sumValue = validateSumTree1(node.left) + validateSumTree1(node.right);

		if (sumValue == 0 || (oldValue == sumValue))
		{
			return oldValue + sumValue;
		} else
		{
			return 0;
		}

	}

	public static boolean validateSumTree(Node node)
	{
		if (node == null || node.left == null || node.right == null)
		{
			return true;
		}

		int left = findSum(node.left);
		int right = findSum(node.right);

		if ((node.value == (left + right)) && validateSumTree(node.left) && validateSumTree(node.right))
		{
			return true;
		} else
		{
			return false;
		}

	}

	public static int findSum(Node node)
	{
		if (node == null)
		{
			return 0;
		}

		return findSum(node.left) + node.value + findSum(node.right);
	}
}
