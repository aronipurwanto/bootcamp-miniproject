package com.bootcamp.pos.controller;

import com.bootcamp.pos.model.request.AddressRequest;
import com.bootcamp.pos.service.AddressService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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
    public ModelAndView save(AddressRequest request){
        if (request == null){
            return new ModelAndView("redirect:/address/add");
        }

        if (request.getNoHome().isEmpty()){
            return new ModelAndView("redirect:/address/add");
        }

        addressService.save(request);
        return new ModelAndView("redirect:/address");
    }
}
