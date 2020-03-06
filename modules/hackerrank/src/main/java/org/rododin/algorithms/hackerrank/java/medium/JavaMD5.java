package org.rododin.algorithms.hackerrank.java.medium;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * <a href="https://www.hackerrank.com/challenges/java-md5/problem">
 *   HackerRank > Practice > Java > Advanced > Java MD5
 * </a> Problem Solution.
 *
 * @author Nikolay Chebotaryov (Rod Odin)
 */
public class JavaMD5
{
	public static String printEncodedMD5(String str)
	{
		final String rv = encodeToMD5(str);
		System.out.println(str + " -> " + rv);
		return rv;
	}

	public static String encodeToMD5(String str)
	{
		try
		{
			final MessageDigest mdAlgorithm = MessageDigest.getInstance("MD5");
			final byte messageDigest[];
			synchronized (mdAlgorithm)
			{
				mdAlgorithm.reset();
				mdAlgorithm.update((str).getBytes());
				messageDigest = mdAlgorithm.digest();
			}
			final StringBuilder signature = new StringBuilder();
			for (byte aByte : messageDigest)
				signature.append(String.format("%02x", 0xFF & aByte));
			return signature.toString();
		}
		catch (NoSuchAlgorithmException x)
		{
			x.printStackTrace();
			return str;
		}
	}
}
