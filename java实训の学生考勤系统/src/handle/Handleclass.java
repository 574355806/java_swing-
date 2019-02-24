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
	public DefaultTableModel showAlldata() { // 显示表数据
		Vector tbvalue;
		tbvalue = classesaccess.selectAll();
		return this.showTable(tbvalue);
	}

	//@SuppressWarnings("rawtypes")
	public DefaultTableModel showTablecname(String name) {   //根据班级名称查找
		Vector tbvalue;
		tbvalue = classesaccess.findByName(name);
		return this.showTable(tbvalue);
	}
	
	//@SuppressWarnings("rawtypes")
	public DefaultTableModel showTablecdept(String dept){//查找    以系别为依据
		Vector tbvalue;
		tbvalue = classesaccess.findByDept(dept);
		return this.showTable(tbvalue);
	}
	

	public DefaultTableModel findresultbyzonghe(String num,String name) {//返回查找学号的表
		
		Vector tbvalue = classesaccess.selectfindbyall(num,name);
		Vector tbtitle=new Vector();
		tbtitle.add("班级编号");
		tbtitle.add("班级名称");
		tbtitle.add("所在系");
		tbtitle.add("总人数");
		//tbtitle.add("考勤类型");
		return new DefaultTableModel(tbvalue, tbtitle);
	}

	public DefaultTableModel findresultbydept(String dept) {//返回查找学号的表
		
		Vector tbvalue = classesaccess.selectfindbydept(dept);
		Vector tbtitle=new Vector();
		tbtitle.add("班级编号");
		tbtitle.add("班级名称");
		tbtitle.add("所在系");
		tbtitle.add("总人数");
		//tbtitle.add("考勤类型");
		return new DefaultTableModel(tbvalue, tbtitle);
	}
	
public DefaultTableModel findresultbynum(String num) {//返回查找学号的表
		
		Vector tbvalue = classesaccess.selectfindbynum(num);
		Vector tbtitle=new Vector();
		tbtitle.add("班级编号");
		tbtitle.add("班级名称");
		tbtitle.add("所在系");
		tbtitle.add("总人数");
		//tbtitle.add("考勤类型");
		return new DefaultTableModel(tbvalue, tbtitle);
	}

public DefaultTableModel findresultbyname(String name) {//返回查找学号的表
		
		Vector tbvalue = classesaccess.selectfindbyname(name);
		Vector tbtitle=new Vector();
		tbtitle.add("班级编号");
		tbtitle.add("班级名称");
		tbtitle.add("所在系");
		tbtitle.add("总人数");
		//tbtitle.add("考勤类型");
		return new DefaultTableModel(tbvalue, tbtitle);
	}
	
	
	
	
	//@SuppressWarnings("rawtypes")
	/*public DefaultTableModel showTablectn(String num,String name){//查找，名称编号都填的
		Vector tbvalue = classesaccess.findBytn(num, name);
		System.out.print(tbvalue.toString());
		
		return this.showTable(tbvalue);
		}*/
	
	public DefaultTableModel deleteDatacname(String name){  //以班级名称 为依据删除
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
	/*public DefaultTableModel showTablecnum(String num){       //根据班级编号查询
		
		Vector tbvalue;
		tbvalue = classesaccess.findByNum(num);
		return this.showTable(tbvalue);
	}*/
	public DefaultTableModel updataAll(JTable jTable){           //修改
		Vector tbvalue;
		String[] strings=new String[5];
		strings= classesaccess.updateClass(jTable);
		
		classesaccess.deleteBynumwutanchuang(strings[0]);//this.deleteDatacnum(strings[0]);
		int count = Integer.parseInt(strings[4]);
		
		this.addClassAll(strings[1],strings[2],strings[3],strings[4]);
		return showAlldata();
	}
	
	//添加
	public void addClassAll(String num,String name,String dept,String count){
		 int count1 = Integer.parseInt(count);//转换成string
		if(! classesaccess.findBytn1(num, name))
		{
			classesaccess.addClasswuchuangkou(num, name, dept, count1);
			//return showAlldata();
		}
		else
			JOptionPane.showMessageDialog(null, "班级已存在", "添加失败", 1);
		 // return null;
		
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public DefaultTableModel showTable(Vector tbvalue) {// 显示表内容

		Vector tbtitle;
		tbtitle = new Vector();
		tbtitle.add("班级编号");
		tbtitle.add("班级名称");
		tbtitle.add("系别");
		tbtitle.add("总人数");
		
		return new DefaultTableModel(tbvalue, tbtitle);
	}

}
