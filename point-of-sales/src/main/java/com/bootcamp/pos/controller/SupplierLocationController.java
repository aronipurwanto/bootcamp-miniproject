package com.bootcamp.pos.controller;

import com.bootcamp.pos.model.request.AddressRequest;
import com.bootcamp.pos.model.request.SupplierLocationRequest;
import com.bootcamp.pos.model.request.SupplierRequest;
import com.bootcamp.pos.service.AddressService;
import com.bootcamp.pos.service.SupplierLocationService;
import com.bootcamp.pos.service.SupplierService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/supplierLocation")
public class SupplierLocationController {
    private final SupplierLocationService supplierLocationService;
    private final SupplierService supplierService;
    private final AddressService addressService;

    @GetMapping
    public ModelAndView index(){
        ModelAndView view = new ModelAndView("pages/supplier_location/index");
        List<SupplierLocationRequest> supplierLocation = supplierLocationService.getAll();

        view.addObject("supplierLocation", supplierLocation);
        return view;
    }

    @GetMapping("/add")
    public ModelAndView add(){
        ModelAndView view = new ModelAndView("pages/supplier_location/add");

        List<SupplierRequest> requests = supplierService.getAll();
        List<AddressRequest> address = addressService.getAll();

        view.addObject("addSupplier", requests);

        view.addObject("addAddress", address);
        return view;
    }

    @PostMapping("/save")
    public ModelAndView save(@ModelAttribute SupplierLocationRequest request){
        if (request == null){
            return new ModelAndView("redirect:/supplierLocation/add");
        }

        if (request.getSupplierId().isEmpty()){
            return new ModelAndView("redirect:/supplierLocation/add");
        }

        supplierLocationService.save(request);
        return new ModelAndView("redirect:/supplierLocation");
    }

    @GetMapping("/edit/{id}")
    public ModelAndView edit(@PathVariable("id") String id){
        ModelAndView view = new ModelAndView("pages/supplier_location/edit");
        SupplierLocationRequest supplier = supplierLocationService.getById(id);
        if (supplier == null){
            return new ModelAndView("redirect:/supplierLocation");
        }

        List<SupplierRequest> requests = supplierService.getAll();
        List<AddressRequest> address = addressService.getAll();

        view.addObject("editSupplier", requests);

        view.addObject("editAddress", address);

        view.addObject("editSupplierLoc", supplier);
        return view;
    }

    @PostMapping("/update")
    public ModelAndView update(@ModelAttribute SupplierLocationRequest request){
        supplierLocationService.update(request, request.getId());
        return new ModelAndView("redirect:/supplierLocation");
    }

    @GetMapping("/delete/{id}")
    public ModelAndView delete(@PathVariable("id") String id){
        supplierLocationService.delete(id);
        return new ModelAndView("redirect:/supplierLocation");
    }

    @GetMapping("/detail/{id}")
    public ModelAndView detail(@PathVariable("id") String id){
        ModelAndView view = new ModelAndView("pages/supplier_location/detail");
        SupplierLocationRequest supplier = supplierLocationService.getById(id);
        if (supplier == null){
            return new ModelAndView("redirect:/supplierLocation");
        }

        view.addObject("detailSupplierLoc", supplier);
        return view;
    }
}
