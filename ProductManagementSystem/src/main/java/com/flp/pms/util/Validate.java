package com.flp.pms.util;

import java.util.Date;

public class Validate {
	
	public static boolean isValidProductName(String productName){
		return productName.matches("[A-Z][A-Za-z1-9_$ ]*");
	}
	
	public static boolean isValidDate(String givenDate){
		return givenDate.matches("([1-9]|[1-2]\\d{1}|[30|31])-(jan|feb|mar|apr|may|jun|jul|aug|sep|oct|nov|dec)-[12][7890]\\d{2}");
	}

	
	public static boolean isValidExpiryDate(Date expiryDate){
		return expiryDate.after(new Date());
			
	}
	
	
	public static boolean isValidRatings(float ratings){
		if(ratings>=0.0 && ratings<=5.0)
			return true;
		else
			return false;
	}
	
	
	public static boolean isValidContactNo(String contactNo){
		return contactNo.matches("\\d{10}");
	}
	
	
	
	public static boolean isValidQuantity(int quantity){
		return quantity>0;
	}
	
	
	
}
