package dynamicprogramming;

public class LongestCommonSubSequence
{
	public static void main(String[] arg)
	{
		commonSubSeq("ABD", "ABCD");
	}

	public static void commonSubSeq(String str1, String str2)
	{
		int n = str1.length();
		int m = str2.length();
		int memo[][] = new int[n + 1][m + 1];
		for (int i = 0; i < n + 1; i++)
		{
			memo[n][0] = 0;
		}
		for (int i = 0; i < m + 1; i++)
		{
			memo[0][m] = 0;
		}

		for (int i = 1; i < n + 1; i++)
		{
			for (int j = 1; j < m + 1; j++)
			{
				if (str1.charAt(i - 1) == str2.charAt(j - 1))
				{
					memo[i][j] = 1 + memo[i - 1][j - 1];
				} else
				{
					memo[i][j] = Math.max(memo[i][j - 1], memo[i - 1][j]);
				}
			}
		}
		System.out.println(memo[n][m]);
		printMatrix(memo);
	}

	public static void printMatrix(int[][] palin)
	{
		int n = palin.length;
		for (int i = 0; i < palin.length; i++)
		{
			for (int j = 0; j < palin[0].length; j++)
			{
				System.out.print(palin[i][j] + "\t");
			}
			System.out.println("");
		}
	}

}
