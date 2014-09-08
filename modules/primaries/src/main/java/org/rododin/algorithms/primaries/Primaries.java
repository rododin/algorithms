/*
 * Primaries.java
 */

package org.rododin.algorithms.primaries;

/**
 * Description.
 * @author Rod Odin
 */
public class Primaries
{
// The Main Routine ----------------------------------------------------------------------------------------------------

  public static void main(String[] args)
  {
    final StandardFindPrimary standardFindPrimary = new StandardFindPrimary();

    int num;
    while ((num = standardFindPrimary.next()) <= 10870)
    {
      System.out.println(num);
    }
  }
}

