package table;

import java.sql.Date;

public class Present {
	String classnum,studentnum,course,typeString,time;
	public Present(String classnum, String studentnum, String course,
			String typeString, String time) {
		super();
		this.classnum = classnum;
		this.studentnum = studentnum;
		this.course = course;
		this.typeString = typeString;
		this.time = time;
	}
	public String getclassnum(){
		return this.classnum;
		
	}
	public String getstudString(){
		return this.studentnum;
		
	}
	
	public String getcourse(){
		return this.course;
		
	}
	
	public String gettypeString2(){
		return this.typeString;
		
	}
	
	public String gettime(){
		return this.time;
	
	}
	
	
}
