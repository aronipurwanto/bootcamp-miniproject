package com.bootcamp.pos.controller;

import com.bootcamp.pos.model.request.AddressRequest;
import com.bootcamp.pos.model.request.CustomerAddressRequest;
import com.bootcamp.pos.model.request.CustomerRequest;
import com.bootcamp.pos.service.AddressService;
import com.bootcamp.pos.service.CustomerAddressService;
import com.bootcamp.pos.service.CustomerService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/customerAddress")
public class CustomerAddressController {

    private final CustomerAddressService customerAddressService;
    private final CustomerService customerService;
    private final AddressService addressService;

    public CustomerAddressController(CustomerAddressService customerAddressService, CustomerService customerService, AddressService addressService) {
        this.customerAddressService = customerAddressService;
        this.customerService = customerService;
        this.addressService = addressService;
    }

    @GetMapping
    public ModelAndView index() {
        ModelAndView view = new ModelAndView("pages/customerAddress/index");
        List<CustomerAddressRequest> data = customerAddressService.getAll();

        view.addObject("customerAddressList", data);
        return view;
    }
    @GetMapping("/add")
    public ModelAndView addCustomerAddress() {
        ModelAndView view = new ModelAndView("pages/customerAddress/add");
        List<CustomerRequest> dataCustomer = this.customerService.getAll();
        view.addObject("dataCustomer", dataCustomer);

        List<AddressRequest> dataAddress = this.addressService.getAll();
        view.addObject("dataAddress", dataAddress);
        return view;
    }
    @PostMapping("/save")
    public ModelAndView saveCustomerAddress(@ModelAttribute CustomerAddressRequest request) {
        if (request == null){
            return new ModelAndView("redirect:/customerAddress/add");
        }
        if (request.getDateFrom().isEmpty()){
            return new ModelAndView("redirect:/customerAddress/add");
        }
        if (request.getAddressTypeCodeDateTo() == null){
            return new ModelAndView("redirect:/customerAddress/add");
        }
        this.customerAddressService.save(request);
        return new ModelAndView("redirect:/customerAddress");
    }
    @GetMapping("/edit/{id}")
    public ModelAndView editCustomerAddress(@PathVariable("id") String id){
        ModelAndView view = new ModelAndView("pages/customerAddress/edit");
        CustomerAddressRequest customerAddressRequest = this.customerAddressService.getById(id);
        if (customerAddressRequest == null){
            return new ModelAndView("redirect:/edit");
        }
        List<CustomerRequest> dataCustomer = this.customerService.getAll();
        view.addObject("dataCustomer", dataCustomer);

        List<AddressRequest> dataAddress = this.addressService.getAll();
        view.addObject("dataAddress", dataAddress);
        view.addObject("customerAddress", customerAddressRequest);
        return view;
    }
    @PostMapping("/update")
    public ModelAndView updateCustomerAddress(@ModelAttribute CustomerAddressRequest request){
        if (request.getDateFrom().isEmpty()){
            return new ModelAndView("redirect:/customerAddress/edit" + request.getId());
        }
        if (request.getAddressTypeCodeDateTo().isEmpty()){
            return new ModelAndView("redirect:/customerAddress/edit" + request.getId());
        }
        this.customerAddressService.update(request, request.getId());
        return new ModelAndView("redirect:/customerAddress");
    }
    @GetMapping("/delete/{id}")
    public String deleteCustomerAddress(@PathVariable("id") String id){
        customerAddressService.delete(id);
        return "redirect:/customerAddress";
    }
    @GetMapping("/detail/{id}")
    public ModelAndView detailCustomerAddress(@PathVariable("id") String id){
        ModelAndView view = new ModelAndView("pages/customerAddress/detail");
        CustomerAddressRequest customerAddressRequest = this.customerAddressService.getById(id);
        if (customerAddressRequest == null){
            return new ModelAndView("redirect:/customerAddress");
        }

        view.addObject("customerAddress", customerAddressRequest);
        return view;
    }
}
