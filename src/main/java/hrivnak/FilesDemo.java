package hrivnak;

import java.io.File;
import java.nio.charset.Charset;
import java.util.List;

import com.google.common.base.Charsets;
import com.google.common.io.Files;

public class FilesDemo {
	public static void main(String[] args) throws Exception {
		File tempDir = Files.createTempDir();
		File ourFile = new File(tempDir, "file-to-read.txt");
		System.out.println("our file: " + ourFile.getAbsolutePath());
		System.out.println("our file's extension: " + Files.getFileExtension(ourFile.getAbsolutePath()));

		String newline = System.getProperty("line.separator");
		Charset utf8 = Charsets.UTF_8;
		Files.append("This is a simple file." + newline, ourFile, utf8);
		Files.append("Its purpose is to show that we can easily read a file line-by-line." + newline, ourFile, utf8);
		Files.append("This is the 3rd line." + newline, ourFile, utf8);
		Files.append("I ran out of things to write." + newline, ourFile, utf8);

		List<String> lines = Files.readLines(ourFile, utf8);
		Utils.printCollection("file-to-read.txt", lines);
	}
}
