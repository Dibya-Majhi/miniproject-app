package com.example.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.example.entity.CitizenPlan;
import com.example.repo.CitizenPlanRepository;
import com.example.request.SearchRequest;

@Service
public class ReportServiceImpl implements ReportService {
	
	
	@Autowired
	private CitizenPlanRepository repo;

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
	public boolean exportExcel() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean exportPdf() {
		// TODO Auto-generated method stub
		return false;
	}

}
