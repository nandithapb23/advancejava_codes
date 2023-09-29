package springcoree;

public class Employe {

	private String name;
	private double salary;
	
	public Employe(String name, double salary) {
		this.name = name;
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Employe [name=" + name + ", salary=" + salary + "]";
	}
	
	
}
