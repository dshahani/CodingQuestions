package crackingthecoding;

/*
 * Write an algorithm such that if an element in an MxN matrix is 0, its entire row and
column is set to 0.
 */

public class MatrixElement
{
	public static void main(String[] arg)
	{
		int[][] A = { { 4, 0, 1 }, { 2, 1, 1 }, { 5, 3, 6 } };
		printMatrix(A);
		updateMatrix(A);
		printMatrix(A);
	}

	public static void updateMatrix(int[][] A)
	{
		int row[], col[];
		row = new int[A.length];
		col = new int[A[0].length];

		for (int i = 0; i < A.length; i++)
		{
			for (int j = 0; j < A[0].length; j++)
			{
				if (A[i][j] == 0)
				{
					row[i] = 1;
					col[j] = 1;
				}
			}

		}
		for (int i = 0; i < A.length; i++)
		{
			for (int j = 0; j < A[0].length; j++)
			{
				if (row[i] == 1 || col[j] == 1)
				{
					A[i][j] = 0;
				}
			}
		}

	}

	public static void printMatrix(int[][] palin)
	{
		int n = palin.length;
		int m = palin[0].length;
		for (int i = 0; i < n; i++)
		{
			for (int j = 0; j < m; j++)
			{
				System.out.print(palin[i][j] + "\t");
			}
			System.out.println("");
		}
		System.out.println("-------------");
	}
}
