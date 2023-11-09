package com.bootcamp.pos.controller;

import com.bootcamp.pos.model.request.CustomerRequest;
import com.bootcamp.pos.service.CustomerService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/customer")
public class CustomerController {
    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }
    @GetMapping
    public ModelAndView index() {
        ModelAndView view = new ModelAndView("pages/customer/index");
        List<CustomerRequest> data = customerService.getAll();

        view.addObject("customerList", data);
        return view;
    }
    @GetMapping("/add")
    public ModelAndView addCustomer() {
        ModelAndView view = new ModelAndView("pages/customer/Add");
        return view;
    }
    @PostMapping("/save")
    public ModelAndView saveCustomer(@ModelAttribute CustomerRequest request) {
        if (request == null) {
            return new ModelAndView("redirect:/customer/add");
        }
        if (request.getCustomerName().isEmpty()){
            return new ModelAndView("redirect:/customer/add");
        }
        //call save from service
        this.customerService.save(request);
        //redirect to index
        return new ModelAndView("redirect:/customer");
    }
    @GetMapping("/edit/{id}")
    public ModelAndView edit(@PathVariable("id") String id) {
        ModelAndView view = new ModelAndView("pages/customer/edit");
        CustomerRequest customerRequest = this.customerService.getById(id);
        if (customerRequest == null) {
            return new ModelAndView("redirect:/customer");
        }

        view.addObject("customer", customerRequest);
        return view;
    }
    @PostMapping("/update")
    public ModelAndView updateGedung(@ModelAttribute CustomerRequest request) {
        if (request == null) {
            return new ModelAndView("redirect:/customer/edit" + request.getId());
        }
        if (request.getCustomerName().isEmpty()){
            return new ModelAndView("redirect:/customer/edit" + request.getId());
        }
        this.customerService.update(request, request.getId());
        return new ModelAndView("redirect:/customer");
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") String id) {
        this.customerService.delete(id);
        return "redirect:/customer";
    }
    @GetMapping("/detail/{id}")
    public ModelAndView detail(@PathVariable("id") String id) {
        ModelAndView view = new ModelAndView("pages/customer/detail");
        //get data from service
        CustomerRequest customerRequest = this.customerService.getById(id);
        if (customerRequest == null) {
            return new ModelAndView("redirect:/customer");
        }

        view.addObject("customer", customerRequest);
        return view;

    }
}
