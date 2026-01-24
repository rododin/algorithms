package org.rododin.algorithms.misc;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Stack;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.Vector;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentSkipListMap;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;

import org.rododin.algorithms.Constants;
import org.rododin.algorithms.misc.java_internals_uncovered.BitDepthOverflow;
import org.rododin.algorithms.misc.java_internals_uncovered.CollectionsAndNulls;

/**
 * Just an app stub for quick testing.
 *
 * @author Nikolay Chebotaryov (Rod Odin)
 */
public class Misc
	implements Constants
{
	public static void main(String[] args)
	{
		BitDepthOverflow.someIntArithmeticCornerCases();
		checkCollections();
	}

	public static void checkCollections()
	{
		CollectionsAndNulls.checkNulls(new ArrayList<>(), 0);
		CollectionsAndNulls.checkNulls(new Vector<>(), 1);
		CollectionsAndNulls.checkNulls(new LinkedList<>(), 2);
		CollectionsAndNulls.checkNulls(new HashSet<>(), 3);
		CollectionsAndNulls.checkNulls(new LinkedHashSet<>(), 4);
		CollectionsAndNulls.checkNulls(new TreeSet<>(), 5);
		CollectionsAndNulls.checkNulls(new HashMap<>(), 6, 7, "-7-");
		CollectionsAndNulls.checkNulls(new LinkedHashMap<>(), 8, 9, "-9-");
		CollectionsAndNulls.checkNulls(new TreeMap<>(), 10, 11, "-11-");
		CollectionsAndNulls.checkNulls(new Hashtable<>(), 12, 13, "-13-");
		CollectionsAndNulls.checkNulls(new ConcurrentHashMap<>(), 14, 15, "-15-");
		CollectionsAndNulls.checkNulls(new Stack<>(), 16);
		CollectionsAndNulls.checkNulls(new ArrayDeque<> (), 17);
		CollectionsAndNulls.checkNulls(new ConcurrentSkipListMap <> (), 18, 19, "-19-");
		CollectionsAndNulls.checkNulls(new ConcurrentSkipListSet<>(), 20);
		CollectionsAndNulls.checkNulls(new CopyOnWriteArrayList <> (), 21);
		CollectionsAndNulls.checkNulls(new CopyOnWriteArraySet<>(), 21);
		CollectionsAndNulls.checkNulls(new ArrayBlockingQueue<>(10), 22);
		CollectionsAndNulls.checkNulls(new PriorityQueue<> (), 23);
	}
}
