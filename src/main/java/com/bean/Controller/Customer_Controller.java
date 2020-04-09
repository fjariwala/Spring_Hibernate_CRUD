package com.bean.Controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bean.DAO.Customer_DAO;
import com.bean.Entity.Customer;

@Controller
@RequestMapping("/customer")
public class Customer_Controller {

	@Autowired
	private Customer_DAO customerDAO;

	/*
	 * We use @InitBinder annotation to remove front and back white spaces. How it
	 * is gonna work? All the requests(data) coming to '/student' controller will be
	 * trimmed using this method
	 */
	@InitBinder
	public void initBinder(WebDataBinder dataBinder) {

		StringTrimmerEditor trimmer = new StringTrimmerEditor(true);
		// true means if there are all the white spaces , StringTrimmerEditor class will
		// trim it down to null

		dataBinder.registerCustomEditor(String.class, trimmer);
	}

	@GetMapping("/showList")
	// @RequestMapping("/showList")
	public String list(Model model) {

		/* GET the customers from the database */
		List<Customer> customers = customerDAO.getCustomers();

		/* Now adding results to model attributes so that we can use it further */
		model.addAttribute("customers", customers);

		return "/customer/listPage";
	}

	/*
	 * GET method for Form
	 */
	@GetMapping("/viewForm")
	// @RequestMapping("/viewForm")
	public String viewForm(Model model) {

		model.addAttribute("customer", new Customer());

		return "/customer/regForm";
	}

	/*
	 * POST method for Form
	 */
	@PostMapping("/saveFormData")
	// @RequestMapping("/saveFormData")
	public String saveData(@Valid @ModelAttribute("customer") Customer customer, BindingResult theBindedResult,
			Model model) {

		if (theBindedResult.hasErrors()) {
			return "/customer/regForm";
		} else {

			/* If the form has no errors then save it and go to list page */
			String result = customerDAO.saveCustomer(customer);

			model.addAttribute("message", result);

			return "redirect:/customer/showList";
		}

	}

	/*
	 * Update form view => GET method for the form
	 */
	@GetMapping("/updateForm")
	public String updateForm(@RequestParam("customerId") int id, Model model) {

		/* Using getUser() method to get individual data of customers */
		Customer customer = customerDAO.getCustomer(id);

		model.addAttribute("customer", customer);

		return "/customer/updationForm";
	}

	/*
	 * POST method for update form data
	 */
	@PostMapping("/updateFormData")
	public String updateFormData(@Valid @ModelAttribute("customer") Customer customer, BindingResult theBindedResult) {

		if (theBindedResult.hasErrors()) {
			return "/customer/updationForm";
		} else {

//			Customer cus = customerDAO.getCustomer(customer.id);
//
//			cus.setFirstName(customer.firstName);
//			cus.setLastName(customer.getLastName());
//			cus.setEmail(customer.getEmail());

			return "/customer/listPage";
		}

	}

	@GetMapping("/deleteCustomer")
	public String deleteCustomerData(@RequestParam("deleteId") int id) {

		String result = customerDAO.deleteCustomer(id);

		System.out.println(result);

		return "redirect:/customer/showList";
	}

}
