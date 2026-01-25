package org.rododin.algorithms.misc.java_internals_uncovered;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

import org.openjdk.jol.info.ClassLayout;
import org.openjdk.jol.vm.VM;
import org.rododin.algorithms.misc.Misc;
import org.rododin.algorithms.misc.UserId;

/**
 * TODO: Add description.
 */
public class ObjectSizeAnalysis
{
	public static void objectSizeAnalysis()
	{
		System.out.println(VM.current().details());

		System.out.println(ClassLayout.parseClass(Object.class).toPrintable());
		System.out.println(ClassLayout.parseClass(Integer.class).toPrintable());
		System.out.println(ClassLayout.parseClass(String.class).toPrintable());
		System.out.println(ClassLayout.parseClass(Misc.class).toPrintable());
		System.out.println(ClassLayout.parseClass(UserId.class).toPrintable());

		System.out.printf("Size of %s: %d\n", Object.class.getName(), VM.current().sizeOf(new Object()));
		System.out.printf("Size of %s: %d\n", Integer.class.getName(), VM.current().sizeOf(Integer.valueOf(0)));
		System.out.printf("Size of %s: %d\n", String.class.getName(), VM.current().sizeOf("abc"));
		System.out.printf("Size of %s: %d\n", Misc.class.getName(), VM.current().sizeOf(new Misc()));
		System.out.printf("Size of %s: %d\n", UserId.class.getName(), VM.current().sizeOf(new UserId(123L, "UserUserUser")));
	}

	public static Collection<UUID> getUserUUIDs(Map<String, List<UserId>> groupedUserIds)
	{
		return groupedUserIds.values().stream().flatMap(userIdsByGroup -> userIdsByGroup.stream().map(UserId::getUuid)).collect(Collectors.toSet());
	}

	public static String getConcatenatedUsernames(Map<String, List<UserId>> groupedUserIds)
	{
		// return usernames separated by coma
		return groupedUserIds.values().stream().map(userIds -> userIds.stream().map(UserId::getName).reduce("", (str, currentName) -> str + "," + currentName)).collect(Collectors.joining(","));
	}
}
