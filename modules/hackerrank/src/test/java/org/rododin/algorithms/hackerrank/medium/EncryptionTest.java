/*
 * EncryptionTest.java
 */

package org.rododin.algorithms.hackerrank.medium;

import org.junit.Assert;
import org.junit.Test;

/**
 * Unit Test(s) for <code>{@link Encryption}</code>.
 *
 * @author Nikolay Chebotaryov (Rod Odin)
 */
public class EncryptionTest
{
	@Test
	public void test01()
	{
		Assert.assertEquals("", Encryption.printEncryption(""));
	}

	@Test
	public void test02()
	{
		Assert.assertEquals("", Encryption.printEncryption("      "));
	}

	@Test
	public void test03()
	{
		Assert.assertEquals("hae and via ecy", Encryption.printEncryption("have a nice day"));
	}

	@Test
	public void test04()
	{
		Assert.assertEquals("fto ehg ee dd", Encryption.printEncryption("feed the dog    "));
	}

	@Test
	public void test05()
	{
		Assert.assertEquals("clu hlt io", Encryption.printEncryption("  chill out  "));
	}

	@Test
	public void test06()
	{
		Assert.assertEquals("imtgdvs fearwer mayoogo anouuio ntnnlvt wttddes aohghn sseoau", Encryption.printEncryption("if man was meant to stay on the ground god would have given us roots"));
	}
}
