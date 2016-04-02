package recursion;

import java.util.ArrayList;

public class PatternMatching
{
	public static void main(String[] arg)
	{
		PatternMatching obj = new PatternMatching();
		ArrayList<String> arr = new ArrayList<String>();
		obj.printSymbol(arr, "", 3, 3);
		System.out.println(arr);

		ArrayList<String> genLst = new ArrayList<String>();
		obj.generatePattern(genLst, "", 3, 3);
		System.out.println(genLst);
	}

	public void generatePattern(ArrayList<String> result, String s, int left, int right)
	{
		if (left > right)
		{
			return;
		}

		if (left == 0 && right == 0)
		{
			result.add(s);
		}

		if (left > 0)
		{
			generatePattern(result, s + "(", left - 1, right);
		}

		if (right > 0)
		{
			generatePattern(result, s + ")", left, right - 1);
		}
	}

	public void printSymbol(ArrayList<String> result, String s, int left, int right)
	{
		if (left > right)
			return;

		if (left == 0 && right == 0)
		{
			result.add(s);
			return;
		}

		if (left > 0)
		{
			printSymbol(result, s + "(", left - 1, right);
		}

		if (right > 0)
		{
			printSymbol(result, s + ")", left, right - 1);
		}
	}
}
