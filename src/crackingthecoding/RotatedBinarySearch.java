package crackingthecoding;

public class RotatedBinarySearch
{
	static int[] a = { 5, 6, 7, 8, 1, 2, 3, 4 };

	public static void main(String[] arg)
	{
		System.out.print(findNumber(10));
	}

	public static int findPivot(int low, int high)
	{
		int mid = (low + high) / 2;
		if (low < mid && (a[mid - 1] > a[mid]))
		{
			return (mid - 1);
		}

		if (high > mid && (a[mid] > a[mid + 1]))
		{
			return mid;
		}

		if (a[low] >= a[mid])
		{
			return findPivot(low, mid - 1);
		} else
		{
			return findPivot(mid + 1, high);
		}
	}

	public static boolean findNumber(int x)
	{
		int pivotIndex = findPivot(0, a.length);
		int index;
		if (a[pivotIndex + 1] <= x && a[a.length - 1] >= x)
		{
			index = binarySrch(x, pivotIndex + 1, a.length - 1);
		} else
		{
			index = binarySrch(x, 0, pivotIndex);
		}

		return (index >= 0);
	}

	public static int binarySrch(int x, int low, int high)
	{
		if (low > high)
		{
			return -1;
		}
		int mid = (low + high) / 2;
		if (a[mid] == x)
		{
			return mid;
		}

		if (a[mid] > x)
		{
			return binarySrch(x, low, mid - 1);
		} else
		{
			return binarySrch(x, mid + 1, high);
		}
	}
}
