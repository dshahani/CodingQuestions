package crackingthecoding;

public class QuickSort
{
	static int[] arr = { 6, 4, 1, 3, 2, 8, 10, 11, 5 };

	public static void main(String[] args)
	{
		System.out.println(kthSmallest(0, arr.length - 1, 7));
		quicksort(0, arr.length - 1);
		for (int n : arr)
		{
			System.out.print(n + "\t");
		}

	}

	public static int partition(int low, int high)
	{
		int pivot = arr[high];
		int i = low - 1, temp;
		for (int j = low; j <= high - 1; j++)
		{
			if (arr[j] < pivot)
			{
				i++;
				temp = arr[j];
				arr[j] = arr[i];
				arr[i] = temp;
			}
		}
		temp = arr[i + 1];
		arr[i + 1] = arr[high];
		arr[high] = temp;
		return i + 1;

	}

	public static void quicksort(int low, int high)
	{
		if (low < high)
		{
			int p = partition(low, high);
			quicksort(low, p - 1);
			quicksort(p + 1, high);
		}
	}

	static int kthSmallest(int l, int r, int k)
	{
		// If k is smaller than number of elements in array
		if (k > 0 && k <= r - l + 1)
		{
			// Partition the array around last element and get
			// position of pivot element in sorted array
			int pos = partition(l, r);

			// If position is same as k
			if (pos - l == k - 1)
				return arr[pos];
			if (pos - l > k - 1) // If position is more, recur for left subarray
				return kthSmallest(l, pos - 1, k);

			// Else recur for right subarray
			return kthSmallest(pos + 1, r, k - pos + l - 1);
		}

		// If k is more than number of elements in array
		return Integer.MAX_VALUE;
	}

}
