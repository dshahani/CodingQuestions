package crackingthecoding;

public class LongestPalinSubstr
{

	public static void main(String[] args)
	{
		longestPalinSubstr("abac");

	}

	public static String expandCenter(String s, int left, int right)
	{
		while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right))
		{
			left--;
			right++;
		}
		return s.substring(left + 1, right);
	}

	public static void longestPalinSubstr(String str)
	{
		String lPalin = "", temp;
		for (int i = 0; i < str.length(); i++)
		{
			temp = expandCenter(str, i, i);
			if (temp.length() > lPalin.length())
			{
				lPalin = temp;
			}
			temp = expandCenter(str, i, i + 1);
			if (temp.length() > lPalin.length())
			{
				lPalin = temp;
			}
		}
		System.out.println(lPalin + " : " + lPalin.length());
	}

}
