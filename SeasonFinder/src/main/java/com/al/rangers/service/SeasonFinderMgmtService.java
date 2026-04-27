package com.al.rangers.service;

import java.time.LocalDate;

import org.springframework.stereotype.Service;

@Service
public class SeasonFinderMgmtService implements ISeasonFinderMgmtService {

	
	
	@Override
	public String findSeason() {
		
		LocalDate date = LocalDate.now();
		int month=date.getMonthValue();
		
		if(month>3 && month<6) {
			return "Summer Season";
		}
		else if(month>6 && month<9) {
			return "Rainy Season";
		}else {
			return "Winter Season";
		}

	}

	@Override
	public String findMonthsRange(String monthName) {
		
		int month=0;
		if(monthName.equalsIgnoreCase("january")) {
			month=1;
		}
		if(monthName.equalsIgnoreCase("feb")) {
			month=2;
		}
		if(monthName.equalsIgnoreCase("march")) {
			month=3;
		}
		if(monthName.equalsIgnoreCase("april")) {
			month=4;
		}
		if(monthName.equalsIgnoreCase("may")) {
			month=5;
		}
		if(monthName.equalsIgnoreCase("june")) {
			month=6;
		}
		
	
		
		return "Your Answer is : "+month+" "+monthName;
	}

}
