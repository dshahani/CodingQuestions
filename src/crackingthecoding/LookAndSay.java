package crackingthecoding;

public class LookAndSay
{
	public static void main(String[] args)
	{
		invokeLookSay("1", 4);
	}

	public static void invokeLookSay(String str, int rounds)
	{
		for (int i = 0; i < rounds; i++)
		{
			str = lookSay(str);
			System.out.println(str);
		}

	}

	public static String lookSay(String str)
	{
		StringBuffer buf = new StringBuffer("");
		if (str.isEmpty())
		{
			return "";
		}
		char firstChar = str.charAt(0);
		int charIndex = 0, len;
		for (int i = 0; i < str.length(); i++)
		{
			if (str.charAt(i) != firstChar)
			{
				len = str.substring(charIndex, i).length();
				buf.append(String.valueOf(len) + firstChar);
				firstChar = str.charAt(i);
				charIndex = i;
			}
		}
		len = str.substring(charIndex, str.length()).length();
		buf.append(String.valueOf(len) + firstChar);
		return buf.toString();
	}

}
