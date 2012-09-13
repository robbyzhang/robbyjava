package org.robby;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Vector;

public class TabNote {

	void insert(String title, String content) throws Exception{
		MyDb db = new MyDb();
		String sql = "insert into tab_note(title, content) ";
		sql = sql + " values('"+ title +"','"+ content +"')";
		db.exec(sql);
	}
	
	void selectAll(Vector<Note> list) throws Exception {
		MyDb db = new MyDb();
		Connection con = db.initrdb();
		String sql = "select id, title, content, ts from tab_note order by ts desc";
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(sql);
		
		while(rs.next()){
			Note n = new Note();
			n.setId(rs.getInt("id"));
			n.setTitle(rs.getString("title"));
			n.setContent(rs.getString("content"));
			n.setTs(rs.getString("ts"));
			list.add(n);
		}
		
		st.close();
		con.close();
	}
}
