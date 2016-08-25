package info.longnetpro.examples;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;

import info.longnetpro.common.util.generic.NumberRomanConverter;
import info.longnetpro.common.util.generic.NumberRomanConverterException;

public class NumberRomanConverterExamples {
	public static void example1()
			throws UnsupportedEncodingException, FileNotFoundException, IOException, NumberRomanConverterException {
		String file = "c:\\temp\\roman.txt";
		OutputStreamWriter writer = new OutputStreamWriter(new FileOutputStream(file), "UTF-8");
		for (int i = 1; i < 1000; i++) {
			int j = i * 100000;
			String s = String.format("%d -> %s", j, NumberRomanConverter.fromInteger(j));
			writer.write(s);
			writer.write('\n');
		}
		writer.flush();
		writer.close();
	}

	public static void example2()
			throws UnsupportedEncodingException, FileNotFoundException, IOException, NumberRomanConverterException {
		String file = "c:\\temp\\roman1.txt";
		OutputStreamWriter writer = new OutputStreamWriter(new FileOutputStream(file), "UTF-8");
		for (int i = 1; i < 1000; i++) {
			int j = i * 100000;
			String number = j + "";
			String s = String.format("%d -> %s", j, NumberRomanConverter.fromInteger(number));
			writer.write(s);
			writer.write('\n');
		}
		writer.flush();
		writer.close();
	}

	public static void example3()
			throws UnsupportedEncodingException, FileNotFoundException, IOException, NumberRomanConverterException {
		String result = NumberRomanConverter.fromInteger(12345678);
		System.out.println(result);
	}

	public static void main(String[] args) throws UnsupportedEncodingException, FileNotFoundException, IOException, NumberRomanConverterException {
		example3();
	}
}
