package heap;

public class MinHeap
{

	private int[] heap;
	private int size;
	private int maxSize;
	private static final int FRONT = 1;

	public MinHeap(int maxSize)
	{
		this.heap = new int[maxSize + 1];
		heap[0] = Integer.MIN_VALUE;
		this.size = 0;
	}

	private int getParent(int position)
	{
		return position / 2;
	}

	private int getLeftChild(int position)
	{
		return 2 * position;
	}

	private int getRightChild(int position)
	{
		return 2 * position + 1;
	}

	private void swap(int position1, int position2)
	{
		int temp = heap[position1];
		heap[position1] = heap[position2];
		heap[position2] = temp;
	}

	private boolean isLeaf(int position)
	{

		if (position > size / 2)
		{
			return true;
		}
		return false;
	}

	public void insert(int data)
	{
		heap[++size] = data;
		int currentItem = size;
		while (heap[getParent(currentItem)] > heap[currentItem])
		{
			swap(getParent(currentItem), currentItem);
			currentItem = getParent(currentItem);
		}
	}

	public int delete()
	{
		int itemPopped = heap[FRONT];
		heap[FRONT] = heap[size--];
		heapify(FRONT);
		return itemPopped;
	}

	private void heapify(int position)
	{
		if (isLeaf(position))
		{
			return;
		}

		if (heap[position] > heap[getLeftChild(position)] || heap[position] > heap[getRightChild(position)])
		{

			if (heap[getLeftChild(position)] < heap[getRightChild(position)])
			{
				swap(position, getLeftChild(position));
				heapify(getLeftChild(position));
			} else
			{
				swap(position, getRightChild(position));
				heapify(getRightChild(position));
			}
		}
	}

	@Override
	public String toString()
	{
		StringBuilder output = new StringBuilder();
		for (int i = 1; i <= size / 2; i++)
		{
			output.append("Parent :" + heap[i]);
			output.append("LeftChild : " + heap[getLeftChild(i)] + " RightChild :" + heap[getRightChild(i)])
					.append("\n");
		}
		return output.toString();
	}
}
