package table;

public class Classes {      //成员变量的获得和设置

	String classnum,classname,classdept ;
	int classcount;
	public Classes(String classnum,String classname,String classdept,int classcount){   //构造函数
		
		super();
		this.classname = classname;
		this.classdept = classdept;
		this.classnum = classnum;
		this.classcount = classcount;
	}
	
	public String getClassname(){
		return this.classname;
	}
	
	public String getClassnum(){
		return this.classnum;
	}
	
	public String getClassdept(){
		return this.classdept;
	}
	
	public int getClasscount(){
		return this.classcount;
	}
	
	
	public void setClassname(String classname){
		this.classname = classname;
	}
	
	public void setClassnum(String classnum){
		this.classnum = classnum;
	}
	
	public void setClassdept(String classdept){
		this.classdept = classdept;
	}
	
	public void setClasscount(int classcount){
		this.classcount = classcount;
	}
}
