package com.code.codeevents.controllers;

import com.code.codeevents.data.EventCategoryRepository;
import com.code.codeevents.models.Event;
import com.code.codeevents.models.EventCategory;
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
@RequestMapping("eventCategories")
public class EventCategoryController {

    @Autowired
    private EventCategoryRepository eventCategoryRepository;

    @GetMapping()
    public String displayAllCategories(Model model) {
        model.addAttribute("title", "All Categories");
        model.addAttribute("categories", eventCategoryRepository.findAll());
        return "eventCategories/index";
    }

    // lives at /events/createCategory
    @GetMapping("createCategory")
    public String displayCreateEventCategoryForm(Model model) {
        model.addAttribute("title", "Create Event Category");
        model.addAttribute(new EventCategory());
        return "eventCategories/create";
    }

    // lives at /event/createCategory
    @PostMapping("createCategory")
    public String processCreateEventCategoryForm(@ModelAttribute @Valid EventCategory newEvent,
                                                 Errors errors, Model model) {
        if(errors.hasErrors()) {
            model.addAttribute("title", "Create Event Category");
            model.addAttribute(newEvent);
            return "eventCategories/create";
        }
        eventCategoryRepository.save(newEvent);
        return "redirect:";
    }

}
