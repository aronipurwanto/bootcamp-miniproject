package com.bootcamp.pos.controller;


import com.bootcamp.pos.model.request.SuppliersModel;
import com.bootcamp.pos.service.SuppliersService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/suppliers")
public class SuppliersController {
    private final SuppliersService suppliersService;


    @GetMapping
    public ModelAndView index(){
        ModelAndView view = new ModelAndView("pages/suppliers/index");
        List<SuppliersModel> data = this.suppliersService.getAll();
        view.addObject("listDataSuppliers", data);

        return view;
    }

    @GetMapping("add")
    public ModelAndView add(){
        ModelAndView view = new ModelAndView("pages/suppliers/add");
        return view;
    }

    @PostMapping("/save")
    public ModelAndView save(@ModelAttribute SuppliersModel request){
        // validasi
        if (request == null){
            return new ModelAndView("redirect:/suppliers/add");
        }
        if (request.getSupplierCode().isEmpty()){
            return new ModelAndView("redirect:/suppliers/add");
        }
        if (request.getSupplierName().isEmpty()){
            return new ModelAndView("redirect:/suppliers/add");
        }
        if (request.getSupplierAddress().isEmpty()){
            return new ModelAndView("redirect:/suppliers/add");
        }
        if (request.getSupplierEmail().isEmpty()){
            return new ModelAndView("redirect:/suppliers/add");
        }
        if (request.getSupplierPhone().isEmpty()){
            return new ModelAndView("redirect:/suppliers/add");
        }
        if (request.getSupplierDetails().isEmpty()){
            return new ModelAndView("redirect:/suppliers/add");
        }
        // panggil dari service
        this.suppliersService.save(request);
        // kirim ke view
        return new ModelAndView("redirect:/suppliers");
    }

    @GetMapping("/edit/{id}")
    public ModelAndView edit(@PathVariable("id") String id){
        ModelAndView view = new ModelAndView("pages/suppliers/edit");
        SuppliersModel data = this.suppliersService.getById(id).orElse(null);
        if (data == null){
            return new ModelAndView("redirect:/suppliers");
        }
        // data kirim ke view
        view.addObject("dataSuppliers", data);
        return view;
    }

    @PostMapping("/update")
    public ModelAndView update(@ModelAttribute SuppliersModel request){
        // validasi
        if (request == null){
            return new ModelAndView("redirect:/suppliers/edit/"+ request.getId());
        }
        if (request.getSupplierCode().isEmpty()){
            return new ModelAndView("redirect:/suppliers/edit/"+ request.getId());
        }
        if (request.getSupplierName().isEmpty()){
            return new ModelAndView("redirect:/suppliers/edit/"+ request.getId());
        }
        if (request.getSupplierAddress().isEmpty()){
            return new ModelAndView("redirect:/suppliers/edit/"+ request.getId());
        }
        if (request.getSupplierEmail().isEmpty()){
            return new ModelAndView("redirect:/suppliers/edit/"+ request.getId());
        }
        if (request.getSupplierPhone().isEmpty()){
            return new ModelAndView("redirect:/suppliers/edit/"+ request.getId());
        }
        if (request.getSupplierDetails().isEmpty()){
            return new ModelAndView("redirect:/suppliers/edit/"+ request.getId());
        }
        // memanggil dari service
        this.suppliersService.update(request, request.getId());
        // data krim ke view
        return new ModelAndView("redirect:/suppliers");
    }

    @GetMapping("/detail/{id}")
    public ModelAndView detail(@PathVariable("id") String id){
        ModelAndView view = new ModelAndView("pages/suppliers/detail");
        SuppliersModel data = this.suppliersService.getById(id).orElse(null);
        if ( data == null){
            return  new ModelAndView("redirect:/suppliers");
        }

        // kirim data ke view
        view.addObject("dataSuppliers", data);
        return view;
    }

    @GetMapping("/delete/{id}")
    public ModelAndView delete(@PathVariable("id") String id){
        // ambil data dari servie
        this.suppliersService.delete(id);
        // kirim data ke view
        return new ModelAndView("redirect:/suppliers");
    }
}
