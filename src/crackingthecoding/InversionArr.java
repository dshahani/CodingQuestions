package crackingthecoding;

public class InversionArr
{

	Element[] input = new Element[7];
	Element[] tempArr = new Element[7];

	int[] inputArr = { 3, 4, 5, 9, 2, 1, 3 };
	int[] arr = new int[inputArr.length];

	public static void main(String[] arg)
	{
		InversionArr obj = new InversionArr();
		Element ele;
		for (int i = 0; i < obj.inputArr.length; i++)
		{
			ele = new Element();
			ele.value = obj.inputArr[i];
			obj.input[i] = ele;
		}
		obj.doMerge(0, obj.inputArr.length - 1);
		for (Element ele1 : obj.input)
		{
			System.out.println(ele1.value + " " + ele1.count);
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
			if (tempArr[i].value < tempArr[j].value)
			{
				input[k] = tempArr[i];
				input[k].count += (high - j) + 1;
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

		while (j <= high)
		{
			input[k] = tempArr[j];
			k++;
			j++;
		}

	}

	// direct inversion

	public static int doMergeInv(int lowerIndex, int higherIndex)
	{
		int inv = 0;
		int mid = lowerIndex + (higherIndex - lowerIndex) / 2;
		if (lowerIndex < higherIndex)
		{
			inv += doMergeInv(lowerIndex, mid);
			inv += doMergeInv(mid + 1, higherIndex);
			inv += combineInv(lowerIndex, mid, higherIndex);
		}
		return inv;
	}

	public static int combineInv(int low, int mid, int high)
	{
		InversionArr obj = new InversionArr();
		int inversion = 0;
		for (int i = low; i <= high; i++)
		{
			obj.arr[i] = obj.inputArr[i];
		}
		int i = low;
		int j = mid + 1;
		int k = low;
		while (i <= mid && j <= high)
		{
			if (obj.arr[i] < obj.arr[j])
			{
				obj.inputArr[k] = obj.arr[i];
				inversion += (mid - i);
				i++;
			} else
			{
				obj.inputArr[k] = obj.arr[j];
				j++;
			}
			k++;
		}

		while (i <= mid)
		{
			obj.inputArr[k] = obj.arr[i];
			k++;
			i++;
		}

		while (j <= high)
		{
			obj.inputArr[k] = obj.arr[j];
			k++;
			j++;
		}
		return inversion;

	}

}
