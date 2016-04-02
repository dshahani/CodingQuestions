package dynamicprogramming;

public class SubsetSum
{
	/*
	 * subset sum. {2,3,7,8,10} sum = 11 True {8,3} sum = 14 False
	 */

	public static void main(String[] arg)
	{
		System.out.println(findSubsetSum(new int[] { 2, 3, 7, 8, 10 }, 18));
	}

	public static boolean findSubsetSum(int[] m, int sum)
	{
		boolean[][] memo = new boolean[m.length][sum + 1];

		for (int i = 0; i < m.length; i++)
		{
			memo[i][0] = true;
		}

		for (int i = 0; i < m.length; i++)
		{
			for (int j = 1; j <= sum; j++)
			{
				if (i == 0)
				{
					if (m[i] == j)
					{
						memo[i][j] = true;
					} else
					{
						memo[i][j] = false;
					}
				} else
				{
					if (m[i] > j)
					{
						memo[i][j] = memo[i - 1][j];
					} else
					{
						memo[i][j] = (memo[i - 1][j] | memo[i - 1][j - m[i]]);
					}
				}

			}

		}

		for (int i = 0; i < memo.length; i++)
		{
			for (int j = 0; j < memo[0].length; j++)
			{
				System.out.print(memo[i][j] + "\t");
			}
			System.out.println("");

		}
		printSet(memo, sum, m);
		return (memo[m.length - 1][sum]);

	}

	public static void printSet(boolean[][] memo, int n, int[] m)
	{
		int i = memo.length - 1, j = memo[0].length - 1;
		while (n != 0)
		{
			if (i > 1 && memo[i][j] && memo[i - 1][j])
			{
				i = i - 1;
			} else
			{
				System.out.println(m[i]);
				j -= m[i];
				n -= m[i];
				i -= 1;
			}
		}
	}
}
