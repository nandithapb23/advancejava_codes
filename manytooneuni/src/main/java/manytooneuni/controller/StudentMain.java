package manytooneuni.controller;

import manytooneuni.dao.Schooldao;
import manytooneuni.dao.Studentdao;
import manytooneuni.dto.School;
import manytooneuni.dto.Students;

public class StudentMain {

	public static void main(String[] args) {
		Students s1=new Students();
		s1.setSname("bhuvan");
		s1.setSphone(687687679);
		
		Students s2=new Students();
		s2.setSname("divya");
		s2.setSphone(876868768);
		
		School school=new School();
		school.setName("delhi public school");
		school.setAddress("delhi");
		
		s1.setSchool(school);
		s2.setSchool(school);
		
		Schooldao schooldao=new Schooldao();
		Studentdao  studentdao=new Studentdao();
		
//		schooldao.saveschool(school);
//		studentdao.savestudent(s1);
//		studentdao.savestudent(s2);
		
//		Students students=new Students();
//		students.setSname("divya");
//		students.setSphone(98797987);
//		studentdao.updatestudents(1, students);
//		schooldao.updateschool(1, school);
//		studentdao.deletestudents(5);
//		schooldao.deleteschool(3);
//		schooldao.getschoolbyid(2);
//		schooldao.getallschool();
		studentdao.getallstudents();
		
	}
}
