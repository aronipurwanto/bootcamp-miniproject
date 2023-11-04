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
        List<CustomerRequest> data  = this.customerService.getAll();
        view.addObject("listDataCustomer", data);

        return view;
    }

    @GetMapping("/add")
    public ModelAndView add(){
        ModelAndView view = new ModelAndView("pages/customer/add");
        return view;
    }

    @PostMapping("/save")
    public ModelAndView save(@ModelAttribute CustomerRequest request){
        // validsi
        if (request == null){
            return new ModelAndView("redirect:/customer/add");
        }
        if (request.getCustomerName().isEmpty()){
            return new ModelAndView("redirect:/customer/add");
        }
        if (request.getCustomerPhone() == null){
            return new ModelAndView("redirect:/customer/add");
        }
        if (request.getCustomerEmail().isEmpty()){
            return new ModelAndView("redirect:/customer/add");
        }
        // call save dari service
        this.customerService.save(request);
        // kirim ke index
        return new ModelAndView("redirect:/customer");
    }

    @GetMapping("/edit/{id}")
    public ModelAndView edit(@PathVariable("id") String id){
        ModelAndView view = new ModelAndView("pages/customer/edit");
        CustomerRequest data = this.customerService.getById(id).orElse(null);
        if (data == null){
            return new ModelAndView("redirect:/customer");
        }
        // data kirim ke view
        view.addObject("dataCustomer", data);
        return view;
    }

    @PostMapping("/update")
    public ModelAndView update(@ModelAttribute CustomerRequest request){
        // validasi
        if (request == null){
            return new ModelAndView("redirect:/customer/edit/"+ request.getId());
        }
        if (request.getCustomerName().isEmpty()){
            return new ModelAndView("redirect:/customer/edit/"+ request.getId());
        }
        if (request.getCustomerPhone() == null){
            return new ModelAndView("redirect:/customer/edit/"+ request.getId());
        }
        if (request.getCustomerEmail().isEmpty()){
            return new ModelAndView("redirect:/customer/edit/"+ request.getId());
        }
        // memanggil save dari service
        this.customerService.update(request, request.getId());
        // redirect ke index
        return new ModelAndView("redirect:/customer");
    }

    @GetMapping("/detail/{id}")
    public ModelAndView detail(@PathVariable("id") String id){
        ModelAndView view = new ModelAndView("pages/customer/detail");
        // ambil data dari service
        CustomerRequest data = this.customerService.getById(id).orElse(null);
        if ( data == null){
            return new ModelAndView("redirect:/customer");
        }

        // kirim data to view
        view.addObject("dataCustomer", data);
        return view;
    }

    @GetMapping("/delete/{id}")
    public ModelAndView delete(@PathVariable("id") String id){
        // ambil data dari servie
        this.customerService.delete(id);
        // kirim data ke view
        return new ModelAndView("redirect:/customer");
    }
}
