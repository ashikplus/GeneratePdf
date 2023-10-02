package com.ashik.pdf;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfPageEvent;
import com.itextpdf.text.pdf.PdfWriter;

public class HeaderFooterPageEvent implements PdfPageEvent {
	
    public void onEndPage(PdfWriter writer, Document document) {
    	
       
    }

	@Override
	public void onOpenDocument(PdfWriter writer, Document document) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStartPage(PdfWriter writer, Document document) { 

		try {
			PdfContentByte canvas = writer.getDirectContentUnder();
		      Rectangle headerRect = new Rectangle(0, 670, 595, 930);
		      
		      headerRect.setBackgroundColor(new BaseColor(235, 235, 250));
		      canvas.rectangle(headerRect);

		      Paragraph headerText = new Paragraph("Sunday, August 13, 2023", new Font(Font.FontFamily.HELVETICA, 12, Font.NORMAL));
		      headerText.setAlignment(Element.ALIGN_RIGHT);
		      headerText.setSpacingBefore(-30); 
		      document.add(headerText);
		      
		      PdfPTable headerTable = new PdfPTable(2);
		      headerTable.setWidthPercentage(100);
		      float[] columnWidths = {1f, 2f};
		      headerTable.setWidths(columnWidths);

		      PdfPCell logoCell = new PdfPCell();
		      Image logoImage = Image.getInstance("/home/ashik/Downloads/logo.png");
		      logoImage.scaleToFit(150, 150);
		      logoCell.addElement(logoImage);
		      logoCell.setBorder(Rectangle.NO_BORDER);
		      headerTable.addCell(logoCell);
		      
		      PdfPCell middleTextCell = new PdfPCell();
		      Paragraph middleText = new Paragraph("Contact Us", new Font(Font.FontFamily.HELVETICA, 14, Font.BOLD));
		      //middleText.setIndentationLeft(-70);
		      middleText.setAlignment(Element.ALIGN_LEFT);
		      
		      middleTextCell.addElement(middleText);
		      middleTextCell.setBorder(Rectangle.NO_BORDER);
		      middleTextCell.setPaddingTop(10);
		      Chunk spaceChunk1 = new Chunk("\n\n\n"); 
		      Paragraph spaceParagraph1 = new Paragraph(spaceChunk1);
		      middleTextCell.addElement(spaceParagraph1);
		      headerTable.addCell(middleTextCell);

		      document.add(headerTable);
		      Chunk spaceChunk = new Chunk("\n\n\n"); 
		      Paragraph spaceParagraph = new Paragraph(spaceChunk);
		      document.add(spaceParagraph);
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	@Override
	public void onCloseDocument(PdfWriter writer, Document document) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onParagraph(PdfWriter writer, Document document, float paragraphPosition) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onParagraphEnd(PdfWriter writer, Document document, float paragraphPosition) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onChapter(PdfWriter writer, Document document, float paragraphPosition, Paragraph title) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onChapterEnd(PdfWriter writer, Document document, float paragraphPosition) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onSection(PdfWriter writer, Document document, float paragraphPosition, int depth, Paragraph title) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onSectionEnd(PdfWriter writer, Document document, float paragraphPosition) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onGenericTag(PdfWriter writer, Document document, Rectangle rect, String text) {
		// TODO Auto-generated method stub
		
	}
}