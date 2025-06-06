package org.rododin.algorithms.measure;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.rododin.algorithms.structures.Pair;

/**
 * Introduces a set of unit tests for the {@link ComputationComplexity} enumeration.
 * Generally it tests the {@link ComputationComplexity#estimate(long, long) ComputationComplexity.estimate(...)} methods.
 * @author Nikolay Chebotaryov
 */
public class ComputationComplexityTest
{
	@Test
	public void testSingle_O_1()
	{
		Assert.assertEquals(ComputationComplexity.O_1, ComputationComplexity.estimate(            0, 0));
		Assert.assertEquals(ComputationComplexity.O_1, ComputationComplexity.estimate(            0, 1));
		Assert.assertEquals(ComputationComplexity.O_1, ComputationComplexity.estimate(            1, 0));
		Assert.assertEquals(ComputationComplexity.O_1, ComputationComplexity.estimate(            1, 1));
		Assert.assertEquals(ComputationComplexity.O_1, ComputationComplexity.estimate(           10, 1));
		Assert.assertEquals(ComputationComplexity.O_1, ComputationComplexity.estimate(          100, 1));
		Assert.assertEquals(ComputationComplexity.O_1, ComputationComplexity.estimate(        1_024, 1));
		Assert.assertEquals(ComputationComplexity.O_1, ComputationComplexity.estimate(    1_048_576, 1));
		Assert.assertEquals(ComputationComplexity.O_1, ComputationComplexity.estimate(2_147_483_647, 1)); // MAX_INT
	}

	@Test
	public void testSingle_O_LogN()
	{
		Assert.assertEquals(ComputationComplexity.O_LogN, ComputationComplexity.estimate(            4,  2));
		Assert.assertEquals(ComputationComplexity.O_LogN, ComputationComplexity.estimate(            5,  2));
		Assert.assertEquals(ComputationComplexity.O_LogN, ComputationComplexity.estimate(            7,  2));
		Assert.assertEquals(ComputationComplexity.O_LogN, ComputationComplexity.estimate(            8,  3));
		Assert.assertEquals(ComputationComplexity.O_LogN, ComputationComplexity.estimate(           15,  3));
		Assert.assertEquals(ComputationComplexity.O_LogN, ComputationComplexity.estimate(           16,  4));
		Assert.assertEquals(ComputationComplexity.O_LogN, ComputationComplexity.estimate(           17,  4));
		Assert.assertEquals(ComputationComplexity.O_LogN, ComputationComplexity.estimate(          255,  7));
		Assert.assertEquals(ComputationComplexity.O_LogN, ComputationComplexity.estimate(          256,  8));
		Assert.assertEquals(ComputationComplexity.O_LogN, ComputationComplexity.estimate(          257,  8));
		Assert.assertEquals(ComputationComplexity.O_LogN, ComputationComplexity.estimate(        1_023,  9));
		Assert.assertEquals(ComputationComplexity.O_LogN, ComputationComplexity.estimate(        1_024, 10));
		Assert.assertEquals(ComputationComplexity.O_LogN, ComputationComplexity.estimate(        1_025, 10));
		Assert.assertEquals(ComputationComplexity.O_LogN, ComputationComplexity.estimate(    1_048_575, 19));
		Assert.assertEquals(ComputationComplexity.O_LogN, ComputationComplexity.estimate(    1_048_576, 20));
		Assert.assertEquals(ComputationComplexity.O_LogN, ComputationComplexity.estimate(    1_048_577, 20));
		Assert.assertEquals(ComputationComplexity.O_LogN, ComputationComplexity.estimate(1_073_741_823, 29));
		Assert.assertEquals(ComputationComplexity.O_LogN, ComputationComplexity.estimate(1_073_741_824, 30));
		Assert.assertEquals(ComputationComplexity.O_LogN, ComputationComplexity.estimate(1_073_741_825, 30));
		Assert.assertEquals(ComputationComplexity.O_LogN, ComputationComplexity.estimate(2_147_483_647, 30)); // MAX_INT
	}

