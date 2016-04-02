package crackingthecoding;

import java.util.Arrays;

public class mergeSort
{
	static int[] input = { 2, 5, 8, 9, 10, 15, 2, 2, 3, 5, 5, 11 };// { 3, 4, 1,
																	// 6, 7, 2,
																	// 9,
	// 10, 11
	// };
	int[] tempArr = new int[input.length];

	public static void main(String[] arg)
	{
		mergeSort obj = new mergeSort();
		// obj.doMerge(0, obj.input.length - 1);
		for (int ele : obj.input)
		{
			// System.out.println(ele);
		}

		input = removeDups(input);
		for (int ele : obj.input)
		{
			System.out.println(ele);
		}

	}

	public void doMerge(int lowerIndex, int higherIndex)
	{
		int mid = lowerIndex + (higherIndex - lowerIndex) / 2;
		if (lowerIndex < higherIndex)
		{
			doMerge(lowerIndex, mid);
			doMerge(mid + 1, higherIndex);
			combine(lowerIndex, mid, higherIndex);
		}
	}

	public void combine(int low, int mid, int high)
	{
		for (int i = low; i <= high; i++)
		{
			tempArr[i] = input[i];
		}
		int i = low;
		int j = mid + 1;
		int k = low;
		while (i <= mid && j <= high)
		{
			if (tempArr[i] > tempArr[j])
			{
				input[k] = tempArr[i];
				i++;
			} else
			{
				input[k] = tempArr[j];
				j++;
			}
			k++;
		}

		while (i <= mid)
		{
			input[k] = tempArr[i];
			k++;
			i++;
		}

	}

	public static void doMerge(int[] arr, int lowerIndex, int higherIndex)
	{
		int mid = lowerIndex + (higherIndex - lowerIndex) / 2;
		if (lowerIndex < higherIndex)
		{
			doMerge(arr, lowerIndex, mid);
			doMerge(arr, mid + 1, higherIndex);
			combine(arr, lowerIndex, mid, higherIndex);
		}
	}

	public static void combine(int[] input, int low, int mid, int high)
	{
		int[] tempArr = new int[input.length];
		for (int i = low; i <= high; i++)
		{
			tempArr[i] = input[i];
		}
		int i = low;
		int j = mid + 1;
		int k = low;
		while (i <= mid && j <= high)
		{
			if (tempArr[i] > tempArr[j])
			{
				input[k] = tempArr[i];
				i++;
			} else
			{
				input[k] = tempArr[j];
				j++;
			}
			k++;
		}

		while (i <= mid)
		{
			input[k] = tempArr[i];
			k++;
			i++;
		}

	}

	static int[] removeDups(int[] arr)
	{
		doMerge(arr, 0, arr.length - 1);

		if (arr.length < 2)
			return arr;

		int j = 0;
		int i = 1;

		while (i < arr.length)
		{
			if (arr[i] == arr[j])
			{
				i++;
			} else
			{
				j++;
				arr[j] = arr[i];
				i++;
			}
		}

		int[] B = Arrays.copyOf(arr, j + 1);

		return B;

	}

}
