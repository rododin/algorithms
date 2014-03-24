/*
 * Structures.java
 */

package org.rododin.algorithms.structures;

import org.rododin.algorithms.structures.impl.StandardPair;
import org.rododin.algorithms.structures.impl.UnmodifiablePair;

/**
 * Description.
 * @author Rod Odin
 */
public final class Structures
{
  public static <First, Second> Pair<First, Second> createUnmodifiablePair(First first, Second second)
  {
    return new UnmodifiablePair<First, Second>(first, second);
  }

  public static <First, Second> Pair<First, Second> createStandardPair()
  {
    return new StandardPair<First, Second>();
  }

  public static <First, Second> Pair<First, Second> createStandardPair(First first, Second second)
  {
    return new StandardPair<First, Second>(first, second);
  }
}
