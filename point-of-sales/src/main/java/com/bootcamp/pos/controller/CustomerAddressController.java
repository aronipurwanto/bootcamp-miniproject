package com.bootcamp.pos.controller;

import com.bootcamp.pos.model.request.AddressRequest;
import com.bootcamp.pos.model.request.CustomerAddressRequest;
import com.bootcamp.pos.model.request.CustomerRequest;
import com.bootcamp.pos.service.AddressService;
import com.bootcamp.pos.service.CustomerAddressService;
import com.bootcamp.pos.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/customerAddress")
public class CustomerAddressController {

    private final CustomerAddressService CustomerAddressService;
    private final CustomerService customerService;
    private final AddressService addressService;

    @GetMapping
    public ModelAndView index(){
        ModelAndView view  = new ModelAndView("pages/customerAddress/index");
        List<CustomerAddressRequest> customerAddress = this.CustomerAddressService.getAll();

        view.addObject("customerAddressList", customerAddress);
        return view;
    }

    @GetMapping("/add")
    public ModelAndView add(){
        ModelAndView view = new ModelAndView("/pages/customerAddress/add");
        List<CustomerRequest> customer = this.customerService.getAll();
        List<AddressRequest> address = this.addressService.getAll();

        view.addObject("customerList", customer);
        view.addObject("addressList", address);
        return view;
    }

    @PostMapping("/save")
    public ModelAndView save(@ModelAttribute CustomerAddressRequest request){
        ModelAndView view = new ModelAndView("/pages/customerAddress/add");
        List<CustomerRequest> customer = this.customerService.getAll();
        List<AddressRequest> address = this.addressService.getAll();

        view.addObject("customerList", customer);
        view.addObject("addressList", address);
        this.CustomerAddressService.save(request);
        return new ModelAndView("redirect:/customerAddress");
    }

    @GetMapping("/edit/{id}")
    public ModelAndView edit(@PathVariable("id")String id){
        ModelAndView view = new ModelAndView("pages/customerAddress/edit");
        CustomerAddressRequest data = this.CustomerAddressService.getById(id).orElse(null);
        if (data == null){
            return new ModelAndView("redirect:/customerAddress");
        }

        List<CustomerRequest> customer = this.customerService.getAll();
        List<AddressRequest> address = this.addressService.getAll();

        view.addObject("customerList", customer);
        view.addObject("addressList", address);
        view.addObject("customerAddress", data);
        return view;
    }

    @PostMapping("/update")
    public ModelAndView update (@ModelAttribute CustomerAddressRequest request){
        this.CustomerAddressService.update(request, request.getId());
        return new ModelAndView("redirect:/customerAddress");
    }

    @GetMapping("/delete/{id}")
    public ModelAndView delete (@PathVariable("id") String id){
        this.CustomerAddressService.delete(id);
        return new ModelAndView("redirect:/customerAddress");
    }

    @GetMapping("/detail/{id}")
    public ModelAndView detail(@PathVariable("id") String id){
        ModelAndView view = new ModelAndView("pages/customerAddress/detail");
        CustomerAddressRequest customerAddress = this.CustomerAddressService.getById(id).orElse(null);
        if (customerAddress == null){
            return new ModelAndView("redirect:/customerAddress");
        }

        view.addObject("customerAddress", customerAddress);
        return view;
    }
}
