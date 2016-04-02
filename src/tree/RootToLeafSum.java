package tree;

public class RootToLeafSum
{
	public static void main(String[] arg)
	{
		Node root = new Node(10);
		Node a = new Node(8);
		Node b = new Node(2);
		Node c = new Node(3);
		Node d = new Node(5);
		Node e = new Node(2);
		// TreeNode f = new TreeNode(3);
		root.left = a;
		root.right = b;
		a.left = c;
		a.right = d;
		b.left = e;
		// b.right = f;
		// findSum(root, 0);
		System.out.println(findSum(root));
	}

	static int sum = 0;

	public static int findSum(Node root, int sum)
	{
		if (root == null)
		{
			return 0;
		}

		sum += root.value;

		if (root.left == null && root.right == null)
		{
			System.out.println(sum);
			return 0;
		}

		sum += findSum(root.left, sum);
		sum += findSum(root.right, sum);

		return 0;
	}

	public static int findSum(Node root)
	{
		if (root == null)
		{
			return 0;
		}

		int sum = 0;
		sum = root.value;

		if (root.left == null && root.right == null)
		{
			System.out.println(sum);
			return sum;
		}

		sum += findSum(root.left, sum);
		sum += findSum(root.right, sum);

		return sum;
	}
}
