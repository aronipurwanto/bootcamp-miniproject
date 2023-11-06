package com.bootcamp.pos.controller;

import com.bootcamp.pos.model.request.SupplierRequest;
import com.bootcamp.pos.service.SupplierService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/supplier")
public class SupplierController {
    private final SupplierService supplierService;

    @GetMapping
    public ModelAndView index(){
        ModelAndView view = new ModelAndView("pages/supplier/index");
        List<SupplierRequest> request = supplierService.getAll();

        view.addObject("dataSupplier", request);
        return view;
    }

    @GetMapping("/add")
    public ModelAndView add(){
        ModelAndView view = new ModelAndView("pages/supplier/add");
        return view;
    }

    @PostMapping("/save")
    public ModelAndView save(@ModelAttribute SupplierRequest request) {
        if (request == null){
            return new ModelAndView("redirect:/supplier/add");
        }

        if (request.getName().isEmpty()){
            return new ModelAndView("redirect:/supplier/add");
        }
        supplierService.save(request);
        return new ModelAndView("redirect:/supplier");
    }

    @GetMapping("/edit/{id}")
    public ModelAndView edit(@PathVariable("id") String id){
        ModelAndView view = new ModelAndView("pages/supplier/edit");
        SupplierRequest supplierRequest = supplierService.getById(id);
        if (supplierRequest == null){
            return new ModelAndView("redirect:/supplier");
        }
        view.addObject("editSupplier", supplierRequest);
        return view;
    }

    @PostMapping("/update")
    public ModelAndView update(@ModelAttribute SupplierRequest request){
        supplierService.update(request, request.getId());
        return new ModelAndView("redirect:/supplier");
    }

    @GetMapping("/delete/{id}")
    public ModelAndView delete(@PathVariable("id") String id){
        supplierService.delete(id);
        return new ModelAndView("redirect:/supplier");
    }

    @GetMapping("/detail/{id}")
    public ModelAndView detail(@PathVariable("id") String id) {
        ModelAndView view = new ModelAndView("pages/supplier/detail");
        SupplierRequest supplierRequest = supplierService.getById(id);
        if (supplierRequest == null) {
            return new ModelAndView("redirect:/supplier");
        }
        view.addObject("detailSupplier", supplierRequest);
        return view;
    }
}
