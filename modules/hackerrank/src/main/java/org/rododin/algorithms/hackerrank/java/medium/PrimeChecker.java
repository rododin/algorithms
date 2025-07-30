package org.rododin.algorithms.hackerrank.java.medium;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.Set;

import static java.lang.System.in;

/**
 * <a href="https://www.hackerrank.com/challenges/prime-checker/problem">
 *   HackerRank > Prepare > Java > Advanced > Prime Checker
 * </a> Problem Solution.
 *
 * @author Nikolay Chebotaryov
 */
public class PrimeChecker
{
	public static void main(String[] args)
	{
		try
		{
			final BufferedReader br = new BufferedReader(new InputStreamReader(in));
			final int n1 = Integer.parseInt(br.readLine());
			final int n2 = Integer.parseInt(br.readLine());
			final int n3 = Integer.parseInt(br.readLine());
			final int n4 = Integer.parseInt(br.readLine());
			final int n5 = Integer.parseInt(br.readLine());

			final Prime ob = new Prime();
			ob.checkPrime(n1);
			ob.checkPrime(n1, n2);
			ob.checkPrime(n1, n2, n3);
			ob.checkPrime(n1, n2, n3, n4, n5);

			final Method[] methods = Prime.class.getDeclaredMethods();
			final Set<String> set = new HashSet<>();
			boolean overload = false;
			for(int i = 0; i < methods.length; i++)
			{
				if(set.contains(methods[i].getName()))
				{
					overload = true;
					break;
				}
				set.add(methods[i].getName());
			}
			if(overload)
			{
				throw new Exception("Overloading not allowed");
			}
		}
		catch(Exception x)
		{
			x.printStackTrace();
		}
	}
}

class Prime
{
	public void checkPrime(int... primeCandidates)
	{
		String pref = "";
		for (int primeCandidate : primeCandidates)
		{
			if (primeCandidate < 2)
				continue;

			if (primeCandidate == 2)
			{
				System.out.print(pref + primeCandidate);
				pref = " ";
				continue;
			}

			if (primeCandidate % 2 == 0)
				continue;

			boolean dividerFound = false;
			for (int i = 3; i < primeCandidate; i += 2)
			{
				if (primeCandidate % i == 0)
				{
					dividerFound = true;
					break;
				}
			}
			if (dividerFound)
				continue;

			System.out.print(pref + primeCandidate);
			pref = " ";
		}
		System.out.println();
	}
}
