package org.rododin.algorithms.hackerrank.java.medium;

import org.junit.Assert;
import org.junit.Test;

/**
 * Unit Test(s) for <code>{@link JavaMD5}</code>.
 *
 * @author Nikolay Chebotaryov (Rod Odin)
 */
public class JavaMD5Test
{
	@Test
	public void test01()
	{
		Assert.assertEquals("68e109f0f40ca72a15e05cc22786f8e6", JavaMD5.printEncodedMD5("HelloWorld"));
	}

	@Test
	public void test02()
	{
		Assert.assertEquals("2da2d1e0ce7b4951a858ed2d547ef485", JavaMD5.printEncodedMD5("Javarmi123"));
	}
}
