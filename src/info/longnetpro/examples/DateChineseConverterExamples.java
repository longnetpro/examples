package info.longnetpro.examples;

import java.util.Date;

import info.longnetpro.common.util.generic.DateChineseConverter;

public class DateChineseConverterExamples {
	public static void example1() {
		Date date = new Date();
		String[] codes = DateChineseConverter.getCodesFromDate(date);

		String dateString = "";
		for (String code : codes) {
			dateString += code;
		}
		System.out.println(dateString);
		System.out.println(DateChineseConverter.translateCode(dateString));
		System.out.println(DateChineseConverter.formatDate("Dt|AT'YMdH'|'msW'", date));

		// for (int number = 0; number < 60; number++)
		// System.out.println(number + " -> " + codeNumberWithin20(number));
	}

	public static void main(String[] args) {
		example1();
	}
}
