package info.longnetpro.examples;

import java.net.URISyntaxException;

import com.itextpdf.text.PageSize;

import info.longnetpro.common.util.system.SystemUtils;

public class SystemUtilsExamples {
	public static void main(String[] args) throws URISyntaxException {
		String s = SystemUtils.getClassPath(PageSize.class);
		System.out.println(s);
	}
}
