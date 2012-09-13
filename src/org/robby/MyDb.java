package org.robby;



import java.sql.*;

import com.sina.sae.util.SaeUserInfo;



public class MyDb {
	public Connection initwdb() throws Exception {
		String URL="jdbc:mysql://w.rdc.sae.sina.com.cn:3307/app_myappname";//使用从库的域名
		String username=SaeUserInfo.getAccessKey();
		String password=SaeUserInfo.getSecretKey();
		
		//String URL = "jdbc:mysql://localhost/robbyjava";
		//String username = "root";
		//String password = "robby";
		Class.forName("com.mysql.jdbc.Driver").newInstance();
		Connection con = DriverManager.getConnection(URL, username, password);
		return con;
	}
	
	public Connection initrdb() throws Exception {
		String URL="jdbc:mysql://r.rdc.sae.sina.com.cn:3307/app_myappname";//使用从库的域名
		String username=SaeUserInfo.getAccessKey();
		String password=SaeUserInfo.getSecretKey();
		
		//String URL = "jdbc:mysql://localhost/robbyjava";
		//String username = "root";
		//String password = "robby";
		Class.forName("com.mysql.jdbc.Driver").newInstance();
		Connection con = DriverManager.getConnection(URL, username, password);
		return con;
	}

	public void exec(String sql) throws Exception {
		Connection con = initwdb();
		Statement st = con.createStatement();
		st.execute(sql);
		st.close();
		con.close();
	}

	public ResultSet execQuery(String sql) throws Exception {
		Connection con = initrdb();
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(sql);
		st.close();
		con.close();
		return rs;
	}
}
