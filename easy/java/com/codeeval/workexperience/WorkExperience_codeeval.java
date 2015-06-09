package com.codeeval.workexperience;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class WorkExperience_codeeval {
	private int YEAR =Calendar.YEAR;
	private int MONTH =Calendar.MONTH;
	private int DATE =Calendar.DATE;
	
	private Date startDate;
	private Date endDate;
	private SimpleDateFormat sdf;
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public void setEndDate(String input, String format) throws Exception{
		sdf =  new SimpleDateFormat(format);
		setEndDate(sdf.parse(input));
	}


	public void setStartDate(String input, String format) throws Exception{
		sdf =  new SimpleDateFormat(format);
		setStartDate(sdf.parse(input));
	}

	
	public int getWorkExpInYear(){

		return getDiffYears(startDate, endDate);
	}
	
	public int getWorkExpInMonth(){

		return getDiffMonths(startDate, endDate);
	}


	public int getDiffMonths(Date first, Date last){
		Calendar a = getCalendar(first);
	    Calendar b = getCalendar(last);
	    int diffYear = b.get(YEAR) - a.get(YEAR);
		return diffYear * 12 + b.get(MONTH) - a.get(MONTH)+1;
	}
	
	public  int getDiffYears(Date first, Date last) {
	    Calendar a = getCalendar(first);
	    Calendar b = getCalendar(last);
	    int diff = b.get(YEAR) - a.get(YEAR);
	    if (a.get(MONTH) > b.get(MONTH) || 
	        (a.get(MONTH) == b.get(MONTH) && a.get(DATE) > b.get(DATE))) {
	        diff--;
	    }
	    return diff;
	}
	
	public  Calendar getCalendar(Date date) {
	    Calendar cal = Calendar.getInstance();
	    cal.setTime(date);
	    return cal;
	}

	public boolean isOverlap (WorkExperience we){
		return (we.getStartDate().after(startDate) && we.getStartDate().before(endDate)) 
				|| (we.getEndDate().before(endDate)&&we.getEndDate().after(startDate));
	}
	public void updateOverlap(WorkExperience tmpWe) {
		startDate = (startDate.before(tmpWe.getStartDate())?startDate:tmpWe.getStartDate());
		endDate = (endDate.after(tmpWe.getEndDate())?endDate:tmpWe.getEndDate());
		
	}

}
