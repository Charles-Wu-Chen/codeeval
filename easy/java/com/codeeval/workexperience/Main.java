package com.codeeval.workexperience;

/* Sample code to read in test cases:*/

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.text.html.HTMLDocument.HTMLReader.HiddenAction;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Main {

	public static void main(String[] args) throws IOException {
		File file = new File(args[0]);
		BufferedReader buffer = new BufferedReader(new FileReader(file));
		String line;
		while ((line = buffer.readLine()) != null) {
			line = line.trim();

			System.out.println(findYearExp(line));

		}
	}

	private static int findYearExp(String line)  {

		String inputs[] = line.split(";");
		List<WorkExperience> inputDates = null;
		try{
			inputDates = formatInput(inputs);
		}catch (Exception e){
			e.printStackTrace();
		}
		return calcYear(inputDates);
	}

	private static int calcYear(List<WorkExperience> inputDates) {
		// int yearExp = 0;
		int monthExp = 0;
		for (WorkExperience we : inputDates) {
			monthExp += we.getWorkExpInMonth();
		}
		System.out.println("Month ::" + monthExp);
		return monthExp / 12;
	}

	private static List<WorkExperience> formatInput(String[] inputs)
			throws Exception {
		List<WorkExperience> workList = new ArrayList<WorkExperience>();
		List<WorkExperience> inputList = sortInputToWorkExperience(inputs);
		
		for (WorkExperience we : inputList) {
//
//			WorkExperience we = new WorkExperience();
//			we.setStartDate(input.split("-")[0].trim(), "MMM yyyy");
//			we.setEndDate(input.split("-")[1].trim(), "MMM yyyy");

			boolean overlap = false;
			for (WorkExperience tmpWe : workList) {
				if (tmpWe.isOverlap(we) == true) {
					tmpWe.updateOverlap(we);
					overlap = true;
				}
			}
			if (overlap == false) {
				workList.add(we);
			}

		}
		return workList;
	}

	
	
	private static List<WorkExperience> sortInputToWorkExperience(
			String[] inputs)  throws Exception {
		
		List<WorkExperience> workList = new ArrayList<WorkExperience>();
		for (String input : inputs) {

			WorkExperience we = new WorkExperience();
			we.setStartDate(input.split("-")[0].trim(), "MMM yyyy");
			we.setEndDate(input.split("-")[1].trim(), "MMM yyyy");
			workList.add(we);
		}
		
		Collections.sort(workList, new Comparator<WorkExperience>() {
			
	        public int compare(WorkExperience  we1, WorkExperience  we2)
	        {

	            return  we1.getStartDate().compareTo(we2.getStartDate());
	        }
		});
		
		
		return workList;
	}

//	public static void main(String[] args) throws Exception {
//		System.out.println(findYearExp("Feb 2004-Dec 2009; Sep 2004-Jul 2008"));
//		System.out.println(findYearExp("Aug 2013-Mar 2014; Apr 2013-Aug 2013; Jun 2014-Aug 2015; Apr 2003-Nov 2004; Apr 2014-Jan 2015"));
//		System.out.println(findYearExp("Mar 2003-Jul 2003; Nov 2003-Jan 2004; Apr 1999-Nov 1999"));
//		System.out.println(findYearExp("Apr 1992-Dec 1993; Feb 1996-Sep 1997; Jan 2002-Jun 2002; Sep 2003-Apr 2004; Feb 2010-Nov 2011"));
//		System.out.println(findYearExp("Feb 2004-May 2004; Jun 2004-Jul 2004"));
//		System.out.println(findYearExp("Jun 2013-Apr 2015; Jan 2012-Feb 2012; Oct 2009-Sep 2010; Jun 1991-Feb 1992; Jan 2010-Oct 2011; Jun 1991-May 1993; Dec 1996-Apr 1998; Nov 2001-Jul 2003; Dec 2014-Feb 2016; Mar 2006-Jan 2008; Apr 2005-Aug 2005; Jul 2002-Jul 2003; Nov 2000-Sep 2001; Nov 2008-Mar 2009; Aug 1999-Sep 1999; Jul 1992-Mar 1993; Jul 1992-Mar 1994; Dec 2005-Jun 2006; Aug 2006-Jun 2008; Oct 1996-Nov 1997; Jul 1997-Jun 1998; Mar 2003-Jun 2004; Jun 1993-Aug 1994; Jun 2008-Oct 2008; Jun 2004-Jun 2005; Feb 2015-Aug 2016; Apr 2012-Dec 2012; Dec 2003-Oct 2005; Nov 2012-Jan 2013"));
//		System.out.println(findYearExp("Apr 1994-Nov 1995; Mar 1994-Jun 1995; Nov 2007-Apr 2009; Jan 1998-Jun 1998; Sep 2013-Jun 2014; Dec 2002-Dec 2003; Nov 2006-Jan 2007; Jun 2015-Feb 2016; Feb 2005-Sep 2006; Nov 2013-Feb 2014; Feb 1993-Feb 1994; Mar 1998-Nov 1998; Apr 1991-Jul 1991; Apr 1998-May 1998; Sep 2009-Mar 2010; Apr 1996-Jun 1996; Aug 2003-Jan 2004; Dec 2007-Jul 2009; Jul 2015-Aug 2016; Mar 1992-Dec 1993; Apr 1991-May 1992; Oct 2014-Aug 2015"));
//		System.out.println(findYearExp("May 1997-Apr 1998; Jan 1994-Apr 1995; Sep 2012-Dec 2013; Mar 2015-Aug 2015; May 2013-Mar 2014; Apr 2015-Sep 2016; Nov 1996-Jan 1997; Jun 1998-Aug 1998; Jan 2015-Mar 2015; Dec 2008-Dec 2009; Oct 2006-Apr 2007; Mar 2011-Apr 2011; Jan 1995-Apr 1995; Nov 2013-Jul 2014; Aug 1997-Apr 1999; Nov 2012-Mar 2013; Apr 1997-Mar 1998; Apr 2000-Dec 2000; Jan 2000-Apr 2001; Jan 2012-Apr 2012; Dec 1993-Nov 1994; Jul 2007-Feb 2008; Jun 1999-May 2001; Dec 2011-May 2013; Jun 2009-Dec 2009; Jun 2006-May 2007; Nov 2012-Oct 2013; Feb 2007-Oct 2008"));
//		System.out.println(findYearExp("Jul 2014-Oct 2015; Nov 1992-Jan 1993; Jul 1999-Apr 2001; Sep 2010-Jun 2011; Jan 1997-Feb 1997; Dec 2000-Oct 2001; Oct 2008-May 2010; Jun 2003-Oct 2003; May 2001-Nov 2001; Nov 2007-Mar 2009; Jun 2001-May 2003; Jun 1992-Aug 1992; Jan 2015-Oct 2015; Jan 2012-Dec 2012; Mar 2007-Jul 2008; Oct 1990-Mar 1991; Jan 2001-Dec 2002; Jul 2008-Jan 2010"));
//		System.out.println(findYearExp("May 2003-Aug 2004; Jul 1993-Feb 1995; Jul 2005-Mar 2007; May 1992-Jul 1993; May 1996-May 1997"));
//		System.out.println(findYearExp("Feb 2004-Dec 2009; Sep 2004-Jul 2008"));
//		System.out.println(findYearExp("Nov 2007-Jan 2008; Jul 2009-May 2011; Jan 1997-Jun 1998; Feb 1991-Oct 1991; Jul 1998-Aug 1999; Jan 2009-Apr 2009; Nov 1994-Oct 1996; Jun 2011-Oct 2011; May 1999-Oct 2000; Mar 2012-May 2013; Jan 2001-Aug 2002; May 2008-Jun 2009; Apr 2010-Oct 2011; Mar 2008-Aug 2008; Jul 2003-Jan 2005; Feb 1996-May 1997; Jun 1999-Sep 1999; Dec 1998-Apr 2000; Jan 1992-Jul 1993; Jun 2000-Oct 2000; Jul 2012-Oct 2012; Jun 2007-Mar 2009"));
//		System.out.println(findYearExp("Feb 2005-May 2005; Jun 2006-Jul 2006"));
//		System.out.println(findYearExp("Mar 1998-Mar 1999; Jul 2005-Dec 2005; Jan 2008-Sep 2009; Jun 2015-Mar 2017; Nov 1990-Mar 1992; Feb 2011-Jul 2012; May 2007-May 2008"));
//		System.out.println(findYearExp("Apr 2009-Jul 2010; Feb 1995-Mar 1996; Jan 1999-Apr 1999; Jan 2005-Nov 2006; Oct 1999-Apr 2000; May 2004-Dec 2005; Dec 1994-Jul 1995; Sep 2002-Jul 2003; Oct 2015-Feb 2017; Apr 1999-Sep 1999; Jul 2011-Jan 2012; Jul 2003-Feb 2005; Jun 2007-Jul 2008; Aug 2004-Jan 2005; Aug 2011-Apr 2013; Jun 1994-Aug 1995; Feb 2013-Jan 2014; Apr 1997-Apr 1998; Apr 2004-Dec 2004; Feb 2000-Jan 2001; Sep 2000-Jul 2002; May 1996-Jan 1998; Feb 1994-Mar 1995; Jun 1994-Mar 1996; Aug 1991-Jan 1992; Mar 1992-Sep 1992; Feb 2013-Aug 2014; Apr 1994-Jan 1996"));
//		System.out.println(findYearExp("Sep 2009-Feb 2011; Mar 1990-Jan 1992; Jun 2012-Jun 2013; Mar 2001-Jul 2001; Aug 2006-Nov 2006; May 1990-Feb 1992"));
//		System.out.println(findYearExp("Sep 2002-Mar 2003; Oct 2002-Aug 2004; Jul 2005-Jun 2006; Jan 1999-Feb 1999; Jul 2011-Feb 2012; Aug 1991-Sep 1992; Jul 1992-Apr 1994; Oct 2002-Jan 2003; Dec 2008-Dec 2009; Aug 2015-Sep 2016; Apr 2000-Aug 2000; Jan 1991-Jul 1991; Jan 2014-Sep 2015; Jun 1992-Feb 1993; Oct 2013-Jul 2015; Jan 2001-Apr 2001; Apr 1994-Jan 1996; Dec 2010-May 2012; Sep 2012-May 2013; Apr 2000-Jan 2002; Jun 1993-Jul 1993; Apr 2013-Jun 2013; Oct 1995-Aug 1996; Oct 2005-Mar 2007; Nov 1994-Aug 1995; May 2010-Jul 2010; Jan 1992-Mar 1992; Aug 1994-Jul 1996"));
//		System.out.println(findYearExp("Dec 2013-Sep 2015; Jan 2000-Mar 2001; Dec 1999-Feb 2001; Jan 2002-Mar 2003; Mar 2003-Nov 2004; Jul 1992-Nov 1993; Mar 1992-Dec 1993; Apr 2008-Apr 2009; Dec 1997-Aug 1998; May 2007-Dec 2007; Dec 1993-May 1994; Aug 2004-Nov 2005; Jan 1990-Jul 1990; May 2014-Nov 2015; Nov 2014-Dec 2014; Apr 1990-Aug 1990"));
//		System.out.println(findYearExp("Sep 1993-Jun 1994; Jun 1993-Jul 1994; Sep 1994-Aug 1996; Jun 2005-Jan 2007; Mar 2004-Dec 2004; Feb 1991-Jan 1993"));
//		System.out.println(findYearExp("Jun 2008-Dec 2008; Mar 2000-Mar 2001; Apr 2001-May 2002; May 2010-Aug 2010; Feb 1997-Dec 1997; Aug 2012-Feb 2013; May 2010-Dec 2010"));
//		System.out.println(findYearExp("Dec 2013-Jul 2014; Dec 1991-Mar 1993; Jan 1992-Apr 1993; Aug 1991-Oct 1991; May 2008-Oct 2009; Sep 2004-Jul 2006; Nov 2007-Sep 2009; Jan 2004-Jun 2005; Aug 1999-Jan 2000; Apr 1991-Feb 1993"));
//		System.out.println(findYearExp("Dec 2013-Jul 2014; Dec 1991-Mar 1993; Jan 1992-Apr 1993; Aug 1991-Oct 1991; Apr 1991-Feb 1993"));
//		System.out.println(findYearExp("May 2008-Oct 2009; Sep 2004-Jul 2006; Nov 2007-Sep 2009; Jan 2004-Jun 2005; Aug 1999-Jan 2000; Apr 1991-Feb 1993"));
//		System.out.println(findYearExp("Nov 2003-May 2004; Aug 2008-May 2009; Feb 1991-Aug 1992; Jan 2002-Feb 2003; Apr 2000-Mar 2001; Oct 2015-Feb 2016; Jun 2003-Nov 2003; May 2012-Dec 2013; Apr 1996-Sep 1996; Nov 1999-Nov 2000; Feb 2008-Feb 2009; Mar 1993-Jun 1994; Jul 2008-May 2009"));
//		System.out.println(findYearExp("May 1992-Feb 1993; Dec 1999-Jun 2000; Oct 2013-May 2014; Dec 2001-Sep 2002; Sep 2008-Nov 2009; Jun 1997-Jul 1998; May 2006-Jun 2006; Dec 2006-Apr 2008; Sep 1993-Feb 1994; Oct 2006-Nov 2007; Aug 1992-Sep 1993; Jul 2008-Oct 2008; May 2010-Nov 2011; Jul 1996-May 1998; Jul 1991-Jul 1992; May 1992-Dec 1992; Nov 1993-Oct 1994; Dec 2000-Apr 2002; Sep 1991-Dec 1992; Dec 2008-Feb 2010; Apr 2002-Oct 2002; Jan 2001-Aug 2001; Sep 1995-Nov 1995; May 2013-Feb 2014; Jan 1997-Jan 1999; Feb 2009-Oct 2009; Jan 2012-Feb 2012"));
//		System.out.println(findYearExp("Aug 2012-Jul 2014; Sep 2009-Feb 2010; Mar 2001-Nov 2002"));
//		System.out.println(findYearExp("Jan 1998-Jan 1999; Jul 1997-Jan 1999; Aug 2012-Dec 2012; Jul 1997-Jun 1998; Jun 2003-Nov 2004; Apr 2002-Jul 2002; Sep 1990-Nov 1991; Nov 1991-Jul 1992; Apr 2008-Nov 2009; Feb 2006-Aug 2007"));
//		
		
//		String line = "Dec 2013-Jul 2014; Dec 1991-Mar 1993; Jan 1992-Apr 1993; Aug 1991-Oct 1991; Apr 1991-Feb 1993";
//		String inputs[] = line.split(";");
//		List<WorkExperience> inputList = sortInputToWorkExperience(inputs);
//		System.out.println(inputList);
//		
//		WorkExperience we1 = new WorkExperience();
//		we1.setStartDate("Jan 2013", "MMM yyyy");
//		we1.setEndDate("Dec 2013", "MMM yyyy");
//		
//		WorkExperience we2 = new WorkExperience();
//		we2.setStartDate("Dec 2013", "MMM yyyy");
//		we2.setEndDate("Jun 2014", "MMM yyyy");
//		System.out.println("overlap true--" + we1.isOverlap(we2));
//		we1.updateOverlap(we2);
//		System.out.println("update range start" + we1.getStartDate());
//		System.out.println("update range end" + we1.getEndDate());
//		
//		
//		we1.setStartDate("Jan 2013", "MMM yyyy");
//		we1.setEndDate("Dec 2013", "MMM yyyy");
//		we2.setEndDate("Jun 2014", "MMM yyyy");
//		we2.setStartDate("Jan 2013", "MMM yyyy");
//		System.out.println("overlap true--" + we1.isOverlap(we2));
//		we1.updateOverlap(we2);
//		System.out.println("update range start" + we1.getStartDate());
//		System.out.println("update range end" + we1.getEndDate());
//		
//		we1.setStartDate("Jan 2013", "MMM yyyy");
//		we1.setEndDate("Dec 2013", "MMM yyyy");
//		we2.setEndDate("Jun 2013", "MMM yyyy");
//		we2.setStartDate("Jan 2012", "MMM yyyy");
//		System.out.println("overlap true--" + we1.isOverlap(we2));
//		we1.updateOverlap(we2);
//		System.out.println("update range start" + we1.getStartDate());
//		System.out.println("update range end" + we1.getEndDate());
//		
//		
//		we2.setStartDate("Jan 2012", "MMM yyyy");
//		System.out.println("overlap true--" + we1.isOverlap(we2));
//		
//		
//		we2.setEndDate("Jun 2012", "MMM yyyy");
//		System.out.println("overlap false--" + we1.isOverlap(we2));
//	}
}


class WorkExperience {
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
		return we.getStartDate().compareTo(endDate) <=0 
				&& we.getEndDate().compareTo(startDate) >=0;
	}
	public void updateOverlap(WorkExperience tmpWe) {
		startDate = (tmpWe.getStartDate().compareTo(startDate) <= 0)?tmpWe.getStartDate():startDate;
		endDate = tmpWe.getEndDate().compareTo(endDate)>=0?tmpWe.getEndDate():endDate;
		
	}

}