package com.bootcamp.pos.controller;

import com.bootcamp.pos.model.request.AddressRequest;
import com.bootcamp.pos.service.AddressService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/address")
public class AddressController {
    private final AddressService addressService;

    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    @GetMapping
    public ModelAndView index() {
        ModelAndView view = new ModelAndView("pages/address/index");
        List<AddressRequest> data = addressService.getAll();

        view.addObject("addressList", data);
        return view;
    }

    @GetMapping("/add")
    public ModelAndView addAddress() {
        ModelAndView view = new ModelAndView("pages/address/Add");
        return view;
    }
    @PostMapping("/save")
    public ModelAndView saveAddress(@ModelAttribute AddressRequest request) {
        if (request == null) {
            return new ModelAndView("redirect:/address/add");
        }
        if (request.getNamaJalan().isEmpty()){
            return new ModelAndView("redirect:/address/add");
        }
        //call save from service
        this.addressService.save(request);
        //redirect to index
        return new ModelAndView("redirect:/address");
    }

    @GetMapping("/edit/{id}")
    public ModelAndView editAddress(@PathVariable("id") String id) {
        ModelAndView view = new ModelAndView("pages/address/edit");
        AddressRequest addressRequest = this.addressService.getById(id);
        if (addressRequest == null) {
            return new ModelAndView("redirect:/edit");
        }

        view.addObject("address", addressRequest);
        return view;
    }
    @PostMapping("/update")
    public ModelAndView updateAddress(@ModelAttribute AddressRequest request) {
        if (request == null) {
            return new ModelAndView("redirect:/address/edit" + request.getId());
        }
        if (request.getNamaJalan().isEmpty()) {
            return new ModelAndView("redirect:/address/edit" + request.getId());
        }
        this.addressService.update(request, request.getId());
        return new ModelAndView("redirect:/address");
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") String id) {
        this.addressService.delete(id);
        return "redirect:/address";
    }

    @GetMapping("/detail/{id}")
    public ModelAndView detail(@PathVariable("id") String id) {
        ModelAndView view = new ModelAndView("pages/address/detail");
        //get data from service
        AddressRequest addressRequest = this.addressService.getById(id);
        if (addressRequest == null) {
            return new ModelAndView("redirect:/address");
        }

        view.addObject("address", addressRequest);
        return view;
    }
}
