package manytomanyuni.controller;

import java.util.ArrayList;
import java.util.List;

import manytomanyuni.dao.Persondao;
import manytomanyuni.dto.Language;
import manytomanyuni.dto.Person;

public class PersonMain {

	public static void main(String[] args) {
		Person p1=new Person();
		p1.setName("vijay");
		p1.setPhone(97979879);
		
		Person p2=new Person();
		p2.setName("ajay");
		p2.setPhone(6868688);
		
		Language l1=new Language();
		l1.setName("english");
		l1.setOrigin("england");
		
		Language l2=new Language();
		l2.setName("kannada");
		l2.setOrigin("karnataka");
		
		List<Language> list=new ArrayList<Language>();
		list.add(l1);
		list.add(l2);
		
		List<Language> list2=new ArrayList<Language>();
		list2.add(l2);
		
		p1.setList(list);
		p2.setList(list2);
		
		Persondao persondao=new Persondao();
//		persondao.savelanguage(l1);
//		persondao.savelanguage(l2);
//		persondao.saveperson(p1);
//		persondao.saveperson(p2);
		Person person=new Person();
		person.setName("jay");
		person.setPhone(786876868);
//		persondao.updateperson(1, person);
//		persondao.deleteperson(1);
		persondao.getallperson();
		
		
	}
}
