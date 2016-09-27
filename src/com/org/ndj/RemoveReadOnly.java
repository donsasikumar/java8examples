package com.org.ndj;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class RemoveReadOnly {
	static boolean makeWritable(String directory) {
		try (Stream<Path> paths = Files.walk(Paths.get(directory))) {
			paths.forEach(path -> path.toFile().setWritable(true));
			return true;
		}  catch (IOException e) {
			e.printStackTrace();
			return false;
		}

	}

	public static void main(String[] args) {
		System.out.println(makeWritable("."));
	}

}
