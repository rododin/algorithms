package org.rododin.algorithms.hackerrank.java.easy;

import org.junit.Assert;
import org.junit.Test;

/**
 * Unit Test(s) for <code>{@link JavaPrimality}</code>.
 *
 * @author Nikolay Chebotaryov (Rod Odin)
 */
public class JavaPrimalityTest
{
	@Test
	public void test1()
	{
		Assert.assertEquals("not prime", JavaPrimality.printIsProbablePrime("1"));
	}

	@Test
	public void test2()
	{
		Assert.assertEquals("prime", JavaPrimality.printIsProbablePrime("2"));
	}

	@Test
	public void test13()
	{
		Assert.assertEquals("prime", JavaPrimality.printIsProbablePrime("13"));
	}

	@Test
	public void test14()
	{
		Assert.assertEquals("not prime", JavaPrimality.printIsProbablePrime("14"));
	}

	@Test
	public void test17()
	{
		Assert.assertEquals("prime", JavaPrimality.printIsProbablePrime("17"));
	}

	@Test
	public void test19()
	{
		Assert.assertEquals("prime", JavaPrimality.printIsProbablePrime("19"));
	}

	@Test
	public void test31()
	{
		Assert.assertEquals("prime", JavaPrimality.printIsProbablePrime("31"));
	}

	@Test
	public void test2367495770217142995264827948666809233066409497699870112003149352380375124855230068487109373226251983()
	{
		Assert.assertEquals("prime", JavaPrimality.printIsProbablePrime("2367495770217142995264827948666809233066409497699870112003149352380375124855230068487109373226251983"));
	}

	@Test
	public void test2367495770217142995264827948666809233066409497699870112003149352380375124855230068487109373226251982()
	{
		Assert.assertEquals("not prime", JavaPrimality.printIsProbablePrime("2367495770217142995264827948666809233066409497699870112003149352380375124855230068487109373226251982"));
	}

	@Test
	public void test34263233064835421125264776608163440537925705997962346596977803462033841059628723()
	{
		Assert.assertEquals("prime", JavaPrimality.printIsProbablePrime("34263233064835421125264776608163440537925705997962346596977803462033841059628723"));
	}

	@Test
	public void test4901971054862853523()
	{
		Assert.assertEquals("not prime", JavaPrimality.printIsProbablePrime("4901971054862853523"));
	}

	@Test
	public void test8306193547961364862906443093104785840173353478461()
	{
		Assert.assertEquals("not prime", JavaPrimality.printIsProbablePrime("8306193547961364862906443093104785840173353478461"));
	}

	@Test
	public void test9547848065153773335707495885453566120069130270246768806790708393909999()
	{
		Assert.assertEquals("prime", JavaPrimality.printIsProbablePrime("9547848065153773335707495885453566120069130270246768806790708393909999"));
	}

	@Test
	public void test282755483533707287054752184321121345766861480697448703443857012153264407439766013042402571()
	{
		Assert.assertEquals("prime", JavaPrimality.printIsProbablePrime("282755483533707287054752184321121345766861480697448703443857012153264407439766013042402571"));
	}

	@Test
	public void test6513516734600035718300327211250928237178281758494417357560086828416863929270451437126021949850746381()
	{
		Assert.assertEquals("prime", JavaPrimality.printIsProbablePrime("6513516734600035718300327211250928237178281758494417357560086828416863929270451437126021949850746381"));
	}
}
