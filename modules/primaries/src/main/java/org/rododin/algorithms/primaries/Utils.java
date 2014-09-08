/*
 * Utils.java
 */

package org.rododin.algorithms.primaries;

import java.util.Collection;

/**
 * Description.
 * @author Rod Odin
 */
public class Utils
{
  public static final int[] FIRST_PRIMARIES = new int[] {2, 3, 5, 7};
  public static final int[] NEXT_PRIMARY_ENDS = new int[] {1, 3, 7, 9};

  public static boolean isPrimary(int number)
  {
    //if (number <= 0)
    //  return false;
    //if (number == 1)
    //  return false;

    for (int div : FIRST_PRIMARIES)
    {
      if (number % div == 0)
        return false;
    }

    final int max = (int)Math.sqrt(number);
    for (int base = 10; base <= max; base += 10)
    {
      for (int off : NEXT_PRIMARY_ENDS)
      {
        if (number % (base + off) == 0)
          return false;
      }
    }

    return true;
  }

  public static boolean isPrimary(int number, Collection<Integer> knownPrimaries)
  {
    //if (number <= 0)
    //  return false;
    //if (number == 1)
    //  return false;

    final int max = (int)Math.sqrt(number);
    for (int div : knownPrimaries)
    {
      if (div > max)
        break;
      if (number % div == 0)
        return false;
    }
    return true;
  }
}
