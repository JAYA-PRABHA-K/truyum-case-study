package Util;
import java.time.*;
import java.time.format.DateTimeFormatter;
public class DateUtil {
	//this class accepts date in string input only in the specified date format and returns date as local date.
	public static LocalDate convertToDate(String date)
	{
		try {
			DateTimeFormatter formater=DateTimeFormatter.ofPattern("dd/MM/yyyy");
			
			LocalDate dt=LocalDate.parse(date,formater);
			
			return dt;
		}
		catch(Exception e)
		{
			DateTimeFormatter format=DateTimeFormatter.ofPattern("yyyy-MM-dd");
			LocalDate d=LocalDate.parse(date,format);
			return d;
		}
	}
}
