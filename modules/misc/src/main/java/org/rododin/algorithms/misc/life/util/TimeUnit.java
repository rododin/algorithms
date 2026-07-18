package org.rododin.algorithms.misc.life.util;

/**
 * Introduces a specific and advanced replacement for {@link java.util.concurrent.TimeUnit} because the last one doesn't
 * cover weeks, months, years, decades, centuries and millenniums.
 * <p/>
 * It's purposed to be used together with {@link TimeAmount}.
 */
public enum TimeUnit
{
	NanoSecond ("ns", "nanos" , "nanoseconds" ),
	MicroSecond("µs", "micros", "microseconds"),
	MilliSecond("ms", "millis", "milliseconds"),
	CentiSecond("cs", "centis", "centiseconds"),
	DeciSecond ("ds", "decis" , "deciseconds" ),
	Second     ("s" , "secs"  , "seconds"     ),
	Minute     ("m" , "mins"  , "minutes"     ),
	Hour       ("h" , "hours" , "hours"       ),
	Day        ("d" , "days"  , "days"        ),
	Week       ("w" , "weeks" , "weeks"       ),
	Month      ("M" , "months", "months"      ),
	Year       ("Y" , "years", "years"        ),
	Decade     ("DC", "dcds" , "decades"      ),
	Century    ("C" , "cnts" , "centuries"    ),
	Millennium ("M" , "mlnms", "millenniums"  );

	TimeUnit(String acronym, String shortening, String plural)
	{
		this.acronym = acronym;
		this.shortening = shortening;
		this.plural = plural;
	}

	public String getAcronym()
	{
		return acronym;
	}

	public String getShortening()
	{
		return shortening;
	}

	public String getPlural()
	{
		return plural;
	}

	private final String acronym;
	private final String shortening;
	private final String plural;
}
