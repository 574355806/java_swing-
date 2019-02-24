package handle;

import java.util.Vector;

import javax.swing.table.DefaultTableModel;

import table.Course;
import table.Present;
import dao.Courseaccess;
import dao.Precentaccess;

public class Handlecourse {
	Courseaccess courseaccess = null;

	public  Handlecourse() {
		
		courseaccess = new Courseaccess();
	}

	public DefaultTableModel showTable() {
		Vector tbvalue = courseaccess.selectAll();
		Vector tbtitle=new Vector();
		tbtitle.add("课程编号");
		tbtitle.add("课程名称");
		tbtitle.add("授课老师");
		tbtitle.add("学时");
		return new DefaultTableModel(tbvalue, tbtitle);
	}
	public DefaultTableModel findresultbynum(String x) {//返回查找学号的表
		
		Vector tbvalue = courseaccess.selectfindbynum(x);
		Vector tbtitle=new Vector();
		tbtitle.add("课程编号");
		tbtitle.add("课程名称");
		tbtitle.add("授课老师");
		tbtitle.add("学时");
		return new DefaultTableModel(tbvalue, tbtitle);
	}
public DefaultTableModel findresultbyname(String x) {//返回查找姓名的表
		
		Vector tbvalue = courseaccess.selectfindbyname(x);
		Vector tbtitle=new Vector();
		tbtitle.add("课程编号");
		tbtitle.add("课程名称");
		tbtitle.add("授课老师");
		tbtitle.add("学时");
		return new DefaultTableModel(tbvalue, tbtitle);
	}
public DefaultTableModel findresultbyzonghe(Course p) {//返回查找学号的表
	
	Vector tbvalue = courseaccess.selectfindbyzonghe(p);
	Vector tbtitle=new Vector();
	tbtitle.add("课程编号");
	tbtitle.add("课程名称");
	tbtitle.add("授课老师");
	tbtitle.add("学时");
	return new DefaultTableModel(tbvalue, tbtitle);
}

public DefaultTableModel findresultbyteacher(String x) {//返回查找的表
		
		Vector tbvalue = courseaccess.selectfindbyteacher(x);
		Vector tbtitle=new Vector();
		tbtitle.add("课程编号");
		tbtitle.add("课程名称");
		tbtitle.add("授课老师");
		tbtitle.add("学时");
		return new DefaultTableModel(tbvalue, tbtitle);
	}

	public boolean add(Course e) {
		return courseaccess.addinformatioon(e);
	}
	public Course findbyname(String e) {
		if (courseaccess.findByname(e)!=null)
			return courseaccess.findByname(e);
		return null;
	}
	public Course findbyteacher(String e) {
		if (courseaccess.findByteacher(e)!=null)
			return courseaccess.findByteacher(e);
		return null;
	}
	
	public boolean deletezonghe(Course zcno) {
		return courseaccess.deletezonghe(zcno);
	}
	public Course findzonghe(Course p) {
		return courseaccess.findByzonghe(p);
	}

}
