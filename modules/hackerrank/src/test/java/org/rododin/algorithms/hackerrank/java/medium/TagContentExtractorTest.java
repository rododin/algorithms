package org.rododin.algorithms.hackerrank.java.medium;

import org.junit.Test;
import org.rododin.algorithms.hackerrank.AbstractTest;

/**
 * Unit Test(s) for <code>{@link TagContentExtractor}</code>.
 *
 * @author Nikolay Chebotaryov (Rod Odin)
 */
public class TagContentExtractorTest
	extends AbstractTest
{
	@Test
	public void testSample1()
	{
		doTest
		( stringsToStringByLine
			( "4"
			, "<h1>Nayeem loves counseling</h1>"
			, "<h1><h1>Sanjay has no watch</h1></h1><par>So wait for a while</par>"
			, "<Amee>safat codes like a ninja</amee>"
			, "<SA premium>Imtiaz has a secret crush</SA premium>"
			)
		, () -> TagContentExtractor.main(null)
		, stringsToStringByLine
			( "Nayeem loves counseling"
			, "Sanjay has no watch"
			, "So wait for a while"
			, "None"
			, "Imtiaz has a secret crush"
			)
		);
	}

	@Test
	public void testSample2()
	{
		doTest
		( stringsToStringByLine
			( "4"
			, "<h1>Nayeem loves counseling</h1>"
			, "<h1><h1>Sanjay has no watch</h1></h1><par>So wait for a while<par>"
			, "<Amee>safat codes like a ninja</amee>"
			, "<SA premium>Imtiaz has a secret crush</SA premium>"
			)
		, () -> TagContentExtractor.main(null)
		, stringsToStringByLine
			( "Nayeem loves counseling"
			, "Sanjay has no watch"
			, "None"
			, "Imtiaz has a secret crush"
			)
		);
	}

	@Test
	public void testSample3()
	{
		doTest
		( stringsToStringByLine
			( "10"
			, "<h1>some</h1>"
			, "<h1>had<h1>public</h1></h1>"
			, "<h1>had<h1>public</h1515></h1>"
			, "<h1><h1></h1></h1>"
			, "<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<"
			, ">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>"
			, "<<<<<<<<<<<<<<<<<<<<<>>>>>>>>>>>>>>>>>>>>>>>>>><<<<<<<<<<<<<<<<<<<<<<<<<<<>>>>>>>>>>>>>>>>>>>>>>>"
			, "<>hello</>"
			, "<>hello</><h>dim</h>"
			, "<>hello</><h>dim</h>>>>>"
			)
		, () -> TagContentExtractor.main(null)
		, stringsToStringByLine
			( "some"
			, "public"
			, "None"
			, "None"
			, "None"
			, "None"
			, "None"
			, "None"
			, "dim"
			, "dim"
			)
		);
	}

	@Test
	public void testSample4()
	{
		doTest
		( stringsToStringByLine
			( "1"
			, "qqoNVOmJDG@6IBDZoEmk9337LswEL&TQnLCuR`04XD%1t{G)Jmi_iNEXKwp&<iBKMbDGtF4v@coLsF1_LqgTJ3cSp& 3a~I&Q(j0h_w~Vk(oBZCL#vhYY9%c><wkjkTvAuA8Zk}n_l7Si\"-pfm`M8YE3F}4`YQyChgC3uRbyTvu>bMUGux)5n7L={M}e^`0xlSm5ce}ehiE}CJ6y0KPd~~B~ak5$PTdPGv}QnXpw6n9V8wVCVaTRTgLKkeF</wkjkTvAuA8Zk}n_l7Si\"-pfm`M8YE3F}4`YQyChgC3uRbyTvu>haZQKlWPxlRqXXkKHo=FDofc6$_S-GWA&m0zT*D~uorf_nAF^ym*U&6hGAI)s<XshvNhnnNbeVDuxRcQAgTpWZ-kqIps-@@}Uwq0J3Z06Y5mZgB9><FbTSC#F104{py9Xl6s{yi-R~}k5Fv4i1kCgmBY7P=vVj-j48xUg8x9BCxl~Y><lyxRRMqnMBGj1_d7Qqh5Ebn7 aMb{Q0Dm){9~I0DTS8BZ7+bui~)rQ\"2Yb4f>EeZWvJvHIk</XshvNhnnNbeVDuxRcQAgTpWZ-kqIps-@@}Uwq0J3Z06Y5mZgB9><BkkZV631Pnj}#%TWhZn@Y><kXjDpTvLA^tnXYb`h+cA J2"
			)
		, () -> TagContentExtractor.main(null)
		, stringsToStringByLine
			( "bMUGux)5n7L={M}e^`0xlSm5ce}ehiE}CJ6y0KPd~~B~ak5$PTdPGv}QnXpw6n9V8wVCVaTRTgLKkeF"
			)
		);
	}
}
