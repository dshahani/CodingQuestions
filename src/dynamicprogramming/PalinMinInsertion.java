package dynamicprogramming;

public class PalinMinInsertion
{

	public static void main(String[] args)
	{
		String str = "DERRQEZD";

		int[][] opt = new int[str.length()][str.length()];

		for (int gap = 1; gap < str.length(); gap++)
		{
			for (int i = 0, j = gap; j < str.length(); i++, j++)
			{
				if (str.charAt(i) == str.charAt(j))
				{
					opt[i][j] = opt[i + 1][j - 1];
				} else
				{
					opt[i][j] = 1 + Math.min(opt[i + 1][j], opt[i][j - 1]);
				}
			}
		}

		System.out.println(opt[0][str.length() - 1]);

	}

}
