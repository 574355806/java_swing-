package table;

public class Course {
	String coursenum,coursename,teacher ;
	int hours;
	
	public Course(String coursenum, String coursename, String teacher, int hours) {
		super();
		this.coursenum = coursenum;
		this.coursename = coursename;
		this.teacher = teacher;
		this.hours = hours;
	}

	
	
	public String getcoursename(){
		return this.coursename;
	}
	
	public String getcoursenum(){
		return this.coursenum;
	}
	
	public String getteacher(){
		return this.teacher;
	}
	
	public int gethours(){
		return this.hours;
	}
	
	
	public void setClassname(String classname){
		this.coursename = classname;
	}
	
	public void setClassnum(String classnum){
		this.coursenum = classnum;
	}
	
	public void setteacher(String classdept){
		this.teacher = classdept;
	}
	
	public void sethours(int classcount){
		this.hours = classcount;
	}

}