	@Test
	public void testSingle_O_Ndiv2()
	{
		Assert.assertEquals(ComputationComplexity.O_Ndiv2, ComputationComplexity.estimate(            6,             3));
		Assert.assertEquals(ComputationComplexity.O_Ndiv2, ComputationComplexity.estimate(            7,             3));
		Assert.assertEquals(ComputationComplexity.O_Ndiv2, ComputationComplexity.estimate(            9,             4));
		Assert.assertEquals(ComputationComplexity.O_Ndiv2, ComputationComplexity.estimate(           10,             5));
		Assert.assertEquals(ComputationComplexity.O_Ndiv2, ComputationComplexity.estimate(           11,             5));
		Assert.assertEquals(ComputationComplexity.O_Ndiv2, ComputationComplexity.estimate(           99,            49));
		Assert.assertEquals(ComputationComplexity.O_Ndiv2, ComputationComplexity.estimate(          100,            50));
		Assert.assertEquals(ComputationComplexity.O_Ndiv2, ComputationComplexity.estimate(         1023,           511));
		Assert.assertEquals(ComputationComplexity.O_Ndiv2, ComputationComplexity.estimate(         1024,           512));
		Assert.assertEquals(ComputationComplexity.O_Ndiv2, ComputationComplexity.estimate(    1_048_575,       524_287));
		Assert.assertEquals(ComputationComplexity.O_Ndiv2, ComputationComplexity.estimate(    1_048_576,       524_288));
		Assert.assertEquals(ComputationComplexity.O_Ndiv2, ComputationComplexity.estimate(2_147_483_647, 1_073_741_823)); // MAX_INT
	}

	@Test
	public void testSingle_O_N()
	{
		Assert.assertEquals(ComputationComplexity.O_N, ComputationComplexity.estimate(            8,             5));
		Assert.assertEquals(ComputationComplexity.O_N, ComputationComplexity.estimate(            8,             6));
		Assert.assertEquals(ComputationComplexity.O_N, ComputationComplexity.estimate(            8,             7));
		Assert.assertEquals(ComputationComplexity.O_N, ComputationComplexity.estimate(            8,             8));
		Assert.assertEquals(ComputationComplexity.O_N, ComputationComplexity.estimate(        1_024,         1_023));
		Assert.assertEquals(ComputationComplexity.O_N, ComputationComplexity.estimate(        1_024,         1_024));
		Assert.assertEquals(ComputationComplexity.O_N, ComputationComplexity.estimate(        1_025,         1_024));
		Assert.assertEquals(ComputationComplexity.O_N, ComputationComplexity.estimate(    1_048_576,     1_048_575));
		Assert.assertEquals(ComputationComplexity.O_N, ComputationComplexity.estimate(    1_048_576,     1_048_576));
		Assert.assertEquals(ComputationComplexity.O_N, ComputationComplexity.estimate(    1_048_577,     1_048_576));
		Assert.assertEquals(ComputationComplexity.O_N, ComputationComplexity.estimate(2_147_483_647, 2_147_483_646));
		Assert.assertEquals(ComputationComplexity.O_N, ComputationComplexity.estimate(2_147_483_647, 2_147_483_647)); // MAX_INT
	}

	@Test
	public void testSingle_O_Nx2()
	{
		Assert.assertEquals(ComputationComplexity.O_Nx2, ComputationComplexity.estimate(            7 ,            14 ));
		Assert.assertEquals(ComputationComplexity.O_Nx2, ComputationComplexity.estimate(            8 ,            16 ));
		Assert.assertEquals(ComputationComplexity.O_Nx2, ComputationComplexity.estimate(            9 ,            17 ));
		Assert.assertEquals(ComputationComplexity.O_Nx2, ComputationComplexity.estimate(            9 ,            18 ));
		Assert.assertEquals(ComputationComplexity.O_Nx2, ComputationComplexity.estimate(        1_023 ,         2_046 ));
		Assert.assertEquals(ComputationComplexity.O_Nx2, ComputationComplexity.estimate(        1_024 ,         2_047 ));
		Assert.assertEquals(ComputationComplexity.O_Nx2, ComputationComplexity.estimate(        1_024 ,         2_048 ));
		Assert.assertEquals(ComputationComplexity.O_Nx2, ComputationComplexity.estimate(    1_048_576 ,     2_097_152 ));
		Assert.assertEquals(ComputationComplexity.O_Nx2, ComputationComplexity.estimate(2_147_483_647 , 4_294_967_294L)); // MAX_INT
		Assert.assertEquals(ComputationComplexity.O_Nx2, ComputationComplexity.estimate(2_147_483_648L, 4_294_967_296L)); // Over MAX_INT
	}

