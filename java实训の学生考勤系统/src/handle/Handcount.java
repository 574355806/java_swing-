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
		tbtitle.add("�༶");
		tbtitle.add("ѧ��");
		tbtitle.add("����");
		tbtitle.add("����");
		tbtitle.add("�ٵ�");
		tbtitle.add("�¼�");
		tbtitle.add("����");
		return new DefaultTableModel(tbvalue, tbtitle);
	}
	public DefaultTableModel showbynum() {
		Vector tbvalue = countaccess.selectAll();
		Vector tbtitle=new Vector();
		tbtitle.add("�༶");
		tbtitle.add("ѧ��");
		tbtitle.add("����");
		tbtitle.add("����");
		tbtitle.add("�ٵ�");
		tbtitle.add("�¼�");
		tbtitle.add("����");
		return new DefaultTableModel(tbvalue, tbtitle);
	}
	public DefaultTableModel findresultbyclass(String x) {
		
		Vector tbvalue = countaccess.selectbyclass(x);
		Vector tbtitle=new Vector();
		tbtitle.add("�༶");
		tbtitle.add("ѧ��");
		tbtitle.add("����");
		tbtitle.add("����");
		tbtitle.add("�ٵ�");
		tbtitle.add("�¼�");
		tbtitle.add("����");
	    return new DefaultTableModel(tbvalue, tbtitle);
	}
public DefaultTableModel findresultname(String x) {
		
		Vector tbvalue = countaccess.selectbynum(x);
		Vector tbtitle=new Vector();
		tbtitle.add("�༶");
		tbtitle.add("����");
		tbtitle.add("����");
		tbtitle.add("����");
		tbtitle.add("�ٵ�");
		tbtitle.add("�¼�");
		tbtitle.add("����");
	return new DefaultTableModel(tbvalue, tbtitle);
	}


public DefaultTableModel findresultbykq(String x) {
	
	Vector tbvalue = countaccess.selectbykq(x);
	Vector tbtitle=new Vector();
	tbtitle.add("�༶");
	tbtitle.add("����");
	tbtitle.add("����");
	
    return new DefaultTableModel(tbvalue, tbtitle);
}
	public Present findbyclass(String e) {
		if (countaccess.findByclass(e)!=null)
			return countaccess.findByclass(e);
		return null;
	}
	

}
