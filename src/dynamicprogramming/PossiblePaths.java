package dynamicprogramming;

public class PossiblePaths
{
	public static void main(String[] arg)
	{
		System.out.println(calcPaths(5, 6));
	}

	public static int calcPaths(int row, int col)
	{
		int[][] matrix = new int[row][col];
		for (int i = 0; i < row; i++)
		{
			matrix[i][col - 1] = 1;
		}
		for (int i = 0; i < col; i++)
		{
			matrix[row - 1][i] = 1;
		}

		for (int i = row - 2; i >= 0; i--)
		{
			for (int j = col - 2; j >= 0; j--)
			{
				matrix[i][j] = matrix[i + 1][j] + matrix[i][j + 1];
			}
		}
		printMatrix(matrix);
		return matrix[0][0];

	}

	public static void printMatrix(int[][] palin)
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
