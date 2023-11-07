package com.bootcamp.pos.controller;

import com.bootcamp.pos.model.request.CustomerRequest;
import com.bootcamp.pos.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/customer")
public class CustomerController {

    private final CustomerService customerService;

    @GetMapping
    public ModelAndView index(){
        ModelAndView view  = new ModelAndView("pages/customer/index");
        List<CustomerRequest> customer = this.customerService.getAll();

        view.addObject("customerList", customer);
        return view;
    }

    @GetMapping("/add")
    public ModelAndView add(){
        return new ModelAndView("pages/customer/add");
    }

    @PostMapping("/save")
    public ModelAndView save(@ModelAttribute CustomerRequest request){
        this.customerService.save(request);
        return new ModelAndView("redirect:/customer");
    }

    @GetMapping("/edit/{id}")
    public ModelAndView edit(@PathVariable("id")String id){
        ModelAndView view = new ModelAndView("pages/customer/edit");
        CustomerRequest data = this.customerService.getById(id).orElse(null);
        if (data == null){
            return new ModelAndView("redirect:/customer");
        }

        view.addObject("customer", data);
        return view;
    }

    @PostMapping("/update")
    public ModelAndView update (@ModelAttribute CustomerRequest request){
        this.customerService.update(request, request.getId());
        return new ModelAndView("redirect:/customer");
    }

    @GetMapping("/delete/{id}")
    public ModelAndView delete (@PathVariable("id") String id){
        this.customerService.delete(id);
        return new ModelAndView("redirect:/customer");
    }

    @GetMapping("/detail/{id}")
    public ModelAndView detail(@PathVariable("id") String id){
        ModelAndView view = new ModelAndView("pages/customer/detail");
        CustomerRequest customer = this.customerService.getById(id).orElse(null);
        if (customer == null){
            return new ModelAndView("redirect:/customer");
        }

        view.addObject("customer", customer);
        return view;
    }
}
