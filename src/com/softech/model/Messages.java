package com.softech.model;

public class Messages {
	private int msgid;
	private String msgdatetime;
	private String userid;
	private String userid_to;
	private String message;
	private String status;
	private String sub;
	public String getSubject() {
		return sub;
	}
	public void setSubject(String sub) {
		this.sub = sub;
	}
	public int getMsgid() {
		return msgid;
	}
	public void setMsgid(int msgid) {
		this.msgid = msgid;
	}
	public String getMsgdatetime() {
		return msgdatetime;
	}
	public void setMsgdatetime(String msgdatetime) {
		this.msgdatetime = msgdatetime;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getUserid_to() {
		return userid_to;
	}
	public void setUserid_to(String userid_to) {
		this.userid_to = userid_to;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}


}
