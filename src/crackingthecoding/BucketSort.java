package crackingthecoding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BucketSort
{
	static int BUCKET_SIZE = 2;

	public static void main(String[] args)
	{
		int[] arr = { 2, 3, 1, 9, 6, 7, 1, 4, 3, 2, 6, 7, 3, 1, 8 };
		bucketSort(arr, 1, 9);
	}

	public static void bucketSort(int[] arr, int min, int max)
	{
		int bucketCount = (max - min) / BUCKET_SIZE + 1;
		List<List<Integer>> buckets = new ArrayList<List<Integer>>(bucketCount);

		for (int i = 0; i < bucketCount; i++)
		{
			buckets.add(new ArrayList<Integer>());
		}

		for (int i = 0; i < arr.length; i++)
		{
			buckets.get((arr[i] - min) / BUCKET_SIZE).add(arr[i]);
		}

		for (int i = 0; i < buckets.size(); i++)
		{
			List<Integer> bucket = buckets.get(i);
			Collections.sort(bucket);
			for (Integer t : bucket)
			{
				System.out.print(t + "\t");
			}
		}
	}
}
