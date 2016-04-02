package crackingthecoding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LstOfAnagrams
{

	public static void main(String[] arg)
	{
		String[] words = { "cat", "dog", "tac", "god", "act" };
		Map<String, ArrayList<String>> map;
		map = generateAnagram(words);

		for (String word : map.keySet())
		{
			System.out.println(map.get(word));
		}

	}

	private static Map<String, ArrayList<String>> generateAnagram(String[] inpurWords)
	{
		Map<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
		String sortedWord;
		ArrayList<String> values;
		for (String word : inpurWords)
		{
			sortedWord = sort(word);
			if (map.containsKey(sortedWord))
			{
				values = map.get(sortedWord);
				values.add(word);
			} else
			{
				values = new ArrayList<String>();
				values.add(word);
				map.put(sortedWord, values);
			}
		}
		return map;
	}

	private static String sort(String word)
	{
		List<Character> sortedCharacters = new ArrayList<Character>();
		for (int i = 0; i < word.length(); i++)
		{
			sortedCharacters.add(word.charAt(i));
		}
		Collections.sort(sortedCharacters);
		StringBuilder builder = new StringBuilder();
		for (Character character : sortedCharacters)
		{
			builder.append(character);
		}
		return builder.toString();
	}

}
