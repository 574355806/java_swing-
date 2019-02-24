package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import table.Present;

public class Countaccess {

	
		Connection con;
		Statement stm;
		PreparedStatement pstm;
		ResultSet rs;
	     public Countaccess()  {
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
	    		rs=stm.executeQuery("select distinct classnum,studentnum from KQmannger");
	    		while(rs.next()){
	    			Vector v=new Vector();
	    			v.add(rs.getString(1));
	    			v.add(rs.getString(2));
	    			//v.add(rs.getString(3));
	    			//v.add(rs.getString(4));
	    		    vector.add(v);
	    		}
	    	}catch(SQLException sqle){sqle.printStackTrace();
	    	}
	    	return vector;
	    }
	    public Vector selectbyclass(String x){
	    	Vector vector= new Vector();
	    		try{
	    		stm=con.createStatement();
	    		rs=stm.executeQuery("select  distinct studentnum,classnum from KQmannger where classnum='"+x+"'");
	    		while(rs.next()){
	    			Vector v=new Vector();
	    			v.add(rs.getString(2));
	    			v.add(rs.getString(1));
	    			vector.add(v);
	    		}
	    	}catch(SQLException sqle){sqle.printStackTrace();
	    	}
	    	return vector;
	    }
	    

	    public Vector selectbykq(String x){
	    	Vector vector= new Vector();
	    	//if(x==null) return selectAll();
	    	//else
	    	try{
	    		stm=con.createStatement();
	    		rs=stm.executeQuery("select  distinct studentnum,classnum,type1 from KQmannger where type1='"+x+"'");
	    		while(rs.next()){
	    			Vector v=new Vector();
	    			v.add(rs.getString(2));
	    			v.add(rs.getString(1));
	    			//v.add(rs.getString(3));
	    			//v.add(rs.getString(5));
	    			vector.add(v);
	    		}
	    	}catch(SQLException sqle){sqle.printStackTrace();
	    	}
	    	return vector;
	    }
	    
	    public Vector selectbynum(String x){
	    	Vector vector= new Vector();
	    	//if(x==null) return selectAll();
	    	//else
	    	try{
	    		stm=con.createStatement();
	    		rs=stm.executeQuery("select  distinct studentnum,classnum,type1 from KQmannger where studentnum='"+x+"'");
	    		
	    		while(rs.next()){
	    			Vector v=new Vector();
	    			v.add(rs.getString(2));
	    			v.add(rs.getString(1));
	    			v.add(rs.getString(3));
	    			//v.add(rs.getString(5));
	    			vector.add(v);
	    		}
	    	}catch(SQLException sqle){sqle.printStackTrace();
	    	}
	    	return vector;
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
				while (rs.next()) {
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
				+ p.getclassnum() + "'";
			Present x;
			try {
				rs = stm.executeQuery(sql);
				while (rs.next()) {
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
				e.printStackTrace();
			}

		}

}
