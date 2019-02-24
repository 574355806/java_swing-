package handle;

import java.util.Vector;

import javax.print.attribute.standard.PresentationDirection;
import javax.swing.table.DefaultTableModel;

import dao.Precentaccess;

import table.Present;

public class Handlepresent {
	Precentaccess precentaccess = null;

	public  Handlepresent() {
		
		precentaccess = new Precentaccess();
	}

	public DefaultTableModel showTable() {
		Vector tbvalue = precentaccess.selectAll();
		Vector tbtitle=new Vector();
		tbtitle.add("�༶");
		tbtitle.add("ѧ��ѧ��");
		tbtitle.add("�γ�");
		tbtitle.add("�γ�ʱ��");
		tbtitle.add("��������");
		return new DefaultTableModel(tbvalue, tbtitle);
	}
	public DefaultTableModel findresult(String x) {//���ز���ѧ�ŵı�
		
		Vector tbvalue = precentaccess.selectfindbynum(x);
		Vector tbtitle=new Vector();
		tbtitle.add("�༶");
		tbtitle.add("ѧ��ѧ��");
		tbtitle.add("�γ�");
		tbtitle.add("�γ�ʱ��");
		tbtitle.add("��������");
		return new DefaultTableModel(tbvalue, tbtitle);
	}
public DefaultTableModel findresultbyclass(String x) {//���ز���ѧ�ŵı�
		
		Vector tbvalue = precentaccess.selectfindbyclass(x);
		Vector tbtitle=new Vector();
		tbtitle.add("�༶");
		tbtitle.add("ѧ��ѧ��");
		tbtitle.add("�γ�");
		tbtitle.add("�γ�ʱ��");
		tbtitle.add("��������");
		return new DefaultTableModel(tbvalue, tbtitle);
	}
public DefaultTableModel findresultbyzonghe(Present p) {//���ز���ѧ�ŵı�
	
	Vector tbvalue = precentaccess.selectfindbyzonghe(p);
	Vector tbtitle=new Vector();
	tbtitle.add("�༶");
	tbtitle.add("ѧ��ѧ��");
	tbtitle.add("�γ�");
	tbtitle.add("�γ�ʱ��");
	tbtitle.add("��������");
	return new DefaultTableModel(tbvalue, tbtitle);
}

public DefaultTableModel findresultbykq(String x) {//���ز��ҵı�
		
		Vector tbvalue = precentaccess.selectfindbykq(x);
		Vector tbtitle=new Vector();
		tbtitle.add("�༶");
		tbtitle.add("ѧ��ѧ��");
		tbtitle.add("�γ�");
		tbtitle.add("�γ�ʱ��");
		tbtitle.add("��������");
		return new DefaultTableModel(tbvalue, tbtitle);
	}

	public boolean add(Present e) {
		return precentaccess.addinformatioon(e);
	}
	public Present findbyname(String e) {
		if (precentaccess.findByName(e)!=null)
			return precentaccess.findByName(e);
		return null;
	}
	public Present findbyclass(String e) {
		if (precentaccess.findByclass(e)!=null)
			return precentaccess.findByclass(e);
		return null;
	}
	public boolean findbyzonghe(Present e) {
		if (precentaccess.findByzonghepresent(e)!=null)
			return true;
		return false;
	}
	
	public boolean delete(String zcno) {
		return precentaccess.delete(zcno);
	}
	public boolean deletep(Present zcno) {
		return precentaccess.deletep(zcno);
	}
	public Present findzonghe(Present p) {
		return precentaccess.findByzonghepresent(p);
	}
	public Present findzonghedelete(Present p) {
		return precentaccess.findByzonghepresent(p);
	}

}
