package eu.mpham.web.resources;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import eu.mpham.web.model.Customer;

@Path("/")
public class App {
	
	private static Map<Integer, Customer> customers;
	
	static {
		customers = new HashMap<Integer, Customer>();
		Customer c = new Customer("Mickael Pham", "mickael.pham@outlook.com", "+1 (408) 931-1041");
		customers.put(c.getId(), c);
	}

	@GET
	@Path("customers")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Customer> getCustomersInJSON() {
		return new ArrayList<Customer>(customers.values());
	}
	
	@GET
	@Path("customer-{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Customer getCustomer(@PathParam("id") Integer customerId) {
		return customers.get(customerId);
	}
	
	@POST
	@Path("customer")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public void postCustomer(@FormParam("name") String name, @FormParam("email") String email, @FormParam("phone") String phone) {
		Customer c = new Customer(name, email, phone);
		customers.put(c.getId(), c);
	}
	
	@PUT
	@Path("customer-{id}")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public void updateCustomer(@PathParam("id") Integer customerId, @FormParam("name") String name, @FormParam("email") String email, @FormParam("phone") String phone) {
		Customer c = customers.get(customerId);
		c.setName(name);
		c.setEmail(email);
		c.setPhone(phone);
	}
	
	@DELETE
	@Path("customer-{id}")
	public void deleteCustomer(@PathParam("id") Integer id) {
		customers.remove(id);
	}
}
