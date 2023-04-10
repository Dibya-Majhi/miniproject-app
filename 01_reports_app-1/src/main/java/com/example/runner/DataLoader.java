package com.example.runner;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.example.entity.CitizenPlan;
import com.example.repo.CitizenPlanRepository;
@Component
public class DataLoader implements ApplicationRunner {
	
	@Autowired
	private CitizenPlanRepository repo;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		
		repo.deleteAll();
		
				//cash plane data
				CitizenPlan c1=new CitizenPlan();
				c1.setCitizenName("Dibya");
				c1.setGender("male");
				c1.setPlanName("cash");
				c1.setPlanStatus("Approved");
				c1.setPlanStartDate(LocalDate.now());
				c1.setPalnEndDate(LocalDate.now().plusMonths(6));
				c1.setBenefitAmt(5000.00);
		
		
				CitizenPlan c2=new CitizenPlan();
				c2.setCitizenName("Rghu");
				c2.setGender("male");
				c2.setPlanName("cash");
				c2.setPlanStatus("Denied");
				c2.setDenialReason("Rental income");
				
				CitizenPlan c3=new CitizenPlan();
				c3.setCitizenName("cyati");
				c3.setGender("female");
				c3.setPlanName("cash");
				c3.setPlanStatus("terminated");
				c3.setPlanStartDate(LocalDate.now().minusMonths(4));
				c3.setPalnEndDate(LocalDate.now().plusMonths(6));
				c3.setBenefitAmt(5000.00);
				c3.setTerminatedDate(LocalDate.now());
				c3.setTerminationRsn("Employed");
				
		
				//Food plane data
				CitizenPlan c4=new CitizenPlan();
				c4.setCitizenName("biranchi");
				c4.setGender("male");
				c4.setPlanName("Food");
				c4.setPlanStatus("Approved");
				c4.setPlanStartDate(LocalDate.now());
				c4.setPalnEndDate(LocalDate.now().plusMonths(6));
				c4.setBenefitAmt(5000.00);
		
		
				CitizenPlan c5=new CitizenPlan();
				c5.setCitizenName("robert");
				c5.setGender("male");
				c5.setPlanName("Food");
				c5.setPlanStatus("Denied");
				c5.setDenialReason("property income");
				
				CitizenPlan c6=new CitizenPlan();
				c6.setCitizenName("smita");
				c6.setGender("female");
				c6.setPlanName("Food");
				c6.setPlanStatus("terminated");
				c6.setPlanStartDate(LocalDate.now().minusMonths(4));
				c6.setPalnEndDate(LocalDate.now().plusMonths(6));
				c6.setBenefitAmt(5000.00);
				c6.setTerminatedDate(LocalDate.now());
				c6.setTerminationRsn("Employed");
				
		
		
				//Medical plane data
				CitizenPlan c7=new CitizenPlan();
				c7.setCitizenName("Rabi");
				c7.setGender("male");
				c7.setPlanName("Medical");
				c7.setPlanStatus("Approved");
				c7.setPlanStartDate(LocalDate.now());
				c7.setPalnEndDate(LocalDate.now().plusMonths(6));
				c7.setBenefitAmt(5000.00);
		
		
				CitizenPlan c8=new CitizenPlan();
				c8.setCitizenName("kumar");
				c8.setGender("male");
				c8.setPlanName("Medical");
				c8.setPlanStatus("Denied");
				c8.setDenialReason("Rental income");
				
				CitizenPlan c9=new CitizenPlan();
				c9.setCitizenName("rita");
				c9.setGender("female");
				c9.setPlanName("Medical");
				c9.setPlanStatus("terminated");
				c9.setPlanStartDate(LocalDate.now().minusMonths(4));
				c9.setPalnEndDate(LocalDate.now().plusMonths(6));
				c9.setBenefitAmt(5000.00);
				c9.setTerminatedDate(LocalDate.now());
				c9.setTerminationRsn("Govt job");
				
		
		
				//Employed plane data
				CitizenPlan c10=new CitizenPlan();
				c10.setCitizenName("sankar");
				c10.setGender("male");
				c10.setPlanName("Employed");
				c10.setPlanStatus("Approved");
				c10.setPlanStartDate(LocalDate.now());
				c10.setPalnEndDate(LocalDate.now().plusMonths(6));
				c10.setBenefitAmt(5000.00);
		
		
				CitizenPlan c11=new CitizenPlan();
				c11.setCitizenName("chahal");
				c11.setGender("male");
				c11.setPlanName("Employed");
				c11.setPlanStatus("Denied");
				c11.setDenialReason("Rental income");
				
				CitizenPlan c12=new CitizenPlan();
				c12.setCitizenName("sita");
				c12.setGender("female");
				c12.setPlanName("Employed");
				c12.setPlanStatus("terminated");
				c12.setPlanStartDate(LocalDate.now().minusMonths(4));
				c12.setPalnEndDate(LocalDate.now().plusMonths(6));
				c12.setBenefitAmt(5000.00);
				c12.setTerminatedDate(LocalDate.now());
				c12.setTerminationRsn("Employed");
				
		List<CitizenPlan> list = Arrays.asList(c1,c2,c3,c4,c5,c6,c7,c8,c9,c10,c11,c12);
		repo.saveAll(list);
		
	
		
	}

}
