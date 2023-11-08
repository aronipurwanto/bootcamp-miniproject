package com.bootcamp.pos.controller;

import com.bootcamp.pos.model.request.AddressRequest;
import com.bootcamp.pos.model.request.CustomerAddRequest;
import com.bootcamp.pos.model.request.CustomerRequest;
import com.bootcamp.pos.model.request.RefAddressRequest;
import com.bootcamp.pos.service.AddressService;
import com.bootcamp.pos.service.CustomerAddService;
import com.bootcamp.pos.service.CustomerService;
import com.bootcamp.pos.service.RefAddressService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/customerAddress")
public class CustomerAddController {
    private final CustomerAddService customerAddService;
    private final AddressService addressService;
    private final CustomerService customerService;
    private final RefAddressService refAddressService;

    @GetMapping
    public ModelAndView index() {
        ModelAndView view = new ModelAndView("pages/customerAddress/index");
        List<CustomerAddRequest> requests = customerAddService.getAll();

        view.addObject("dataCustomer", requests);
        return view;
    }

    @GetMapping("/add")
    public ModelAndView add() {
        ModelAndView view = new ModelAndView("pages/customerAddress/add");
        List<AddressRequest> requests = addressService.getAll();
        List<CustomerRequest> customer = customerService.getAll();
        List<RefAddressRequest> refAddress = refAddressService.getAll();

        view.addObject("addAddress", requests);

        view.addObject("addCustomer", customer);

        view.addObject("addRefAddress", refAddress);
        return view;
    }

    @PostMapping("/save")
    public ModelAndView save(@ModelAttribute CustomerAddRequest request) {
        if (request == null){
            return new ModelAndView("redirect:/customerAddress/add");
        }

        if (request.getCustomerId().isEmpty()){
            return new ModelAndView("redirect:/customerAddress/add");
        }
        customerAddService.save(request);
        return new ModelAndView("redirect:/customerAddress");
    }

    @GetMapping("/edit/{id}")
    public ModelAndView edit(@PathVariable("id") String id) {
        ModelAndView view = new ModelAndView("pages/customerAddress/edit");
        CustomerAddRequest request = customerAddService.getById(id);
        if (request == null) {
            return new ModelAndView("redirect:/customerAddress");
        }
        List<AddressRequest> requests = addressService.getAll();
        List<CustomerRequest> customer = customerService.getAll();
        List<RefAddressRequest> refAddress = refAddressService.getAll();


        view.addObject("addAddress", requests);

        view.addObject("addCustomer", customer);

        view.addObject("editRefAddress", refAddress);

        view.addObject("editCustomerAdd", request);
        return view;
    }

    @PostMapping("/update")
    public ModelAndView update(@ModelAttribute CustomerAddRequest request) {
        customerAddService.update(request, request.getId());
        return new ModelAndView("redirect:/customerAddress");
    }

    @GetMapping("/delete/{id}")
    public ModelAndView delete(@PathVariable("id") String id) {
        customerAddService.delete(id);
        return new ModelAndView("redirect:/customerAddress");
    }

    @GetMapping("/detail/{id}")
    public ModelAndView detail(@PathVariable("id") String id) {
        ModelAndView view = new ModelAndView("pages/customerAddress/detail");
        CustomerAddRequest request = customerAddService.getById(id);
        if (request == null) {
            return new ModelAndView("redirect:/customerAddress");
        }
        view.addObject("detailCustomerAdd", request);
        return view;
    }
}
