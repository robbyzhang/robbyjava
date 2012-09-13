package org.robby;

import java.util.Vector;

import com.opensymphony.xwork2.ActionSupport;

public class Init extends ActionSupport {
	String status;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String execute() {
		status = "success";
		MyDb db = null;
		try {
			db = new MyDb();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			status = "db init error";
			return SUCCESS;
		}
		
		try {
			db.exec("drop table tab_note");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		}
		
		try {
			db.exec("create table tab_note(id int primary key auto_increment, title varchar(255), content text, ts timestamp NOT NULL default CURRENT_TIMESTAMP)");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return SUCCESS;
	}

	public String insert() throws Exception{
		status = "insert";
		TabNote tn = new TabNote();
		tn.insert("t1", "t1");
		return SUCCESS;
	}
	
	public String select() throws Exception{
		status = "select";
		TabNote tn = new TabNote();
		Vector<Note> list = new Vector<Note>();
		tn.selectAll(list);
		for(Note n:list){
			status += "<p>" + n.getId() + "\t" + n.getTitle() + "\t" + n.getContent() + "\t" + n.getTs() + "</p>";
		}
		return SUCCESS;
	}
}
