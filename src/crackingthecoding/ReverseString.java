package crackingthecoding;

public class ReverseString
{
	public static void main(String[] arg)
	{
		String str = "This is a test";
		reverseRec(str.toCharArray(), 0, str.length() - 1);
		reverseSentence("This is a sentence.");
	}

	public static void reverseSentence(String str)
	{
		int size = str.length();
		char[] sent = str.toCharArray();
		if (str.charAt(size - 1) == '.')
		{
			size--;
		}

		reverse(sent, 0, size);
		int startIndex = 0;

		for (int i = 0; i < size; i++)
		{
			if (sent[i] == ' ')
			{
				reverse(sent, startIndex, i);
				startIndex = i + 1;
			}
		}
		reverse(sent, startIndex, size);

		for (char c : sent)
		{
			System.out.print(c);
		}

	}

	public static void reverse(char[] sent, int startIndex, int endIndex)
	{
		if (startIndex + 1 == endIndex)
		{
			return;
		}
		char temp;
		int index = 1;
		for (int i = startIndex; i < (startIndex + endIndex) / 2; i++)
		{
			temp = sent[i];
			sent[i] = sent[endIndex - index];
			sent[endIndex - index] = temp;
			index++;
		}
	}

	public static String reverse(String str)
	{

		/*
		 * String[] strArr = S.split(" "); StringBuffer buf = new
		 * StringBuffer(""); for (int i = 0; i < strArr.length; i++) {
		 * buf.append(reverse(strArr[i]) + " "); } return
		 * buf.deleteCharAt(buf.length() - 1).toString();
		 */

		char[] sent = str.toCharArray();
		int endIndex = sent.length - 1;
		char temp;
		int index = 1;
		for (int i = 0; i < sent.length / 2; i++)
		{
			temp = sent[i];
			sent[i] = sent[endIndex - index];
			sent[endIndex - index] = temp;
			index++;
		}
		return String.valueOf(sent);
	}

	private static void reverseRec(char[] s, int start, int end)
	{

		if (start >= end)
		{
			System.out.println("Reversed String " + String.valueOf(s));
			return;
		}

		char temp = s[start];
		s[start] = s[end];
		s[end] = temp;
		reverseRec(s, start + 1, end - 1);

	}
}
