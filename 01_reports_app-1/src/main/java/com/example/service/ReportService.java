package com.example.service;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import com.example.entity.CitizenPlan;
import com.example.request.SearchRequest;

public interface ReportService {
	
	public List<String> getPlanNames();
	
	public List<String> getPlanStatuses();
	
	public List <CitizenPlan> search(SearchRequest request);
	
	public boolean exportExcel(HttpServletResponse respones) throws Exception ;
	
	public boolean exportPdf(HttpServletResponse respones) throws Exception;

}
