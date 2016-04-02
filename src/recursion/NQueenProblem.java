package recursion;

public class NQueenProblem
{
	// board size
	static int SIZE = 5;
	int position[] = new int[SIZE];
	int possibilities = 0;

	void placeQueens(int r, int n)
	{

		// iterate for columns
		for (int i = 0; i < n; i++)
		{
			// can I place queen in row r and column i?
			if (canPlaceQueen(r, i))
			{
				position[r] = i;
				if (r == n - 1)
				{
					printQueens(n);
				} else
				{
					placeQueens(r + 1, n);
				}
			}

		}
	}

	boolean canPlaceQueen(int r, int c)
	{
		// iterating for all the below rows : rows already having queen
		for (int i = 0; i < r; i++)
		{
			/*
			 * position[i] means in ith row queen is placed in position[i]
			 * column
			 */
			// cannot be placed in same row, or diagonal
			if (position[i] == c || (i - r) == (position[i] - c) || (i - r) == (c - position[i]))
			{
				return false;
			}
		}
		return true;
	}

	void printQueens(int n)
	{
		possibilities++;
		for (int i = 0; i < n; i++)
		{
			for (int j = 0; j < n; j++)
			{
				if (position[i] == j)
				{
					System.out.print(" Q ");
				} else
				{
					System.out.print(" * ");
				}
			}
			System.out.println("");
		}
		System.out.println("--------------------------------");
	}

	public static void main(String[] arg)
	{
		NQueenProblem obj = new NQueenProblem();
		obj.placeQueens(0, SIZE);
		System.out.println(obj.possibilities);
	}
}
