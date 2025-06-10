package com.example.springpractice.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.springpractice.form.ContactForm;


@Controller
public class ContactFormController {
	@GetMapping("/form")
	public String form(Model model) {
	    model.addAttribute("contactForm", new ContactForm());
	    return "contactFormView";
	}
	
	@GetMapping("/confirm")
	public String confirm(@ModelAttribute("contactForm") ContactForm form) {
		
		return "confirmView";
	}
	

    @PostMapping("/form")
    public String formSubmit(@Validated ContactForm form, BindingResult result, Model model, RedirectAttributes redirect) {
        if(result.hasErrors()) {
            model.addAttribute("contactForm", form);
            return "contactFormView";
        }
        redirect.addFlashAttribute("contactForm", form);
        return "redirect:/confirm";
    }
}  