	@Test
	public void testSingle_O_NxLogN()
	{
		Assert.assertEquals(ComputationComplexity.O_NxLogN, ComputationComplexity.estimate(    7,     15));
		Assert.assertEquals(ComputationComplexity.O_NxLogN, ComputationComplexity.estimate(    7,     19));
		Assert.assertEquals(ComputationComplexity.O_NxLogN, ComputationComplexity.estimate(    8,     20));
		Assert.assertEquals(ComputationComplexity.O_NxLogN, ComputationComplexity.estimate(    8,     24));
		Assert.assertEquals(ComputationComplexity.O_NxLogN, ComputationComplexity.estimate(1_023,  2_048));
		Assert.assertEquals(ComputationComplexity.O_NxLogN, ComputationComplexity.estimate(1_024,  2_049));
		Assert.assertEquals(ComputationComplexity.O_NxLogN, ComputationComplexity.estimate(1_024, 10_240));
		Assert.assertEquals(ComputationComplexity.O_NxLogN, ComputationComplexity.estimate(1_025, 10_241));
	}

	@Test
	public void testSingle_O_Npow2div2()
	{
		Assert.assertEquals(ComputationComplexity.O_Npow2div2, ComputationComplexity.estimate(    7,      20));
		Assert.assertEquals(ComputationComplexity.O_Npow2div2, ComputationComplexity.estimate(    7,      24));
		Assert.assertEquals(ComputationComplexity.O_Npow2div2, ComputationComplexity.estimate(    8,      25));
		Assert.assertEquals(ComputationComplexity.O_Npow2div2, ComputationComplexity.estimate(1_023, 523_264));
		Assert.assertEquals(ComputationComplexity.O_Npow2div2, ComputationComplexity.estimate(1_024, 523_265));
		Assert.assertEquals(ComputationComplexity.O_Npow2div2, ComputationComplexity.estimate(1_024, 524_288));
		Assert.assertEquals(ComputationComplexity.O_Npow2div2, ComputationComplexity.estimate(1_025, 524_289));
	}

	@Test
	public void testSingle_O_Npow2()
	{
		Assert.assertEquals(ComputationComplexity.O_Npow2, ComputationComplexity.estimate(    6,        36));
		Assert.assertEquals(ComputationComplexity.O_Npow2, ComputationComplexity.estimate(    7,        37));
		Assert.assertEquals(ComputationComplexity.O_Npow2, ComputationComplexity.estimate(    7,        49));
		Assert.assertEquals(ComputationComplexity.O_Npow2, ComputationComplexity.estimate(    8,        50));
		Assert.assertEquals(ComputationComplexity.O_Npow2, ComputationComplexity.estimate(    8,        64));
		Assert.assertEquals(ComputationComplexity.O_Npow2, ComputationComplexity.estimate(1_023, 1_046_529));
		Assert.assertEquals(ComputationComplexity.O_Npow2, ComputationComplexity.estimate(1_024, 1_046_530));
		Assert.assertEquals(ComputationComplexity.O_Npow2, ComputationComplexity.estimate(1_024, 1_048_576));
		Assert.assertEquals(ComputationComplexity.O_Npow2, ComputationComplexity.estimate(1_025, 1_048_577));
	}

