package com.bootcamp.pos.controller;

import com.bootcamp.pos.model.request.*;
import com.bootcamp.pos.service.AddressService;
import com.bootcamp.pos.service.InventoryLocationService;
import com.bootcamp.pos.service.ProductService;
import com.bootcamp.pos.service.ProductSupService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/inventory")
public class InventoryLocationController {
    private final InventoryLocationService inventoryLocationService;
    private final ProductService productService;
    private final AddressService addressService;

    @GetMapping
    public ModelAndView index(){
        ModelAndView view = new ModelAndView("pages/inventory/index");
        List<InventoryLocationRequest> data = inventoryLocationService.getAll();

        view.addObject("inventoryList", data);
        return view;
    }

    @GetMapping("/add")
    public ModelAndView add(){
        ModelAndView view = new ModelAndView("pages/inventory/add");
        List<ProductRequest> requests = productService.getAll();
        List<AddressRequest> address = addressService.getAll();

        view.addObject("addProduct", requests);

        view.addObject("addAddress", address);
        return view;
    }

    @PostMapping("/save")
    public ModelAndView save(@ModelAttribute InventoryLocationRequest request){
        if (request == null){
            return new ModelAndView("redirect:/inventory/add");
        }

        if (request.getOtherInventoryDetail().isEmpty()){
            return new ModelAndView("redirect:/inventory/add");
        }

        inventoryLocationService.save(request);
        return new ModelAndView("redirect:/inventory");
    }

    @GetMapping("/edit/{id}")
    public ModelAndView edit(@PathVariable("id") String id){
        ModelAndView view = new ModelAndView("pages/inventory/edit");
        InventoryLocationRequest request = inventoryLocationService.getById(id);
        if (request == null){
            return new ModelAndView("redirect:/inventory");
        }

        List<ProductRequest> product = productService.getAll();
        List<AddressRequest> address = addressService.getAll();

        view.addObject("editProduct", product);

        view.addObject("editAddress", address);

        view.addObject("inventory", request);
        return view;
    }

    @PostMapping("/update")
    public ModelAndView update(@ModelAttribute InventoryLocationRequest request){
        inventoryLocationService.update(request, request.getId());
        return new ModelAndView("redirect:/inventory");
    }

    @GetMapping("/delete/{id}")
    public ModelAndView delete(@PathVariable("id") String id){
        inventoryLocationService.delete(id);
        return new ModelAndView("redirect:/customer");
    }

    @GetMapping("/detail/{id}")
    public ModelAndView detail(@PathVariable("id") String id){
        ModelAndView view = new ModelAndView("pages/inventory/detail");
        InventoryLocationRequest request = inventoryLocationService.getById(id);
        if (request == null){
            return new ModelAndView("redirect:/inventory");
        }
        view.addObject("inventory", request);
        return view;
    }
}
