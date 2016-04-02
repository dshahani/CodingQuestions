package trie;

import java.util.HashMap;
import java.util.Map;

public class TrieNode<T>
{
	T c;
	Map<T, TrieNode<T>> children = new HashMap<T, TrieNode<T>>();
	boolean isLeaf;

	TrieNode(T c)
	{
		this.c = c;
	}

	TrieNode()
	{

	}
}
