package dynamicprogramming;

public class LargestIncreasingSubArr
{

	public static void main(String[] args)
	{
		int[] arr = { 1, 2, 1, 3, 2, 3, 6, 8, 6 };
		// { 1, 2, 1, 1, 2, 3, 6, 8, 6 }
		System.out.println(increasingSubArr(arr));
	}

	public static int increasingSubArr(int[] m)
	{
		int n = m.length;
		int[] opt = new int[n];
		int[] p = new int[n];
		for (int i = 0; i < n; i++)
		{
			opt[i] = 1;
		}

		for (int i = 2; i < n; i++)
		{
			for (int j = 1; j < i; j++)
			{
				if (m[j] < m[i])
				{
					if (opt[i] < (opt[j] + 1))
					{
						opt[i] = opt[j] + 1;
						p[i] = j;
					} else
					{
						p[i] = i;
					}

				}
			}
		}

		for (int i = 0; i < n; i++)
		{
			System.out.print(opt[i] + " \t");
		}
		System.out.println("");
		for (int i = 0; i < n; i++)
		{
			System.out.print(p[i] + " \t");
		}

		System.out.println("");
		int max = -1, index = -1;
		for (int i = 0; i < n; i++)
		{
			if (max < opt[i])
			{
				max = opt[i];
				index = i;
			}
		}

		/*
		 * for (int i = index; i >=0; i--) { for(int j=i;j) }
		 */

		System.out.println(index);

		return max;
	}

}