	@Test
	public void testSingle_O_Npow2x2()
	{
		Assert.assertEquals(ComputationComplexity.O_Npow2x2, ComputationComplexity.estimate(    6,        72));
		Assert.assertEquals(ComputationComplexity.O_Npow2x2, ComputationComplexity.estimate(    7,        73));
		Assert.assertEquals(ComputationComplexity.O_Npow2x2, ComputationComplexity.estimate(    7,        98));
		Assert.assertEquals(ComputationComplexity.O_Npow2x2, ComputationComplexity.estimate(    8,        99));
		Assert.assertEquals(ComputationComplexity.O_Npow2x2, ComputationComplexity.estimate(    8,       128));
		Assert.assertEquals(ComputationComplexity.O_Npow2x2, ComputationComplexity.estimate(1_023, 2_093_058));
		Assert.assertEquals(ComputationComplexity.O_Npow2x2, ComputationComplexity.estimate(1_024, 2_093_059));
		Assert.assertEquals(ComputationComplexity.O_Npow2x2, ComputationComplexity.estimate(1_024, 2_097_152));
		Assert.assertEquals(ComputationComplexity.O_Npow2x2, ComputationComplexity.estimate(1_025, 2_097_153));
	}

	@Test
	public void testSingle_O_Npow2xLogN()
	{
		Assert.assertEquals(ComputationComplexity.O_Npow2xLogN, ComputationComplexity.estimate(    6,         93));
		Assert.assertEquals(ComputationComplexity.O_Npow2xLogN, ComputationComplexity.estimate(    7,         99));
		Assert.assertEquals(ComputationComplexity.O_Npow2xLogN, ComputationComplexity.estimate(    7,        137));
		Assert.assertEquals(ComputationComplexity.O_Npow2xLogN, ComputationComplexity.estimate(    8,        138));
		Assert.assertEquals(ComputationComplexity.O_Npow2xLogN, ComputationComplexity.estimate(1_023,  2_538_564));
		Assert.assertEquals(ComputationComplexity.O_Npow2xLogN, ComputationComplexity.estimate(1_024,  2_538_565));
		Assert.assertEquals(ComputationComplexity.O_Npow2xLogN, ComputationComplexity.estimate(1_024, 10_485_760));
		Assert.assertEquals(ComputationComplexity.O_Npow2xLogN, ComputationComplexity.estimate(1_025, 10_485_761));
	}

	@Test
	public void testSingle_O_Npow3()
	{
		Assert.assertEquals(ComputationComplexity.O_Npow3, ComputationComplexity.estimate(    6,           216));
		Assert.assertEquals(ComputationComplexity.O_Npow3, ComputationComplexity.estimate(    7,           217));
		Assert.assertEquals(ComputationComplexity.O_Npow3, ComputationComplexity.estimate(    7,           343));
		Assert.assertEquals(ComputationComplexity.O_Npow3, ComputationComplexity.estimate(    8,           344));
		Assert.assertEquals(ComputationComplexity.O_Npow3, ComputationComplexity.estimate(1_023, 1_070_599_167));
		Assert.assertEquals(ComputationComplexity.O_Npow3, ComputationComplexity.estimate(1_024, 1_070_599_168));
		Assert.assertEquals(ComputationComplexity.O_Npow3, ComputationComplexity.estimate(1_024, 1_073_741_824));
		Assert.assertEquals(ComputationComplexity.O_Npow3, ComputationComplexity.estimate(1_025, 1_073_741_825));
	}

	@Test
	public void testSingle_O_Npow3xLogN()
	{
		Assert.assertEquals(ComputationComplexity.O_Npow3xLogN, ComputationComplexity.estimate(    6,            558 ));
		Assert.assertEquals(ComputationComplexity.O_Npow3xLogN, ComputationComplexity.estimate(    7,            559 ));
		Assert.assertEquals(ComputationComplexity.O_Npow3xLogN, ComputationComplexity.estimate(    7,            962 ));
		Assert.assertEquals(ComputationComplexity.O_Npow3xLogN, ComputationComplexity.estimate(    8,            963 ));
		Assert.assertEquals(ComputationComplexity.O_Npow3xLogN, ComputationComplexity.estimate(1_023, 10_704_482_585L));
		Assert.assertEquals(ComputationComplexity.O_Npow3xLogN, ComputationComplexity.estimate(1_024, 10_704_482_586L));
		Assert.assertEquals(ComputationComplexity.O_Npow3xLogN, ComputationComplexity.estimate(1_024, 10_737_418_240L));
		Assert.assertEquals(ComputationComplexity.O_Npow3xLogN, ComputationComplexity.estimate(1_025, 10_737_418_241L));
	}

