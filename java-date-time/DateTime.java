package Javamiscellaneous;

import java.util.Date;
import java.text.*;

/** 
 * @author TINITIATE.COM 
 * 
 * TOPIC   : Date Time Class
 * 
 * CLASS   : DateTime (Using Built-in classes / Constructs)
 * PURPOSE : 1) Using Printf with Date class.
 *           2) Date/Time Format Codes using Printf
 *           3) Using SimpleDateFormat, from java.text package
 *           4) Entering custom date /formats using SimpleDateFormat.parse
 *           5) Simple DateFormat format codes
 */
public class DateTime 
{
	/**
	 * java.util provides the Date class 
	 */
	public static void main(String[] args)
	{
       /**
        *  Date Object
        *  Date Formatting using "printf"
        */
       Date date1 = new Date();
       // Display Date-time using toString()
       System.out.println("Display SYSTEM Date-time using toString()" + date1.toString());
       System.out.println("For the SYSTEM Date-Time, Using printf formatting:");
       System.out.printf("%1$s %2$tc %n", "c Complete date and time                                      :",date1);
       System.out.printf("%1$s %2$tF %n", "F ISO 8601 date                                               :",date1);
       System.out.printf("%1$s %2$tD %n", "D U.S. formatted date (month/day/year)                        :",date1);
       System.out.printf("%1$s %2$tT %n", "T 24-hour time                                                :",date1);
       System.out.printf("%1$s %2$tr %n", "r 12-hour time                                                :",date1);
       System.out.printf("%1$s %2$tR %n", "R 24-hour time, no seconds                                    :",date1);
       System.out.printf("%1$s %2$tY %n", "Y Four-digit year (with leading zeroes)                       :",date1);
       System.out.printf("%1$s %2$ty %n", "y Last two digits of the year (with leading zeroes)           :",date1);
       System.out.printf("%1$s %2$tC %n", "C First two digits of the year (with leading zeroes)          :",date1);
       System.out.printf("%1$s %2$tB %n", "B Full month name                                             :",date1);
       System.out.printf("%1$s %2$tb %n", "b Abbreviated month name                                      :",date1);
       System.out.printf("%1$s %2$td %n", "d Two-digit day (with leading zeroes)                         :",date1);
       System.out.printf("%1$s %2$te %n", "e Two-digit day (without leading zeroes)                      :",date1);
       System.out.printf("%1$s %2$tA %n", "A Full weekday name                                           :",date1);
       System.out.printf("%1$s %2$ta %n", "a Abbreviated weekday name                                    :",date1);
       System.out.printf("%1$s %2$tj %n", "j Three-digit day of year (with leading zeroes)               :",date1);
       System.out.printf("%1$s %2$tH %n", "H Two-digit hour (with leading zeroes), between 00 and 23     :",date1);
       System.out.printf("%1$s %2$tk %n", "k Two-digit hour (without leading zeroes), between 0 and 23   :",date1);
       System.out.printf("%1$s %2$tI %n", "I Two-digit hour (with leading zeroes), between 01 and 12     :",date1);
       System.out.printf("%1$s %2$tl %n", "l Two-digit hour (without leading zeroes), between 1 and 12   :",date1);
       System.out.printf("%1$s %2$tM %n", "M Two-digit minutes (with leading zeroes)                     :",date1);
       System.out.printf("%1$s %2$tS %n", "S Two-digit seconds (with leading zeroes)                     :",date1);
       System.out.printf("%1$s %2$tL %n", "L Three-digit milliseconds (with leading zeroes)              :",date1);
       System.out.printf("%1$s %2$tN %n", "N Nine-digit nanoseconds (with leading zeroes)                :",date1);
       System.out.printf("%1$s %2$tp %n", "p Lowercase morning or afternoon marker                       :",date1);
       System.out.printf("%1$s %2$tz %n", "z RFC 822 numeric offset from GMT                             :",date1);
       System.out.printf("%1$s %2$tZ %n", "Z Time zone                                                   :",date1);
       System.out.printf("%1$s %2$ts %n", "s Seconds since 1970-01-01 00:00:00 GMT                       :",date1);
       System.out.printf("%1$s %2$tQ %n", "Q Milliseconds since 1970-01-01 00:00:00 GMT                  :",date1);

       /**
        *  Date Object
        *  Date Formatting using "SimpleDateFormat"
        */
       Date date2 = new Date();
       SimpleDateFormat date_fmt = new SimpleDateFormat ("yyyy.MM.dd hh:mm:ss a zzz");
       System.out.println("System Date to format: (yyyy.MM.dd hh:mm:ss a zzz):" + date_fmt.format(date2));

       /**
        *  Using Parse to read an input date format string
        */
       DateFormat formatter = new SimpleDateFormat("MM/dd/yy");
       try
       { 
    	   Date date = (Date)formatter.parse("01/29/02"); 
    	   System.out.println(date.toString());
       } 
       catch (ParseException e) { e.printStackTrace(); }

       /**
        * Simple DateFormat format codes
        */

       Date systemDate = new Date();
       String test = new SimpleDateFormat("dd MMM yyyy HH:mm:ss Z").format(systemDate).toString();
       System.out.println(" systemDate " + test);

       test =  new SimpleDateFormat("G").format(systemDate).toString();
       System.out.println(systemDate + ": G Era designator " + test);
       
       test =  new SimpleDateFormat("y").format(systemDate).toString();
       System.out.println(systemDate + ": y Year in four digits " + test);
       
       test =  new SimpleDateFormat("M").format(systemDate).toString();
       System.out.println(systemDate + ": M Month in year " + test);
       
       test =  new SimpleDateFormat("d").format(systemDate).toString();
       System.out.println(systemDate + ": d Day in month " + test);
       
       test =  new SimpleDateFormat("h").format(systemDate).toString();
       System.out.println(systemDate + ": h Hour in A.M./P.M. (1~12) " + test);
       
       test =  new SimpleDateFormat("H").format(systemDate).toString();
       System.out.println(systemDate + ": H Hour in day (0~23) " + test);
       
       test =  new SimpleDateFormat("m").format(systemDate).toString();
       System.out.println(systemDate + ": m Minute in hour " + test);
       
       test =  new SimpleDateFormat("s").format(systemDate).toString();
       System.out.println(systemDate + ": s Second in minute " + test);
       
       test =  new SimpleDateFormat("S").format(systemDate).toString();
       System.out.println(systemDate + ": S Millisecond " + test);
       
       test =  new SimpleDateFormat("E").format(systemDate).toString();
       System.out.println(systemDate + ": E Day in week " + test);
       
       test =  new SimpleDateFormat("D").format(systemDate).toString();
       System.out.println(systemDate + ": D Day in year " + test);
       
       test =  new SimpleDateFormat("F").format(systemDate).toString();
       System.out.println(systemDate + ": F Day of week in month " + test);
       
       test =  new SimpleDateFormat("w").format(systemDate).toString();
       System.out.println(systemDate + ": w Week in year " + test);
       
       test =  new SimpleDateFormat("W").format(systemDate).toString();
       System.out.println(systemDate + ": W Week in month " + test);
       
       test =  new SimpleDateFormat("a").format(systemDate).toString();
       System.out.println(systemDate + ": a A.M./P.M. marker " + test);
       
       test =  new SimpleDateFormat("k").format(systemDate).toString();
       System.out.println(systemDate + ": k Hour in day (1~24) " + test);
       
       test =  new SimpleDateFormat("K").format(systemDate).toString();
       System.out.println(systemDate + ": K Hour in A.M./P.M. (0~11) " + test);
       
       test =  new SimpleDateFormat("z").format(systemDate).toString();
       System.out.println(systemDate + ": z Time Zone " + test);
	}
	
}
