package recursion;

public class PowerSet
{
	public static void main(String[] arg)
	{
		generatePowerSet(new char[] { 'a', 'b', 'c', 'd' });
		// withRec("abc", new StringBuffer(), 0);
		// printPermu("abc", 0);
	}

	public static void generatePowerSet(char[] inputArr)
	{
		int len = inputArr.length;
		int powerLen = (int) Math.pow(2, len);

		for (int i = 1; i < powerLen; i++)
		{
			for (int j = 0; j < len; j++)
			{
				if ((i & (1 << j)) > 0)
				{
					System.out.print(inputArr[j]);
				}
			}
			System.out.println("");
		}
	}

	public static void withRec(String str, StringBuffer buf, int start)
	{
		for (int i = start; i < str.length(); i++)
		{
			buf.append(str.charAt(i));
			System.out.println(buf.toString());
			withRec(str, buf, i + 1);
			buf.deleteCharAt(buf.length() - 1);
		}

	}

	public static void printPermu(String str, int start)
	{
		if (start == str.length() - 1)
		{
			System.out.println(str);
		}
		for (int i = start; i < str.length(); i++)
		{
			str = swapChar(str, start, i);
			printPermu(str, start + 1);
			str = swapChar(str, start, i);
		}
	}

	public static String swapChar(String str, int i, int j)
	{
		StringBuffer buf = new StringBuffer(str);
		char temp = buf.charAt(i);
		buf.setCharAt(i, buf.charAt(j));
		buf.setCharAt(j, temp);
		return buf.toString();
	}

}