	@Test
	public void testSingle_O_Npow4()
	{
		Assert.assertEquals(ComputationComplexity.O_Npow4, ComputationComplexity.estimate(    6,             1_296 ));
		Assert.assertEquals(ComputationComplexity.O_Npow4, ComputationComplexity.estimate(    7,             1_297 ));
		Assert.assertEquals(ComputationComplexity.O_Npow4, ComputationComplexity.estimate(    7,             2_401 ));
		Assert.assertEquals(ComputationComplexity.O_Npow4, ComputationComplexity.estimate(    8,             2_402 ));
		Assert.assertEquals(ComputationComplexity.O_Npow4, ComputationComplexity.estimate(1_023, 1_095_222_947_841L));
		Assert.assertEquals(ComputationComplexity.O_Npow4, ComputationComplexity.estimate(1_024, 1_095_222_947_841L));
		Assert.assertEquals(ComputationComplexity.O_Npow4, ComputationComplexity.estimate(1_024, 1_099_511_627_776L));
		Assert.assertEquals(ComputationComplexity.O_Npow4, ComputationComplexity.estimate(1_025, 1_099_511_627_777L));
	}

	@Test
	public void testSingle_O_2powN()
	{
		Assert.assertEquals(ComputationComplexity.O_2powN, ComputationComplexity.estimate(17,                   131_072 ));
		Assert.assertEquals(ComputationComplexity.O_2powN, ComputationComplexity.estimate(18,                   131_073 ));
		Assert.assertEquals(ComputationComplexity.O_2powN, ComputationComplexity.estimate(18,                   262_144 ));
		Assert.assertEquals(ComputationComplexity.O_2powN, ComputationComplexity.estimate(19,                   262_145 ));
		Assert.assertEquals(ComputationComplexity.O_2powN, ComputationComplexity.estimate(20,                 1_048_576 ));
		Assert.assertEquals(ComputationComplexity.O_2powN, ComputationComplexity.estimate(21,                 1_048_577 ));
		Assert.assertEquals(ComputationComplexity.O_2powN, ComputationComplexity.estimate(60, 1_152_921_504_606_846_976L));
		Assert.assertEquals(ComputationComplexity.O_2powN, ComputationComplexity.estimate(61, 1_152_921_504_606_846_977L));
	}

	@Test
	public void testSingle_O_Nfact()
	{
		Assert.assertEquals(ComputationComplexity.O_Nfact, ComputationComplexity.estimate( 7,              2_402 ));
		Assert.assertEquals(ComputationComplexity.O_Nfact, ComputationComplexity.estimate( 7,              5_040 ));
		Assert.assertEquals(ComputationComplexity.O_Nfact, ComputationComplexity.estimate( 8,              5_041 ));
		Assert.assertEquals(ComputationComplexity.O_Nfact, ComputationComplexity.estimate( 8,             40_320 ));
		Assert.assertEquals(ComputationComplexity.O_Nfact, ComputationComplexity.estimate( 9,             40_321 ));
		Assert.assertEquals(ComputationComplexity.O_Nfact, ComputationComplexity.estimate(15,  1_307_674_368_000L));
		Assert.assertEquals(ComputationComplexity.O_Nfact, ComputationComplexity.estimate(16,  1_307_674_368_001L));
		Assert.assertEquals(ComputationComplexity.O_Nfact, ComputationComplexity.estimate(16, 20_922_789_888_000L));
		Assert.assertEquals(ComputationComplexity.O_Nfact, ComputationComplexity.estimate(17, 20_922_789_888_001L));
	}

