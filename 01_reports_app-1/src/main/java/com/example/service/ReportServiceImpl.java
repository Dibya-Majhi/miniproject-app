package com.example.service;

import java.io.File;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.example.entity.CitizenPlan;
import com.example.repo.CitizenPlanRepository;
import com.example.request.SearchRequest;
import com.example.util.EmailUtils;
import com.example.util.ExcelGenerator;
import com.example.util.PdfGenerator;
import com.lowagie.text.Document;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.CMYKColor;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

@Service
public class ReportServiceImpl implements ReportService   {
	
	
	@Autowired
	private CitizenPlanRepository repo;
	
	@Autowired
	private EmailUtils emailUtils;
	
	
	@Autowired
	private ExcelGenerator excelGenerator;
	
	@Autowired
    private PdfGenerator pdfGenerator;
	
	@Override
	public List<String> getPlanNames() {
		return repo.getPlanName();
		
	}

	@Override
	public List<String> getPlanStatuses() {
		return repo.getPlanStatus();
	}

	@Override
	public List<CitizenPlan> search(SearchRequest request) {
		
		CitizenPlan entity = new CitizenPlan();
		
		if(null!=request.getPlanName() && !"".equals(request.getPlanName())) {
			entity.setPlanName(request.getPlanName());
		}
		if(null!=request.getPlanStatus() && !"".equals(request.getPlanStatus())) {
			entity.setPlanStatus(request.getPlanStatus());
		}
		if(null!=request.getGender() && !"".equals(request.getGender())) {
			entity.setGender(request.getGender());
		}//convert String to LocalDate
			if(null!=request.getPlanStartDate()&& !"".equals(request.getPlanStartDate() )) {
				String startDate = request.getPlanStartDate();
				 DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

				  //convert String to LocalDate
				  LocalDate localDate = LocalDate.parse(startDate, formatter);
				entity.setPlanStartDate(localDate);
			
		}
			if(null!=request.getPlanEndDate()&& !"".equals(request.getPlanEndDate() )) {
				String endDate = request.getPlanEndDate();
				 DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

				  //convert String to LocalDate
				  LocalDate localDate = LocalDate.parse(endDate, formatter);
				entity.setPalnEndDate(localDate);
			
		}
		return repo.findAll(Example.of(entity));
		
	}

	@Override
	public boolean exportExcel(HttpServletResponse respones) throws Exception {
		
		//create xl file in my name system//will create the generator class
		File f=new File("plans.xls");
		
	List<CitizenPlan> plans =repo.findAll();
	//that file im pasing to generator method and store in to system
	excelGenerator.generate(respones, plans,f);
	
	
	//response is used to sendfile to browser//f is used to create file in the system
	//plans is used to write the data in to the excel
	String subject="test mail subject";
	String body="<h1>test mail body</h1>";
	String to="dibyamajhi231@gmail.com";
	
	//same file im passing to my email for the attachment 
     emailUtils.sendEmail(subject, body, to ,f);
     
   //deleted from system
     f.delete();
		return true;
	}

	@Override
	public boolean exportPdf(HttpServletResponse respones) throws Exception {
		
		File f=new File("plans.pdf");
		
		List<CitizenPlan> plans= repo.findAll();
		
		
		pdfGenerator.generate(respones, plans,f);
		
		String subject="test mail subject";
		String body="<h1>test mail body</h1>";
		String to="dibyamajhi231@gmail.com";
		
		//after downloaded im sending the file to the parameter to send email method then go to utile of file
	     emailUtils.sendEmail(subject, body, to ,f);
	     //deleted from system
	     f.delete();
	     
		return false;
	}

	
	

}
