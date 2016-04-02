package crackingthecoding;

public class LongestSum
{
	public static void main(String[] args)
	{
		int[] arr = { -4, 2, -5, 1, 2, 3, 6, -1, 6 };
		findMaxSum(arr);
	}

	public static void findMaxSum(int[] arr)
	{
		int localSum = 0, globalSum = 0;
		int start = 0, end = 0;
		for (int i = 0; i < arr.length; i++)
		{
			if (localSum < 0)
			{
				start = i;
				localSum = arr[i];
			} else
			{
				localSum += arr[i];
			}
			if (globalSum < localSum)
			{
				end = i;
				globalSum = localSum;
			}

		}
		System.out.println("Max sum is: " + globalSum);
		System.out.println("index starts at " + start + " with value " + arr[start]);
		System.out.println("index ends at " + end + " with value " + arr[end]);
	}

}
