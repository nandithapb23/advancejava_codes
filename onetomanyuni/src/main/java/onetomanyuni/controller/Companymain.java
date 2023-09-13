package onetomanyuni.controller;

import java.util.ArrayList;
import java.util.List;

import onetomanyuni.dao.Companydao;
import onetomanyuni.dto.Company;
import onetomanyuni.dto.Employee;

public class Companymain {

	public static void main(String[] args) {
		Company company=new Company();
		company.setCname("wipro");
		company.setCaddress("bangalore");
		
		Employee e1=new Employee();
//		e1.setId(1);
		e1.setName("ajay");
		e1.setPhone(9798797);
		
		Employee e2=new Employee();
//		e2.setId(2);
		e2.setName("raj");
		e2.setPhone(868799);
		
		List<Employee> list=new ArrayList();
		list.add(e1);
		list.add(e2);
		
		company.setList(list);
		Companydao companydao=new Companydao();
//		companydao.savecompany(company);
//		companydao.updatecompany(1, company);
//		companydao.deletecompany(2);
//		companydao.getcompanybyid(1);
		companydao.getallcompany();
		
	}
}
