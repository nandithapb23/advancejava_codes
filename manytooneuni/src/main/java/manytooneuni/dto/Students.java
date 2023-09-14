package manytooneuni.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Students {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int sid;
	private String sname;
	private long sphone;
	
	@ManyToOne
	private School school;

	public int getSid() {
		return sid;
	}

	public void setSid(int sid) {
		this.sid = sid;
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public long getSphone() {
		return sphone;
	}

	public void setSphone(long sphone) {
		this.sphone = sphone;
	}

	public School getSchool() {
		return school;
	}

	public void setSchool(School school) {
		this.school = school;
	}

	@Override
	public String toString() {
		return "Students [sid=" + sid + ", sname=" + sname + ", sphone=" + sphone + ", school=" + school + "]";
	}
	
	
}
