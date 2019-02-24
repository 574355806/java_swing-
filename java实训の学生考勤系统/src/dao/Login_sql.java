package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import table.Loginuser;

public class Login_sql {
	Connection con;
	Statement stm=null;
	PreparedStatement pstm=null;
	ResultSet rs;

	
	 public Login_sql() {
		
		try {
			DBconnect db = new DBconnect();
			con = db.getConn();
			stm = con.createStatement();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public boolean findByUserName(String userName) {
		try {
			rs = stm.executeQuery("select * from LogUser where userName='"
					+ userName + "'");
			if (rs.next()) {
				return true;
			}
		} catch (SQLException e) {
		    e.printStackTrace();
		}
		return false;
	}

	public boolean findlogin(Loginuser logUser) {
		try {
			rs = stm.executeQuery("select * from loginin where username='"
					+ logUser.getUserName() + "' and password='"
					+ logUser.getPassword() + "'");
			if (rs.next()) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public void insert(Loginuser logUser) {
		String sql = "insert into Loginuser values('"+logUser.getUserName()+"', '"+logUser.getPassword()+"')";
		try {
			/*stm = con.createStatement();
			stm.execute(sql);
		    stm.executeUpdate(sql);*/
			pstm = con.prepareStatement(sql);
			/*pstm.setString(1, logUser.getUserName());
			pstm.setString(2, logUser.getPassword());
			*/pstm.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	public void delete(Loginuser logUser) {  
		String  nameString=logUser.getUserName();//É¾³ý²éÕÒµÄ
		String sql = "delete  from Loginuser where userName=" +
				"'"+ nameString + "'";
		try {
			stm = con.createStatement();
			stm.execute(sql);
		    stm.executeUpdate(sql);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

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
