package com.bootcamp.pos.controller;

import com.bootcamp.pos.model.response.*;
import com.bootcamp.pos.repository.CustomerAddressRepo;
import com.bootcamp.pos.service.AddressesService;
import com.bootcamp.pos.service.CustomerAddressService;
import com.bootcamp.pos.service.CustomerService;
import com.bootcamp.pos.service.RefAddressTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/cusaddress")
@RequiredArgsConstructor
public class CustomerAddressController {
    private final CustomerAddressService customerAddressService;
    private final AddressesService addressesService;
    private final CustomerService customerService;
    private final RefAddressTypeService refAddressTypeService;

  @GetMapping
  public ModelAndView index() {
      ModelAndView view = new ModelAndView("pages/cusaddress/index");

      List<CustomerAddressResponse> data = customerAddressService.getAll();

      view.addObject("dataList", data);
      return view;

  }

  @GetMapping("/add")
    public ModelAndView add(){
      ModelAndView view = new ModelAndView("pages/cusaddress/add");
       // get data address
      List<AddressesResponse> data = this.addressesService.getAll();
      view.addObject("dataAddress", data);

      List<RefAddressTypeResponse> ref = this.refAddressTypeService.getAll();
      view.addObject("dataref", ref);

       // get data customer
     List<CustomerResponse> response = this.customerService.getAll();
     view.addObject("dataCustomer", response);
     return view;
  }
  @PostMapping("/save")
    public ModelAndView save(@ModelAttribute CustomerAddressResponse request){
      if (request == null) {
          return new ModelAndView("redirect:/cusaddress/add");
      }
      customerAddressService.save(request);
      return new ModelAndView("redirect:/cusaddress");
  }

  @GetMapping("/edit/{id}")
    public ModelAndView edit(@PathVariable("id")String id){
      ModelAndView view = new ModelAndView("pages/cusaddress/edit");
      CustomerAddressResponse response = this.customerAddressService.getById(id).orElse(null);
      if(response == null){
          return new ModelAndView("redirect:/cusaddress");
      }
      view.addObject("cusaddress", response);

      List<AddressesResponse> dataAddress = this.addressesService.getAll();
      view.addObject("dataAddress", dataAddress);


      List<RefAddressTypeResponse> ref = this.refAddressTypeService.getAll();
      view.addObject("datarefAaddrs", ref);

      List<CustomerResponse> dataCustomer = this.customerService.getAll();
      view.addObject("dataCustomer", dataCustomer);
      return view;
  }
  @PostMapping("/update")
    public ModelAndView update(@ModelAttribute CustomerAddressResponse request){
      customerAddressService.update(request, request.getId());
      return new ModelAndView("redirect:/cusaddress");
  }

  @GetMapping("/delete/{id}")
    public ModelAndView delete(@PathVariable("id")String id){
      CustomerAddressResponse response = this.customerAddressService.getById(id).orElse(null);
      customerAddressService.delete(id);
          return new ModelAndView("redirect:/cusaddress");
  }

  @GetMapping("/detail/{id}")
    public ModelAndView detail(@PathVariable("id")String id){
      ModelAndView view = new ModelAndView("pages/cusaddress/detail");
      CustomerAddressResponse response = customerAddressService.getById(id).orElse(null);
      if(response == null){
          return new ModelAndView("redirect:/cusaddress");
      }

      view.addObject("cusaddress", response);
      return view;
  }


}