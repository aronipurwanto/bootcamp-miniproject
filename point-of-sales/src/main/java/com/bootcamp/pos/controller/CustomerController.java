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
        ModelAndView view = new ModelAndView("pages/customer/index");
        List<CustomerRequest> data = customerService.getAll();

        view.addObject("customerList", data);
        return view;
    }

    @GetMapping("/add")
    public ModelAndView add(){
        ModelAndView view = new ModelAndView("pages/customer/add");
        return view;
    }

    @PostMapping("/save")
    public ModelAndView save(@ModelAttribute CustomerRequest request){
        if (request == null){
            return new ModelAndView("redirect:/customer/add");
        }

        if (request.getName().isEmpty()){
            return new ModelAndView("redirect:/customer/add");
        }

        customerService.save(request);
        return new ModelAndView("redirect:/customer");
    }

    @GetMapping("/edit/{id}")
    public ModelAndView edit(@PathVariable("id") String id){
        ModelAndView view = new ModelAndView("pages/customer/edit");
        CustomerRequest request = customerService.getById(id);
        if (request == null){
            return new ModelAndView("redirect:/customer");
        }
        view.addObject("customer", request);
        return view;
    }

    @PostMapping("/update")
    public ModelAndView update(@ModelAttribute CustomerRequest request){
        if (request == null){
            return new ModelAndView("redirect:/customer/edit"+ request.getId());
        }

        if (request.getName().isEmpty()){
            return new ModelAndView("redirect:/customer/edit"+ request.getId());
        }
        customerService.update(request, request.getId());
        return new ModelAndView("redirect:/customer");
    }

    @GetMapping("/delete/{id}")
    public ModelAndView delete(@PathVariable("id") String id){
        customerService.delete(id);
        return new ModelAndView("redirect:/customer");
    }

    @GetMapping("/detail/{id}")
    public ModelAndView detail(@PathVariable("id") String id){
        ModelAndView view = new ModelAndView("pages/customer/detail");
        CustomerRequest request = customerService.getById(id);
        if (request == null){
            return new ModelAndView("redirect:/customer");
        }
        view.addObject("customerDetail", request);
        return view;
    }
}
