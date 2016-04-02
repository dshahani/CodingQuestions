package tree;

public class SumSubTree
{

	public static void main(String[] args)
	{
		Node root = new Node(10);
		Node a = new Node(-2);
		Node b = new Node(6);
		Node c = new Node(8);
		Node d = new Node(-4);
		Node e = new Node(7);
		Node f = new Node(5);
		root.left = a;
		root.right = b;
		a.left = c;
		a.right = d;
		b.left = e;
		b.right = f;
		createSumTree(root);
		System.out.println(root.value);
	}

	public static int createSumTree(Node root)
	{
		if (root == null)
		{
			return 0;
		}

		int oldData = root.value;

		root.value = createSumTree(root.left) + createSumTree(root.right);

		return oldData + root.value;
	}

}
