package dynamicprogramming;

public class PossibleCoins
{

	public static void main(String[] args)
	{
		System.out.println(possibleComb(new int[] { 1, 2, 3 }, 5));
	}

	public static int possibleComb(int m[], int n)
	{
		int memo[][] = new int[m.length][n + 1];
		for (int i = 0; i < m.length; i++)
		{
			memo[i][0] = 1;
		}

		for (int i = 0; i <= n; i++)
		{
			memo[0][i] = 1;
		}

		for (int i = 1; i < m.length; i++)
		{
			for (int j = 1; j <= n; j++)
			{
				if (m[i] > j)
				{
					memo[i][j] = memo[i - 1][j];
				} else
				{
					memo[i][j] = memo[i - 1][j] + memo[i][j - m[i]];
				}
			}
		}
		return memo[m.length - 1][n];
	}

}
