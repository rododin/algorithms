package org.rododin.algorithms.hackerrank.java.easy;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * <a href="https://www.hackerrank.com/challenges/java-sort/problem">
 *   HackerRank > Prepare > Java > Data Structures > Java Sort
 * </a> Problem Solution.
 *
 * @author Nikolay Chebotaryov (Rod Odin)
 */
public class JavaSort
{
	public static class Student
	{
		private final int id;
		private final String fname;
		private final double cgpa;

		public Student(int id, String fname, double cgpa)
		{
			this.id = id;
			this.fname = fname;
			this.cgpa = cgpa;
		}

		public int getId()
		{
			return id;
		}

		public String getFname()
		{
			return fname;
		}

		public double getCgpa()
		{
			return cgpa;
		}
	}

	public static void main(String[] args)
	{
		final Scanner scanner = new Scanner(System.in);
		final List<Student> studentList = new ArrayList<>();
		for (int n = Integer.parseInt(scanner.nextLine()); n > 0; n--)
		{
			final String[] studentRecord = scanner.nextLine().split("\\s");
			final int studentId = Integer.parseInt(studentRecord[0]);
			final String studentFname = studentRecord[1];
			final double studentCpga = Double.parseDouble(studentRecord[2]);
			studentList.add(new Student(studentId, studentFname, studentCpga));
		}

		scanner.close();

		studentList.sort((student1, student2) ->
		{
			final long cgpaCompRes = Math.round(Math.signum(student2.getCgpa() - student1.getCgpa()));
			if (cgpaCompRes != 0L)
					return (int)cgpaCompRes;

			final int nameCompRes = student1.getFname().compareTo(student2.getFname());
			if (nameCompRes != 0)
				return nameCompRes;

			return student1.getId() - student2.getId();
		});

		studentList.stream().map(Student::getFname).forEach(System.out::println);
	}
}
