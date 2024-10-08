package com.example.domain;

import java.util.Date;

public class EnrollVO {
	private String scode;
	private String lcode;
	private Date edate;
	private int grade;
	
	public String getScode() {
		return scode;
	}
	public void setScode(String scode) {
		this.scode = scode;
	}
	public String getLcode() {
		return lcode;
	}
	public void setLcode(String lcode) {
		this.lcode = lcode;
	}
	public Date getEdate() {
		return edate;
	}
	public void setEdate(Date edate) {
		this.edate = edate;
	}
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
	@Override
	public String toString() {
		return "EnrollVO [scode=" + scode + ", lcode=" + lcode + ", edate=" + edate + ", grade=" + grade + "]";
	}
}