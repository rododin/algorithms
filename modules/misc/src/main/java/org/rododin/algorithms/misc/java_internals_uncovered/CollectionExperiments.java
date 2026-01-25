package org.rododin.algorithms.misc.java_internals_uncovered;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Stack;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.Vector;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentSkipListMap;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.rododin.algorithms.structures.Pair;

/**
 * Checking what collections permit {@code null}s for their elements/values and keys (in maps).
 */
public class CollectionExperiments
{
	private static final Logger log = LogManager.getLogger(CollectionExperiments.class);

	public static void checkForNulls()
	{
		CollectionExperiments.checkNulls(new ArrayList<>(), 0);
		CollectionExperiments.checkNulls(new Vector<>(), 1);
		CollectionExperiments.checkNulls(new LinkedList<>(), 2);
		CollectionExperiments.checkNulls(new HashSet<>(), 3);
		CollectionExperiments.checkNulls(new LinkedHashSet<>(), 4);
		CollectionExperiments.checkNulls(new TreeSet<>(), 5);
		CollectionExperiments.checkNulls(new HashMap<>(), 6, 7, "-7-");
		CollectionExperiments.checkNulls(new LinkedHashMap<>(), 8, 9, "-9-");
		CollectionExperiments.checkNulls(new TreeMap<>(), 10, 11, "-11-");
		CollectionExperiments.checkNulls(new Hashtable<>(), 12, 13, "-13-");
		CollectionExperiments.checkNulls(new ConcurrentHashMap<>(), 14, 15, "-15-");
		CollectionExperiments.checkNulls(new Stack<>(), 16);
		CollectionExperiments.checkNulls(new ArrayDeque<>(), 17);
		CollectionExperiments.checkNulls(new ConcurrentSkipListMap<>(), 18, 19, "-19-");
		CollectionExperiments.checkNulls(new ConcurrentSkipListSet<>(), 20);
		CollectionExperiments.checkNulls(new CopyOnWriteArrayList<>(), 21);
		CollectionExperiments.checkNulls(new CopyOnWriteArraySet<>(), 21);
		CollectionExperiments.checkNulls(new ArrayBlockingQueue<>(10), 22);
		CollectionExperiments.checkNulls(new PriorityQueue<>(), 23);
	}

	public static <E> void checkNulls(Collection<E> collection, E e)
	{
		checkOperations(collection.getClass().getSimpleName(), List.of(
			Pair.of(".add(null) ", () -> collection.add(null)),
			Pair.of(".add(" + e + ") ", () -> collection.add(e)),
			Pair.of(".contains(null) ", () -> collection.contains(null)),
			Pair.of(".toString() ", collection::toString)
		));
	}

	public static <K, V> void checkNulls(Map<K, V> map, K keyForNull, K key, V value)
	{
		checkOperations(map.getClass().getSimpleName(), List.of(
			Pair.of(".put(null, null) ", () -> map.put(null, null)),
			Pair.of(".put(" + keyForNull + ", null) ", () -> map.put(key, null)),
			Pair.of(".put(" + key +", " + value + ") ", () -> map.put(key, value)),
			Pair.of(".containsKey(null) ", () -> map.containsKey(null)),
			Pair.of(".containsKey(" + keyForNull + ") ", () -> map.containsKey(keyForNull)),
			Pair.of(".containsValue(null) ", () -> map.containsValue(null)),
			Pair.of(".toString() ", map::toString)
		));
	}

	public static void checkOperations(String targetClassName, List<Pair<String, Callable<?>>> operations)
	{
		for (Pair<String, Callable<?>> opEntry : operations)
			checkOperation(targetClassName, opEntry.getFirst(), () -> opEntry.getSecond().call());
	}

	public static void checkOperation(String targetClassName, String operationInfo, Callable<?> operation)
	{
		try
		{
			final Object result = operation.call();
			System.out.println(targetClassName + operationInfo + " - PASSED: " + result);
		}
		catch (Exception x)
		{
			System.out.println(targetClassName + operationInfo + " - FAILED: " + x.getClass().getSimpleName() + ".getMessage(): " + x.getMessage());
		}
	}
}
