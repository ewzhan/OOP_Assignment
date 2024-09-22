import java.util.*;
import java.time.*;
public class MyDate{
	private int day;
	private int month;
	private int year;
	private int hour;
	private int minute;
	private int second;
	
	public MyDate() {																//Default constructor
        Calendar calendar = new GregorianCalendar();
        this.day = calendar.get(Calendar.DAY_OF_MONTH); 
        this.month = calendar.get(Calendar.MONTH) + 1; 
        this.year = calendar.get(Calendar.YEAR);
        this.hour = calendar.get(Calendar.HOUR_OF_DAY);
        this.minute = calendar.get(Calendar.MINUTE);
        this.second = calendar.get(Calendar.SECOND);
    }
    public MyDate(int day, int month, int year){									//constructor only day month year
    	this.day = day;
		this.month = month;
		this.year = year;
    }
	public MyDate(int day, int month, int year,int hour, int minute, int second){	//constructor with actual time
		this.day = day;
		this.month = month;
		this.year = year;
		this.hour = hour;
		this.minute = minute;
		this.second = second;
	}
	
	public int getDay(){								//Accessors
		return this.day;
	}
	public int getMonth(){
		return this.month;
	}
	public int getYear(){
		return this.year;
	}
	public int getHour(){
		return this.hour;
	}
	public int getMinute(){
		return this.minute;
	}
	public int getSecond(){
		return this.second;
	}
	
	public void setDay(int day){						//Mutators
		this.day = day;
	}
	public void setMonth(int month){
		this.month = month;
	}
	public void setYear(int year){
		this.year = year;
	}
	public void setHour(int hour){
		this.hour = hour;
	}
	public void setMinute(int minute){
		this.minute = minute;
	}
	public void setSecond(int second){
		this.second = second;
	}
	
	public String toDate(){							//Display Date only
		return this.day+"-"+this.month+"-"+this.year;
	}
	public String toTime(){							//Display Time only
		return this.hour+"h:"+this.minute+"m:"+this.second+"s";
	}
	public String toString(){						//DIsplay All
		return this.day+"-"+this.month+"-"+this.year+" "+this.hour+"h:"+this.minute+"m:"+this.second+"s";
	}
}