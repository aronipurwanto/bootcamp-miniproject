package com.bootcamp.pos.controller;

import com.bootcamp.pos.model.response.*;
import com.bootcamp.pos.service.AddressesService;
import com.bootcamp.pos.service.CustomerAddressService;
import com.bootcamp.pos.service.SupllierService;
import com.bootcamp.pos.service.SupplierLocationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/suploc")
public class SupplierLocationController {
    private final SupplierLocationService supplierLocationService;
    private final SupllierService supllierService;
    private final AddressesService addressesService;
    private final CustomerAddressService customerAddressService;
    @GetMapping
    public ModelAndView index(){
        ModelAndView view = new ModelAndView("pages/suploc/index");

        List<SupplierLocationResponse> data = supplierLocationService.getAll();

        view.addObject("dataList", data);
        return view;
    }
    @GetMapping("/add")
    public ModelAndView add(){
        ModelAndView view = new ModelAndView("pages/suploc/add");

        List<SupplierLocationResponse> data = supplierLocationService.getAll();
        view.addObject("dataSupLoc",data);

        List<SupllierResponse> dataSup = supllierService.getAll();
        view.addObject("dataSup",dataSup);

        List<AddressesResponse> dataAdr = addressesService.getAll();
        view.addObject("daraAdr",dataAdr);

        List<CustomerAddressResponse> dataCusAdr = customerAddressService.getAll();
        view.addObject("dataCusAdr" , dataCusAdr);

        return view;
    }

    @PostMapping("/save")
    public ModelAndView save(@ModelAttribute SupplierLocationResponse request){
        if(request == null){
            return new ModelAndView("redirect:/suploc");
        }
        if(request.getSupplierId().isEmpty()){
            return new ModelAndView("redirect:/suploc/add");
        }

        supplierLocationService.save(request);
        return new ModelAndView("redirect:/suploc");
    }

    @GetMapping("/edit/{id}")
    public ModelAndView edit(@PathVariable("id")String id){
        ModelAndView view = new ModelAndView("pages/suploc/edit");
        SupplierLocationResponse response = this.supplierLocationService.getById(id).orElse(null);
        if(response == null){
            return new ModelAndView("redirect:/suploc");
        }
        view.addObject("data",response);

        List<SupllierResponse> dataSup = supllierService.getAll();
        view.addObject("dataSup",dataSup);

        List<AddressesResponse> dataAdr = addressesService.getAll();
        view.addObject("dataAdr",dataAdr);

        List<CustomerAddressResponse> dataCusAdr = customerAddressService.getAll();
        view.addObject("dataCusAdr",dataCusAdr);
        return view;


    }
    @PostMapping("/update")
    public ModelAndView update(@ModelAttribute SupplierLocationResponse request){
        supplierLocationService.update(request, request.getId());
        return new ModelAndView("redirect:/suploc");
    }

    @GetMapping("/delete/{id}")
    public ModelAndView delete(@PathVariable("id")String id){
        SupplierLocationResponse response = supplierLocationService.getById(id).orElse(null);
        supplierLocationService.delete(id);

        return new ModelAndView("redirect:/suploc");
    }

    @GetMapping("/detail/{id}")
    public ModelAndView detail(@PathVariable("id")String id){
        ModelAndView view = new ModelAndView("pages/suploc/detail");
        SupplierLocationResponse response = supplierLocationService.getById(id).orElse(null);
        if(response == null){
            return new ModelAndView("redirect:/suploc");
        }
        view.addObject("detail",response);
        return view;
    }
}