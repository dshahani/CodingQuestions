package crackingthecoding;

public class LongestPalinSubseq
{

	public static void main(String[] arg)
	{
		longestSeqPalin("abc", new StringBuffer(), 0);
	}

	public static void longestSeqPalin(String str, StringBuffer buf, int index)
	{
		for (int i = index; i < str.length(); i++)
		{
			buf.append(str.charAt(i));
			System.out.println(buf.toString());
			System.out.println(isPalindrome(buf.toString()));
			longestSeqPalin(str, buf, i + 1);
			buf.deleteCharAt(buf.toString().length() - 1);
		}
	}

	public static boolean isPalindrome(String str)
	{
		return str.equals(new StringBuffer(str).reverse().toString());
	}
}
