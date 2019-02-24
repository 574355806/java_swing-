package handle;

import java.util.Vector;

import javax.swing.table.DefaultTableModel;

import table.Present;
import dao.Countaccess;

public class Handcount {
	Countaccess countaccess = null;

	public  Handcount() {
		
		 countaccess= new Countaccess();
	}

	public DefaultTableModel showTable() {
		Vector tbvalue = countaccess.selectAll();
		Vector tbtitle=new Vector();
		tbtitle.add("班级");
		tbtitle.add("学号");
		tbtitle.add("出勤");
		tbtitle.add("旷课");
		tbtitle.add("迟到");
		tbtitle.add("事假");
		tbtitle.add("病假");
		return new DefaultTableModel(tbvalue, tbtitle);
	}
	public DefaultTableModel showbynum() {
		Vector tbvalue = countaccess.selectAll();
		Vector tbtitle=new Vector();
		tbtitle.add("班级");
		tbtitle.add("学号");
		tbtitle.add("出勤");
		tbtitle.add("旷课");
		tbtitle.add("迟到");
		tbtitle.add("事假");
		tbtitle.add("病假");
		return new DefaultTableModel(tbvalue, tbtitle);
	}
	public DefaultTableModel findresultbyclass(String x) {
		
		Vector tbvalue = countaccess.selectbyclass(x);
		Vector tbtitle=new Vector();
		tbtitle.add("班级");
		tbtitle.add("学号");
		tbtitle.add("出勤");
		tbtitle.add("旷课");
		tbtitle.add("迟到");
		tbtitle.add("事假");
		tbtitle.add("病假");
	    return new DefaultTableModel(tbvalue, tbtitle);
	}
public DefaultTableModel findresultname(String x) {
		
		Vector tbvalue = countaccess.selectbynum(x);
		Vector tbtitle=new Vector();
		tbtitle.add("班级");
		tbtitle.add("姓名");
		tbtitle.add("出勤");
		tbtitle.add("旷课");
		tbtitle.add("迟到");
		tbtitle.add("事假");
		tbtitle.add("病假");
	return new DefaultTableModel(tbvalue, tbtitle);
	}


public DefaultTableModel findresultbykq(String x) {
	
	Vector tbvalue = countaccess.selectbykq(x);
	Vector tbtitle=new Vector();
	tbtitle.add("班级");
	tbtitle.add("姓名");
	tbtitle.add("次数");
	
    return new DefaultTableModel(tbvalue, tbtitle);
}
	public Present findbyclass(String e) {
		if (countaccess.findByclass(e)!=null)
			return countaccess.findByclass(e);
		return null;
	}
	

}
