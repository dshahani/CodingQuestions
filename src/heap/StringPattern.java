package heap;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/*
 * Input: aaabc
 * Output: abaca
 */

public class StringPattern
{

	public static void main(String[] str)
	{
		System.out.println(rearrangeStr("aaabc"));
	}

	public static String rearrangeStr(String str)
	{
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		int currVal;
		for (int i = 0; i < str.length(); i++)
		{
			if (map.containsKey(str.charAt(i)))
			{
				currVal = map.get(str.charAt(i)) + 1;
				map.put(str.charAt(i), currVal);
				if (currVal > (str.length() / 2) + 1)
				{
					return "INVALID";
				}
			} else
			{
				map.put(str.charAt(i), 1);
			}
		}

		StringBuffer buf = new StringBuffer();

		PriorityQueue<Letter> pq = new PriorityQueue<>(new Comparator<Letter>()
		{
			public int compare(Letter l1, Letter l2)
			{
				if (l1.count > l2.count)
				{
					return -1;
				} else if (l1.count < l2.count)
				{
					return 1;
				} else
				{
					return 0;
				}
			}
		});

		for (Character c : map.keySet())
		{
			pq.add(new Letter(map.get(c), c));
		}

		while (!pq.isEmpty())
		{
			Letter first = pq.poll(), second = null;

			if (!pq.isEmpty())
			{
				second = pq.poll();
			}

			buf.append(first.c);

			if (second != null)
			{
				buf.append(second.c);
				second.count = second.count - 1;
				if (second.count > 0)
				{
					pq.add(second);
				}
			}
			first.count = first.count - 1;
			if (first.count > 0)
			{
				pq.add(first);
			}
		}
		return buf.toString();
	}
}
