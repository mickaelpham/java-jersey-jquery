package eu.mpham.web.model;

public class Customer {
	
	private static Integer autoIncrement = 1;

	private Integer id;
	private String name;
	private String email;
	private String phone;
	
	public Customer() {
	}
	
	public Customer(String name, String email, String phone) {
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.id = autoIncrement++;
	}
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
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
	
	public String getPhone() {
		return phone;
	}
	
	public void setPhone(String phone) {
		this.phone = phone;
	}

}
