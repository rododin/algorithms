package org.rododin.algorithms.hackerrank.java.medium;

import org.junit.Test;
import org.rododin.algorithms.hackerrank.AbstractTest;

/**
 * Unit Test(s) for <code>{@link JavaRegEx}</code>.
 *
 * @author Nikolay Chebotaryov (Rod Odin)
 */
public class JavaRegExTest
	extends AbstractTest
{
	@Test
	public void testBasic()
	{
		doTest( stringsToStringByLine("000.12.12.034", "121.234.12.12", "23.45.12.56", "00.12.123.123123.123", "000.12.234.23.23", "122.23", "Hello.IP", "567.765.23.23", ".213.123.23.32", "23.45.22.32.", "I.Am.not.an.ip")
		      , () -> JavaRegEx.main(null)
		      , booleansToStringByLine(true, true, true, false, false, false, false, false, false, false, false)
		      );
	}

	@Test
	public void testValidIps()
	{
		doTest( stringsToStringByLine("0.0.0.0", "1.1.1.1", "9.9.9.9", "10.10.10.10", "100.100.100.100", "200.200.200.200", "127.0.0.1", "192.168.0.1", "255.255.255.255", "0.10.100.255", "199.99.9.0", "0.255.127.1")
		      , () -> JavaRegEx.main(null)
		      , booleansToStringByLine(true, true, true, true, true, true, true, true, true, true, true, true)
		      );
	}

	@Test
	public void testInvalidIps()
	{
		doTest( stringsToStringByLine("", "   ", "...", " . . .", ".0.1.2", "1.2.3.", ".1.2.", "-1.2.3.4", "-1.-2.-3.-4", "1.2.3.-255", "a.b.c.d", "localhost", "256.255.255.255", "0.10.100.256", "999.99.9.0", "0.299.127.1", "0,0,0,0", "0-0-0-0", "0:0:0:0", "0 0 0 0")
		      , () -> JavaRegEx.main(null)
		      , booleansToStringByLine(false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false)
		      );
	}
}
