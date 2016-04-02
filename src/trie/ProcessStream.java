package trie;

/*
 * <p>Given an infinite stream of characters and a list L of strings, create a function 
 * that calls an external API when a word in L is recognized during the processing of 
 * the stream.
 * Example:
 * L = ["ok","test","one","try","trying"]
 * stream = a,b,c,o,k,d,e,f,t,r,y,i,n,g.............
 * the call to external API (let's call it some function callAPI()) would be called when the
 * 'k' is encountered, again when the 'y' is encountered, and again at 'g'.</p> 
 */

public class ProcessStream
{
	public static void main(String[] arg)
	{
		CraeteTrie trie = new CraeteTrie();
		trie.insert("ok");
		trie.insert("test");
		trie.insert("one");
		trie.insert("try");
		trie.insert("trying");

		Character[] inputStream = { 'a', 'b', 'c', 'o', 'k', 'd', 'e', 'f', 't', 'r', 'y', 'i', 'n', 'g' };

		Character c;
		TrieNode<Character> node = null;
		for (int i = 0; i < inputStream.length; i++)
		{
			c = inputStream[i];
			node = trie.search(String.valueOf(c), node);
			if (node != null && node.isLeaf)
			{
				System.out.println(c);
			}
			if (node != null && node.children.isEmpty())
			{
				node = null;
			}
		}

		StringBuffer buf = new StringBuffer();
		for (int i = 0; i < inputStream.length; i++)
		{
			buf.append(inputStream[i]);
			if (!trie.prefix(buf.toString()))
			{
				buf = new StringBuffer("");
			} else if (trie.match(buf.toString()))
			{
				System.out.println(buf.toString());
				if (!trie.hasMoreChar(buf.toString()))
				{
					buf = new StringBuffer("");
				}
			}
		}
	}

}
