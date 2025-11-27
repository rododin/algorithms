package org.rododin.algorithms.hackerrank.java.medium;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

/**
 * <a href="https://www.hackerrank.com/challenges/sha-256/problem">
 *   HackerRank > Prepare > Java > Advanced > Java SHA-256
 * </a> Problem Solution.
 *
 * @author Nikolay Chebotaryov (Rod Odin)
 */
public class JavaSHA256
{
	public static void main(String[] args)
	{
		final Scanner scanner = new Scanner(System.in);
		final String str = scanner.nextLine();
		scanner.close();

		System.out.println(encodeToSHA256(str));
	}

	/**
	 * Generally this algorithm has been taken from a {@link JavaMD5#encodeToMD5 pretty old solution for MD5},
	 * I've only made a few cosmetic fixes.
	 */
	public static String encodeToSHA256(String str)
	{
		try
		{
			final MessageDigest mdAlgorithm = MessageDigest.getInstance("SHA-256");
			final byte[] messageDigest;
			synchronized (mdAlgorithm)
			{
				mdAlgorithm.reset();
				mdAlgorithm.update((str).getBytes());
				messageDigest = mdAlgorithm.digest();
			}
			final StringBuilder signature = new StringBuilder();
			for (byte aByte : messageDigest)
				signature.append(String.format("%02x", aByte));
			return signature.toString();
		}
		catch (NoSuchAlgorithmException x)
		{
			x.printStackTrace();
			return str;
		}
	}
}
