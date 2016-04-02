package crackingthecoding;

import java.util.HashSet;
import java.util.Set;

public class LongestPalinSubseqNor
{
	public static void main(String[] arg)
	{
		LongestPalinSubseqNor obj = new LongestPalinSubseqNor();
		obj.longestPalindrome("aabac");
	}

	public boolean isPalindrome(String str)
	{
		return (str.equals(new StringBuilder(str).reverse().toString()));
	}

	public void longestPalindrome(String str)
	{
		StringBuffer subBfr;
		int maxPalin = 0;
		String palin = null;
		Set<String> palinSet = new HashSet<String>();
		for (int i = 0; i < str.length() - 1; i++)
		{
			subBfr = new StringBuffer(str.charAt(i));
			for (int j = i + 1; j < str.length(); j++)
			{
				subBfr.append(str.charAt(j));
				if (isPalindrome(subBfr.toString()))
				{
					if (subBfr.toString().length() > maxPalin)
					{
						maxPalin = subBfr.toString().length();
						palin = subBfr.toString();
					}
					palinSet.add(subBfr.toString());
				}
			}
		}
		System.out.println(palinSet);
		System.out.println(palin);
	}

}
