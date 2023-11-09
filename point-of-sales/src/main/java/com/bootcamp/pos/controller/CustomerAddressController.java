package com.bootcamp.pos.controller;

import com.bootcamp.pos.model.request.AddressModel;
import com.bootcamp.pos.model.request.AddressTypeModel;
import com.bootcamp.pos.model.request.CustomerAddressModel;
import com.bootcamp.pos.model.request.CustomerRequest;
import com.bootcamp.pos.service.AddressService;
import com.bootcamp.pos.service.AddressTypeService;
import com.bootcamp.pos.service.CustomerAddressService;
import com.bootcamp.pos.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/customer-address")
public class CustomerAddressController {
    private final CustomerAddressService customerAddressService;
    private final CustomerService customerService;
    private final AddressService addressService;
    private final AddressTypeService addressTypeService;

    @GetMapping
    public ModelAndView index(){
        ModelAndView view = new ModelAndView("pages/customer-address/index");

        List<CustomerAddressModel> data = this.customerAddressService.getAll();
        view.addObject("customerAddressList", data);

        return view;
    }

    @GetMapping("/add")
    public ModelAndView add(){
        ModelAndView view = new ModelAndView("pages/customer-address/add");
        // ambil data dari service customer
        List<CustomerRequest> customer = this.customerService.getAll();
        // ambil data dari service address
        List<AddressModel> address = this.addressService.getAll();
        // ambil data dari service address type
        List<AddressTypeModel> addressType = this.addressTypeService.getAll();

        // kirim data ke view
        view.addObject("dataCustomer", customer);
        // kirim data ke view
        view.addObject("dataAddress", address);
        // kirim data ke view
        view.addObject("dataAddressType", addressType);

        return view;
    }

    @PostMapping("/save")
    public ModelAndView save(@ModelAttribute CustomerAddressModel request){
        if (request == null){
            return new ModelAndView("pages/customer-address/add");
        }
        if (request.getDateFrom() == null){
            return new ModelAndView("pages/customer-address/add");
        }
        // memanggil data save dari service
        this.customerAddressService.save(request);
        // kirim ke view
        return new ModelAndView("redirect:/customer-address");
    }

    @GetMapping("/edit/{id}")
    public ModelAndView edit(@PathVariable("id") String id){
        ModelAndView view = new ModelAndView("pages/customer-address/edit");
        CustomerAddressModel model = this.customerAddressService.getById(id);
        if (model == null){
            return new ModelAndView("redirect:/customer-address");
        }
        // ambil data dari service cutomer
        List<CustomerRequest> customer = this.customerService.getAll();
        // ambil data dari service address
        List<AddressModel> address = this.addressService.getAll();
        // ambil data dari service address type
        List<AddressTypeModel> addressType = this.addressTypeService.getAll();

        // kirim data ke view
        view.addObject("dataCustomer", customer);
        // kirim data ke view
        view.addObject("dataAddress", address);
        // kirim data ke view
        view.addObject("dataAddressType", addressType);
        // kirim data ke view
        view.addObject("customerAddressList", model);
        return view;
    }

    @PostMapping("/update")
    public ModelAndView update(@ModelAttribute CustomerAddressModel request){
        // memangil data dari service
        this.customerAddressService.update(request, request.getId());
        // send to view
        return new ModelAndView("redirect:/customer-address");
    }

    @GetMapping("/detail/{id}")
    public ModelAndView detail(@PathVariable("id") String id){
        ModelAndView view =new ModelAndView("pages/customer-address/detail");
        CustomerAddressModel model = this.customerAddressService.getById(id);
        if (model == null){
            return new ModelAndView("redirect:/customer-address");
        }

        view.addObject("customerAddressList", model);
        return view;
    }

    @GetMapping("/delete/{id}")
    public ModelAndView delete(@PathVariable("id") String  id){
        this.customerAddressService.delete(id);
        return new ModelAndView("redirect:/customer-address");
    }
}
