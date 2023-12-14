package com.feuji.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "student")
public class Student {
	
	@Id
	@Column(name="studentId")
	private int studentId;
	@Column(name="studentName")
	private String studentName;
	@Column(name="studentAge")
	private int studentAge;
	@Column(name="studentPhno")
	private long studentPhno;
	@OneToOne(mappedBy = "student")
	private StudentMarks marks;
	public int getStudentId() {
		return studentId;
	}
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public int getStudentAge() {
		return studentAge;
	}
	public void setStudentAge(int studentAge) {
		this.studentAge = studentAge;
	}
	public long getStudentPhno() {
		return studentPhno;
	}
	public void setStudentPhno(long studentPhno) {
		this.studentPhno = studentPhno;
	}
	@Override
	public String toString() {
		return "Student [studentId=" + studentId + ", studentName=" + studentName + ", studentAge=" + studentAge
				+ ", studentPhno=" + studentPhno + "]";
	}
	
	

}
