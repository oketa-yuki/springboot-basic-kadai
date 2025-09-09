package com.examplespringkadaiform.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.examplespringkadaiform.form.ContactForm;

import jakarta.validation.Valid;

@Controller
public class ContactFormController {

    // フォーム画面表示
    @GetMapping("/form")
    public String showForm(Model model) {
        model.addAttribute("contactForm", new ContactForm());
        return "contactFormView";
    }

    // 確認画面表示
    @PostMapping("/confirm")
    public String confirm(
            @Valid @ModelAttribute ContactForm contactForm,
            BindingResult bindingResult,
            Model model) {

        if (bindingResult.hasErrors()) {
            // バリデーションNG → 元のフォームを表示
            return "contactFormView";
        }
        // バリデーションOK → 確認画面を表示
        model.addAttribute("contactForm", contactForm);
        return "confirmView";
    }
}