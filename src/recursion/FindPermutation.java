package recursion;

import java.util.ArrayList;

public class FindPermutation
{

	public static void main(String[] arg)
	{
		calcPer("123".toCharArray(), 0, 2);
		ArrayList<Integer> arr = new ArrayList<Integer>();
		arr.add(1);
		arr.add(2);
		arr.add(3);
		ArrayList<ArrayList<Integer>> res = calcPer(arr, 0, 2);
		for (ArrayList<Integer> ir : res)
		{
			// System.out.println(ir);
			System.out.println("(" + ir.get(0) + "," + ir.get(1) + "," + ir.get(2) + ")");
		}
	}

	public static ArrayList<ArrayList<Integer>> clone(ArrayList<ArrayList<Integer>> arr)
	{
		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
		for (ArrayList<Integer> in : arr)
		{
			ArrayList<Integer> n = new ArrayList<Integer>();
			for (Integer i : in)
			{
				n.add(i);
			}
			res.add(n);
		}
		return res;
	}

	public static ArrayList<ArrayList<Integer>> calcPer(ArrayList<Integer> arr, int start, int end)
	{
		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
		if (start == end)
		{
			res.add(arr);
		} else
		{
			int temp;
			for (int i = start; i <= end; i++)
			{
				temp = arr.get(start);
				arr.set(start, arr.get(i));
				arr.set(i, temp);
				res.addAll(clone(calcPer(arr, start + 1, end)));
				temp = arr.get(start);
				arr.set(start, arr.get(i));
				arr.set(i, temp); // backtrack
			}
		}
		return res;
	}

	public static void calcPer(char[] charArr, int start, int end)
	{
		if (start == end)
		{
			for (char c : charArr)
				System.out.print(c);
			System.out.println("");
		} else
		{
			for (int i = start; i <= end; i++)
			{
				swap(charArr, start, i);
				calcPer(charArr, start + 1, end);
				swap(charArr, start, i); // backtrack
			}
		}

	}

	public static void swap(char[] arr, int l, int h)
	{
		char temp;
		temp = arr[l];
		arr[l] = arr[h];
		arr[h] = temp;
	}

}
