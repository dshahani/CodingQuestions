package crackingthecoding;

public class stack<T>
{
	public static class Node<T>
	{
		private T data;
		private Node<T> next;

		public Node(T data)
		{
			this.data = data;
		}
	}

	private Node<T> top;

}
