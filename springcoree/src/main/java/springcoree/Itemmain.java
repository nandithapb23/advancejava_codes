package springcoree;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Itemmain {

	public static void main(String[] args) {
		ApplicationContext applicationContext=new AnnotationConfigApplicationContext(Myconfiguration.class);
		Person person=applicationContext.getBean("person",Person.class);
		person.itemused();
	}
}
