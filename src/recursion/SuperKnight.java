package recursion;

public class SuperKnight
{
	// board size
	static int SIZE = 5;
	int position[] = new int[SIZE];
	int maxSuperKnight = 0;
	int oldRow = -1;

	void placeQueens(int r, int n)
	{

		// iterate for columns
		for (int i = 0; i < n; i++)
		{

			if (maxSuperKnight == SIZE)
			{
				break;
			}
			// can I place queen in row r and column i?
			if (canPlaceQueen(r, i))
			{
				position[r] = i;
				if (oldRow < r)
				{
					maxSuperKnight++;
					oldRow = r;
				}
				if (r < n - 1)
				{
					placeQueens(r + 1, n);
				}
			}

		}

	}

	boolean canPlaceQueen(int r, int c)
	{

		/*
		 * position[i] means in ith row queen is placed in position[i] column
		 */

		// checking for 'L' shaped attack

		// if knight is at C1 then we cannot place another at D4'
		if (r - 1 >= 0 && c - 3 >= 0)
		{
			if (position[r - 1] == c - 3)
			{
				return false;
			}
		}

		// if knight is at C7 then we cannot place another at D4'
		if (r - 1 >= 0 && c + 3 < SIZE)
		{
			if (position[r - 1] == c + 3)
			{
				return false;
			}
		}

		// if knight is at A3 then we cannot place another at D4'
		if (r - 3 >= 0 && c - 1 >= 0)
		{
			if (position[r - 3] == c - 1)
			{
				return false;
			}
		}

		// if knight is at A5 then we cannot place another at D4'
		if (r - 3 >= 0 && c + 1 < SIZE)
		{
			if (position[r - 3] == c + 1)
			{
				return false;
			}
		}

		// we are placing knights starting from row 0 to n. So for 'L' shaped
		// attack we need to check only lower rows

		// iterating for all the below rows : rows already having queen
		for (int i = 0; i < r; i++)
		{
			// cannot be placed in same row, or diagonal
			if (position[i] == c || (i - r) == (position[i] - c) || (i - r) == (c - position[i]))
			{
				return false;
			}
		}
		return true;
	}

	public static void main(String[] arg)
	{
		SuperKnight obj = new SuperKnight();
		obj.placeQueens(0, SIZE);
		System.out.println("Maximum number of super knights can be placed are : " + obj.maxSuperKnight);
	}
}
