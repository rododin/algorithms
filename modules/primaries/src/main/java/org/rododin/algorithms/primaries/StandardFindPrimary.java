/*
 * StandardFindPrimary.java
 */

package org.rododin.algorithms.primaries;

/**
 * Description.
 * @author Rod Odin
 */
public class StandardFindPrimary
  implements FindPrimary
{
  public static final int[] FIRST_PRIMARIES = new int[] {1, 2, 3, 5, 7};
  public static final int[] NEXT_PRIMARY_ENDS = new int[] {1, 3, 7, 9};
  public static final int MAX_BASE = 2147483640;

  private int last = 1;
  private int lastBase = 10;
  private int lastOffIdx = 0;

  public int next()
  {
    if (last < FIRST_PRIMARIES[FIRST_PRIMARIES.length - 1])
    {
      for (int i = FIRST_PRIMARIES.length - 2; i >= 0; i--)
      {
        if (last == FIRST_PRIMARIES[i])
        {
          last = FIRST_PRIMARIES[i + 1];
          return last;
        }
      }
    }

    for ( ; lastBase < MAX_BASE; lastBase += 10, lastOffIdx = 0)
    {
      for (; lastOffIdx < NEXT_PRIMARY_ENDS.length; lastOffIdx++)
      {
        final int cand = lastBase + NEXT_PRIMARY_ENDS[lastOffIdx];
        if (cand > last && Utils.isPrimary(cand))
        {
          last = cand;
          return last;
        }
      }
    }

    return 0;
  }
}
