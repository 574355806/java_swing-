package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import table.Present;

public class Precentaccess {

	Connection con;
	Statement stm;
	PreparedStatement pstm;
	ResultSet rs;
     public Precentaccess()  {
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
    		rs=stm.executeQuery("select * from KQmannger");
    		while(rs.next()){
    			Vector v=new Vector();
    			v.add(rs.getString(1));
    			v.add(rs.getString(2));
    			v.add(rs.getString(3));
    			v.add(rs.getString(4));
    			v.add(rs.getString(5));
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
    		rs=stm.executeQuery("select * from KQmannger where studentnum='"+x+"'");
    		while(rs.next()){
    			Vector v=new Vector();
    			v.add(rs.getString(1));
    			v.add(rs.getString(2));
    			v.add(rs.getString(3));
    			v.add(rs.getString(4));
    			v.add(rs.getString(5));
    			vector.add(v);
    		}
    	}catch(SQLException sqle){sqle.printStackTrace();
    	}
    	return vector;
    }
    public Vector selectfindbyclass(String x){
    	Vector vector= new Vector();
    	if(x==null) return selectAll();
    	else
    	try{
    		stm=con.createStatement();
    		rs=stm.executeQuery("select * from KQmannger where classnum='"+x+"'");
    		while(rs.next()){
    			Vector v=new Vector();
    			v.add(rs.getString(1));
    			v.add(rs.getString(2));
    			v.add(rs.getString(3));
    			v.add(rs.getString(4));
    			v.add(rs.getString(5));
    			vector.add(v);
    		}
    	}catch(SQLException sqle){sqle.printStackTrace();
    	}
    	return vector;
    }
    
    public Vector selectfindbykq(String x){
    	Vector vector= new Vector();
    	if(x==null) return selectAll();
    	else
    	try{
    		stm=con.createStatement();
    		rs=stm.executeQuery("select * from KQmannger where type1='"+x+"'");
    		while(rs.next()){
    			Vector v=new Vector();
    			v.add(rs.getString(1));
    			v.add(rs.getString(2));
    			v.add(rs.getString(3));
    			v.add(rs.getString(4));
    			v.add(rs.getString(5));
    			vector.add(v);
    		}
    	}catch(SQLException sqle){sqle.printStackTrace();
    	}
    	return vector;
    }
    
    public Vector selectfindbyzonghe(Present x){
    	Vector vector= new Vector();
    	if(x==null) return selectAll();
    	else
    	try{
    		stm=con.createStatement();
    		rs=stm.executeQuery("select * from KQmannger where studentnum='"+x.getstudString()+"' and classnum='"
			+ x.getclassnum()+"'");
    		while(rs.next()){
    			Vector v=new Vector();
    			v.add(rs.getString(1));
    			v.add(rs.getString(2));
    			v.add(rs.getString(3));
    			v.add(rs.getString(4));
    			v.add(rs.getString(5));
    			vector.add(v);
    		}
    	}catch(SQLException sqle){sqle.printStackTrace();
    	}
    	return vector;
    }
   
    public boolean addinformatioon(Present e){
        try{
        	stm=con.createStatement();
        	String sql="insert into KQmannger values ('"+e.getclassnum()+"','"+e.getstudString()+"','" +
        		         			e.getcourse()+"','"+e.gettime()+"','"+e.gettypeString2()+"')";
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
    	String sql="delete from KQmannger where studentnum='"+empNo+"'";
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
    public boolean deletep(Present empNo){
    	String sql="delete from KQmannger where studentnum='"+empNo.getstudString()+"' and course='"+empNo.getcourse()+"' and time='"+empNo.gettime()+"'";
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
    


	public Present findByName(String userName) {
		Present x;
		try {
			rs = stm.executeQuery("select * from KQmannger where studentnum='"
					+ userName + "'");
			if (rs.next()) {
				x=new Present(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(5), rs.getString(4));
				return x;
			}
		} catch (SQLException e) {
		    e.printStackTrace();
		}
		return null;
	}

	public Present findByclass(String userName) {
		Present x;
		try {
			rs = stm.executeQuery("select * from KQmannger where classnum='"
					+ userName + "'");
			if (rs.next()) {
				x=new Present(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(5), rs.getString(4));
				return x;
			}
		} catch (SQLException e) {
		    e.printStackTrace();
		}
		return null;
	}
	public Present findByzonghe(Present p) {
		String sql="select * from KQmannger where studentnum='"
			+ p.getstudString() + "'  and classnum='"
			+ p.getclassnum()+"'" /*"' and course='"+p.getcourse()+"'"*/;
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
