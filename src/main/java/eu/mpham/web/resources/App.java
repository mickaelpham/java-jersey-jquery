package eu.mpham.web.resources;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import eu.mpham.web.model.Customer;

@Path("/")
public class App {
	
	private static Map<Integer, Customer> customers;
	
	static {
		customers = new HashMap<Integer, Customer>();
		Customer c = new Customer("Mickael Pham", "mickael.pham@outlook.com", "+1 (408) 646-0219");
		customers.put(c.getId(), c);
		c = new Customer("Jenny Murray", "jennydmurray@gmail.com", "+1 (951) 329-1745");
		customers.put(c.getId(), c);
	}

	@GET
	@Path("customers")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Customer> getCustomerInJSON() {
		return new ArrayList<Customer>(customers.values());
	}
	
	@POST
	@Path("customer")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public void postCustomer(@FormParam("name") String name, @FormParam("email") String email, @FormParam("phone") String phone) {
//		System.out.println("Added new customer: " + name + " (" + email + ")");
		Customer c = new Customer(name, email, phone);
		customers.put(c.getId(), c);
	}
}
