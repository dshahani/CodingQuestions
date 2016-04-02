package crackingthecoding;

public class ShiftingElemArr
{

	public static void main(String[] arg)
	{
		shiftEle(new int[] { 4, 3, 2, 1, 5, 6 }, 3);
	}

	public static int calcGcd(int a, int b)
	{
		int c = 0;
		while (b != 0)
		{
			c = a;
			a = b;
			b = c % a;
		}
		return c;
	}

	public static void shiftEle(int[] arr, int n)
	{
		int size = arr.length;
		int d = calcGcd(size, n);
		int tmp;
		for (int i = 0; i < d; i++)
		{
			tmp = arr[i];
			for (int j = i - n + size; j != i; j = (j - n + size) % size)
				arr[(j + n) % size] = arr[j];
			arr[i + n] = tmp;
		}
		System.out.println(arr);

	}
}
