package crackingthecoding;

public class CountSort
{

	public static void main(String[] args)
	{
		int[] arr = { 2, 3, 1, 9, 6, 7, 1, 4, 3, 2, 6, 7, 3, 1, 8 };
		countSort(arr, 9);
	}

	public static void countSort(int[] arr, int max)
	{
		int[] sort = new int[max + 1];

		for (int i = 0; i < arr.length; i++)
		{
			sort[arr[i]]++;
		}

		for (int i = 0; i < sort.length; i++)
		{
			int j = sort[i];
			for (int k = 0; k < j; k++)
			{
				System.out.print(i + "\t");
			}
		}
	}

}
