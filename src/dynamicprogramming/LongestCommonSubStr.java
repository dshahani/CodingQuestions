package dynamicprogramming;

public class LongestCommonSubStr
{
	public static void main(String[] args)
	{
		longestSubStr("ABCDertyh", "PBCQertyu");
	}

	public static void longestSubStr(String str1, String str2)
	{
		int n = str1.length();
		int m = str2.length();
		int maxLength = 0;
		int memo[][] = new int[n + 1][m + 1];

		for (int i = 0; i <= n; i++)
		{
			memo[i][0] = 0;
		}

		for (int i = 0; i <= m; i++)
		{
			memo[0][m] = 0;
		}

		for (int i = 1; i <= n; i++)
		{
			for (int j = 1; j <= m; j++)
			{
				if (str1.charAt(i - 1) == str2.charAt(j - 1))
				{
					memo[i][j] = 1 + memo[i - 1][j - 1];

				} else
				{
					memo[i][j] = 0;
				}

				if (memo[i][j] > maxLength)
				{
					maxLength = memo[i][j];
				}
			}
		}

		System.out.println(maxLength);
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
