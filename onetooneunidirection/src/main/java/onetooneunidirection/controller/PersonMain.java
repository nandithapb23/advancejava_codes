package onetooneunidirection.controller;

import java.util.Scanner;

import onetooneunidirection.dao.Persondao;
import onetooneunidirection.dto.Pancard;
import onetooneunidirection.dto.Person;

public class PersonMain {

	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		Person person=new Person();
		Persondao persondao=new Persondao();
		Pancard pancard=new Pancard();
		boolean check=true;
		do {
			System.out.println("1.save person \n 2.update person \n 3.delete person \n 4.get person by id"
					+ "\n 5.get all person");
			int choice=scanner.nextInt();
			switch (choice) {
			case 1:{
				System.out.println("enter the name");
				String name=scanner.next();
				System.out.println("enter the address");
				String address=scanner.next();
				
				person.setName(name);
				person.setAddress(address);
				
				System.out.println("enter the pancard name");
				String pname=scanner.next();
				System.out.println("enter the pancard address");
				String paddress=scanner.next();
				
				pancard.setName(pname);
				pancard.setAddress(paddress);
				
				person.setPancard(pancard);
				
				persondao.saveperson(person);
			}
			break;
			case 2:{
				System.out.println("enter the id");
				int id=scanner.nextInt();
				System.out.println("enter the updating name");
				String name=scanner.next();
				System.out.println("enter the updating address");
				String address=scanner.next();
				
				person.setId(id);
				person.setName(name);
				person.setAddress(address);
				
				persondao.updatePerson(id, person);
			}
			break;
			case 3:{
				System.out.println("enter the id");
				int id=scanner.nextInt();
				
				persondao.deleteperson(id);
			}
			break;
			case 4:{
				System.out.println("enter the id");
				int id=scanner.nextInt();
				
				persondao.getpersonbyid(id);
			}
			break;
			case 5:{
				persondao.getallperson();
			}
			break;

			default:
				break;
			}
		} while (check);
	}
}
