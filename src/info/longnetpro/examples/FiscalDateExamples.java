package info.longnetpro.examples;

import info.longnetpro.common.util.date.FiscalDate;

public class FiscalDateExamples {
	public static void test() {
		FiscalDate fd = new FiscalDate();
		fd.setFiscalYearEndMonth(9).setStartMonthInThisFiscalYear(false).build(2015, 9, 3);
		fd.printFiscalDateDetails();
	}
	
	public static void main(String[] args) {
		test();
	}
}
