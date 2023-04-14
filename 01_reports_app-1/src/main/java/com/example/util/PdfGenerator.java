package com.example.util;

import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.entity.CitizenPlan;
import com.example.repo.CitizenPlanRepository;
import com.lowagie.text.Document;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
@Component
public class PdfGenerator {
	
	public void generate(HttpServletResponse respones, List<CitizenPlan> plans,File f) throws Exception {
		
		
		Document document=new Document(PageSize.A4);
		//response.getoutputstream is used send response to the  browsesr
       PdfWriter.getInstance(document, respones.getOutputStream());
    // how to attach pdf into another pdf file
       //new fileout....is for download the file in my system
       PdfWriter.getInstance(document,new FileOutputStream(f));//pass to method argumment(service sapp this file object)
      
        document.open();
       
     // Creating font
     		// Setting font style and size
     		Font fontTiltle = FontFactory.getFont(FontFactory.TIMES_ROMAN);
     		fontTiltle.setSize(20);

     		// Creating paragraph
     		Paragraph paragraph = new Paragraph("Citizen Plan Info", fontTiltle);

     		// Aligning the paragraph in document
     		paragraph.setAlignment(Paragraph.ALIGN_CENTER);

     		// Adding the created paragraph in document
     		document.add(paragraph);

        //create pdf table
        PdfPTable table=new PdfPTable(6);
        
        table.setSpacingBefore(5);
        
        table.addCell("Id");
        table.addCell("Citizen Name");
        table.addCell("plan Name");
        table.addCell("plan status");
        table.addCell("Start Date");
        table.addCell("End Date");
        
        //send the data to pdf
//           List<CitizenPlan> plans = repo.findAll();
        for(CitizenPlan plan:plans) {
        
        	 table.addCell(String.valueOf(plan.getCitizenId()));
             table.addCell(plan.getCitizenName());
             table.addCell(plan.getPlanName());
             table.addCell(plan.getPlanStatus());
             table.addCell(plan.getPlanStartDate()+"");
             table.addCell(plan.getPalnEndDate()+"");
        }
        document.add(table);
        document.close();
        
	}

}
