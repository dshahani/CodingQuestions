package crackingthecoding;

import java.util.LinkedHashSet;

public class backtracking
{
	static LinkedHashSet<String> sethash = new LinkedHashSet<String>();

	public static void main(String[] arg)
	{
		combine("abc", new StringBuffer(), 0);
		// System.out.println(sethash);
	}

	static void combine(String instr, StringBuffer outstr, int index)
	{
		for (int i = index; i < instr.length(); i++)
		{
			outstr.append(instr.charAt(i));
			System.out.println(outstr);
			// sethash.add(outstr.toString());
			combine(instr, outstr, i + 1);
			outstr.deleteCharAt(outstr.length() - 1);
		}
	}
}
