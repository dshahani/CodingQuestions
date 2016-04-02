package tree;

public class LowestCmnAncestorBST
{

	public static void main(String[] args)
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

		System.out.println((findLowestCmn(root, right, a)).value);
	}

	public static Node findLowestCmn(Node root, Node node1, Node node2)
	{
		Node node;
		if (root == null)
		{
			return null;
		}

		if ((root.value > node1.value && root.value < node2.value)
				|| (root.value < node1.value && root.value > node2.value))
		{
			return root;
		} else if (root.value > node1.value && root.value > node2.value)
		{
			node = findLowestCmn(root.left, node1, node2);
			if (node != null)
			{
				return node;
			}
		} else
		{
			node = findLowestCmn(root.right, node1, node2);
			if (node != null)
			{
				return node;
			}
		}
		return null;
	}

}
