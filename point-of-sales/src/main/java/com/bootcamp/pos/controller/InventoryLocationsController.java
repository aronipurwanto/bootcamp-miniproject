package com.bootcamp.pos.controller;

import com.bootcamp.pos.model.request.AddressModel;
import com.bootcamp.pos.model.request.InventoryLocationsModel;
import com.bootcamp.pos.model.request.ProductsModel;
import com.bootcamp.pos.service.AddressService;
import com.bootcamp.pos.service.InventoryLocationsService;
import com.bootcamp.pos.service.ProductsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/inventory-locations")
public class InventoryLocationsController {
    private final InventoryLocationsService inventoryLocationsService;
    private final AddressService addressService;
    private final ProductsService productsService;

    @GetMapping
    public ModelAndView index(){
        ModelAndView view = new ModelAndView("pages/inventory-locations/index");

        List<InventoryLocationsModel> data = this.inventoryLocationsService.getAll();
        view.addObject("inventoryLocList", data);

        return view;
    }

    @GetMapping("/add")
    public ModelAndView add(){
        ModelAndView view = new ModelAndView("pages/inventory-locations/add");
        // ambil data dari service product
        List<ProductsModel> products = this.productsService.getAll();
        // ambil data dari service address
        List<AddressModel> address = this.addressService.getAll();

        // kirim data ke view
        view.addObject("dataProduct", products);
        // kirim data ke view
        view.addObject("dataAddress", address);

        return view;
    }

    @PostMapping("/save")
    public ModelAndView save(@ModelAttribute InventoryLocationsModel request){
        if (request == null){
            return new ModelAndView("pages/inventory-locations/add");
        }
        if (request.getQtyInStock() == null){
            return new ModelAndView("pages/inventory-locations/add");
        }
        if (request.getInventoryDetails() == null){
            return new ModelAndView("pages/inventory-locations/add");
        }
        // memanggil data save dari service
        this.inventoryLocationsService.save(request);
        // kirim ke view
        return new ModelAndView("redirect:/inventory-locations");
    }

    @GetMapping("/edit/{id}")
    public ModelAndView edit(@PathVariable("id") String id){
        ModelAndView view = new ModelAndView("pages/inventory-locations/edit");
        InventoryLocationsModel model = this.inventoryLocationsService.getById(id);
        if (model == null) {
            return new ModelAndView("redirect:/inventory-locations");
        }
        // ambil data dari service product
        List<ProductsModel> products = this.productsService.getAll();
        // ambil data dari service address
        List<AddressModel> address = this.addressService.getAll();

        // kirim data ke view
        view.addObject("dataProduct", products);
        // kirim data ke view
        view.addObject("dataAddress", address);
        // kirim data ke view
        view.addObject("inventoryLocationsList", model);
        return view;
    }

    @PostMapping("/update")
    public ModelAndView update(@ModelAttribute InventoryLocationsModel request){
        if (request == null){
            return new ModelAndView("pages/inventory-locations/edit/"+ request.getId());
        }
        if (request.getQtyInStock() == null){
            return new ModelAndView("pages/inventory-locations/edit/"+ request.getId());
        }
        if (request.getInventoryDetails() == null){
            return new ModelAndView("pages/inventory-locations/edit/"+ request.getId());
        }
        // memanggil data dari service
        this.inventoryLocationsService.update(request, request.getId());
        // send to view
        return new ModelAndView("redirect:/inventory-locations");
    }

    @GetMapping("/detail/{id}")
    public ModelAndView detail(@PathVariable("id") String id){
        ModelAndView view = new ModelAndView("pages/inventory-locations/detail");
        InventoryLocationsModel model = this.inventoryLocationsService.getById(id);
        if (model == null){
            return new ModelAndView("redirect:/inventory-locations");
        }

        view.addObject("inventoryLocationsList", model);
        return view;
    }

    @GetMapping("/delete/{id}")
    public ModelAndView delete(@PathVariable("id") String id){
        this.inventoryLocationsService.delete(id);
        return new ModelAndView("redirect:/inventory-locations");
    }
}
