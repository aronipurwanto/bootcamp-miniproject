package com.bootcamp.pos.controller;

import com.bootcamp.pos.model.request.AddressRequest;
import com.bootcamp.pos.service.AddressService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/address")
public class AddressController {

    private final AddressService AddressService;

    @GetMapping
    public ModelAndView index(){
        ModelAndView view  = new ModelAndView("pages/address/index");
        List<AddressRequest> address = this.AddressService.getAll();

        view.addObject("addressList", address);
        return view;
    }

    @GetMapping("/add")
    public ModelAndView add(){
        return new ModelAndView("/pages/address/add");
    }

    @PostMapping("/save")
    public ModelAndView save(@ModelAttribute AddressRequest request){
        this.AddressService.save(request);
        return new ModelAndView("redirect:/address");
    }

    @GetMapping("/edit/{id}")
    public ModelAndView edit(@PathVariable("id")String id){
        ModelAndView view = new ModelAndView("pages/address/edit");
        AddressRequest data = this.AddressService.getById(id).orElse(null);
        if (data == null){
            return new ModelAndView("redirect:/address");
        }

        view.addObject("address", data);
        return view;
    }

    @PostMapping("/update")
    public ModelAndView update (@ModelAttribute AddressRequest request){
        this.AddressService.update(request, request.getId());
        return new ModelAndView("redirect:/address");
    }

    @GetMapping("/delete/{id}")
    public ModelAndView delete (@PathVariable("id") String id){
        this.AddressService.delete(id);
        return new ModelAndView("redirect:/address");
    }

    @GetMapping("/detail/{id}")
    public ModelAndView detail(@PathVariable("id") String id){
        ModelAndView view = new ModelAndView("pages/address/detail");
        AddressRequest address = this.AddressService.getById(id).orElse(null);
        if (address == null){
            return new ModelAndView("redirect:/address");
        }

        view.addObject("address", address);
        return view;
    }
}
