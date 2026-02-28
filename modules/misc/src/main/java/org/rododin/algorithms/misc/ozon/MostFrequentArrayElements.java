package org.rododin.algorithms.misc.ozon;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.TreeMap;

/**
 * Дан массив {@code arr} и число {@code k}.
 * Необходимо вернуть {@code k} самых часто встречающихся элементов массива.
 * <p>
 * <b>Пример:</b>
 * <p>
 * Input: {@code arr=[1,1,1,1,2,3,3,3,4,4]}, {@code k=3}
 * <p>
 * Output: {@code res=[1,3,4]}
 */
public class MostFrequentArrayElements
{
	public static int[] topKOnInterviewWithSyntaxMistakeFixes(int[] arr, int k)
	{
		Map<Integer, Integer> map = new HashMap<>();
		for (int e : arr)
		{
			map.compute(e, (key, value) -> value == null ? 1 : value + 1);
		}

		TreeMap<Integer, List<Integer>> m = new TreeMap<>(Comparator.reverseOrder());
		for (Map.Entry<Integer, Integer> entry : map.entrySet())
		{
			m.compute(entry.getKey(), (key, value) -> { value = value == null ? new ArrayList<>() : value; value.add(key); return value; } );
		}

		int i = 0;
		int[] res =  new int[k];
		for (Map.Entry<Integer, List<Integer>> entry : m.entrySet())
		{
			if (i >= k)
				break;
			for (int e : entry.getValue())
			{
				if (i >= k)
					break;
				res[i++] = e;
			}
		}
		return res;
	}

	public static int[] topK(int[] arr, int k)
	{
		if (k == 0 || arr == null || arr.length == 0)
			return arr;

		Map<Integer, Integer> map = new HashMap<>();
		for (int e : arr)
			map.compute(e, (key, value) -> value == null ? 1 : value + 1);

		PriorityQueue<Map.Entry<Integer, Integer>> queue = new PriorityQueue<>((entry1, entry2) -> Integer.compare(entry2.getValue(), entry1.getValue()));
		queue.addAll(map.entrySet());

		int[] res = new int[k];
		for (int i = 0; i < k; i++)
			res[i] = queue.poll().getKey();
		return res;
	}

	public List<String> topKFrequent(String[] arr, int k)
	{
		if (k == 0 || arr == null || arr.length == 0)
			return List.of();

		Map<String, Integer> map = new HashMap<>();
		for (String e : arr)
			map.compute(e, (key, value) -> value == null ? 1 : value + 1);

		final PriorityQueue<Map.Entry<String, Integer>> queue = new PriorityQueue<>((entry1, entry2) ->
		{
			int cr = Integer.compare(entry2.getValue(), entry1.getValue());
			if (cr == 0)
				cr = entry1.getKey().compareTo(entry2.getKey());
			return cr;
		});
		queue.addAll(map.entrySet());

		final List<String> res = new ArrayList<>(k);
		for (int i = 0; i < k; i++)
			res.add(queue.poll().getKey());
		return res;
	}

}
