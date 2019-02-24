package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import table.Course;
import table.Present;

public class Courseaccess {

	Connection con;
	Statement stm;
	PreparedStatement pstm;
	ResultSet rs;
     public Courseaccess()  {
    	try{
    		DBconnect db=new DBconnect();
    		con=db.getConn();
    	}
    	catch(Exception e){e.printStackTrace();
    	}
    }
    public Vector selectAll(){
    	Vector vector= new Vector();
    	try{
    		stm=con.createStatement();
    		rs=stm.executeQuery("select * from Course");
    		while(rs.next()){
    			Vector v=new Vector();
    			v.add(rs.getString(1));
    			v.add(rs.getString(2));
    			v.add(rs.getString(3));
    			v.add(rs.getString(4));
    			vector.add(v);
    		}
    	}catch(SQLException sqle){sqle.printStackTrace();
    	}
    	return vector;
    }
    public Vector selectfindbynum(String x){
    	Vector vector= new Vector();
    	if(x==null) return selectAll();
    	else
    	try{
    		stm=con.createStatement();
    		rs=stm.executeQuery("select * from Course where coursenum='"+x+"'");
    		while(rs.next()){
    			Vector v=new Vector();
    			v.add(rs.getString(1));
    			v.add(rs.getString(2));
    			v.add(rs.getString(3));
    			v.add(rs.getString(4));
    			vector.add(v);
    		}
    	}catch(SQLException sqle){sqle.printStackTrace();
    	}
    	return vector;
    }
    public Vector selectfindbyname(String x){
    	Vector vector= new Vector();
    	if(x==null) return selectAll();
    	else
    	try{
    		stm=con.createStatement();
    		rs=stm.executeQuery("select * from Course where coursename='"+x+"'");
    		while(rs.next()){
    			Vector v=new Vector();
    			v.add(rs.getString(1));
    			v.add(rs.getString(2));
    			v.add(rs.getString(3));
    			v.add(rs.getString(4));
    			vector.add(v);
    		}
    	}catch(SQLException sqle){sqle.printStackTrace();
    	}
    	return vector;
    }
    
    public Vector selectfindbyteacher(String x){
    	Vector vector= new Vector();
    	if(x==null) return selectAll();
    	else
    	try{
    		stm=con.createStatement();
    		rs=stm.executeQuery("select * from Course where teacher='"+x+"'");
    		while(rs.next()){
    			Vector v=new Vector();
    			v.add(rs.getString(1));
    			v.add(rs.getString(2));
    			v.add(rs.getString(3));
    			v.add(rs.getString(4));
    			vector.add(v);
    		}
    	}catch(SQLException sqle){sqle.printStackTrace();
    	}
    	return vector;
    }
    
    public Vector selectfindbyzonghe(Course x){
    	Vector vector= new Vector();
    	if(x==null) return selectAll();
    	else
    	try{
    		stm=con.createStatement();
    		rs=stm.executeQuery("select * from Course where coursenum='"+x.getcoursenum()+"' and coursename='"
			+ x.getcoursename()+"' and teacher ='"+x.getteacher()+"'");
    		while(rs.next()){
    			Vector v=new Vector();
    			v.add(rs.getString(1));
    			v.add(rs.getString(2));
    			v.add(rs.getString(3));
    			v.add(rs.getString(4));
    			vector.add(v);
    		}
    	}catch(SQLException sqle){sqle.printStackTrace();
    	}
    	return vector;
    }
   
    public boolean addinformatioon(Course e){
        try{
        	stm=con.createStatement();
        	String sql="insert into Course values ('"+e.getcoursenum()+"','"+e.getcoursename()+"','" +
        		         			e.getteacher()+"','"+e.gethours()+"')";
        	int h = stm.executeUpdate(sql);
            if(h==1){
            	return true;
            }else{
            	return false;
            }
    	}catch(SQLException sqle){
    		sqle.printStackTrace();
    		return false;
    	}
    }
    public boolean delete(String empNo){
    	String sql="delete from Course where coursenum='"+empNo+"'";
    	try{
    	stm=con.createStatement();
    	int h=stm.executeUpdate(sql);
    	if(h!=0||h!=-1)
    		return true;
    	else
    		return false;
    	}catch(SQLException e){
    		e.printStackTrace();
    		return false;
    	}
    } 
    public boolean deletezonghe(Course empNo){
    	String sql="delete from Course where coursenum='"+empNo.getcoursenum()+"' and coursename='"+empNo.getcoursename()+"'and teacher='"+empNo.getteacher()+"' ";
    	//String sql1="delete from Course where coursenum='"+empNo.()+"' and teacher='"+empNo.getteacher()+"' ";
    	
    	try{
    	stm=con.createStatement();
    	int h=stm.executeUpdate(sql);
    	if(h!=0||h!=-1)
    		return true;
    	else
    		return false;
    	}catch(SQLException e){
    		e.printStackTrace();
    		return false;
    	}
    } 
    


	public Course findBynum(String userName) {
		Course x;
		try {
			rs = stm.executeQuery("select * from Course where coursenum='"
					+ userName + "'");
			if (rs.next()) {
				x=new Course(rs.getString(1), rs.getString(2), rs.getString(3), Integer.parseInt( rs.getString(4)));
				return x;
			}
		} catch (SQLException e) {
		    e.printStackTrace();
		}
		return null;
	}
	public Course findByteacher(String userName) {
		Course x;
		try {
			rs = stm.executeQuery("select * from Course where teacher='"
					+ userName + "'");
			if (rs.next()) {
				x=new Course(rs.getString(1), rs.getString(2), rs.getString(3), Integer.parseInt( rs.getString(4)));
				return x;
			}
		} catch (SQLException e) {
		    e.printStackTrace();
		}
		return null;
	}

	public Course findByname(String userName) {
		Course x;
		try {
			rs = stm.executeQuery("select * from Course where coursename='"
					+ userName + "'");
			if (rs.next()) {
				x=new Course(rs.getString(1), rs.getString(2), rs.getString(3), Integer.parseInt( rs.getString(4)));
				return x;
			}
		} catch (SQLException e) {
		    e.printStackTrace();
		}
		return null;
	}
	public Course findByzonghe(Course p) {
		String sql="select * from Course where coursenum='"+p.getcoursenum()+"' and teacher='"+p.getteacher()+"' and coursename='"+p.getcoursename()+"'";
		Course x=null;
		try {
			rs = stm.executeQuery(sql);
			if (rs.next()) {
				x=new Course(rs.getString(1), rs.getString(2), rs.getString(3), Integer.parseInt( rs.getString(4)));
				return x;
			}
		} catch (SQLException e) {
		    e.printStackTrace();
		}
		return null;
	}

	public Present findByzonghepresent(Present p) {
		String sql="select * from KQmannger where studentnum='"
			+ p.getstudString() + "'  and classnum='"
			+ p.getclassnum()+"' and course='"+p.getcourse()+"' and time='"+p.gettime()+"'";
		Present x;
		try {
			rs = stm.executeQuery(sql);
			if (rs.next()) {
				x=new Present(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(5), rs.getString(4));
				return x;
			}
		} catch (SQLException e) {
		    e.printStackTrace();
		}
		return null;
	}

	
	public void close() {

		try {
			if (rs != null) {
				rs.close();
			}

			if (stm != null) {
				stm.close();
			}
			if (pstm != null) {
				pstm.close();
			}
			if (con != null) {
				con.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
