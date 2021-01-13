package com.code.codeevents.controllers;

import com.code.codeevents.data.CustomerCategoryRepository;
import com.code.codeevents.data.CustomerRepository;
import com.code.codeevents.models.Customer;
import com.code.codeevents.models.CustomerCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@Controller
@RequestMapping("customers")
public class CustomerController {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private CustomerCategoryRepository customerCategoryRepository;

    @GetMapping
    public String displayAllCustomers(@RequestParam(required = false) Integer categoryId, Model model) {
        if(categoryId == null) {
            model.addAttribute("title", "All Customers");
            model.addAttribute("customers", customerRepository.findAll());
        } else {
            Optional<CustomerCategory> result = customerCategoryRepository.findById(categoryId);
            if (result.isEmpty()) {
                model.addAttribute("title", "Invalid Category ID: " + categoryId);
            } else {
                CustomerCategory category = result.get();
                model.addAttribute("title", "Customer in category: " + category.getName());
                model.addAttribute("customers", category.getCustomers());
            }
        }
        return "customers/index";
    }

    @GetMapping("create")
    public String displayCreateCustomerForm(Model model) {
        model.addAttribute("title", "Add new Customer");
        model.addAttribute(new Customer());
        model.addAttribute("categories", customerCategoryRepository.findAll());
        return "customers/create";
    }

    @PostMapping("create")
    public String processCreateCustomerForm(@ModelAttribute @Valid Customer newCustomer,
                                            Errors errors, Model model) {
        if(errors.hasErrors()) {
            model.addAttribute("title", "Add new Customer");
            return "customers/create";
        }
        customerRepository.save(newCustomer);
        return "redirect:";
    }

    @GetMapping("delete")
    public String displayDeleteCustomersForm(Model model) {
        model.addAttribute("title", "Delete Customer");
        model.addAttribute("customers", customerRepository.findAll());
        return "customers/delete";
    }

    @PostMapping("delete")
    public String processDeleteCustomersForm(@RequestParam(required = false) int[] customerIds) {
        if(customerIds != null) {
            for (int id : customerIds) {
                customerRepository.deleteById(id);
            }
        }

        return "redirect:";
    }

    @GetMapping("detail")
    public String displayCustomerDetails(@RequestParam Integer customerId, Model model) {
        Optional<Customer> result = customerRepository.findById(customerId);

        if(result.isEmpty()) {
            model.addAttribute("title", "Invalid Customer ID: " + customerId);
        } else {
            Customer customer = result.get();
            model.addAttribute("title", customer.getFirstName() + " " + customer.getLastName() + " Details");
            model.addAttribute("customer", customer);
        }

        return "customers/detail";
    }

    @GetMapping("edit")
    public String renderUpdatePetForm(Model model){
        model.addAttribute("title", "Edit Customer");
        model.addAttribute(new Customer());
        model.addAttribute("customerIds", customerRepository.findAll());
        model.addAttribute("categories", customerCategoryRepository.findAll());
        return "customers/edit";
    }

    @PostMapping("edit")
    public String updatePet(@RequestParam(required = false) int[] customerIds, Model model,
                            @ModelAttribute @Valid Customer newCustomer, Errors errors){
        if(errors.hasErrors()){
            model.addAttribute("title", "Edit Customer");
            return "customers/edit";
        }
        if(customerIds != null) {
            for (int id : customerIds) {
                customerRepository.deleteById(id);
            }
        }
        customerRepository.save(newCustomer);

        return "redirect:";
    }


}