	@Test
	public void testSingle_O_NpowN()
	{
		Assert.assertEquals(ComputationComplexity.O_NpowN, ComputationComplexity.estimate( 7,         823_542 ));
		Assert.assertEquals(ComputationComplexity.O_NpowN, ComputationComplexity.estimate( 7,         823_543 ));
		Assert.assertEquals(ComputationComplexity.O_NpowN, ComputationComplexity.estimate( 8,         823_544 ));
		Assert.assertEquals(ComputationComplexity.O_NpowN, ComputationComplexity.estimate(10,   9_999_999_999L));
		Assert.assertEquals(ComputationComplexity.O_NpowN, ComputationComplexity.estimate(10,  10_000_000_000L));
		Assert.assertEquals(ComputationComplexity.O_NpowN, ComputationComplexity.estimate(11,  10_000_000_001L));
		Assert.assertEquals(ComputationComplexity.O_NpowN, ComputationComplexity.estimate(11, 285_311_670_611L));
		Assert.assertEquals(ComputationComplexity.O_NpowN, ComputationComplexity.estimate(12, 285_311_670_612L));
	}

	@Test
	public void testSingle_O_NpowNover()
	{
		Assert.assertEquals(ComputationComplexity.O_NpowNover, ComputationComplexity.estimate( 7,         823_544 ));
		Assert.assertEquals(ComputationComplexity.O_NpowNover, ComputationComplexity.estimate(10,  10_000_000_001L));
		Assert.assertEquals(ComputationComplexity.O_NpowNover, ComputationComplexity.estimate(11, 285_311_670_612L));
	}

	@Test
	public void testMultiple_O_1()
	{
		Assert.assertEquals(ComputationComplexity.O_1, ComputationComplexity.estimateO(List.of
		( Pair.of(            0L, 0L)
		, Pair.of(            0L, 1L)
		, Pair.of(            1L, 0L)
		, Pair.of(            1L, 1L)
		, Pair.of(           10L, 1L)
		, Pair.of(          100L, 1L)
		, Pair.of(        1_024L, 1L)
		, Pair.of(    1_048_576L, 1L)
		, Pair.of(2_147_483_647L, 1L)
		)));
	}

	@Test
	public void testMultiple_O_1_forced()
	{
		Assert.assertEquals(ComputationComplexity.O_1, ComputationComplexity.estimateO(List.of
		( Pair.of(            0L, 10L)
		, Pair.of(            0L, 10L)
		, Pair.of(            1L, 10L)
		, Pair.of(            1L, 10L)
		, Pair.of(           10L, 10L)
		, Pair.of(          100L, 10L)
		, Pair.of(        1_024L, 10L)
		, Pair.of(    1_048_576L, 10L)
		, Pair.of(2_147_483_647L, 10L)
		), true));
	}

	@Test
	public void testMultipleWorst_O_LogN()
	{
		Assert.assertEquals(ComputationComplexity.O_LogN, ComputationComplexity.estimateO(List.of
		( Pair.of(            0L,  0L) // Few best cases are still O(1)
		, Pair.of(            0L,  1L)
		, Pair.of(            1L,  0L)
		, Pair.of(            1L,  1L)
		, Pair.of(          255L,  4L)
		, Pair.of(        1_024L,  9L)
		, Pair.of(    1_048_576L, 20L) // The worst case
		, Pair.of(2_147_483_647L, 15L) // The most big case gives less than the previous worst one (e.g. on binary search we may find the required value less than in 31 iterations having n=2³¹ or so)
		)));
	}

	@Test
	public void testMultipleWorst_Npow2div2()
	{
		Assert.assertEquals(ComputationComplexity.O_Npow2div2, ComputationComplexity.estimateO(List.of
		( Pair.of(    5L,      10L) // Few best cases are better than the worst
		, Pair.of(  100L,      20L)
		, Pair.of(  200L,      30L)
		, Pair.of(  150L,      35L)
		, Pair.of(  500L,  10_000L)
		, Pair.of(1_000L, 490_000L) // The worst case
		, Pair.of(2_000L, 100_000L) // The other bigger cases may be randomly better
		, Pair.of(3_000L, 200_000L)
		, Pair.of(4_000L, 300_000L)
		)));
	}
}
