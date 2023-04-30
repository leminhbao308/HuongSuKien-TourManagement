package utils;

import java.awt.image.BufferedImage;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;

import models.VeTour;

public class PDFCreator {

    public static void createTicketPDF(VeTour veTour, BufferedImage logo) throws DocumentException, IOException {
	// Kích thước trang A4
	float pageWidth = PageSize.A4.getWidth();
	float pageHeight = PageSize.A4.getHeight();

	// Thiết lập kích thước trang PDF bằng một nửa kích thước trang A4
	float quadPageHeight = pageHeight / 4;
	System.out.println(pageWidth);
	System.out.println(quadPageHeight);
	Rectangle pageSize = new Rectangle(pageWidth, quadPageHeight);

	// Tạo đối tượng Document với kích thước trang tùy chỉnh
	Document document = new Document(pageSize);

	// Tạo tên file
	String fileName = veTour.getMaVe() + "_" + veTour.getKhachHang().getMaKhachHang() + ".pdf";
	// Tạo đường dẫn đến thư mục Ticket
	String filePath = "./Ticket/" + fileName;

	PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(filePath));
	document.open();

	// Set up fonts
	BaseFont baseFont = BaseFont.createFont("/font/times.ttf", BaseFont.IDENTITY_H, BaseFont.EMBEDDED);

	Font companyFont = new Font(baseFont, 18, Font.BOLD);
	Font codeFont = new Font(baseFont, 14, Font.BOLD);
	Font nameFont = new Font(baseFont, 12);
	Font dateFont = new Font(baseFont, 12, Font.ITALIC);

	// Add company name and logo
	String companyName = "SE Tourist - Vé Tour Du Lịch";
	Paragraph company = new Paragraph(companyName, companyFont);
	company.setAlignment(Element.ALIGN_CENTER);
	document.add(company);

	PdfContentByte canvas = writer.getDirectContent();
	canvas.moveTo(10, 10);
	canvas.lineTo(10, 200);
	canvas.lineTo(585, 200);
	canvas.lineTo(585, 10);
	canvas.closePathStroke();

	// Add logo
	Image image = Image.getInstance(logo, null);
	image.setAbsolutePosition(20, 145);
	document.add(image);

	// Add code
	Chunk labelChunk = new Chunk("Mã vé:  ", codeFont);
	labelChunk.setFont(new Font(codeFont.getBaseFont(), codeFont.getSize(), Font.BOLD, BaseColor.RED));
	Paragraph code = new Paragraph(labelChunk);
	Chunk codeChunk = new Chunk(veTour.getMaVe(), codeFont);
	codeChunk.setCharacterSpacing(5);
	codeChunk.setFont(new Font(codeFont.getBaseFont(), codeFont.getSize(), Font.BOLD, BaseColor.RED));
	code.add(codeChunk);
	code.setAlignment(Element.ALIGN_CENTER);
	document.add(code);

	// Add name
	Paragraph name = new Paragraph("Tên khách hàng: " + veTour.getKhachHang().getTenKhachHang(), nameFont);
	name.setAlignment(Element.ALIGN_LEFT);
	document.add(name);

	// Add Location
	Paragraph location = new Paragraph(
		"Địa Danh: " + veTour.getKhachHang().getTourDuLich().getDiaDanh().getTenDiaDanh() + " - Tỉnh "
			+ veTour.getKhachHang().getTourDuLich().getDiaDanh().getTinhThanh(),
		nameFont);
	code.setAlignment(Element.ALIGN_CENTER);
	document.add(location);

	// Add Go Date
	Paragraph godate = new Paragraph("Ngày đi: "
		+ new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(veTour.getKhachHang().getTourDuLich().getNgayDi()),
		nameFont);
	code.setAlignment(Element.ALIGN_CENTER);
	document.add(godate);

	// Add date
	SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	String currentDate = dateFormat.format(new Date());
	Paragraph date = new Paragraph("Ngày in vé: " + currentDate, dateFont);
	date.setAlignment(Element.ALIGN_RIGHT);
	document.add(date);

	document.close();
    }
}
