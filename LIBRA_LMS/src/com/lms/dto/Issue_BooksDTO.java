package com.lms.dto;

import java.util.Date;

public class Issue_BooksDTO {
	
	Date issue_date;
	Date return_date;
	public int member_id;
	static String ISBN_issue;
	
	public Date getIssue_date() {
		return issue_date;
	}
	public void setIssue_date(Date issue_date) {
		this.issue_date = issue_date;
	}
	public Date getReturn_date() {
		return return_date;
	}
	public void setReturn_date(Date return_date) {
		this.return_date = return_date;
	}
	public int getMember_id() {
		return member_id;
	}
	public void setMember_id(int member_id) {
		this.member_id = member_id;
	}
	public String getISBN_issue() {
		return ISBN_issue;
	}
	public static void setISBN_issue(String iSBN_issue) {
		ISBN_issue = iSBN_issue;
	}

}
