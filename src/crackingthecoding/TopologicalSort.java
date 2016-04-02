package crackingthecoding;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class TopologicalSort
{
	static Map<Integer, ArrayList<Integer>> map = new HashMap<Integer, ArrayList<Integer>>();
	static ArrayList<Integer> list = new ArrayList<Integer>();

	/*
	 * map contains adjacent list. Consider key as node and values as its
	 * neighbors key = 0, value = 1,2,3 node 1,2,3 is adjacent to node 0 or say
	 * employee 0 works with employee 1,2,3
	 */

	public static void main(String[] arg)
	{
		list.add(1);
		list.add(2);
		list.add(3);
		map.put(0, list);
		list = new ArrayList<Integer>();
		list.add(0);
		list.add(3);
		map.put(1, list);
		list = new ArrayList<Integer>();
		list.add(0);
		list.add(1);
		map.put(2, list);
		list = new ArrayList<Integer>();
		list.add(0);
		list.add(2);
		map.put(3, list);

		// disconnected part of graph
		list = new ArrayList<Integer>();
		list.add(5);
		list.add(6);
		map.put(4, list);

		ArrayList<Set<Integer>> t;
		t = topologicalSort();
		System.out.println(t);

	}

	/*
	 * topologicalSort returns all the possible groups.
	 */

	public static ArrayList<Set<Integer>> topologicalSort()
	{
		Set<Integer> traversed = new HashSet<Integer>();
		Set<Integer> visited;
		ArrayList<Set<Integer>> lst = new ArrayList<Set<Integer>>();
		Set<Integer> grp;
		Queue<Integer> q = new LinkedList<Integer>();
		// Takes care if graph is not connected
		for (Integer t : map.keySet())
		{
			// creates group of employees working together
			if (!traversed.contains(t))
			{
				grp = new HashSet<Integer>();
				traversed.add(t);
				q.add(t);
				visited = new HashSet<Integer>();
				while (!q.isEmpty())
				{
					int n = (int) q.poll();
					traversed.add(n);
					grp.add(n);
					for (Integer val : map.get(t))
					{
						if (!visited.contains(val))
						{
							visited.add(val);
							q.add(val);
						}
					}
				}
				lst.add(grp);
			}
		}
		return lst;

	}

}
