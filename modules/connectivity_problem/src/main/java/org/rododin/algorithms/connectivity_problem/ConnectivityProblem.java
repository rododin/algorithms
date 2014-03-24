/*
 * ConnectivityProblem.java
 */

package org.rododin.algorithms.connectivity_problem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import org.rododin.algorithms.structures.Pair;
import org.rododin.algorithms.structures.Structures;

/**
 * Description.
 * @author Rod Odin
 */
public class ConnectivityProblem
{
  public static void main(String[] args)
  {
    if (args.length != 2)
    {
      System.err.println("Wrong arguments: " + Arrays.asList(args));
      return;
    }

    final int N;
    final int P;
    try
    {
      N = Integer.parseInt(args[0]);
      P = Integer.parseInt(args[1]);
    }
    catch (NumberFormatException x)
    {
      System.err.println("Integer arguments expected: " + Arrays.asList(args));
      return;
    }

    System.out.println("Generating random pairs, P=" + P);
    final Random R = new Random();
    final List<Pair<Integer, Integer>> pairs = new ArrayList<>(P);

    //for (int i = 0; i < P; i++)
    //{
    //  final int f = R.nextInt(N);
    //  int s;
    //  do
    //  {
    //    s = R.nextInt(N);
    //  } while (f == s);
    //
    //  final Pair<Integer, Integer> pair = Structures.createUnmodifiablePair(f, s);
    //  pairs.add(pair);
    //}
    pairs.add(Structures.createUnmodifiablePair(5, 2));
    pairs.add(Structures.createUnmodifiablePair(2, 0));
    pairs.add(Structures.createUnmodifiablePair(8, 5));
    pairs.add(Structures.createUnmodifiablePair(0, 8));
    pairs.add(Structures.createUnmodifiablePair(8, 2));
    pairs.add(Structures.createUnmodifiablePair(7, 5));
    pairs.add(Structures.createUnmodifiablePair(9, 2));
    pairs.add(Structures.createUnmodifiablePair(0, 3));
    pairs.add(Structures.createUnmodifiablePair(4, 5));
    pairs.add(Structures.createUnmodifiablePair(8, 9));

    final List<Pair<Integer, Integer>> uniquePairs = QuickFind.execute(N, pairs);

    //for (Pair<Integer, Integer> pair : uniquePairs)
    //  System.out.println(pair);

    final Iterator<Pair<Integer, Integer>> uniquePairsIterator = uniquePairs.iterator();
    Pair<Integer, Integer> uniquePair = null;
    for (int i = 0; i < P; i++)
    {
      final Pair<Integer, Integer> pair = pairs.get(i);
      if (uniquePair == null && uniquePairsIterator.hasNext())
        uniquePair = uniquePairsIterator.next();
      String uniquePairStr = null;
      if (pair.equals(uniquePair))
      {
        uniquePairStr = uniquePair.toString();
        uniquePair = null;
      }
      System.out.println(pair + "  --  " + (uniquePairStr != null ? uniquePairStr : "already connected"));
    }
  }
}
