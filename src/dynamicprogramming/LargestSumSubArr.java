package dynamicprogramming;

public class LargestSumSubArr
{
	public static void main(String[] args)
	{
		int[] arr = { -4, 2, -5, 1, 2, 3, 6, -1, 6 };
		System.out.println(findMaxSubArr(arr));
	}

	public static int findMaxSubArr(int[] inp)
	{
		int n = inp.length;
		int[] opt = new int[n];
		opt[n - 1] = inp[n - 1];

		for (int i = n - 2; i >= 0; i--)
		{
			opt[i] = Math.max(opt[i + 1] + inp[i], inp[i]);
		}

		int max = -1, index = -1;
		for (int i = 0; i < n; i++)
		{
			if (max < opt[i])
			{
				max = opt[i];
				index = i;
			}
		}
		return max;
	}
}
