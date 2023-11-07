package com.bootcamp.pos.controller;

import com.bootcamp.pos.model.response.AddressesResponse;
import com.bootcamp.pos.model.response.CustomerResponse;
import com.bootcamp.pos.service.AddressesService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
@RequestMapping("/address")
public class AddressesController {
    private final AddressesService addressesService;
    @GetMapping
    public ModelAndView index(){
        ModelAndView view = new ModelAndView("pages/address/index");

        List<AddressesResponse> data = addressesService.getAll();

        view.addObject("addresss", data);
        return view;
    }

    @GetMapping("/add")
    public ModelAndView add(){
        ModelAndView view = new ModelAndView("pages/address/add");

        List<AddressesResponse> data = addressesService.getAll();

        view.addObject("address",data);
        return view;
    }

    @PostMapping("/save")
    public ModelAndView save(@ModelAttribute AddressesResponse request){
        if(request == null){
            return new ModelAndView("redirect:/address");
        }
        if(request.getHouseNumber().isEmpty()){
            return new ModelAndView("redirect:/address");
        }
        addressesService.save(request);
        return new ModelAndView("redirect:/address");
    }

    @GetMapping("/edit/{id}")
    public ModelAndView edit(@PathVariable("id")String id){
        ModelAndView view = new ModelAndView("pages/address/edit");
        AddressesResponse response = this.addressesService.getById(id).orElse(null);
        if(response == null){
            return new ModelAndView("redirect:/address");
        }
        view.addObject("address", response);
        return view;
    }
    @PostMapping("/update")
    public ModelAndView update(@ModelAttribute AddressesResponse request){
        addressesService.update(request, request.getId());
        return new ModelAndView("redirect:/address");
    }

    @GetMapping("/delete/{id}")
    public ModelAndView delete(@PathVariable("id")String id) {
        AddressesResponse response = addressesService.getById(id).orElse(null);
        addressesService.delete(id);

        return new ModelAndView("redirect:/inlocal");
    }

    @GetMapping("/detail/{id}")
    public ModelAndView detail(@PathVariable("id")String id){
        ModelAndView view = new ModelAndView("pages/address/detail");
        AddressesResponse address = addressesService.getById(id).orElse(null);
        if(address == null){
            return new ModelAndView("redirect:/address");
        }

        view.addObject("address", address );
        return view;
    }
}
