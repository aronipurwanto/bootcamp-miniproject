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
    private final AddressService addressService;

    @GetMapping
    public ModelAndView index(){
        ModelAndView view = new ModelAndView("pages/address/index");
        List<AddressRequest> requests = addressService.getAll();

        view.addObject("dataAddress", requests);
        return view;
    }

    @GetMapping("/add")
    public ModelAndView add(){
        ModelAndView view = new ModelAndView("pages/address/add");
        return view;
    }

    @PostMapping("/save")
    public ModelAndView save(@ModelAttribute AddressRequest request){
        if (request == null){
            return new ModelAndView("redirect:/address/add");
        }

        if (request.getNoHome().isEmpty()){
            return new ModelAndView("redirect:/address/add");
        }

        addressService.save(request);
        return new ModelAndView("redirect:/address");
    }

    @GetMapping("/edit/{id}")
    public ModelAndView edit(@PathVariable("id") String id){
        ModelAndView view = new ModelAndView("pages/address/edit");
        AddressRequest request = addressService.getById(id);
        if (request == null){
            return new ModelAndView("redirect:/address");
        }
        view.addObject("editAddress", request);
        return view;
    }

    @PostMapping("/update")
    public ModelAndView update(@ModelAttribute AddressRequest request){
        if (request == null){
            return new ModelAndView("redirect:/address/edit"+ request.getId());
        }

        if (request.getNoHome().isEmpty()){
            return new ModelAndView("redirect:/address/edit"+ request.getId());
        }

        addressService.update(request, request.getId());
        return new ModelAndView("redirect:/address");
    }

    @GetMapping("/delete/{id}")
    public ModelAndView delete(@PathVariable("id") String id){
        addressService.delete(id);
        return new ModelAndView("redirect:/address");
    }

    @GetMapping("/detail/{id}")
    public ModelAndView detail(@PathVariable("id") String id) {
        ModelAndView view = new ModelAndView("pages/address/detail");
        AddressRequest request = addressService.getById(id);
        if (request == null) {
            return new ModelAndView("redirect:/address");
        }
        view.addObject("detailAddress", request);
        return view;
    }
}
