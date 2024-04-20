package live.learnjava.employeeapp.model;

public class Employee {
	private int id;
	private String name;
	private String email;
	private float sal;
	private String addr;
	
	public Employee() {
		
	}

	public Employee(String name, String email, float sal, String addr) {
		super();
		this.name = name;
		this.email = email;
		this.sal = sal;
		this.addr = addr;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public float getSal() {
		return this.sal;
	}

	public void setSal(float sal) {
		this.sal = sal;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", email=" + email + ", sal=" + sal + ", addr=" + addr + "]";
	}

}
