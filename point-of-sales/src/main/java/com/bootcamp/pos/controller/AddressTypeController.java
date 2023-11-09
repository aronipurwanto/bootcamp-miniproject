package com.bootcamp.pos.controller;

import com.bootcamp.pos.model.request.AddressTypeModel;
import com.bootcamp.pos.service.AddressTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/address-type")
public class AddressTypeController {
    private final AddressTypeService addressTypeService;

    @GetMapping
    public ModelAndView index(){
        ModelAndView view = new ModelAndView("pages/address-type/index");
        List<AddressTypeModel> data  = this.addressTypeService.getAll();
        view.addObject("listDataAddressType", data);

        return view;
    }

    @GetMapping("/add")
    public ModelAndView add(){
        ModelAndView view = new ModelAndView("pages/address-type/add");
        return view;
    }

    @PostMapping("/save")
    public ModelAndView save(@ModelAttribute AddressTypeModel request){
        if (request == null){
            return new ModelAndView("redirect:/address-type/add");
        }
        if (request.getAddressCode().isEmpty()){
            return new ModelAndView("redirect:/address-type/add");
        }
        if (request.getBilling().isEmpty()){
            return new ModelAndView("redirect:/address-type/add");
        }
        if (request.getDelivery().isEmpty()){
            return new ModelAndView("redirect:/address-type/add");
        }
        // call save dari service
        this.addressTypeService.save(request);
        // kirim ke index
        return new ModelAndView("redirect:/address-type");
    }

    @GetMapping("/edit/{id}")
    public ModelAndView edit(@PathVariable("id") String id){
        ModelAndView view = new ModelAndView("pages/address-type/edit");
        AddressTypeModel data = this.addressTypeService.getById(id).orElse(null);
        if (data == null){
            return new ModelAndView("redirect:/address_type");
        }
        // data kirim ke view
        view.addObject("dataAddressType", data);
        return view;
    }

    @PostMapping("/update")
    public ModelAndView update(@ModelAttribute AddressTypeModel request){
        // validasi
        if (request == null){
            return new ModelAndView("redirect:/address-type/edit/"+ request.getId());
        }
        if (request.getAddressCode().isEmpty()){
            return new ModelAndView("redirect:/address-type/edit/"+ request.getId());
        }
        if (request.getBilling().isEmpty()){
            return new ModelAndView("redirect:/address-type/edit/"+ request.getId());
        }
        if (request.getDelivery().isEmpty()){
            return new ModelAndView("redirect:/address-type/edit/"+ request.getId());
        }
        // memanggil save dari service
        this.addressTypeService.update(request, request.getId());
        // redirect ke index
        return new ModelAndView("redirect:/address-type");
    }

    @GetMapping("/detail/{id}")
    public ModelAndView detail(@PathVariable("id") String id){
        ModelAndView view = new ModelAndView("pages/address-type/detail");
        // ambil data dari service
        AddressTypeModel data = this.addressTypeService.getById(id).orElse(null);
        if ( data == null){
            return new ModelAndView("redirect:/address-type");
        }

        // kirim data to view
        view.addObject("dataAddressType", data);
        return view;
    }

    @GetMapping("/delete/{id}")
    public ModelAndView delete(@PathVariable("id") String id){
        // ambil data dari servie
        this.addressTypeService.delete(id);
        // kirim data ke view
        return new ModelAndView("redirect:/address-type");
    }
}
