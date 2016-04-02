package dynamicprogramming;

// Dynamic programming : Longest palindrome sub string.

public class LongestPalindromeSubStr
{
	public static void main(String[] arg)
	{
		longestPalinSubStr("hellolle");
	}

	public static void longestPalinSubStr(String str)
	{
		int n = str.length();
		int maxLength = 0;
		int startIndex = -1;
		boolean palin[][] = new boolean[n][n];

		for (int i = 0; i < n; i++)
		{
			palin[i][i] = true;

		}

		maxLength = 1;

		for (int i = 1; i < n - 1; i++)
		{
			if (str.charAt(i) == str.charAt(i + 1))
			{
				palin[i][i + 1] = true;
				maxLength = 2;
				startIndex = i;
			} else
			{
				palin[i][i + 1] = false;
			}
		}

		for (int len = 3; len < n + 1; len++)
		{
			for (int i = 0; i < n - len + 1; i++)
			{
				int j = i + len - 1;
				if (str.charAt(i) == str.charAt(j) && palin[i + 1][j - 1])
				{
					maxLength = len;
					startIndex = i;
					palin[i][j] = true;
				} else
				{
					palin[i][j] = false;
				}
			}
		}
		// printMatrix(palin);
		System.out.println(str.substring(startIndex, startIndex + maxLength));

	}

	public static void printMatrix(boolean[][] palin)
	{
		int n = palin.length;
		for (int i = 0; i < n; i++)
		{
			for (int j = 0; j < n; j++)
			{
				System.out.print(palin[i][j] + "\t");
			}
			System.out.println("");
		}
	}

}
