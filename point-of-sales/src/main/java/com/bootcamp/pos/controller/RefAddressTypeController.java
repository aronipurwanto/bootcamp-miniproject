package com.bootcamp.pos.controller;

import com.bootcamp.pos.model.response.RefAddressTypeResponse;
import com.bootcamp.pos.service.RefAddressTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/refaddress")
@RequiredArgsConstructor
public class RefAddressTypeController {
    private final RefAddressTypeService refAddressTypeService;

    @GetMapping
    public ModelAndView index(){
        ModelAndView view = new ModelAndView("pages/refaddress/index");

        List<RefAddressTypeResponse> data = refAddressTypeService.getAll();

        view.addObject("dataList", data);
        return view;

    }

    @GetMapping("/add")
    public ModelAndView add(){
        ModelAndView view = new ModelAndView("pages/refaddress/add");

        List<RefAddressTypeResponse> data = refAddressTypeService.getAll();

        view.addObject("refaddres",data);
        return view;
    }
    @PostMapping("/save")
    public ModelAndView save(@ModelAttribute RefAddressTypeResponse request){
        if(request == null){
            return new ModelAndView("redirect:/refaddress");
        }
        refAddressTypeService.save(request);
        return new ModelAndView("redirect:/refaddress");
    }

    @GetMapping("/edit/{id}")
    public ModelAndView edit(@PathVariable("id")String id){
        ModelAndView view = new ModelAndView("pages/refaddress/edit");
        RefAddressTypeResponse response = this.refAddressTypeService.getById(id).orElse(null);
        if(response == null){
            return new ModelAndView("redirect:/refaddress");
        }
        view.addObject("refaddress", response);
        return view;
    }
    @PostMapping("/update")
    public ModelAndView update(@ModelAttribute RefAddressTypeResponse request){
        refAddressTypeService.update(request, request.getId());
        return new ModelAndView("redirect:/refaddress");
    }

    @GetMapping("/delete/{id}")
    public ModelAndView delete(@ModelAttribute RefAddressTypeResponse request) {
        Optional<RefAddressTypeResponse> response = refAddressTypeService.getById(request.getId());
        if (response == null) {
            return new ModelAndView("redirect:/address");
        }
        refAddressTypeService.delete(request.getId());
        return new ModelAndView("redirect:/address");
    }
    @GetMapping("/detail/{id}")
    public ModelAndView detail(@PathVariable("id")String id){
        ModelAndView view = new ModelAndView("pages/refaddress/detail");
        RefAddressTypeResponse data = refAddressTypeService.getById(id).orElse(null);
        if(data == null){
            return new ModelAndView("redirect:/refaddress");
        }

        view.addObject("data", data );
        return view;
    }
}
