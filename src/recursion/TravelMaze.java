package recursion;

// travel a maze. you cannot step on '#' and you have to reach 'G'

public class TravelMaze
{
	static int MAX_ROW = 6;
	static int MAX_COL = 6;
	static char[][] maze = new char[MAX_ROW][MAX_COL];
	// goal
	static int END_R = 5;
	static int END_C = 5;
	// start point
	static int START_R = 1;
	static int START_C = 4;

	public static void main(String args[])
	{
		TravelMaze obj = new TravelMaze();
		// creating maze : start
		maze[END_R][END_C] = 'G';
		for (int i = 1; i < 6; i++)
		{
			maze[0][i] = '#';
		}
		maze[1][5] = '#';
		for (int i = 0; i < 6; i++)
		{
			if ((i != 1) && (i != 4))
			{
				maze[2][i] = '#';
			}
		}
		for (int i = 0; i < 6; i++)
		{
			if (i != 1)
			{
				maze[3][i] = '#';
			}
		}
		maze[4][3] = '#';
		maze[4][5] = 'G';
		maze[5][0] = '#';
		maze[5][1] = '#';
		maze[5][5] = '#';
		obj.printMatrix();
		// creating maze : end

		// find path
		obj.findPath(START_R, START_C);
		System.out.println("");
		System.out.println("Path denoted by '+'");
		obj.printMatrix();
	}

	public void printMatrix()

	{
		for (int i = 0; i < MAX_ROW; i++)
		{
			for (int j = 0; j < MAX_COL; j++)
			{
				System.out.print(maze[i][j]);
			}
			System.out.println("");
		}
	}

	public boolean findPath(int r, int c)
	{
		if (MAX_ROW <= r || MAX_COL <= c)
		{
			return false;
		}

		if (maze[r][c] == '#' || maze[r][c] == '+' || maze[r][c] == '-')
		{
			return false;
		}

		if (maze[r][c] == 'G')
		{
			return true;
		}

		maze[r][c] = '+';

		if (findPath(r + 1, c))
		{
			return true;
		}
		if (findPath(r, c + 1))
		{
			return true;
		}
		if (findPath(r - 1, c))
		{
			return true;
		}
		if (findPath(r, c - 1))
		{
			return true;
		}

		maze[r][c] = '-';
		return false;
	}
}
