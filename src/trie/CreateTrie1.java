package trie;

import java.util.Map;

public class CreateTrie1
{
	private TrieNode root;

	public static void main(String[] arg)
	{
		CreateTrie1 obj = new CreateTrie1();
		obj.insert("tea");
		obj.insert("ted");
		System.out.println(obj.search("tea"));
	}

	public CreateTrie1()
	{
		root = new TrieNode();
	}

	// Inserts a word into the trie.
	public void insert(String word)
	{
		Map<Character, TrieNode> children = root.children;

		for (int i = 0; i < word.length(); i++)
		{
			char c = word.charAt(i);

			TrieNode t;
			if (children.containsKey(c))
			{
				t = children.get(c);
			} else
			{
				t = new TrieNode(c);
				children.put(c, t);
			}

			children = t.children;

			// set leaf node
			if (i == word.length() - 1)
				t.isLeaf = true;
		}
	}

	// Returns if the word is in the trie.
	public boolean search(String word)
	{
		TrieNode t = searchNode(word);

		if (t != null && t.isLeaf)
			return true;
		else
			return false;
	}

	// Returns if there is any word in the trie
	// that starts with the given prefix.
	public boolean startsWith(String prefix)
	{
		if (searchNode(prefix) == null)
			return false;
		else
			return true;
	}

	public TrieNode searchNode(String str)
	{
		Map<Character, TrieNode> children = root.children;
		TrieNode t = null;
		for (int i = 0; i < str.length(); i++)
		{
			char c = str.charAt(i);
			if (children.containsKey(c))
			{
				t = children.get(c);
				children = t.children;
			} else
			{
				return null;
			}
		}

		return t;
	}
}
