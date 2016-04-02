package tree;

public class CheckBalance
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
		// a.right = d;
		b.right = e;
		b.left = d;
		int max = maxDepth(root), min = minDepth(root);
		System.out.println(max);
		System.out.println(min);
		if (max - min > 1)
		{
			System.out.println("Not balanced");
		}

	}

	public static int maxDepth(Node root)
	{
		if (root == null)
		{
			return 0;
		}
		return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
	}

	public static int minDepth(Node root)
	{
		if (root == null)
		{
			return 0;
		}
		return 1 + Math.min(minDepth(root.left), minDepth(root.right));
	}

}
