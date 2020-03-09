package org.rododin.algorithms.hackerrank.java.easy;

import org.junit.Assert;
import org.junit.Test;

/**
 * Unit Test(s) for <code>{@link JavaAnagrams}</code>.
 *
 * @author Nikolay Chebotaryov (Rod Odin)
 */
public class JavaAnagramsTest
{
	@Test
	public void testLatin01()
	{
		Assert.assertFalse(JavaAnagrams.isAnagramLatin("anagramm", "marganaa"));
	}

	@Test
	public void testLatin02()
	{
		Assert.assertTrue(JavaAnagrams.isAnagramLatin("Hello", "hello"));
	}

	@Test
	public void testLatin03()
	{
		Assert.assertTrue(JavaAnagrams.isAnagramLatin("sakura", "arukas"));
	}

	@Test
	public void test01()
	{
		Assert.assertFalse(JavaAnagrams.isAnagram("anagramm", "marganaa"));
	}

	@Test
	public void test02()
	{
		Assert.assertFalse(JavaAnagrams.isAnagram("Hello", "hello"));
	}

	@Test
	public void test03()
	{
		Assert.assertTrue(JavaAnagrams.isAnagram("sakura", "arukas"));
	}

	@Test
	public void test04()
	{
		Assert.assertTrue(JavaAnagrams.isAnagram("aabbccddxyz1234567890++--АБВэюя", "яюэ+-xyz0987654321abcabcdd-+ВБА"));
	}
}
