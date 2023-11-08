package com.bootcamp.pos.controller;

import com.bootcamp.pos.model.request.RefAddressRequest;
import com.bootcamp.pos.service.RefAddressService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/refAddress")
public class RefAddressController {
    private final RefAddressService refAddressService;

    @GetMapping
    public ModelAndView index(){
        ModelAndView view = new ModelAndView("pages/refAddress/index");
        List<RefAddressRequest> requests = refAddressService.getAll();

        view.addObject("dataRefAddress", requests);
        return view;
    }

    @GetMapping("/add")
    public ModelAndView add(){
        ModelAndView view = new ModelAndView("pages/refAddress/add");
        return view;
    }

    @PostMapping("/save")
    public ModelAndView save(@ModelAttribute RefAddressRequest request){
        if (request == null){
            return new ModelAndView("redirect:/refAddress/add");
        }

        if (request.getDesc().isEmpty()){
            return new ModelAndView("redirect:/refAddress/add");
        }

        refAddressService.save(request);
        return new ModelAndView("redirect:/refAddress");
    }

    @GetMapping("/edit/{id}")
    public ModelAndView edit(@PathVariable("id") String id){
        ModelAndView view = new ModelAndView("pages/refAddress/edit");
        RefAddressRequest request = refAddressService.getById(id);
        if (request == null){
            return new ModelAndView("redirect:/refAddress");
        }

        view.addObject("editRefAddress", request);
        return view;
    }

    @PostMapping("/update")
    public ModelAndView update(@ModelAttribute RefAddressRequest request){
        refAddressService.update(request, request.getId());
        return new ModelAndView("redirect:/refAddress");
    }

    @GetMapping("/delete/{id}")
    public ModelAndView delete(@PathVariable("id") String id){
        refAddressService.delete(id);
        return new ModelAndView("redirect:/refAddress");
    }

    @GetMapping("/detail/{id}")
    public ModelAndView detail(@PathVariable("id") String id) {
        ModelAndView view = new ModelAndView("pages/refAddress/detail");
        RefAddressRequest request = refAddressService.getById(id);
        if (request == null) {
            return new ModelAndView("redirect:/refAddress");
        }

        view.addObject("detailRefAddress", request);
        return view;
    }
}
