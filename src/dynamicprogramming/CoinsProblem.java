package dynamicprogramming;

public class CoinsProblem
{
	/*
	 * minimum number of coins to the given number
	 */

	public static void main(String[] arg)
	{
		System.out.println(calcCoins(11, new int[] { 1, 5, 6, 8 }));
	}

	public static int calcCoins(int n, int[] m)
	{
		int[][] coin = new int[m.length][n + 1];
		for (int i = 0; i <= n; i++)
		{
			coin[0][i] = i;
		}

		for (int i = 1; i < m.length; i++)
		{
			for (int j = 0; j <= n; j++)
			{
				if (m[i] <= j)
				{
					coin[i][j] = Math.min(coin[i - 1][j], coin[i - 1][j - m[i]] + 1);
				} else
				{
					coin[i][j] = coin[i - 1][j];
				}
			}
		}

		printCoins(coin, n, m);
		return coin[m.length - 1][n];
	}

	public static void printCoins(int[][] coin, int n, int[] m)
	{
		int i = coin.length - 1, j = coin[0].length - 1;
		while (n != 0)
		{
			if (coin[i][j] == coin[i - 1][j])
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

};