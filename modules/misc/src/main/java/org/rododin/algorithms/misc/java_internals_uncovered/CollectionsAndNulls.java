package org.rododin.algorithms.misc.java_internals_uncovered;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;

import org.rododin.algorithms.structures.Pair;

/**
 * Checking what collections permit {@code null}s for their elements/values and keys (in maps).
 */
public class CollectionsAndNulls
{
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
