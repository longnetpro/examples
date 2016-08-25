package info.longnetpro.examples;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;

import com.itextpdf.license.LicenseKey;
import com.itextpdf.license.LicenseKeyException;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfWriter;

import info.longnetpro.pdflib.document.Anchor;
import info.longnetpro.pdflib.document.ContentBox;
import info.longnetpro.pdflib.document.Page;

public class PdfLibExamples {
	public static void loadLicenseFile(InputStream licenseIs) {
		try {
			LicenseKey.loadLicenseFile(licenseIs);
		} catch (LicenseKeyException e) {
			e.printStackTrace();
		}
	}

	public static void loadLicenseFile(String pathToLicFile) {
		try {
			loadLicenseFile(new FileInputStream(pathToLicFile));
		} catch (FileNotFoundException fnf) {
			fnf.printStackTrace();
		}
	}

	public static void main(String[] args) throws DocumentException, FileNotFoundException {
		String licFile = "C:\\_TFS\\BentallKennedy-EBS\\EBS\\Main\\ADF\\configuration\\license\\itextkey14714588134380.xml";
		loadLicenseFile(licFile);

		String dest = "c:\\temp\\anchor.pdf";
		Document doc = new Document();
		PdfWriter.getInstance(doc, new FileOutputStream(dest));
		Rectangle pageSize = PageSize.LETTER;
		Rectangle rect = new Rectangle(0f, 0f, 50f, 100f);
		rect.setBorder(15);
		rect.setBorderColor(BaseColor.RED);
		rect.setBorderWidth(1f);
		rect.setBackgroundColor(BaseColor.BLUE);
		doc.setPageSize(pageSize);
		doc.open();

		Page page = new Page(pageSize.getWidth(), pageSize.getHeight());
		ContentBox rpage = page.margin(new Float[] { 10f, 50f, 10f, 50f });

		for (Anchor anchor : Anchor.values()) {
			float offx = anchor.equals(Anchor.CENTER) ? -50f : 0f;
			float offy = anchor.equals(Anchor.CENTER) ? -50f : 0f;

			ContentBox rr = anchor.anchorElement(rpage, 50f, 100f, offx, offy);
			rect.setLeft(rr.getLeft());
			rect.setBottom(rr.getBottom());
			rect.setRight(rr.getRight());
			rect.setTop(rr.getTop());
			doc.add(rect);
		}
		doc.close();

	}
}
