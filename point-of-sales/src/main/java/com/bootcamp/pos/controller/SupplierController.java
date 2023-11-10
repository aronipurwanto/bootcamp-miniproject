package com.bootcamp.pos.controller;

import com.bootcamp.pos.model.response.AddressesResponse;
import com.bootcamp.pos.model.response.SupllierResponse;
import com.bootcamp.pos.service.SupllierService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
@RequestMapping("/supplier")
public class SupplierController {
    private final SupllierService supllierService;
    @GetMapping
    public ModelAndView index(){
        ModelAndView view = new ModelAndView("pages/supplier/index");

        List<SupllierResponse> data = supllierService.getAll();

        view.addObject("supplier", data);
        return view;
    }
    @GetMapping("/add")
    public ModelAndView add(){
        ModelAndView view = new ModelAndView("pages/supplier/add");

        List<SupllierResponse> data = supllierService.getAll();

        view.addObject("supplier",data);
        return view;
    }

    @PostMapping("/save")
    public ModelAndView save(@ModelAttribute SupllierResponse request){
        if(request == null){
            return new ModelAndView("redirect:/supplier");
        }
        if(request.getCode().isEmpty()){
            return new ModelAndView("redirect:/supplier/add");
        }
        supllierService.save(request);
        return new ModelAndView("redirect:/supplier");
    }


    @GetMapping("/edit/{id}")
    public ModelAndView edit(@PathVariable("id")String id){
        ModelAndView view = new ModelAndView("pages/supplier/edit");
        SupllierResponse response = this.supllierService.getById(id).orElse(null);
        if(response == null){
            return new ModelAndView("redirect:/supplier");
        }
        view.addObject("supplier", response);
        return view;
    }

    @PostMapping("/update")
    public ModelAndView update(@ModelAttribute SupllierResponse request){
        supllierService.update(request, request.getId());
        return new ModelAndView("redirect:/supplier");
    }

    @GetMapping("/delete/{id}")
    public ModelAndView delete(@ModelAttribute AddressesResponse request) {
        Optional<SupllierResponse> response = supllierService.getById(request.getId());
        if (response == null) {
            return new ModelAndView("redirect:/supplier");
        }
        supllierService.delete(request.getId());
        return new ModelAndView("redirect:/supplier");
    }


    @GetMapping("/detail/{id}")
    public ModelAndView detail(@PathVariable("id")String id){
        ModelAndView view = new ModelAndView("pages/supplier/detail");
        SupllierResponse address = supllierService.getById(id).orElse(null);
        if(address == null){
            return new ModelAndView("redirect:/supplier");
        }

        view.addObject("supplier", address );
        return view;
    }

}
