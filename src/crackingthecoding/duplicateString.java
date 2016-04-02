package crackingthecoding;

public class duplicateString
{
	public static void main(String[] args)
	{
		System.out.println((int) 'a');
		System.out.println((int) 'z');
		System.out.println((int) 'A');
		System.out.println((int) 'Z');
		System.out.println(1 << 0);
		System.out.println((int) 'b' - 'a');

		String in = "abcdssa";
		int checker = 0;
		for (int i = 0; i < in.length(); i++)
		{
			int mask = in.charAt(i) - 'a';
			if ((checker & (1 << mask)) > 0)
			{
				System.out.println("false");
				System.out.println("Repeated char is  " + in.charAt(i));
				break;
			}
			checker |= (1 << mask);
		}

	}

}
