package crackingthecoding;

public class RemoveDuplicate
{

	public static void main(String[] args)
	{
		removeDupliate(new char[] { 'a', 'b', 'c', 'a', 'b', 'c', 'd' });
		removeDupliateBit(new char[] { 'a', 'b', 'c', 'a', 'b', 'c', 'd' });
	}

	public static void removeDupliate(char[] abc)
	{
		boolean[] charArr = new boolean[126];
		int len = abc.length;

		for (int i = 0; i < len; i++)
		{
			if (charArr[(int) abc[i]])
			{
				for (int j = i; j < len - 1; j++)
				{
					abc[j] = abc[j + 1];
				}
				abc[len - 1] = '\u0000';
				len -= 1;
				i--;
			} else
			{
				charArr[(int) abc[i]] = true;
			}
		}

		System.out.println(abc);
	}

	public static void removeDupliateBit(char[] abc)
	{
		int checker = 0, asciValue;
		int len = abc.length;
		for (int i = 0; i < len; i++)
		{
			asciValue = (int) abc[i];
			if ((checker & (1 << asciValue)) > 0)
			{
				for (int j = i; j < len - 1; j++)
				{
					abc[j] = abc[j + 1];
				}
				abc[len - 1] = '\u0000';
				len -= 1;
				i--;
			} else
			{
				checker |= (1 << asciValue);
			}
		}
		System.out.println(abc);
	}

}
