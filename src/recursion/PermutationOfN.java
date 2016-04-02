package recursion;

public class PermutationOfN
{

	public static void main(String[] arg)
	{
		findPermu("234", "", 0, 3);
	}

	public static void findPermu(String original, String str, int start, int end)
	{
		if (str.length() == end)
		{
			System.out.println(str);
			return;
		}

		for (int i = start; i < original.length(); i++)
		{
			str += original.charAt(i);
			findPermu(original, str, start, end);
			str = str.substring(0, str.length() - 1);
		}
	}
}
