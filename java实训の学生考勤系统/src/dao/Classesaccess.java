package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import javax.print.DocFlavor.STRING;
import javax.swing.JOptionPane;
import javax.swing.JTable;

import handle.Handleclass;
import table.Classes;
import table.Present;

public class Classesaccess { // 关于班级管理的一系列具体操作

	int u;
	DBconnect dBconnect = null;
	PreparedStatement pstm = null;
	java.sql.Connection con = null;
	ResultSet rs = null;
	Statement stm;
	
	public Classesaccess() {
		dBconnect = new DBconnect();
		con = dBconnect.getConn(); // 获得连接
	}

	@SuppressWarnings({ "rawtypes" })
	public Vector selectAll() { // 获得列表中数据

		String sql = "select * from classmeg";
		try {
			pstm = con.prepareStatement(sql);
			rs = pstm.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return this.datala(rs);
	}

	@SuppressWarnings({ "rawtypes" })
	public Vector findByName(String name) { // 通过班级名称找到班级

		String sql = "select * from classmeg where classname='" + name + "'";

		try {
			pstm = con.prepareStatement(sql);
			rs = pstm.executeQuery();
			if (!rs.next()) {
				JOptionPane.showMessageDialog(null, "查找失败，您查找的班级不存在！", "查找", 1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return this.datala(rs);

	}

	@SuppressWarnings("rawtypes")
	public Vector findByNum(String num) { // 通过班级编号查找班级

		String sql = "select * from classmeg where classnum = '" + num + "'";
		try {
			pstm = con.prepareStatement(sql);
			rs = pstm.executeQuery();
			if (!rs.next()) {
				JOptionPane.showMessageDialog(null, "查找失败，您查找的班级不存在！", "查找", 1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return this.datala(rs);
	}

	@SuppressWarnings("rawtypes")
	public Vector findByDept(String dept) { // 当没有班级信息的时候以系为查询依据

		String sql = "select * from classmeg where dept = '" + dept + "'";
		try {
			pstm = con.prepareStatement(sql);
			rs = pstm.executeQuery();
			if (!rs.next()) {
				JOptionPane.showMessageDialog(null, "查找失败，您查找的班级不存在！", "查找", 1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return this.datala(rs);
	}
	

	@SuppressWarnings("rawtypes")
	public Vector findBytn(String num, String name) {// 编号和名称都填的时候
		String sql = "select * from classmeg where classnum = '" + num + "'  " + "and classname = '" + name + "'";
		try {
			pstm = con.prepareStatement(sql);
			rs = pstm.executeQuery();
			if (!rs.next()) {
				
				JOptionPane.showMessageDialog(null, "查找失败，您查找的班级不存在！", "查找", 1);
			return null;}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return this.datala(rs);
	}
	
	 public Vector selectfindbyall(String num,String name){
	    	Vector vector= new Vector();
	    	//if(x==null) return selectAll();
	    	//else
	    	try{
	    		stm=con.createStatement();
	    		rs=stm.executeQuery("select * from classmeg where classnum = '" + num + "' and " + " classname = '" + name + "'");
	    		while(rs.next()){
	    			Vector v=new Vector();
	    			v.add(rs.getString(1));
	    			v.add(rs.getString(2));
	    			v.add(rs.getString(3));
	    			v.add(rs.getString(4));
	    			//v.add(rs.getString(5));
	    			vector.add(v);
	    		}
	    	}catch(SQLException sqle){sqle.printStackTrace();
	    	}
	    	return vector;
	    }
	 
	 
	 public Vector selectfindbynum(String num){
	    	Vector vector= new Vector();
	    	//if(x==null) return selectAll();
	    	//else
	    	try{
	    		stm=con.createStatement();
	    		rs=stm.executeQuery("select * from classmeg where classnum = '" + num  + "'");
	    		while(rs.next()){
	    			Vector v=new Vector();
	    			v.add(rs.getString(1));
	    			v.add(rs.getString(2));
	    			v.add(rs.getString(3));
	    			v.add(rs.getString(4));
	    			//v.add(rs.getString(5));
	    			vector.add(v);
	    		}
	    	}catch(SQLException sqle){sqle.printStackTrace();
	    	}
	    	return vector;
	    }
	 public Vector selectfindbydept(String dept){
	    	Vector vector= new Vector();
	    	//if(x==null) return selectAll();
	    	//else
	    	try{
	    		stm=con.createStatement();
	    		rs=stm.executeQuery("select * from classmeg where dept = '" + dept  + "'");
	    		while(rs.next()){
	    			Vector v=new Vector();
	    			v.add(rs.getString(1));
	    			v.add(rs.getString(2));
	    			v.add(rs.getString(3));
	    			v.add(rs.getString(4));
	    			//v.add(rs.getString(5));
	    			vector.add(v);
	    		}
	    	}catch(SQLException sqle){sqle.printStackTrace();
	    	}
	    	return vector;
	    }
	
	 public Vector selectfindbyname(String name){
	    	Vector vector= new Vector();
	    	//if(x==null) return selectAll();
	    	//else
	    	try{
	    		stm=con.createStatement();
	    		rs=stm.executeQuery("select * from classmeg where classname = '" + name  + "'");
	    		while(rs.next()){
	    			Vector v=new Vector();
	    			v.add(rs.getString(1));
	    			v.add(rs.getString(2));
	    			v.add(rs.getString(3));
	    			v.add(rs.getString(4));
	    			//v.add(rs.getString(5));
	    			vector.add(v);
	    		}
	    	}catch(SQLException sqle){sqle.printStackTrace();
	    	}
	    	return vector;
	    }
	
	
	
	public boolean findBytn1(String num, String name) {// 编号和名称都填的时候
		String sql = "select * from classmeg where classnum = '" + num + "'  " + "and classname = '" + name + "'";
		try {
			pstm = con.prepareStatement(sql);
			rs = pstm.executeQuery();
			if (!rs.next()) {
				System.out.print("rs.getString(1)");

			return false;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.print("rs.getString(1)");
	return true;
	}

	public void deleteByname(String name) { // 根据班级名称删除

		String sql = "delete from classmeg where classname = '" + name + "'";
		try {
			pstm = con.prepareStatement(sql);
			u = pstm.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (u == 1) {
			JOptionPane.showMessageDialog(null, "删除成功！", "删除", 1);
		} else {
			JOptionPane.showMessageDialog(null, "删除失败，没有您要删除的班级。", "删除", 1);
		}
	}

	public void deleteBynum(String num) {     //根据班级编号删除
		String sql = "delete from classmeg where classnum = '" + num + "'";
		try {
			pstm = con.prepareStatement(sql);
			u = pstm.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (u == 1) {
			JOptionPane.showMessageDialog(null, "删除成功！", "删除", 1);
		} else {
			JOptionPane.showMessageDialog(null, "删除失败，没有您要删除的班级。", "删除", 1);
		}

	}
	public void deleteBynumwutanchuang(String num) {     //根据班级编号删除
		String sql = "delete from classmeg where classnum = '" + num + "'";
		try {
			pstm = con.prepareStatement(sql);
			u = pstm.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void deleteByall(String num,String name) {     //根据班级编号删除
		String sql = "delete from classmeg where classnum = '" + num + "'and classname='"+name+"'";
		try {
			pstm = con.prepareStatement(sql);
			u = pstm.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (u >0) {
			JOptionPane.showMessageDialog(null, "删除成功！", "删除", 1);
		} else {
			JOptionPane.showMessageDialog(null, "删除失败，没有您要删除的班级。", "删除", 1);
		}

	}

	public void addClass(String num, String name, String dept, int count) { //添加
		
		String sql = "insert into classmeg values('" + num + "','" + name + "','" + dept + "','" + count + "')";
		try {
			
			pstm = con.prepareStatement(sql);
			u = pstm.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (u == 1) {
			JOptionPane.showMessageDialog(null, "添加成功", "添加", 1);
		} 
		else {
			JOptionPane.showMessageDialog(null, "添加失败", "添加", 1);
		}
	}
public void addClasswuchuangkou(String num, String name, String dept, int count) { //添加
		
		String sql = "insert into classmeg values('" + num + "','" + name + "','" + dept + "','" + count + "')";
		try {
			
			pstm = con.prepareStatement(sql);
			u = pstm.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
public void addClasswutanchuang(String num, String name, String dept, int count) { //添加
		
		String sql = "insert into classmeg values('" + num + "','" + name + "','" + dept + "','" + count + "')";
		try {
			
			pstm = con.prepareStatement(sql);
			u = pstm.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public String[] updateClass(JTable jTable) {//修改

		int row = jTable.getSelectedRow(); 
		 
		String classnum1 = jTable.getValueAt(row, 0).toString();
		int a = jTable.getEditingRow();
		int c = jTable.getEditingColumn();// 获得编辑的单元格位置
		jTable.getCellEditor(a, c).stopCellEditing(); // 停止编辑时更新

		String classnum2 = jTable.getValueAt(row, 0).toString();
		String classname=  jTable.getValueAt(row, 1).toString();
		String dept =  jTable.getValueAt(row, 2).toString();
	    String count = jTable.getValueAt(row, 3).toString();
		//String count1 = String.valueOf(count);
        String[] strings = new String[5];
        int x = JOptionPane.showInternalConfirmDialog(jTable, "确定修改？", "取消", JOptionPane.YES_NO_OPTION,
				JOptionPane.INFORMATION_MESSAGE);
		if(x==0){		
		    strings[0] = new String(classnum1);
		    strings[1] = new String(classnum2);
		    strings[2] = new String(classname);
		    strings[3] = new String(dept);
		    strings[4] = new String(count);
		   }
		return strings;
	}

	
	@SuppressWarnings("rawtypes")
	public Vector datala(ResultSet rs) { // 将重复步骤写成一个方法，减少工作量

		Vector vector1 = new Vector();

		try {
			while (rs.next()) {
				Vector vector = new Vector();
				vector.add(rs.getString(1));// 班级编号
				vector.add(rs.getString(2));// 班级名称
				vector.add(rs.getString(3));// 系别
				vector.add(rs.getInt(4));// 总人数
				vector1.add(vector);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return vector1;
	}

}
