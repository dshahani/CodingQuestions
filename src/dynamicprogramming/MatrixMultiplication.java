package dynamicprogramming;

public class MatrixMultiplication
{

	public static void main(String[] args)
	{
		int[] p = { 1, 2, 3, 4 };
		int n = p.length - 1;
		int[][] opt = new int[n][n];

		for (int i = 0; i < n; i++)
		{
			opt[i][i] = 0;
		}
		for (int len = 2; len <= n; len++)
		{
			for (int i = 0; i < n - len + 1; i++)
			{
				int j = i + len - 1;
				int q;
				opt[i][j] = Integer.MAX_VALUE;
				for (int k = i; k < j; k++)
				{
					q = opt[i][k] + opt[k + 1][j] + p[i] * p[k + 1] * p[j + 1];
					if (q < opt[i][j])
					{
						opt[i][j] = q;
					}
				}
			}
		}
		System.out.println(opt[0][n - 1]);
		for (int i = 0; i < n; i++)
		{
			for (int j = 0; j < n; j++)
			{
				System.out.print(opt[i][j] + "\t");
			}
			System.out.println("");
		}
	}

}
