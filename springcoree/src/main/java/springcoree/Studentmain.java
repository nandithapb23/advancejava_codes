package springcoree;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Studentmain {

	public static void main(String[] args) {
		BeanFactory beanFactory=new ClassPathXmlApplicationContext("student.xml");
		Student student=(Student) beanFactory.getBean("student");
		System.out.println(student.getName());
		System.out.println(student.getMarks());
	}
}
