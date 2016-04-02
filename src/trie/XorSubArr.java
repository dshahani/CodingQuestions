package trie;

import java.util.Map;

/*
 * Problem1: Given an array of integers, we have to find two elements whose XOR is maximum.
Solution:
Suppose we have a data structure in which can satisfy two types of queries:
1. Insert a number X
2. Given a Y, find maximum XOR of Y with all numbers that have been inserted till now.
 */

/*
 * Let's say F(L,R) is XOR of subarray from L to R.
Here we use the property that F(L,R)=F(1,R) XOR F(1,L-1). How?
Let's say our subarray with maximum XOR ended at position i. Now, we need to maximise F(L,i) ie.
 F(1,i) XOR F(1,L-1) where L<=i. Suppose, we inserted F(1,L-1) in our trie for all L<=i, then it's just problem1.
 */

public class XorSubArr
{
	static TrieNode<Integer> root;
	static int max = 4;

	public static void main(String[] args)
	{
		int[] inputArr = { 4, 6 };// { 8, 1, 2, 12, 7, 6 };
		root = new TrieNode<Integer>();
		/*
		 * for (int i = 0; i < inputArr.length; i++) { insert(inputArr[i]); }
		 * 
		 * for (int i = 0; i < inputArr.length; i++) { findMaxXOR(inputArr[i]);
		 * }
		 */

		int pre = 0;
		insert(0);
		for (int i = 0; i < inputArr.length; i++)
		{
			pre = pre ^ inputArr[i];
			insert(pre);
			findMaxXOR(pre);
		}
	}

	public static void findMaxXOR(Integer s)
	{
		Map<Integer, TrieNode<Integer>> children;
		children = root.children;
		StringBuffer buf = new StringBuffer();
		Integer c;
		TrieNode<Integer> current;
		System.out.println("\nMax XOR with key " + s);
		for (int j = max; j > 0;)
		{
			c = ((s & j) > 0 ? 0 : 1);
			j = j / 2;
			if (children.containsKey(c))
			{
				current = children.get(c);
				System.out.print(1);
			} else
			{
				current = children.get(c ^ 1);
				System.out.print(0);
			}
			children = current.children;
		}
	}

	public TrieNode<Integer> search(String s, TrieNode<Integer> startNode)
	{
		if (startNode == null)
		{
			startNode = root;
		}
		Character c;
		Map<Integer, TrieNode<Integer>> children = startNode.children;
		TrieNode<Integer> nextLevel = null;
		for (int i = 0; i < s.length(); i++)
		{
			c = s.charAt(i);
			if (children.containsKey(c))
			{
				nextLevel = children.get(c);
				children = nextLevel.children;
			} else
			{
				return null;
			}
		}
		return nextLevel;
	}

	public static void insert(Integer s)
	{
		Map<Integer, TrieNode<Integer>> children;
		children = root.children;
		Integer c;
		TrieNode<Integer> newNode = null;
		System.out.println("");

		for (int j = max; j > 0;)
		{
			c = ((s & j) > 0 ? 1 : 0);
			System.out.print(c);
			j = (int) j / 2;
			if (children.containsKey(c))
			{
				newNode = children.get(c);
			} else
			{
				newNode = new TrieNode<Integer>(c);
				children.put(c, newNode);
			}
			children = newNode.children;
		}
		newNode.isLeaf = true;
	}

}
