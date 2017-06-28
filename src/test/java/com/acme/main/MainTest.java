package com.acme.main;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MainTest {
	
	public static void main(String[] args) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		String strDate = "19/09/1992";
		Date date = sdf.parse(strDate);
		
		java.sql.Date sqlDate = new java.sql.Date(date.getTime());
		System.out.println("util.Date -> " + date.toString());
		System.out.println("sql.Date -> " + sqlDate.toString());
		
	}
	

}
