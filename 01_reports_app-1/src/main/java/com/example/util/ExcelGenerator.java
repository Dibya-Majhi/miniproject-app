package com.example.util;

import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.entity.CitizenPlan;
import com.example.repo.CitizenPlanRepository;

@Component
public class ExcelGenerator {
	
	//if you dont want to call the data from the database then take the the list return type as parameter
	public void generate(HttpServletResponse respones,List<CitizenPlan> records,File file) throws Exception {
		//create excel work book
		
				//Workbook workbook=new XSSFWorkbook();
				Workbook workbook=new HSSFWorkbook();
				//create a sheet using excel 
				Sheet sheet = workbook.createSheet("plans-data");
				//create row inside sheet
				Row headerRow = sheet.createRow(0);
				//create cell using row
				
				
				headerRow.createCell(0).setCellValue("ID");
				headerRow.createCell(1).setCellValue("Citizen Name");
				headerRow.createCell(2).setCellValue("Plan Name");
				headerRow.createCell(3).setCellValue("Plan Status");
				headerRow.createCell(4).setCellValue("plan start Date");
				headerRow.createCell(5).setCellValue("plan end Date");
				headerRow.createCell(6).setCellValue("benefit Amt");
				
				
				//to get list of record from the database         here use as a method parameter
//				List<CitizenPlan> records repo.findAll();
				//create data row 
				int dataRowIndes=1;
				for(CitizenPlan plan:records) {
					Row dataRow = sheet.createRow(dataRowIndes);
					dataRow.createCell(0).setCellValue(plan.getCitizenId());
					dataRow.createCell(1).setCellValue(plan.getCitizenName());
					dataRow.createCell(2).setCellValue(plan.getPlanName());
					dataRow.createCell(3).setCellValue(plan.getPlanStatus());
					if(null!=plan.getPlanStartDate()) {
						dataRow.createCell(4).setCellValue(plan.getPlanStartDate()+"");
					}else {
						dataRow.createCell(4).setCellValue("N/A");	
					}
					
					
					if(null!=plan.getPalnEndDate()) {
						dataRow.createCell(5).setCellValue(plan.getPalnEndDate()+"");
						
					}else{
						dataRow.createCell(5).setCellValue("N/A");
					}


					
					if(null!=plan.getBenefitAmt()) {
					dataRow.createCell(6).setCellValue(plan.getBenefitAmt());
					}else {
						dataRow.createCell(6).setCellValue("N/A");
					}
					
					dataRowIndes++;
					
				}
				//it is creat the file in the current folder(file will be created in local)
				
				FileOutputStream fos= new FileOutputStream(file);
				workbook.write(fos);
				fos.close();
				//put all the data to file excel file to store server folder
				 //create file 
//				FileOutputStream fos=new FileOutputStream(new File("plans.xls"));
//				workbook.write(fos);
//				workbook.close();
				
				// i want to send the respones to the breoswer then //and it is send to the browser
				ServletOutputStream outputStream = respones.getOutputStream();
				workbook.write(outputStream);
				workbook.close();
	}

}
