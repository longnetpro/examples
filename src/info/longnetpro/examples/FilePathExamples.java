package info.longnetpro.examples;

import info.longnetpro.common.util.fs.FilePath;
import info.longnetpro.common.util.fs.FilePathNotAbsoluteException;

public class FilePathExamples {

	public static void example1() throws FilePathNotAbsoluteException {
		String file = "c:\\temp\\c\\t\\a.txt";
		String file2 = "c:\\temp\\c\\b.txt";
		FilePath fp = new FilePath(file); 
		String result = fp.getPath();
		System.out.println(result);
		FilePath fp1 = fp.relativizeAgainst(file2);
		System.out.println(fp1.getPath());
	}
	
	public static void main(String[] args) throws FilePathNotAbsoluteException {
		example1();
	}
}
