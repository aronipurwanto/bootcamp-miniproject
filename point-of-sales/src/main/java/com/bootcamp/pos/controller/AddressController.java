package com.bootcamp.pos.controller;

import com.bootcamp.pos.model.request.AddressModel;
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
        List<AddressModel> data  = this.addressService.getAll();
        view.addObject("listDataAddress", data);

        return view;
    }

    @GetMapping("/add")
    public ModelAndView add(){
        ModelAndView view = new ModelAndView("pages/address/add");
        return view;
    }

    @PostMapping("/save")
    public ModelAndView save(@ModelAttribute AddressModel request){
        // validasi
        if (request == null){
            return new ModelAndView("redirect:/address/add");
        }
        if (request.getNoHome().isEmpty()){
            return new ModelAndView("redirect:/address/add");
        }
        if (request.getOnStreet().isEmpty()){
            return new ModelAndView("redirect:/address/add");
        }
        if (request.getVillage().isEmpty()){
            return new ModelAndView("redirect:/address/add");
        }
        if (request.getSubdistrict().isEmpty()){
            return new ModelAndView("redirect:/address/add");
        }
        if (request.getCity().isEmpty()){
            return new ModelAndView("redirect:/address/add");
        }
        if (request.getProvince().isEmpty()){
            return new ModelAndView("redirect:/address/add");
        }
        // call save dari service
        this.addressService.save(request);
        // kirim ke index
        return new ModelAndView("redirect:/address");
    }

    @GetMapping("/edit/{id}")
    public ModelAndView edit(@PathVariable("id") String id){
        ModelAndView view = new ModelAndView("pages/address/edit");
        AddressModel data = this.addressService.getById(id).orElse(null);
        if (data == null){
            return new ModelAndView("redirect:/address");
        }
        // data kirim ke view
        view.addObject("dataAddress", data);
        return view;
    }

    @PostMapping("/update")
    public ModelAndView update(@ModelAttribute AddressModel request){
        // validasi
        if (request == null){
            return new ModelAndView("redirect:/address/edit/"+ request.getId());
        }
        if (request.getNoHome().isEmpty()){
            return new ModelAndView("redirect:/address/edit/"+ request.getId());
        }
        if (request.getOnStreet().isEmpty()){
            return new ModelAndView("redirect:/address/edit/"+ request.getId());
        }
        if (request.getVillage().isEmpty()){
            return new ModelAndView("redirect:/address/edit/"+ request.getId());
        }
        if (request.getSubdistrict().isEmpty()){
            return new ModelAndView("redirect:/address/edit/"+ request.getId());
        }
        if (request.getCity().isEmpty()){
            return new ModelAndView("redirect:/address/edit/"+ request.getId());
        }
        if (request.getProvince().isEmpty()){
            return new ModelAndView("redirect:/address/edit/"+ request.getId());
        }
        // memanggil save dari service
        this.addressService.update(request, request.getId());
        // redirect ke index
        return new ModelAndView("redirect:/address");
    }

    @GetMapping("/detail/{id}")
    public ModelAndView detail(@PathVariable("id") String id){
        ModelAndView view = new ModelAndView("pages/address/detail");
        // ambil data dari service
        AddressModel data = this.addressService.getById(id).orElse(null);
        if ( data == null){
            return new ModelAndView("redirect:/address");
        }

        // kirim data to view
        view.addObject("dataAddress", data);
        return view;
    }

    @GetMapping("/delete/{id}")
    public ModelAndView delete(@PathVariable("id") String id){
        // ambil data dari servie
        this.addressService.delete(id);
        // kirim data ke view
        return new ModelAndView("redirect:/address");
    }
}
