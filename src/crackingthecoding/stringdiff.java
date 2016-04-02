package crackingthecoding;

public class stringdiff
{
	public static void main(String[] arg)
	{
		System.out.println(check("pale", "ple"));
		System.out.println(check("pales", "pale"));
		System.out.println(check("pale", "bale"));
		System.out.println(check("pale", "bake"));
	}

	static boolean check(String str1, String str2)
	{
		int l1, l2, diff, i = 0, j = 0;
		l1 = str1.length();
		l2 = str2.length();
		diff = Math.abs(l1 - l2);
		boolean edit, insert, delete = false;

		String lstr = (str1.length() > str2.length() ? str1 : str2);
		String shstr = (str1.length() < str2.length() ? str1 : str2);

		if (diff > 1)
		{
			return false;
		} else
		{
			while (i < str1.length() && j < str2.length())
			{
				if (str1.charAt(i) != str2.charAt(j))
				{
					if (delete)
					{
						return false;
					}
					delete = true;

					if (str1.length() == str2.length())
					{
						j++;
					}
				} else
				{
					j++;
				}
				i++;
			}
			return true;
		}
	}
}
