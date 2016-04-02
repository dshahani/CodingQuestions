package recursion;

public class PossibleCoinsComb
{

	public static void main(String[] args)
	{
		int[] arr = { 2, 5, 3, 6 };

		System.out.println(findPossCom(arr, arr.length, 10));
	}

	public static int findPossCom(int[] arr, int m, int n)
	{
		if (n == 0)
			return 1;

		if (n < 0)
			return 0;

		if (m <= 0 && n > 0)
			return 0;

		return findPossCom(arr, m - 1, n) + findPossCom(arr, m, n - arr[m - 1]);
	}

}
