package crackingthecoding;

public class getSqrt
{
	public static void main(String[] arg)
	{
		int n = 26;
		System.out.println(calcSqrtV2(n, 0, n));
	}

	public static int calcSqrtV2(int n, int start, int end)
	{
		if (start > end)
		{
			int diff = Math.min(Math.abs((start * start) - n), Math.abs((end) * (end) - n));
			if (Math.abs((start * start) - n) < Math.abs((end) * (end) - n))
			{
				return calcSqrtV2(n + diff, 0, n + diff);
			} else
			{
				return calcSqrtV2(n - diff, 0, n - diff);
			}
		}

		int mid = (start + end) / 2;
		if (mid * mid == n)
		{
			return mid;
		}

		if (mid * mid > n)
		{
			return calcSqrtV2(n, start, mid - 1);
		} else
		{
			return calcSqrtV2(n, mid + 1, end);
		}
	}

	public static int calcSqrt(int n, int start, int end, int diff)
	{
		int mid = (start + end) / 2;
		if (start < end)
		{
			if (mid * mid == n)
			{
				diff = 0;
				return mid;
			} else
			{
				diff = Math.abs((mid * mid) - n);
			}

			if (mid * mid > n)
			{
				return calcSqrt(n, start, mid - 1, diff);
			} else
			{
				return calcSqrt(n, mid + 1, end, diff);
			}
		}
		System.out.println(diff);
		return mid;

	}
}
