package dynamicprogramming;

/*
 * 
<p>Any non-empty string has substrings that are palindromes. For example, in the string S="hellolle", there are many of such "subparlindromes":</p>

<p>1) ellolle</p>

<p>2) ll, ll - note that these are two distinct substrings that only happen to be equal</p>

<p>3) lol and lloll</p>

<p>4) And, of course, each letter can be considered a palindrome - all 8 of them.</p>

 */

public class PureStorage
{

	public static void main(String[] arg)
	{
		longestPalinSubStr("hellolle");

	}

	public static void longestPalinSubStr(String S)
	{
		int n = S.length();
		int countPalin = 0;
		boolean palin[][] = new boolean[n][n];

		for (int i = 0; i < n; i++)
		{
			palin[i][i] = true;
			countPalin++;

		}

		for (int i = 1; i < n - 1; i++)
		{
			if (S.charAt(i) == S.charAt(i + 1))
			{
				palin[i][i + 1] = true;
				countPalin++;
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
				if (S.charAt(i) == S.charAt(j) && palin[i + 1][j - 1])
				{
					palin[i][j] = true;
					countPalin++;
				} else
				{
					palin[i][j] = false;
				}
			}
		}
		System.out.println(countPalin);
	}
}
