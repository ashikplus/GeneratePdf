package com.ashik.pdf;
import java.io.FileOutputStream;

import org.json.JSONArray;
import org.json.JSONObject;

import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;


public class PDFWriterHelper {
    public static void main(String[] args) {
    	
        String pdfFilePath = "/home/ashik/Downloads/PDFGeneratorPrototype.pdf";

        Document document = new Document();

        try {
        	HeaderFooterPageEvent event = new HeaderFooterPageEvent();
        	
            // Initialize the PdfWriter
        	PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(pdfFilePath));
        	
        	writer.setPageEvent(event);
            document.open();

            PdfPTable labelValueTable = new PdfPTable(2);

            float[] columnWidths = {1f, 2f};
            labelValueTable.setWidths(columnWidths);
            
            Font boldFont = new Font(Font.FontFamily.HELVETICA, 12, Font.BOLD);
            
            labelValueTable.setHorizontalAlignment(Element.ALIGN_LEFT);

            String jsonString = "[\n" +
                    "    {\n" +
                    "        \"name\": \"John\",\n" +
                    "        \"age\": \"25\",\n" +
                    "        \"phone\": \"12345\"\n" +
                    "    },\n" +
                    "    {\n" +
                    "        \"name\": \"Jane\",\n" +
                    "        \"age\": \"30\",\n" +
                    "        \"phone\": \"67890\"\n" +
                    "    },\n" +
                    "    {\n" +
                    "        \"name\": \"Alice\",\n" +
                    "        \"age\": \"22\",\n" +
                    "        \"phone\": \"55555\"\n" +
                    "    }\n" +
                    "]";
            
            String jsonString2 = "[\n" +
                    "    {\n" +
                    "        \"name\": \"John1\",\n" +
                    "        \"age\": \"251\",\n" +
                    "        \"phone\": \"123451\"\n" +
                    "    },\n" +
                    "    {\n" +
                    "        \"name\": \"Jane1\",\n" +
                    "        \"age\": \"301\",\n" +
                    "        \"phone\": \"678901\"\n" +
                    "    },\n" +
                    "    {\n" +
                    "        \"name\": \"Alice1\",\n" +
                    "        \"age\": \"221\",\n" +
                    "        \"phone\": \"555551\"\n" +
                    "    }\n" +
                    "]";
            
            JSONArray jsonArray = new JSONArray(jsonString);
            
            for (int i = 0; i < jsonArray.length(); i++) {
            	
            	JSONObject jsonObject = jsonArray.getJSONObject(i);
            	
            	for (String label : jsonObject.keySet()) {
                    String value = jsonObject.getString(label);
                    
                    PdfPCell labelCell = new PdfPCell(new Paragraph(label, boldFont));
                    PdfPCell valueCell = new PdfPCell(new Paragraph(value));
                    
                    labelCell.setBorder(Rectangle.NO_BORDER);
                    valueCell.setBorder(Rectangle.NO_BORDER);
                    
                    valueCell.setPaddingLeft(80);
                    valueCell.setExtraParagraphSpace(10f);
                    
                    labelValueTable.addCell(labelCell);
                    labelValueTable.addCell(valueCell);
                    
                }
            }
            
            JSONArray jsonArray2 = new JSONArray(jsonString2);
            
			for (int i = 0; i < jsonArray.length(); i++) {

				JSONObject jsonObject = jsonArray2.getJSONObject(i);

				for (String label : jsonObject.keySet()) {
					String value = jsonObject.getString(label);

					PdfPCell labelCell = new PdfPCell(new Paragraph(label, boldFont));
					PdfPCell valueCell = new PdfPCell(new Paragraph(value));

					labelCell.setBorder(Rectangle.NO_BORDER);
					valueCell.setBorder(Rectangle.NO_BORDER);

					valueCell.setPaddingLeft(80);
					valueCell.setExtraParagraphSpace(10f);

					labelValueTable.addCell(labelCell);
					labelValueTable.addCell(valueCell);

				}
			}
            

            document.add(labelValueTable);

           
            document.close();

            System.out.println("PDF created successfully!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
