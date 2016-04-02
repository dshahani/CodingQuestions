package crackingthecoding;

public class ReverseNumber
{

	public static void main(String[] args)
	{
		String number = "12345";
		int len = number.length();
		int reverse = 0;
		for (int i = len - 1; i >= 0; i--)
		{
			reverse += Integer.parseInt((String.valueOf(number.charAt(i)))) * Math.pow(10, i);
		}
		System.out.println(reverse);
	}

}
