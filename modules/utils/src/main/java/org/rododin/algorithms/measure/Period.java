/*
 * Period.java
 */

package org.rododin.algorithms.measure;

import java.util.Date;
import java.util.concurrent.atomic.AtomicLong;

import org.rododin.algorithms.utils.DateTimeUtils;

/**
 * Description.
 * @author Rod Odin
 */
public final class Period
{
  private final AtomicLong startTime = new AtomicLong();
  private final AtomicLong stopTime  = new AtomicLong();

  public void start()
  {
    startTime.compareAndSet(0, System.currentTimeMillis());
  }

  public void stop()
  {
    stopTime.compareAndSet(0, System.currentTimeMillis());
  }

  public long getStartTime()
  {
    return startTime.get();
  }

  public long getStopTime()
  {
    return stopTime.get();
  }

  public long getLength()
  {
    final long startTime = this.startTime.get();
    final long stopTime  = this.stopTime .get();
    return startTime != 0L && stopTime != 0L ? stopTime - startTime : 0L;
  }

  @Override
  public boolean equals(final Object o)
  {
    if (this == o)
      return true;
    if (o == null || getClass() != o.getClass())
      return false;

    final Period period = (Period) o;

    if (!startTime.equals(period.startTime))
      return false;
    if (!stopTime.equals(period.stopTime))
      return false;

    return true;
  }

  @Override
  public int hashCode()
  {
    int result = startTime.hashCode();
    result = 31 * result + stopTime.hashCode();
    return result;
  }

  @Override
  public String toString()
  {
    final StringBuilder sb = new StringBuilder(getClass().getSimpleName());
    sb.append("{startTime=").append(DateTimeUtils.fromDateTime(new Date(startTime.get())));
    sb.append(", stopTime=" ).append(DateTimeUtils.fromDateTime(new Date(stopTime .get())));
    sb.append(", length=").append(lengthToString(getLength(), " ", ", ", "ms", "s", "m", "h", "d", "y"));
    sb.append('}');
    return sb.toString();
  }

  /**
   * Convert the given time period <code>length</code> to string representation.
   * @param length the time period length to be converted
   * @param sep1 the separator between values and units
   * @param sep2 the separator between unit groups
   * @param units the precision time units starting from milliseconds, e.g. [ms, secs, mins, hours, days]
   * @return non-<code>null</code> and non-empty string representing the given time period length, e.g. "2 days, 5 hours, 7 mins, 3 secs, 198 ms"
   */
  public static String lengthToString(long length, final String sep1, final String sep2, final String... units)
  {
    if (units == null || units.length == 0)
      return Long.toString(length);

    final long[] unitDividers = new long[] {1000L, 60L, 60L, 24L, 365L};
    final StringBuilder rv = new StringBuilder();
    for (int i = 0; i < unitDividers.length && length > 0; i++)
    {
      final StringBuilder unitGroupStr = new StringBuilder();
      final long unitValue = units.length > i + 1 ? length % unitDividers[i] : units.length > i ? length : -1;
      if (unitValue >= 0)
        unitGroupStr.append(unitValue).append(sep1).append(units[i]).append(rv.length() > 0 ? sep2 : "");
      length /= unitDividers[i];
      rv.insert(0, unitGroupStr);
    }
    if (length > 0 && units.length > unitDividers.length)
    {
      final StringBuilder unitGroupStr = new StringBuilder();
      unitGroupStr.append(length).append(sep1).append(units[unitDividers.length]).append(rv.length() > 0 ? sep2 : "");
      rv.insert(0, unitGroupStr);
    }
    return rv.toString();

    //final String ms    = units.length > 1 ? length % 1000L + " " + units[0] : units.length > 0 ? length + " " + units[0] : Long.toString(length); // "1234567890"       "1234567890 ms"      "890 ms"                     "890 ms"                             "890 ms"                                      "890 ms"
    //length /= 1000;
    //final String secs  = units.length > 2 ? length %   60L + " " + units[1] : units.length > 1 ? length + " " + units[1] : "";                    // ""                 ""                   "1234567 secs"               "7 secs"                             "7 secs"                                      "7 secs"
    //length /= 60;
    //final String mins  = units.length > 3 ? length %   60L + " " + units[2] : units.length > 2 ? length + " " + units[2] : "";                    // ""                 ""                   ""                           "20576 mins"                         "56 mins"                                     "56 mins"
    //length /= 60;
    //final String hours = units.length > 4 ? length %   24L + " " + units[3] : units.length > 3 ? length + " " + units[3] : "";                    // ""                 ""                   ""                           ""                                   "342 hours"                                   "6 hours"
    //length /= 24;
    //final String days  = units.length > 5 ? length %  365L + " " + units[4] : units.length > 4 ? length + " " + units[4] : "";                    // ""                 ""                   ""                           ""                                   ""                                            "14 days"
    //length /= 365;
    //final String years =                                                      units.length > 5 ? length + " " + units[5] : "";                    // ""                 ""                   ""                           ""                                   ""                                            ""
  }
}
