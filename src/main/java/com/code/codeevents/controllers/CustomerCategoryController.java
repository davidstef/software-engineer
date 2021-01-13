package com.code.codeevents.controllers;

import com.code.codeevents.data.CustomerCategoryRepository;
import com.code.codeevents.models.CustomerCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("customerCategories")
public class CustomerCategoryController {

    @Autowired
    private CustomerCategoryRepository customerCategoryRepository;

    @GetMapping()
    public String displayAllCategories(Model model) {
        model.addAttribute("title", "All Categories");
        model.addAttribute("categories", customerCategoryRepository.findAll());
        return "customerCategories/index";
    }

    @GetMapping("create")
    public String displayCreateCustomerCategoryForm(Model model) {
        model.addAttribute("title", "Create Customer Category");
        model.addAttribute(new CustomerCategory());
        return "customerCategories/create";
    }

    @PostMapping("create")
    public String processCreateCustomerCategoryForm(@ModelAttribute @Valid CustomerCategory newCustomer,
                                                 Errors errors, Model model) {
        if(errors.hasErrors()) {
            model.addAttribute("title", "Create Customer Category");
            model.addAttribute(newCustomer);
            return "customerCategories/create";
        }
        customerCategoryRepository.save(newCustomer);
        return "redirect:";
    }




}
