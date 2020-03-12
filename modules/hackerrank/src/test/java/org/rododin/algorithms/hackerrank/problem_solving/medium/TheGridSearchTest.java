package org.rododin.algorithms.hackerrank.problem_solving.medium;

import org.junit.Assert;
import org.junit.Test;

/**
 * Unit Test(s) for <code>{@link TheGridSearch}</code>.
 *
 * @author Nikolay Chebotaryov (Rod Odin)
 */
public class TheGridSearchTest
{
	@Test
	public void test00()
	{
		Assert.assertEquals("NO", TheGridSearch.gridSearch(new String[0], new String[0]));
	}

	@Test
	public void test01()
	{
		Assert.assertEquals("YES", TheGridSearch.gridSearch(new String[]
			{ "1234567890"
			, "0987654321"
			, "1111111111"
			, "1111111111"
			, "2222222222"
			}, new String[]
			{ "876543"
			, "111111"
			, "111111"
			}));
	}

	@Test
	public void test02()
	{
		Assert.assertEquals("YES", TheGridSearch.gridSearch(new String[]
			{ "7283455864"
			, "6731158619"
			, "8988242643"
			, "3830589324"
			, "2229505813"
			, "5633845374"
			, "6473530293"
			, "7053106601"
			, "0834282956"
			, "4607924137"
			}, new String[]
			{ "9505"
			, "3845"
			, "3530"
			}));
	}

	@Test
	public void test03()
	{
		Assert.assertEquals("NO", TheGridSearch.gridSearch(new String[]
			{ "400453592126560"
			, "114213133098692"
			, "474386082879648"
			, "522356951189169"
			, "887109450487496"
			, "252802633388782"
			, "502771484966748"
			, "075975207693780"
			, "511799789562806"
			, "404007454272504"
			, "549043809916080"
			, "962410809534811"
			, "445893523733475"
			, "768705303214174"
			, "650629270887160"
			}, new String[]
			{ "99"
			, "99"
			}));
	}

	@Test
	public void test04()
	{
		Assert.assertEquals("YES", TheGridSearch.gridSearch(new String[]
			{ "400453592126560"
			, "114213133098692"
			, "474386082879648"
			, "522356951189169"
			, "887109450487496"
			, "252802633388782"
			, "502771484966748"
			, "075975207693780"
			, "511799789562806"
			, "404007454272504"
			, "549043809916080"
			, "962410809534811"
			, "445893523733475"
			, "768705303214174"
			, "650629270887160"
			}, new String[]
			{ "9"
			}));
	}
}
