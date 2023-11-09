package com.bootcamp.pos.controller;

import com.bootcamp.pos.model.request.AddressModel;
import com.bootcamp.pos.model.request.SupplierLocationsModel;
import com.bootcamp.pos.model.request.SuppliersModel;
import com.bootcamp.pos.service.AddressService;
import com.bootcamp.pos.service.SupplierLocationsService;
import com.bootcamp.pos.service.SuppliersService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/supplier-locations")
public class SuppliersLocationsController {
    private final SupplierLocationsService supplierLocationsService;
    private final AddressService addressService;
    private final SuppliersService suppliersService;

    @GetMapping
    public ModelAndView index(){
        ModelAndView view = new ModelAndView("pages/supplier-locations/index");
        List<SupplierLocationsModel> data = this.supplierLocationsService.getAll();
        view.addObject("listDataSuppliersLocs", data);

        return view;
    }

    @GetMapping("add")
    public ModelAndView add(){
        ModelAndView view = new ModelAndView("pages/supplier-locations/add");
        // ambil data dari service address
        List<AddressModel> address = this.addressService.getAll();
        // ambil data dari service suppliers
        List<SuppliersModel> suppliers = this.suppliersService.getAll();

        view.addObject("dataAddressLoc", address);
        view.addObject("dataSuppliers", suppliers);
        return view;
    }

    @PostMapping("/save")
    public ModelAndView save(@ModelAttribute SupplierLocationsModel request){
        if (request == null){
            return new ModelAndView("pages/supplier-locations/add");
        }
        if (request.getDateFrom() == null){
            return new ModelAndView("pages/supplier-locations/add");
        }
        if (request.getDateTo() == null){
            return new ModelAndView("pages/supplier-locations/add");
        }
        // panggil dari service
        this.supplierLocationsService.save(request);
        // kirim ke view
        return new ModelAndView("redirect:/supplier-locations");
    }

    @GetMapping("/edit/{id}")
    public ModelAndView edit(@PathVariable("id") String id){
        ModelAndView view = new ModelAndView("pages/supplier-locations/edit");
        SupplierLocationsModel data = this.supplierLocationsService.getById(id).orElse(null);
        if (data == null){
            return new ModelAndView("redirect:/supplier-locations");
        }
        // ambil data dari service addres
        List<AddressModel> address = this.addressService.getAll();
        // ambil data dari service suppliers
        List<SuppliersModel> suplliers = this.suppliersService.getAll();

        view.addObject("dataAddressLoc", address);
        view.addObject("dataSuppliers", suplliers);
        // data kirim ke view
        view.addObject("dataSupplierLocs", data);
        return view;
    }

    @PostMapping("/update")
    public ModelAndView update(@ModelAttribute SupplierLocationsModel request){
        // memanggil dari service
        this.supplierLocationsService.update(request, request.getId());
        // data krim ke view
        return new ModelAndView("redirect:/supplier-locations");
    }

    @GetMapping("/detail/{id}")
    public ModelAndView detail(@PathVariable("id") String id){
        ModelAndView view = new ModelAndView("pages/supplier-locations/detail");
        SupplierLocationsModel model = this.supplierLocationsService.getById(id).orElse(null);
        if ( model == null){
            return  new ModelAndView("redirect:/supplier-locations");
        }

        // kirim data ke view
        view.addObject("dataSupplierLocs", model);
        return view;
    }

    @GetMapping("/delete/{id}")
    public ModelAndView delete(@PathVariable("id") String id){
        // ambil data dari servie
        this.supplierLocationsService.delete(id);
        // kirim data ke view
        return new ModelAndView("redirect:/supplier-locations");
    }
}
