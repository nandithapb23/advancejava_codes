package springcoree;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Person {

	@Autowired//to build a relationship 
	@Qualifier(value = "pen")//to give output and btwn primary and qualifier the priority will be given for qualifier only
	private Item item;
	
	void itemused() {
		item.used();
	}
}
