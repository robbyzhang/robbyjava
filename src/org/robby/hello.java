package org.robby;


import com.opensymphony.xwork2.ActionSupport;

public class hello extends ActionSupport {
	String str;
	public String getStr() {
		return str;
	}
	public void setStr(String str) {
		this.str = str;
	}
	public String execute() throws Exception {
		str = new String("robby test");
		return SUCCESS;
	}
}
