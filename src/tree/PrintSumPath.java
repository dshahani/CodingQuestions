package tree;

import java.util.ArrayList;

public class PrintSumPath
{

	public static void main(String[] args)
	{
		Node root = new Node(-4);
		Node a = new Node(2);
		Node b = new Node(3);
		Node c = new Node(3);
		Node d = new Node(1);
		Node e = new Node(2);
		// TreeNode f = new TreeNode(3);
		root.left = a;
		root.right = b;
		a.left = c;
		a.right = d;
		b.left = e;
		// b.right = f;
		// printSumPath(root, 0, 6, new StringBuffer(""));
		// System.out.println(validateSumTree(root));
		findSum(root, 6, new ArrayList<Integer>(), 0);
	}

	public static void printSumPath(Node root, int currentSum, int requiredSum, StringBuffer buf)
	{
		if (root == null)
		{
			return;
		}
		buf.append(root.value + ",");
		currentSum += root.value;
		if (currentSum == requiredSum)
		{
			System.out.println(buf.toString());
		}
		printSumPath(root.left, currentSum, requiredSum, buf);
		printSumPath(root.right, currentSum, requiredSum, buf);
		printSumPath(root.left, 0, requiredSum, new StringBuffer(""));
		printSumPath(root.right, 0, requiredSum, new StringBuffer(""));
	}

	static void findSum(Node head, int sum, ArrayList<Integer> buffer, int level)
	{
		if (head == null)
			return;
		int tmp = sum;
		buffer.add(head.value);
		for (int i = level; i > -1; i--)
		{
			tmp -= buffer.get(i);
			if (tmp == 0)
				print(buffer, i, level);
		}
		ArrayList<Integer> c1 = (ArrayList<Integer>) buffer.clone();
		ArrayList<Integer> c2 = (ArrayList<Integer>) buffer.clone();
		printLst(c1);
		printLst(c2);
		findSum(head.left, sum, c1, level + 1);
		findSum(head.right, sum, c2, level + 1);
	}

	static void print(ArrayList<Integer> buffer, int level, int i2)
	{
		for (int i = level; i <= i2; i++)
		{
			System.out.print(buffer.get(i).toString() + " ");
		}
		System.out.println();
	}

	static void printLst(ArrayList<Integer> buffer)
	{
		for (Integer t : buffer)
		{
			System.out.print(t + " ");
		}
		System.out.println();
	}
}
