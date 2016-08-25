package info.longnetpro.examples;

import java.util.Date;

import info.longnetpro.common.util.date.DateTime;

public class DateTimeExamples {
	public static void example1() {
		DateTime dt = new DateTime();
		dt.setTime(new Date());
		dt.complete();
		System.out.println(dt.toString());
	}
	
	public static void main(String[] args) {
		example1();
	}
}
