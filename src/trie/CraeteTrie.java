package trie;

import java.util.Map;

public class CraeteTrie
{
	TrieNode<Character> root;

	CraeteTrie()
	{
		root = new TrieNode<Character>();
	}

	public static void main(String[] arg)
	{
		CraeteTrie obj = new CraeteTrie();
		obj.insert("turn");
		obj.insert("turning");
		System.out.println(obj.search("turn"));
	}

	public void insert(String s)
	{
		Map<Character, TrieNode<Character>> children;
		children = root.children;
		Character c;
		TrieNode<Character> newNode;
		for (int i = 0; i < s.length(); i++)
		{
			c = s.charAt(i);
			if (children.containsKey(c))
			{
				newNode = children.get(c);
			} else
			{
				newNode = new TrieNode<Character>(c);
				children.put(c, newNode);
			}
			children = newNode.children;

			if (i == s.length() - 1)
			{
				newNode.isLeaf = true;
			}
		}
	}

	public boolean match(String s)
	{
		TrieNode<Character> node = search(s);
		if (node != null && node.isLeaf)
		{
			return true;
		} else
		{
			return false;
		}
	}

	public boolean prefix(String s)
	{
		TrieNode<Character> node = search(s);
		if (node != null)
		{
			return true;
		} else
			return false;

	}

	public boolean hasMoreChar(String s)
	{
		TrieNode<Character> node = search(s);
		if (node != null && !node.children.isEmpty())
		{
			return true;
		} else
		{
			return false;
		}
	}

	private TrieNode<Character> search(String s)
	{
		Character c;
		Map<Character, TrieNode<Character>> children = root.children;
		TrieNode<Character> nextLevel = null;
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

	public TrieNode<Character> search(String s, TrieNode<Character> startNode)
	{
		if (startNode == null)
		{
			startNode = root;
		}
		Character c;
		Map<Character, TrieNode<Character>> children = startNode.children;
		TrieNode<Character> nextLevel = null;
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
}
