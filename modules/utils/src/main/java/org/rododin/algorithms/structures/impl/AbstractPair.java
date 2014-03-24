/*
 * AbstractPair.java
 */

package org.rododin.algorithms.structures.impl;

import org.rododin.algorithms.structures.Pair;

/**
 * Description.
 * @author Rod Odin
 */
public abstract class AbstractPair <First, Second>
  implements Pair <First, Second>
{
  @Override
  public boolean equals(final Object o)
  {
    if (this == o)
      return true;
    if (o == null || getClass() != o.getClass())
      return false;

    final First first = getFirst();
    final Second second = getSecond();
    final AbstractPair that = (AbstractPair) o;
    final Object thatFirst = that.getFirst();
    final Object thatSecond = that.getSecond();

    if (first != null ? !first.equals(thatFirst) : thatFirst != null)
      return false;
    if (second != null ? !second.equals(thatSecond) : thatSecond != null)
      return false;

    return true;
  }

  @Override
  public int hashCode()
  {
    final First first = getFirst();
    final Second second = getSecond();

    int result = first != null ? first.hashCode() : 0;
    result = 31 * result + (second != null ? second.hashCode() : 0);
    return result;
  }

  @Override
  public String toString()
  {
    final First first = getFirst();
    final Second second = getSecond();

    final StringBuilder sb = new StringBuilder();
    sb.append("<").append(first);
    sb.append(", ").append(second);
    sb.append('>');
    return sb.toString();
  }
}
