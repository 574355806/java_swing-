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
		tbtitle.add("�γ̱��");
		tbtitle.add("�γ�����");
		tbtitle.add("�ڿ���ʦ");
		tbtitle.add("ѧʱ");
		return new DefaultTableModel(tbvalue, tbtitle);
	}
	public DefaultTableModel findresultbynum(String x) {//���ز���ѧ�ŵı�
		
		Vector tbvalue = courseaccess.selectfindbynum(x);
		Vector tbtitle=new Vector();
		tbtitle.add("�γ̱��");
		tbtitle.add("�γ�����");
		tbtitle.add("�ڿ���ʦ");
		tbtitle.add("ѧʱ");
		return new DefaultTableModel(tbvalue, tbtitle);
	}
public DefaultTableModel findresultbyname(String x) {//���ز��������ı�
		
		Vector tbvalue = courseaccess.selectfindbyname(x);
		Vector tbtitle=new Vector();
		tbtitle.add("�γ̱��");
		tbtitle.add("�γ�����");
		tbtitle.add("�ڿ���ʦ");
		tbtitle.add("ѧʱ");
		return new DefaultTableModel(tbvalue, tbtitle);
	}
public DefaultTableModel findresultbyzonghe(Course p) {//���ز���ѧ�ŵı�
	
	Vector tbvalue = courseaccess.selectfindbyzonghe(p);
	Vector tbtitle=new Vector();
	tbtitle.add("�γ̱��");
	tbtitle.add("�γ�����");
	tbtitle.add("�ڿ���ʦ");
	tbtitle.add("ѧʱ");
	return new DefaultTableModel(tbvalue, tbtitle);
}

public DefaultTableModel findresultbyteacher(String x) {//���ز��ҵı�
		
		Vector tbvalue = courseaccess.selectfindbyteacher(x);
		Vector tbtitle=new Vector();
		tbtitle.add("�γ̱��");
		tbtitle.add("�γ�����");
		tbtitle.add("�ڿ���ʦ");
		tbtitle.add("ѧʱ");
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
