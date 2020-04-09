package com.bean.DAO;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.bean.Entity.Customer;

/*
 * This annotation automatically registers our DAO class into the dispatcher-servlet.xml file
 * This work of automatically registration is done by Spring in the back-end
 * */
@Repository
public class Customer_DAO_Impl implements Customer_DAO {

	/* Need to inject the session factory from dispatcher-servlet file here */
	/*
	 * We write 'Autowired' just to connect our sessionFactory object from This
	 * class to the dispatcher-servlet's step 2's id object
	 */
	@Autowired
	private SessionFactory sessionFactory;

	/*
	 * @Transactional => This annotation is used for : When we use this annotation
	 * it automatically begins the transaction and it automatically commits the
	 * transaction
	 */
	@Transactional
	public List<Customer> getCustomers() {
		// TODO Auto-generated method stub

		// getting the current session
		Session session = sessionFactory.getCurrentSession();

		// Creating the query and storing it as a list
		Query<Customer> query = session.createQuery("from Customer", Customer.class);

		// getting the results from the query
		List<Customer> customer = query.getResultList();

		return customer;
	}

	@Transactional
	public String saveCustomer(Customer customer) {
		// TODO Auto-generated method stub

		Session session = sessionFactory.getCurrentSession();

		/*
		 * SaveOrUpdate working => If the id is null then it will save the object, But
		 * if it is not null then it will update the object value
		 */
		session.saveOrUpdate(customer);

		return "You are successfully registered with email id :" + customer.getEmail();
	}

	/*
	 * This method is for getting an individual customer from the database
	 */
	@Transactional
	public Customer getCustomer(int id) {
		// TODO Auto-generated method stub

		/* First making session object for data manipulation */
		Session session = sessionFactory.getCurrentSession();

		/* Getting data into the Customer object using specific ID */
		Customer customer = session.get(Customer.class, id);

		return customer;
	}

	@Transactional
	public String deleteCustomer(int id) {
		// TODO Auto-generated method stub

		Session session = sessionFactory.getCurrentSession();

		Customer customer = session.get(Customer.class, id);

		session.delete(customer);

		return "Customer with userId='" + id + "' is Successfully deleted";
	}

}
