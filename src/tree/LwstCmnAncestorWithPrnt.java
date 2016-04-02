package tree;

public class LwstCmnAncestorWithPrnt
{

	public static void main(String[] args)
	{
		Node root = new Node(6);
		Node left = new Node(3);
		Node right = new Node(10);
		Node a = new Node(11);
		Node r1 = new Node(9);
		root.left = left;
		root.right = r1;
		left.left = right;
		left.right = a;

		System.out.println((getAncestorNode(root, right, r1)).value);
		printPath(root, a);
	}

	public static Node printPath(Node root, Node node)
	{
		if (root == null)
		{
			return null;
		}
		if (root == node)
		{
			System.out.print(root.value + "->");
			return node;
		}

		Node left = printPath(root.left, node);
		Node right = printPath(root.right, node);

		if (left != null || right != null)
		{
			System.out.print(root.value + "->");
			return root;
		} else
		{
			return null;
		}
	}

	public static Node getAncestorNode(Node root, Node node1, Node node2)
	{
		if (root == null)
		{
			return null;
		}

		if (root == node1 || root == node2)
		{
			return root;
		}

		Node leftNode, rightNode;

		leftNode = getAncestorNode(root.left, node1, node2);
		rightNode = getAncestorNode(root.right, node1, node2);

		if (leftNode != null && rightNode != null)
		{
			return root;
		}

		if (leftNode != null)
		{
			return leftNode;
		} else
		{
			return rightNode;
		}

	}

}
