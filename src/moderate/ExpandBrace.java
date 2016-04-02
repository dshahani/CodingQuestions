package moderate;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.Vector;

public class ExpandBrace
{

	public static void main(String[] arg)
	{

		// String expr = "a,((a,b)o(m,n)p),b(a,c)";
		String expr = "a(b,c)o(p,q)d";
		ExpandBrace obj = new ExpandBrace();
		obj.expand(expr);
		Vector<Integer> test = new Vector<Integer>();
		List lst = new ArrayList();
		Stack<String> stck = new Stack<String>();
	}

	public String expand(String expr)
	{
		char current;
		String str = "";
		String finalStr = "";
		int index = 0;
		for (int i = 0; i < expr.length();)
		{
			current = expr.charAt(i++);

			if (current == '(')
			{
				StringBuffer buf = new StringBuffer();
				index = evaluate(buf, multiply(str, expr.substring(index, i - 1)), i, expr);
				i = index;
				str = buf.toString();
			}

			if (current == ',')
			{
				if (expr.charAt(i - 2) != ')')
				{
					str = multiply(str, String.valueOf(expr.charAt(i - 2)));
				}
				if (!finalStr.isEmpty() && finalStr.charAt(finalStr.length() - 1) != ',')
				{
					finalStr += ",";
				}
				finalStr += str;
				index = i;
				str = "";
			}
		}
		finalStr += multiply(str, expr.substring(index, expr.length()));
		if (finalStr.lastIndexOf(",") == finalStr.length() - 1)
		{
			System.out.println(finalStr.substring(0, finalStr.length() - 1));
		} else
		{
			System.out.println(finalStr);
		}

		return finalStr;
	}

	public int evaluate(StringBuffer buf, String str, int i, String expr)
	{
		char c;
		int index = i;
		for (; i < expr.length();)
		{
			c = expr.charAt(i++);
			if (c == ')')
			{
				buf.append(multiply(str, expr.substring(index, i - 1)));
				break;
			}

			if (c == '(')
			{
				StringBuffer buf1 = new StringBuffer();
				index = evaluate(buf1, multiply(str, expr.substring(index, i - 1)), i, expr);
				i = index;
				str = buf1.toString();
			}
		}
		return i;
	}

	public String multiply(String str1, String str2)
	{
		if (str1.isEmpty())
		{
			return str2;
		}
		if (str2.isEmpty())
		{
			return str1;
		}
		String[] str1Arr = str1.split(",");
		String[] str2Arr = str2.split(",");
		String finalStr = "";
		for (int i = 0; i < str1Arr.length; i++)
		{
			for (int j = 0; j < str2Arr.length; j++)
			{
				finalStr += str1Arr[i] + str2Arr[j] + ",";
			}
		}
		return finalStr;
	}
}
