package tree;

public class PathsWithSum
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub

	}

	public static int pathsWithSum(Node root, int targetSum)
	{
		if (root == null)
		{
			return 0;
		}

		int sum = 0;

		sum = pathsWithSumFrmNode(root, targetSum, 0);
		sum += pathsWithSum(root.left, targetSum);
		sum += pathsWithSum(root.right, targetSum);

		return sum;

	}

	public static int pathsWithSumFrmNode(Node root, int targetSum, int currSum)
	{
		if (root == null)
		{
			return 0;
		}

		currSum += root.value;
		int totalPath = 0;
		if (targetSum == currSum)
		{
			totalPath++;
			return totalPath;
		}

		totalPath += pathsWithSumFrmNode(root.left, targetSum, currSum);
		totalPath += pathsWithSumFrmNode(root.right, targetSum, currSum);

		return totalPath;
	}

	// Optimized - running sum

}
