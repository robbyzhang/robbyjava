package org.robby;

public class Note {
	int id;
	String title;
	String content;
	String ts;
	
	public Note(){
		
	}
	
	public Note(int id, String titile, String content, String ts){
		this.id = id;
		this.title = title;
		this.content = content;
		this.ts = ts;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getTs() {
		return ts;
	}

	public void setTs(String ts) {
		this.ts = ts;
	}
	
	
}
