package handle;

import java.util.Vector;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import table.Classes;
import table.Course;
import table.Present;


import dao.Classesaccess;

public class Handleclass {

	Classesaccess classesaccess = new Classesaccess();

	@SuppressWarnings("rawtypes")
	public DefaultTableModel showAlldata() { // ��ʾ������
		Vector tbvalue;
		tbvalue = classesaccess.selectAll();
		return this.showTable(tbvalue);
	}

	//@SuppressWarnings("rawtypes")
	public DefaultTableModel showTablecname(String name) {   //���ݰ༶���Ʋ���
		Vector tbvalue;
		tbvalue = classesaccess.findByName(name);
		return this.showTable(tbvalue);
	}
	
	//@SuppressWarnings("rawtypes")
	public DefaultTableModel showTablecdept(String dept){//����    ��ϵ��Ϊ����
		Vector tbvalue;
		tbvalue = classesaccess.findByDept(dept);
		return this.showTable(tbvalue);
	}
	

	public DefaultTableModel findresultbyzonghe(String num,String name) {//���ز���ѧ�ŵı�
		
		Vector tbvalue = classesaccess.selectfindbyall(num,name);
		Vector tbtitle=new Vector();
		tbtitle.add("�༶���");
		tbtitle.add("�༶����");
		tbtitle.add("����ϵ");
		tbtitle.add("������");
		//tbtitle.add("��������");
		return new DefaultTableModel(tbvalue, tbtitle);
	}

	public DefaultTableModel findresultbydept(String dept) {//���ز���ѧ�ŵı�
		
		Vector tbvalue = classesaccess.selectfindbydept(dept);
		Vector tbtitle=new Vector();
		tbtitle.add("�༶���");
		tbtitle.add("�༶����");
		tbtitle.add("����ϵ");
		tbtitle.add("������");
		//tbtitle.add("��������");
		return new DefaultTableModel(tbvalue, tbtitle);
	}
	
public DefaultTableModel findresultbynum(String num) {//���ز���ѧ�ŵı�
		
		Vector tbvalue = classesaccess.selectfindbynum(num);
		Vector tbtitle=new Vector();
		tbtitle.add("�༶���");
		tbtitle.add("�༶����");
		tbtitle.add("����ϵ");
		tbtitle.add("������");
		//tbtitle.add("��������");
		return new DefaultTableModel(tbvalue, tbtitle);
	}

public DefaultTableModel findresultbyname(String name) {//���ز���ѧ�ŵı�
		
		Vector tbvalue = classesaccess.selectfindbyname(name);
		Vector tbtitle=new Vector();
		tbtitle.add("�༶���");
		tbtitle.add("�༶����");
		tbtitle.add("����ϵ");
		tbtitle.add("������");
		//tbtitle.add("��������");
		return new DefaultTableModel(tbvalue, tbtitle);
	}
	
	
	
	
	//@SuppressWarnings("rawtypes")
	/*public DefaultTableModel showTablectn(String num,String name){//���ң����Ʊ�Ŷ����
		Vector tbvalue = classesaccess.findBytn(num, name);
		System.out.print(tbvalue.toString());
		
		return this.showTable(tbvalue);
		}*/
	
	public DefaultTableModel deleteDatacname(String name){  //�԰༶���� Ϊ����ɾ��
		classesaccess.deleteByname(name);
		return showAlldata();
	}
	public DefaultTableModel deleteDatacnum(String num){
		classesaccess.deleteBynum(num);
		return showAlldata();
	}
	public DefaultTableModel deleteDataall(String num,String name){
		classesaccess.deleteByall(num, name);
		return showAlldata();
	}
	
	@SuppressWarnings("rawtypes")
	/*public DefaultTableModel showTablecnum(String num){       //���ݰ༶��Ų�ѯ
		
		Vector tbvalue;
		tbvalue = classesaccess.findByNum(num);
		return this.showTable(tbvalue);
	}*/
	public DefaultTableModel updataAll(JTable jTable){           //�޸�
		Vector tbvalue;
		String[] strings=new String[5];
		strings= classesaccess.updateClass(jTable);
		
		classesaccess.deleteBynumwutanchuang(strings[0]);//this.deleteDatacnum(strings[0]);
		int count = Integer.parseInt(strings[4]);
		
		this.addClassAll(strings[1],strings[2],strings[3],strings[4]);
		return showAlldata();
	}
	
	//���
	public void addClassAll(String num,String name,String dept,String count){
		 int count1 = Integer.parseInt(count);//ת����string
		if(! classesaccess.findBytn1(num, name))
		{
			classesaccess.addClasswuchuangkou(num, name, dept, count1);
			//return showAlldata();
		}
		else
			JOptionPane.showMessageDialog(null, "�༶�Ѵ���", "���ʧ��", 1);
		 // return null;
		
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public DefaultTableModel showTable(Vector tbvalue) {// ��ʾ������

		Vector tbtitle;
		tbtitle = new Vector();
		tbtitle.add("�༶���");
		tbtitle.add("�༶����");
		tbtitle.add("ϵ��");
		tbtitle.add("������");
		
		return new DefaultTableModel(tbvalue, tbtitle);
	}

}
