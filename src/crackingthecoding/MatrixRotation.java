package crackingthecoding;

public class MatrixRotation
{

	public static void main(String[] args)
	{
		int[][] A = { { 4, 3, 1 }, { 2, 1, 1 }, { 5, 6, 3 } };
		printMatrix(A);
		swapRows(A);
		System.out.println("-------------");
		printMatrix(A);
		transpose(A);
		System.out.println("-------------");
		printMatrix(A);
	}

	public static void swapRows(int[][] arr)
	{
		int len = arr.length;
		int colLen = arr[0].length;
		int temp;
		for (int i = 0; i < len / 2; i++)
		{
			for (int j = 0; j < colLen; j++)
			{
				temp = arr[i][j];
				arr[i][j] = arr[len - i - 1][j];
				arr[len - i - 1][j] = temp;
			}

		}
	}

	public static void transpose(int[][] arr)
	{
		int len = arr.length;
		int colLen = arr[0].length;
		int temp;
		for (int i = 0; i < len; i++)
		{
			for (int j = i + 1; j < colLen; j++)
			{
				temp = arr[i][j];
				arr[i][j] = arr[j][i];
				arr[j][i] = temp;
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
	}

}
