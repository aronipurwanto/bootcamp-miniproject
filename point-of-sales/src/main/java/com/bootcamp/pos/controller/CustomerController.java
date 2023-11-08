package com.bootcamp.pos.controller;

import com.bootcamp.pos.model.entity.RefPaymentEntity;
import com.bootcamp.pos.model.response.CustomerResponse;
import com.bootcamp.pos.model.response.RefPaymentResponse;
import com.bootcamp.pos.service.CustomerService;
import com.bootcamp.pos.service.RefPaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
@RequestMapping("/customer")
public class CustomerController {
    private final CustomerService customerService;
    private final RefPaymentService refPaymentService;

    @GetMapping
    public ModelAndView index(){
        ModelAndView view = new ModelAndView("pages/customer/index");

        List<CustomerResponse> data = customerService.getAll();

        view.addObject("dataList", data);
        return view;
    }

    @GetMapping("/add")
    public ModelAndView add(){
        ModelAndView view = new ModelAndView("pages/customer/add");

        List<CustomerResponse> customer = customerService.getAll();

        view.addObject("dataCus",customer);


        List<RefPaymentResponse> refPayment = refPaymentService.getAll();
        view.addObject("dataPay", refPayment);
        return view;

    }

    @PostMapping("/save")
    public ModelAndView save(@ModelAttribute CustomerResponse request){
        if(request == null){
            return new ModelAndView("redirect:/customer");
        }
        if(request.getName().isEmpty()){
            return new ModelAndView("redirect:/customer");
        }
        customerService.save(request);
        return new ModelAndView("redirect:/customer");
    }

    @GetMapping("/edit/{id}")
    public ModelAndView edit(@PathVariable("id")String id){
        ModelAndView view = new ModelAndView("pages/customer/edit");
        CustomerResponse response = this.customerService.getById(id).orElse(null);
        if(response == null){
            return new ModelAndView("redirect:/customer");
        }

        List<RefPaymentResponse> ref = this.refPaymentService.getAll();
        view.addObject("dataref",ref);


        view.addObject("customer", response);
        return view;
    }
    @PostMapping("/update")
    public ModelAndView update(@ModelAttribute CustomerResponse request){
        customerService.update(request, request.getId());
        return new ModelAndView("redirect:/customer");
    }

    @GetMapping("/delete/{id}")
    public ModelAndView delete(@PathVariable("id")String id) {
        CustomerResponse response = customerService.getById(id).orElse(null);
        customerService.delete(id);

        return new ModelAndView("redirect:/customer");
    }

    @GetMapping("/detail/{id}")
    public ModelAndView detail(@PathVariable("id")String id){
        ModelAndView view = new ModelAndView("pages/customer/detail");
        CustomerResponse customer = customerService.getById(id).orElse(null);
        if(customer == null){
            return new ModelAndView("redirect:/customer");
        }

        view.addObject("customer", customer );
        return view;
    }



}

