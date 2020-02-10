package org.rododin.algorithms.file;

import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.function.Supplier;
import java.util.stream.Stream;

import org.rododin.algorithms.Constants;

/**
 * TODO: Add description.
 * @author Nikolay Chebotaryov (Rod Odin)
 */
public class FileUtils
	implements Constants
{
	public static Stream<String> readResourceByLine(String resourceReference)
	{
		return readResourceByLine(resourceReference, true);
	}

	public static Stream<String> readResourceByLine(String resourceReference, boolean skipEmptyAndComments)
	{
		return doReadFileOrResource(() ->
		{
			try
			{
				return FileUtils.class.getClassLoader().getResource(resourceReference).toURI();
			}
			catch (Exception x)
			{
				throw new RuntimeException(x);
			}
		}, skipEmptyAndComments);
	}

	public static Stream<String> readFileByLine(String filePath)
	{
		return readFileByLine(filePath, true);
	}

	public static Stream<String> readFileByLine(String filePath, boolean skipEmptyAndComments)
	{
		return doReadFileOrResource(() -> URI.create(filePath), skipEmptyAndComments);
	}

	private static Stream<String> doReadFileOrResource(Supplier<URI> resourceSupplier, boolean skipEmptyAndComments)
	{
		try
		{
			return Files.lines(Paths.get(resourceSupplier.get()))
				.map(s -> {
					if (!skipEmptyAndComments)
						return s;
					final int commentIndex = s.indexOf('#');
					return (commentIndex >= 0 ? s.substring(0, commentIndex) : s).trim();
				})
				.filter(s -> !skipEmptyAndComments || !s.isEmpty());
		}
		catch (Exception x)
		{
			LogError.error("File or Resource read error", x);
			return Stream.empty();
		}
	}
}
