package tree;

public class MinimalHeightTree
{
	static Node root;

	public static void main(String[] arg)
	{
		int[] arr = { 1, 2, 3, 4, 5, 6, 7 };
		Node root = createBTree(arr, 0, arr.length - 1);
		CheckHeight height = new CheckHeight();
		System.out.println(height.calcHeight(root));
	}

	public static Node createBTree(int[] elem, int start, int end)
	{
		if (start > end)
		{
			return null;
		}
		int mid = (start + end) / 2;
		Node node = new Node(elem[mid]);
		node.left = createBTree(elem, start, mid - 1);
		node.right = createBTree(elem, mid + 1, end);
		return node;
	}
}
