package org.rododin.algorithms.hackerrank.java.medium;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * <a href="https://www.hackerrank.com/challenges/java-priority-queue/problem">
 *   HackerRank > Prepare > Java > Data Structures > Java Priority Queue
 * </a> Problem Solution.
 *
 * @author Nikolay Chebotaryov (Rod Odin)
 */
public class JavaPriorityQueue
{
	private final static Scanner scan = new Scanner(System.in);
	private final static Priorities priorities = new Priorities();

	public static void main(String[] args)
	{
		int totalEvents = Integer.parseInt(scan.nextLine());
		List<String> events = new ArrayList<>();

		while (totalEvents-- != 0)
		{
			String event = scan.nextLine();
			events.add(event);
		}

		List<Student> students = priorities.getStudents(events);

		if (students.isEmpty())
		{
			System.out.println("EMPTY");
		}
		else
		{
			for (Student st : students)
			{
				System.out.println(st.getName());
			}
		}
	}
}

class Student
{
	private final int id;
	private final String name;
	private final double cgpa;

	public Student(int id, String name, double cgpa)
	{
		this.id = id;
		this.name = name;
		this.cgpa = cgpa;
	}

	public int getID()
	{
		return id;
	}

	public String getName()
	{
		return name;
	}

	public double getCGPA()
	{
		return cgpa;
	}
}

class Priorities
{
	private final PriorityQueue<Student> students = new PriorityQueue<>(1000, (student1, student2) ->
	{
		if (student1 == null && student2 == null)
			return 0;
		if (student1 == null)
			return 1;
		if (student2 == null)
			return -1;
		if (student1 == student2)
			return 0;
		int rv = -Double.compare(student1.getCGPA(), student2.getCGPA());
		if (rv != 0)
			return rv;
		rv = student1.getName().compareTo(student2.getName());
		if (rv != 0)
			return rv;
		return Integer.compare(student1.getID(), student2.getID());
	});

	List<Student> getStudents(List<String> events)
	{
		students.clear();
		for (String event : events)
		{
			String[] tokens = event.split(" ");
			switch (tokens[0])
			{
				case "ENTER":
					students.offer(new Student(Integer.parseInt(tokens[3]), tokens[1], Double.parseDouble(tokens[2])));
					break;
				case "SERVED":
					students.poll();
					break;
			}
		}
		final List<Student> rv = new ArrayList<>(students.size());
		while (!students.isEmpty())
			rv.add(students.poll());
		return rv;
	}
}
