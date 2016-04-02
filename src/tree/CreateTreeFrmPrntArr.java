package tree;

import java.util.ArrayList;
import java.util.HashMap;

/*Given an array that represents a tree in such a way array indexes are values in tree nodes array values give the parent node of that particular index (or node). The value of the root node index would always be -1 as there is no parent for root. Construct the standard linked representation of given Binary Tree from this given representation.

Input: parent[] = {1, 5, 5, 2, 2, -1, 3}
Output: root of below tree
          5
        /  \
       1    2
      /    / \
     0    3   4
         /
        6 
Explanation: 
Index of -1 is 5.  So 5 is root.  
5 is present at indexes 1 and 2.  So 1 and 2 are
children of 5.  
1 is present at index 0, so 0 is child of 1.
2 is present at indexes 3 and 4.  So 3 and 4 are
children of 2.  
3 is present at index 6, so 6 is child of 3.
*/

public class CreateTreeFrmPrntArr
{

	public static void main(String[] args)
	{
		Integer[] arr = { 1, 5, 5, 2, 2, -1, 3 };
		HashMap<Integer, Node> map = createBTree(arr, new HashMap<Integer, Node>(), 0);
		Node root = map.get(-1);
		printBTree(root);
	}

	public static void printBTree(Node root)
	{
		ArrayList<Node> prnt = new ArrayList<Node>();
		ArrayList<Node> lst = new ArrayList<Node>();
		lst.add(root);
		System.out.println(root.value);
		while (!lst.isEmpty())
		{
			prnt = lst;
			lst = new ArrayList<Node>();
			for (Node node : prnt)
			{
				System.out.print(node.left != null ? node.left.value + "   " : 0 + "   ");
				System.out.print(node.right != null ? node.right.value + "   " : 0 + "   ");
				if (node.left != null)
				{
					lst.add(node.left);
				}
				if (node.right != null)
				{
					lst.add(node.right);
				}

			}
			System.out.println("");
		}
	}

	public static HashMap<Integer, Node> createBTree(Integer[] arr, HashMap<Integer, Node> created,
			Integer start)
	{
		if (arr.length == created.size() + 1)
		{
			return created;
		}
		for (int i = start; i < arr.length; i++)
		{
			if (!created.containsKey(i))
			{
				if (arr[i] == -1)
				{
					Node root = new Node(i);
					created.put(i, root);
					created.put(-1, root);
					return created;
				} else if (!created.containsKey(arr[i]))
				{
					createBTree(arr, created, arr[i]);
				} else
				{
					Node prnt = created.get(arr[i]);
					Node node = new Node(i);
					if (prnt.left == null)
					{
						prnt.left = node;
					} else
					{
						prnt.right = node;
					}
					created.put(i, node);
				}
			}
		}
		return created;
	}

}
