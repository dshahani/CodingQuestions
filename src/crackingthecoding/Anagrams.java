package crackingthecoding;

import java.util.HashMap;
import java.util.Map;

public class Anagrams
{
	public static void main(String[] arg)
	{
		findAnagram("cat", "tac");
	}

	public static void findAnagram(String str1, String str2)
	{
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		int value;
		char key;
		boolean anagram = true;
		for (int i = 0; i < str1.length(); i++)
		{
			key = str1.charAt(i);
			if (map.containsKey(key))
			{
				value = map.get(key);
				map.put(key, value + 1);
			} else
			{
				map.put(key, 1);
			}
		}

		for (int i = 0; i < str2.length(); i++)
		{
			key = str2.charAt(i);
			if (map.containsKey(key))
			{
				value = map.get(key);
				map.put(key, value - 1);
			} else
			{
				anagram = false;
				break;
			}
		}

		for (char c : map.keySet())
		{
			if (map.get(c) != 0)
			{
				anagram = false;
				break;
			}
		}

		if (!anagram)
		{
			System.out.println("Strings are not anagram");
		} else
		{
			System.out.println("Strings are anagram");
		}
	}

}
