package springcoree;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Employemain {

	public static void main(String[] args) {
		ApplicationContext applicationContext=new ClassPathXmlApplicationContext("employe.xml");
		Employe employe=(Employe) applicationContext.getBean("employe");
		System.out.println(employe);
	}
}
