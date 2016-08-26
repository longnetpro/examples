package info.longnetpro.examples;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URISyntaxException;

import com.itextpdf.license.LicenseKey;
import com.itextpdf.license.LicenseKeyException;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfWriter;

import info.longnetpro.common.util.fs.FilePathUtils;
import info.longnetpro.common.util.system.SystemUtils;
import info.longnetpro.pdflib.document.Anchor;
import info.longnetpro.pdflib.document.ContentBox;
import info.longnetpro.pdflib.document.Measurement;
import info.longnetpro.pdflib.document.Page;

public class PdfLibExamples {
	private static void loadLicenseFile(InputStream licenseIs) {
		try {
			LicenseKey.loadLicenseFile(licenseIs);
		} catch (LicenseKeyException e) {
			e.printStackTrace();
		}
	}

	private static void loadLicenseFile(String pathToLicFile) {
		try {
			loadLicenseFile(new FileInputStream(pathToLicFile));
		} catch (FileNotFoundException fnf) {
			fnf.printStackTrace();
		}
	}

	private static String getLicenseFilePath() throws URISyntaxException {
		String licfile = "./itextkey14714588134380.xml";
		String jarfile = SystemUtils.getClassPath(LicenseKey.class);
		String path = FilePathUtils.resolve(jarfile, licfile);
		System.out.println(path);
		return path;
	}

	private static String getTargetFilePath() {
		String file = "/temp/pdf/anchor.pdf";
		return FilePathUtils.normalize(file);
	}

	private static String getImageFilePath() {
		String file = "/temp/pdf/BK-logo-only.jpg";
		return FilePathUtils.normalize(file);
	}

	public static void generatePdf() throws DocumentException, URISyntaxException, MalformedURLException, IOException {
		String licFile = getLicenseFilePath();
		loadLicenseFile(licFile);

		String dest = getTargetFilePath();
		Document doc = new Document();
		PdfWriter.getInstance(doc, new FileOutputStream(dest));
		Rectangle pageSize = PageSize.LETTER;
		Rectangle rect = new Rectangle(0f, 0f, 50f, 100f);
		rect.setBorder(15);
		rect.setBorderColor(BaseColor.RED);
		rect.setBorderWidth(.5f);
		rect.setBackgroundColor(BaseColor.BLUE);
		doc.setPageSize(pageSize);
		doc.open();

		Page page = new Page(pageSize.getWidth(), pageSize.getHeight());
		ContentBox rpage = page.margin(new Float[] { 10f, 50f, 10f, 50f });

		for (Anchor anchor : Anchor.values()) {
			ContentBox box = new ContentBox(50f, 100f);
			float offx = anchor.equals(Anchor.CENTER) ? -50f : 0f;
			float offy = anchor.equals(Anchor.CENTER) ? -50f : 0f;

			ContentBox rr = anchor.anchorElement(rpage, box, offx, offy);

			if (anchor.equals(Anchor.BOTTOM_LEFT)) {
				float[] dim = box.scaleByPercentage(0.5f);
				//rr = rr.reposition(dim[0], dim[1], Anchor.TOP_RIGHT);
			}

			rect.setLeft(rr.getLeft());
			rect.setBottom(rr.getBottom());
			rect.setRight(rr.getRight());
			rect.setTop(rr.getTop());
			doc.add(rect);
		}
		String imageFile = getImageFilePath();
		Image image = Image.getInstance(imageFile);
		
		float width = Measurement.dotsToUserUnits(image.getWidth(), 1200);
		float height = Measurement.dotsToUserUnits(image.getHeight(), 1200);
		
		System.out.println(width + " " + height);
		
		ContentBox img = Anchor.BOTTOM_LEFT.anchorElement(rpage, width, height);
		
		
		
		image.scaleToFit(width, height);
		image.setAbsolutePosition(img.getLeft(), img.getBottom());
		
		System.out.println(image.getWidth() + " " + image.getHeight());
		System.out.println(image.getAbsoluteX() + " " + image.getAbsoluteY());
		
		doc.add(image);
		doc.close();
	}

	public static void main(String[] args) throws DocumentException, URISyntaxException, MalformedURLException, IOException {
		generatePdf();
		float f = 0f/0f;
		System.out.println(Float.isNaN(f));
		System.out.println(f);
	}
}
