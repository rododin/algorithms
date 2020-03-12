package org.rododin.algorithms.hackerrank.problem_solving.medium;

import org.junit.Assert;
import org.junit.Test;

/**
 * Unit Test(s) for <code>{@link BiggerIsGreater}</code>.
 *
 * @author Nikolay Chebotaryov (Rod Odin)
 */
public class BiggerIsGreaterTest
{
	@Test
	public void test01()
	{
		Assert.assertEquals("ba", BiggerIsGreater.biggerIsGreater("ab"));
		Assert.assertEquals("no answer", BiggerIsGreater.biggerIsGreater("bb"));
		Assert.assertEquals("hegf", BiggerIsGreater.biggerIsGreater("hefg"));
		Assert.assertEquals("dhkc", BiggerIsGreater.biggerIsGreater("dhck"));
		Assert.assertEquals("hcdk", BiggerIsGreater.biggerIsGreater("dkhc"));
	}

	@Test
	public void test02()
	{
		Assert.assertEquals("lmon", BiggerIsGreater.biggerIsGreater("lmno"));
		Assert.assertEquals("no answer", BiggerIsGreater.biggerIsGreater("dcba"));
		Assert.assertEquals("no answer", BiggerIsGreater.biggerIsGreater("dcbb"));
		Assert.assertEquals("acbd", BiggerIsGreater.biggerIsGreater("abdc"));
		Assert.assertEquals("abdc", BiggerIsGreater.biggerIsGreater("abcd"));
		Assert.assertEquals("fedcbabdc", BiggerIsGreater.biggerIsGreater("fedcbabcd"));
	}

	@Test
	public void test03()
	{
		Assert.assertEquals("dmyms", BiggerIsGreater.biggerIsGreater("dmsym"));
		Assert.assertEquals("zedawdvyyfumwpupuinbdbfndyehircmylbaowuptgwm", BiggerIsGreater.biggerIsGreater("zedawdvyyfumwpupuinbdbfndyehircmylbaowuptgmw"));
		Assert.assertEquals("no answer", BiggerIsGreater.biggerIsGreater("zyyxwwtrrnmlggfeb"));
		Assert.assertEquals("ocsmerkgidvddsazqxjbqlrrxcotrnfvtnlutlfcafdlwiismslaytqdbvlmcpapfbmzxmftrkkqvkpflxpezzapllerxyzlfc", BiggerIsGreater.biggerIsGreater("ocsmerkgidvddsazqxjbqlrrxcotrnfvtnlutlfcafdlwiismslaytqdbvlmcpapfbmzxmftrkkqvkpflxpezzapllerxyzlcf"));
		Assert.assertEquals("biehzcmjckznhwrfgglverxsjepquxz", BiggerIsGreater.biggerIsGreater("biehzcmjckznhwrfgglverxsezxuqpj"));
		Assert.assertEquals("rebjvsszebhehuojrkkhszxltyqfdvayusylgmgkdivzlpmmtvbsavxvydldmyms", BiggerIsGreater.biggerIsGreater("rebjvsszebhehuojrkkhszxltyqfdvayusylgmgkdivzlpmmtvbsavxvydldmsym"));
		Assert.assertEquals("unpzhmbgrsr", BiggerIsGreater.biggerIsGreater("unpzhmbgrrs"));
		Assert.assertEquals("jprfovzkdlmdcesdcpdchcwoedjchcovklhrhlzfeeptoewcqxgp", BiggerIsGreater.biggerIsGreater("jprfovzkdlmdcesdcpdchcwoedjchcovklhrhlzfeeptoewcqpxg"));
		Assert.assertEquals("ywsfmynmiylcjgrfrrmtyeeykffzkuphpajndwxjtjabey", BiggerIsGreater.biggerIsGreater("ywsfmynmiylcjgrfrrmtyeeykffzkuphpajndwxjteyjba"));
		Assert.assertEquals("dkuashjzsqd", BiggerIsGreater.biggerIsGreater("dkuashjzsdq"));
		Assert.assertEquals("gwakhcpkolybihkmxyecrdhsvycjrljajlmlqgpcnmvvkjlkvdowzdfkhi", BiggerIsGreater.biggerIsGreater("gwakhcpkolybihkmxyecrdhsvycjrljajlmlqgpcnmvvkjlkvdowzdfikh"));
	}
}

