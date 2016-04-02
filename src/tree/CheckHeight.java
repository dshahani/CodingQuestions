package tree;

public class CheckHeight
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
		e.left = d;
		System.out.println(calcHeight(root));
	}

	public static int calcHeight(Node root)
	{
		if (root == null)
		{
			return 0;
		}

		return Math.max(calcHeight(root.left), calcHeight(root.right)) + 1;
	}
}
