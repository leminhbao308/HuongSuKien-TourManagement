package utils;

import java.awt.image.BufferedImage;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.draw.VerticalPositionMark;

import DAO.DAO_HopDongTour;
import entity.HopDongTour;
import entity.VeTour;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;

public class PDFCreator {

    public static void createTicketPDF(VeTour veTour, String path) throws DocumentException, IOException {
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

	// Tạo đường dẫn
	String filePath = path;

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
	BufferedImage logo = LoadSave.GetSpriteAtlas(LoadSave.LOGO_LABEL);
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
	Paragraph name = new Paragraph("Tên khách hàng: " + veTour.getHopDong().getKhachHang().getTenKhachHang(),
		nameFont);
	name.setAlignment(Element.ALIGN_LEFT);
	document.add(name);

	// Add Location
	Paragraph location = new Paragraph(
		"Địa Danh: " + veTour.getHopDong().getTourDuLich().getDiaDanh().getTenDiaDanh() + " - Tỉnh "
			+ veTour.getHopDong().getTourDuLich().getDiaDanh().getTinhThanh(),
		nameFont);
	code.setAlignment(Element.ALIGN_CENTER);
	document.add(location);

	// Add Go Date

	LocalDate ngayDi = veTour.getHopDong().getTourDuLich().getNgayDi();
	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	String ngayDiFormatted = ngayDi.format(formatter);

	Paragraph godate = new Paragraph("Ngày đi: " + ngayDiFormatted, nameFont);
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

    @SuppressWarnings("unused")
    public static void createContract(HopDongTour hopDong, String path) throws DocumentException, IOException {
	Document document = new Document(PageSize.A4);

	String filePath = path;

	PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(filePath));
	document.open();

	// Set up font
	BaseFont baseFont = BaseFont.createFont("/font/times.ttf", BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
	Font font = new Font(baseFont, 12, Font.NORMAL, BaseColor.BLACK);
	Font titleFont = new Font(baseFont, 18, Font.BOLD, BaseColor.BLACK);
	Font dateFont = new Font(baseFont, 12, Font.ITALIC);
	Font tableHeader = new Font(baseFont, 12, Font.BOLD, BaseColor.BLACK);
	Font signFont = new Font(baseFont, 12, Font.BOLDITALIC, BaseColor.BLACK);

	// Thêm tiêu đề
	Paragraph title = new Paragraph("HỢP ĐỒNG ĐẶT TOUR", titleFont);
	title.setAlignment(Element.ALIGN_CENTER);
	document.add(title);

	// Thêm thông tin bên A
	Chunk chunk = new Chunk("BÊN A: Công ty SE Tourist", titleFont);
	document.add(chunk);

	PdfPTable table = new PdfPTable(3);
	table.setWidthPercentage(100);
	table.setSpacingBefore(10f);
	table.setSpacingAfter(10f);

	// Add Header Cells to the Table
	PdfPCell cell1 = new PdfPCell(new Paragraph("Mã Nhân Viên", tableHeader));
	cell1.setBorderColor(BaseColor.BLACK);
	cell1.setPaddingLeft(10);
	cell1.setHorizontalAlignment(Element.ALIGN_CENTER);
	cell1.setVerticalAlignment(Element.ALIGN_MIDDLE);

	PdfPCell cell2 = new PdfPCell(new Paragraph("Tên Nhân Viên", tableHeader));
	cell2.setBorderColor(BaseColor.BLACK);
	cell2.setPaddingLeft(10);
	cell2.setHorizontalAlignment(Element.ALIGN_CENTER);
	cell2.setVerticalAlignment(Element.ALIGN_MIDDLE);

	PdfPCell cell3 = new PdfPCell(new Paragraph("Chức Vụ", tableHeader));
	cell3.setBorderColor(BaseColor.BLACK);
	cell3.setPaddingLeft(10);
	cell3.setHorizontalAlignment(Element.ALIGN_CENTER);
	cell3.setVerticalAlignment(Element.ALIGN_MIDDLE);

	table.addCell(cell1);
	table.addCell(cell2);
	table.addCell(cell3);

	// Add Data Cells to the Table
	PdfPCell dataCell1 = new PdfPCell(new Paragraph(hopDong.getNhanVien().getMaNhanVien(), font));
	dataCell1.setBorderColor(BaseColor.BLACK);
	dataCell1.setPaddingLeft(10);
	dataCell1.setHorizontalAlignment(Element.ALIGN_CENTER);
	dataCell1.setVerticalAlignment(Element.ALIGN_MIDDLE);

	PdfPCell dataCell2 = new PdfPCell(new Paragraph(hopDong.getNhanVien().getTenNhanVien(), font));
	dataCell2.setBorderColor(BaseColor.BLACK);
	dataCell2.setPaddingLeft(10);
	dataCell2.setHorizontalAlignment(Element.ALIGN_CENTER);
	dataCell2.setVerticalAlignment(Element.ALIGN_MIDDLE);

	PdfPCell dataCell3 = new PdfPCell(new Paragraph(hopDong.getNhanVien().getChucVu(), font));
	dataCell3.setBorderColor(BaseColor.BLACK);
	dataCell3.setPaddingLeft(10);
	dataCell3.setHorizontalAlignment(Element.ALIGN_CENTER);
	dataCell3.setVerticalAlignment(Element.ALIGN_MIDDLE);

	table.addCell(dataCell1);
	table.addCell(dataCell2);
	table.addCell(dataCell3);

	document.add(table);

	// Thêm thông tin bên B
	chunk = new Chunk("BÊN B: ÔNG/BÀ " + hopDong.getKhachHang().getTenKhachHang(), titleFont);
	document.add(chunk);

	table = new PdfPTable(5);
	table.setWidthPercentage(100);
	table.setSpacingBefore(10f);
	table.setSpacingAfter(10f);

	// Add Header Cells to the Table
	cell1 = new PdfPCell(new Paragraph("Mã Khách Hàng", tableHeader));
	cell1.setBorderColor(BaseColor.BLACK);
	cell1.setPaddingLeft(10);
	cell1.setHorizontalAlignment(Element.ALIGN_CENTER);
	cell1.setVerticalAlignment(Element.ALIGN_MIDDLE);

	cell2 = new PdfPCell(new Paragraph("Số CCCD", tableHeader));
	cell2.setBorderColor(BaseColor.BLACK);
	cell2.setPaddingLeft(10);
	cell2.setHorizontalAlignment(Element.ALIGN_CENTER);
	cell2.setVerticalAlignment(Element.ALIGN_MIDDLE);

	cell3 = new PdfPCell(new Paragraph("Tên Khách Hàng", tableHeader));
	cell3.setBorderColor(BaseColor.BLACK);
	cell3.setPaddingLeft(10);
	cell3.setHorizontalAlignment(Element.ALIGN_CENTER);
	cell3.setVerticalAlignment(Element.ALIGN_MIDDLE);

	PdfPCell cell4 = new PdfPCell(new Paragraph("Email", tableHeader));
	cell4.setBorderColor(BaseColor.BLACK);
	cell4.setPaddingLeft(10);
	cell4.setHorizontalAlignment(Element.ALIGN_CENTER);
	cell4.setVerticalAlignment(Element.ALIGN_MIDDLE);

	PdfPCell cell5 = new PdfPCell(new Paragraph("Số Điện Thoại", tableHeader));
	cell5.setBorderColor(BaseColor.BLACK);
	cell5.setPaddingLeft(10);
	cell5.setHorizontalAlignment(Element.ALIGN_CENTER);
	cell5.setVerticalAlignment(Element.ALIGN_MIDDLE);

	// Add cells with data to the table
	table.addCell(cell1);
	table.addCell(cell2);
	table.addCell(cell3);
	table.addCell(cell4);
	table.addCell(cell5);

	// Populate table with data from KhachHang object
	PdfPCell cell;
	cell = new PdfPCell(new Phrase(hopDong.getKhachHang().getMaKhachHang(), font));
	cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
	cell.setHorizontalAlignment(Element.ALIGN_CENTER);
	table.addCell(cell);

	cell = new PdfPCell(new Phrase(hopDong.getKhachHang().getSoCCCD_HC(), font));
	cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
	cell.setHorizontalAlignment(Element.ALIGN_CENTER);
	table.addCell(cell);

	cell = new PdfPCell(new Phrase(hopDong.getKhachHang().getTenKhachHang(), font));
	cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
	cell.setHorizontalAlignment(Element.ALIGN_CENTER);
	table.addCell(cell);

	cell = new PdfPCell(new Phrase(hopDong.getKhachHang().getEmail(), font));
	cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
	cell.setHorizontalAlignment(Element.ALIGN_CENTER);
	table.addCell(cell);

	cell = new PdfPCell(new Phrase(hopDong.getKhachHang().getSoDienThoai(), font));
	cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
	cell.setHorizontalAlignment(Element.ALIGN_CENTER);
	table.addCell(cell);

	document.add(table);

	// Thêm thông tin Tour
	chunk = new Chunk("BÊN A ĐÃ ĐẶT TOUR:", titleFont);
	document.add(chunk);

	table = new PdfPTable(2);
	table.setWidthPercentage(100);

	cell = new PdfPCell(new Phrase("Tên Tour", tableHeader));
	cell.setBorder(Rectangle.BOTTOM);
	table.addCell(cell);

	cell = new PdfPCell(new Phrase(hopDong.getTourDuLich().getTenTour(), font));
	cell.setBorder(Rectangle.BOTTOM);
	table.addCell(cell);

	cell = new PdfPCell(new Phrase("Mô tả", tableHeader));
	cell.setBorder(Rectangle.BOTTOM);
	table.addCell(cell);

	cell = new PdfPCell(new Phrase(hopDong.getTourDuLich().getMoTa(), font));
	cell.setBorder(Rectangle.BOTTOM);
	table.addCell(cell);

	cell = new PdfPCell(new Phrase("Ngày đi", tableHeader));
	cell.setBorder(Rectangle.BOTTOM);
	table.addCell(cell);

	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy"); // Định dạng ngày theo dd/MM/yyyy
	String goDate = hopDong.getTourDuLich().getNgayDi().format(formatter);
	Paragraph dateGo = new Paragraph(goDate, font);

	cell = new PdfPCell(dateGo);
	cell.setBorder(Rectangle.BOTTOM);
	table.addCell(cell);

	cell = new PdfPCell(new Phrase("Nơi đi", tableHeader));
	cell.setBorder(Rectangle.BOTTOM);
	table.addCell(cell);

	cell = new PdfPCell(new Phrase(hopDong.getTourDuLich().getNoiDi(), font));
	cell.setBorder(Rectangle.BOTTOM);
	table.addCell(cell);

	cell = new PdfPCell(new Phrase("Số ngày dự kiến", tableHeader));
	cell.setBorder(Rectangle.BOTTOM);
	table.addCell(cell);

	cell = new PdfPCell(new Phrase(Integer.toString(hopDong.getTourDuLich().getSoNgayDuKien()) + " Ngày"
		+ Integer.toString(hopDong.getTourDuLich().getSoNgayDuKien() - 1) + " Đêm", font));
	cell.setBorder(Rectangle.BOTTOM);
	table.addCell(cell);

	document.add(table);

	// Thêm thông tin Tour
	chunk = new Chunk("BẢNG CHI PHÍ:", titleFont);
	document.add(chunk);

	// Tạo bảng tính tổng số tiền
	table = new PdfPTable(2);
	table.setWidthPercentage(100);
	table.setSpacingBefore(10f);
	table.setSpacingAfter(10f);

	// Lấy giá trị của giá tour và giá dịch vụ từ CSDL
	float giaTour = hopDong.getTourDuLich().getGiaTour();
	float giaDichVu = hopDong.getDichVu().getGiaDichVu();

	// Tính tổng tiền
	float tongTien = DAO_HopDongTour.getTongTienTour(hopDong.getDichVu().getMaDichVu(),
		hopDong.getTourDuLich().getMaTour());

	// Định dạng số tiền
	NumberFormat format = NumberFormat.getCurrencyInstance(new Locale("vi", "VN"));
	String tongTienFormatted = format.format(tongTien);

	cell = new PdfPCell(new Phrase("Tiền Tour", tableHeader));
	cell.setBorder(Rectangle.BOTTOM);
	table.addCell(cell);

	// Thêm giá trị của giá tour và giá dịch vụ vào bảng
	cell = new PdfPCell(new Phrase(format.format(giaTour), new Font(Font.FontFamily.TIMES_ROMAN, 14)));
	cell.setPadding(10);
	cell.setBorder(Rectangle.BOTTOM);
	cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
	table.addCell(cell);

	cell = new PdfPCell(new Phrase("Dịch Vụ", tableHeader));
	cell.setBorder(Rectangle.BOTTOM);
	table.addCell(cell);

	cell = new PdfPCell(new Phrase(format.format(giaDichVu), new Font(Font.FontFamily.TIMES_ROMAN, 14)));
	cell.setPadding(10);
	cell.setBorder(Rectangle.BOTTOM);
	cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
	table.addCell(cell);

	// Thêm giá trị của tổng tiền vào bảng
	cell = new PdfPCell(new Phrase("Tổng Tiền", tableHeader));
	cell.setBorder(Rectangle.BOTTOM);
	table.addCell(cell);

	cell = new PdfPCell(new Phrase(tongTienFormatted, new Font(Font.FontFamily.TIMES_ROMAN, 14, Font.BOLD)));
	cell.setPadding(10);
	cell.setBorder(Rectangle.BOTTOM);
	cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
	table.addCell(cell);

	document.add(table);

	// Add Footer to the document
	Paragraph footer = new Paragraph();
	footer.setAlignment(Element.ALIGN_BOTTOM);

	// Add Signature Area to the footer
	Paragraph signatureArea = new Paragraph("————————▼————————");
	signatureArea.setAlignment(Element.ALIGN_CENTER);
	signatureArea.setSpacingBefore(10f);

	SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	String currentDate = dateFormat.format(new Date());
	Paragraph date = new Paragraph(hopDong.getTourDuLich().getNoiDi() + ", " + currentDate, dateFont);
	date.setAlignment(Element.ALIGN_RIGHT);

	Chunk space = new Chunk(new VerticalPositionMark());
	Paragraph signatureLineA = new Paragraph("Bên A (Công ty SE Tourist)", signFont);
	signatureLineA.add(space);
	signatureLineA.add("Bên B (Khách Hàng)");

	Paragraph signatureNote = new Paragraph("(Kí, ghi rõ họ tên)",
		new Font(baseFont, 10, Font.ITALIC, BaseColor.BLACK));
	signatureNote.add(space);
	signatureNote.add("(Kí, ghi rõ họ tên)");

	footer.add(signatureArea);
	footer.add(date);
	footer.add(signatureLineA);
	footer.add(signatureNote);

	document.add(footer);

	document.close();

	// Open the PDF document automatically
//	if (Desktop.isDesktopSupported()) {
//	    try {
//		File myFile = new File("hopdongtour" + "_" + hopDong.getMaHopDong() + ".pdf");
//		Desktop.getDesktop().open(myFile);
//	    } catch (IOException ex) {
//		// no application registered for PDFs
//		JOptionPane.showMessageDialog(null, "Không tìm thấy phần mềm để mở file PDF.");
//	    }
//	} else {
//	    JOptionPane.showMessageDialog(null, "Desktop is not supported.");
//	}

    }
}
