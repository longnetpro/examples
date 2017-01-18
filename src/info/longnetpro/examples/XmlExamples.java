package info.longnetpro.examples;

import java.io.StringWriter;
import java.io.Writer;

import info.longnetpro.common.util.xml.XmlUtils;

public class XmlExamples {

	public static void main(String[] args) throws Exception {
		String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><root><el id=\"id1\">test</el></root>";
		String encoding = "UTF-8";
		Writer out = new StringWriter();
		XmlUtils.formatXmlString(xml, out, encoding);
		System.out.println(out.toString());
	}
}
