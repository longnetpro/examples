package info.longnetpro.examples;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;

import info.longnetpro.common.util.generic.NumberChineseConverter;
import info.longnetpro.common.util.generic.NumberChineseConverterException;

public class NumberChineseExamples {
	public static void example1()
			throws UnsupportedEncodingException, FileNotFoundException, IOException, NumberChineseConverterException {
		String file = "c:\\temp\\chinese.txt";
		OutputStreamWriter writer = new OutputStreamWriter(new FileOutputStream(file), "UTF-8");
		for (int i = 0; i < 1000000; i++) {
			int j = i * 1;
			String s = String.format("%d -> %s", j, NumberChineseConverter.toNumberUpperCase(j));
			writer.write(s);
			writer.write('\n');
		}
		writer.flush();
		writer.close();

	}

	public static void example2()
			throws UnsupportedEncodingException, FileNotFoundException, IOException, NumberChineseConverterException {
		String num = "0.00";
		System.out.println("Pattern: " + num.matches(NumberChineseConverter.NUMBER_PATTERN));
		System.out.println("Normal: " + NumberChineseConverter.normalizeNumber(num));
		System.out.println("Coding: " + NumberChineseConverter.codeNumberString(num));
		System.out.println("Money: " + NumberChineseConverter.codeCurrencyString(num));
		System.out.println("Number: " + NumberChineseConverter.toNumberLowerCase(num));
		System.out.println("Money: " + NumberChineseConverter.toCurrencyLowerCase(num));
	}

	public static void main(String[] args) {

	}
}
