package org.rododin.algorithms.hackerrank.java.easy;

import org.junit.Assert;
import org.junit.Test;

/**
 * Unit Test(s) for <code>{@link JavaSubArray}</code>.
 *
 * @author Nikolay Chebotaryov (Rod Odin)
 */
public class JavaSubArrayTest
{
	@Test
	public void test00()
	{
		Assert.assertEquals(0, JavaSubArray.printNegativeSubArraysCount(new int[] {}));
	}

	@Test
	public void test01()
	{
		Assert.assertEquals(9, JavaSubArray.printNegativeSubArraysCount(new int[] {1, -2, 4, -5, 1}));
	}

	@Test
	public void test02()
	{
		Assert.assertEquals(0, JavaSubArray.printNegativeSubArraysCount(new int[] {1, 2, 3, 4, 5}));
	}

	@Test
	public void test03()
	{
		Assert.assertEquals(0, JavaSubArray.printNegativeSubArraysCount(new int[] {1, 100}));
	}

	@Test
	public void test04()
	{
		Assert.assertEquals(1, JavaSubArray.printNegativeSubArraysCount(new int[] {-1, 100}));
	}

	@Test
	public void test05()
	{
		Assert.assertEquals(953, JavaSubArray.printNegativeSubArraysCount(
			new int[] { 463,  589, -321,  164, -613,  246, -869, -889, -712, -251,
			            969, -603,   49,  185,  439,  479,  255, -660,  848,  157,
			            644,  498, -722,   82, -275, -645, -268, -255,  573,  910,
			            303,  267, -162,  487,  103, -823,  400,  612, - 61, -260,
			            732,  286,  505, - 22,   37,  443,   27,  603,  341, -904,
			           - 87, -895, -753,  314,  257,  856,  832, -695, -387,  416,
			            354,  117,  273, -275,  811, -114, -962, - 90,  868,  883,
			           -330,  467,  233,  852,  232, - 44,  831, -672, -883, -774,
			           -830,  297, -897, -860,  143,  594,  186, -988,  928,  391,
			           -812,   99,  302, -803, -422,  583,  817,  748, -619,  183,
			          }
			));
	}

	@Test
	public void test06()
	{
		Assert.assertEquals(5050, JavaSubArray.printNegativeSubArraysCount(JavaSubArray.parseArray(
				"-463 -744 -589 -405 -321 -427 -164 -581 -613 -468 -246 -685 -869 -966 -889 -217 -712 -888 -251 -859 -969 -582 -603 -658 -49 -973 -185 -241 -439 -511 -479 -902 -255 -420 -660 -576 -848 -824 -157 -461 -644 -404 -498 -513 -722 -387 -82 -434 -275 -686 -645 -597 -268 -248 -255 -669 -573 -792 -910 -364 -303 -742 -267 -910 -162 -279 -487 -362 -103 -644 -823 -747 -400 -674 -612 -474 -61 -46 -260 -689 -732 -905 -286 -353 -505 -893 -22 -78 -37 -285 -443 -341 -27 -62 -603 -541 -341 -90 -904 -796" ,
				100)));
	}

	@Test
	public void test07()
	{
		Assert.assertEquals(425, JavaSubArray.printNegativeSubArraysCount(JavaSubArray.parseArray(
				"255 -77 601 89 -993 -307 300 452 -312 400 -993 831 790 236 981 274 167 676 -134 -906 139 -537 -159 483 398 253 583 348 582 481 398 -504 459 39 650 424 511 581 303 142 -300 796 183 -609 432 33 -846 -101 421 602 -789 214 692 -971 212 752 -564 -747 -396 217 448 364 -139 304 -309 337 989 751 698 381 892 -774 34 557 231 612 -377 -677 497 -781 -944 608 21 967 787 -334 835 136 335 -4 -468 -301 -296 65 -664 -303 317 893 624 115" ,
				100)));
	}
}
