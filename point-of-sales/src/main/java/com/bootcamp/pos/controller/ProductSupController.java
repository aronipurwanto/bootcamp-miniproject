package com.bootcamp.pos.controller;

import com.bootcamp.pos.model.request.ProductRequest;
import com.bootcamp.pos.model.request.ProductSupplierRequest;
import com.bootcamp.pos.model.request.SupplierRequest;
import com.bootcamp.pos.service.ProductService;
import com.bootcamp.pos.service.ProductSupService;
import com.bootcamp.pos.service.SupplierService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/productSupplier")
public class ProductSupController {
    private final ProductSupService productSupService;
    private final ProductService productService;
    private final SupplierService supplierService;

    @GetMapping
    public ModelAndView index(){
        ModelAndView view = new ModelAndView("pages/productSupp/index");
        List<ProductSupplierRequest> requests = productSupService.getAll();

        view.addObject("dataProductSupp", requests);
        return view;
    }

    @GetMapping("/add")
    public ModelAndView add(){
        ModelAndView view = new ModelAndView("pages/productSupp/add");
        List<ProductRequest> requests = productService.getAll();
        List<SupplierRequest> supplier = supplierService.getAll();

        view.addObject("dataProduct", requests);
        view.addObject("dataSupplier", supplier);
        return view;
    }

    @PostMapping("/save")
    public ModelAndView save(@ModelAttribute ProductSupplierRequest request){
        if (request == null){
            return new ModelAndView("redirect:/productSupplier/add");
        }

        if (request.getValueSupplied().isEmpty()){
            return new ModelAndView("redirect:/productSupplier/add");
        }

        productSupService.save(request);
        return new ModelAndView("redirect:/productSupplier");
    }

    @GetMapping("/edit/{id}")
    public ModelAndView update(@PathVariable("id") String id){
        ModelAndView view = new ModelAndView("pages/productSupp/edit");
        ProductSupplierRequest request = productSupService.getById(id);
        if (request == null){
            return new ModelAndView("redirect:/productSupplier");
        }

        List<ProductRequest> product = productService.getAll();
        List<SupplierRequest> supplier = supplierService.getAll();

        view.addObject("editProduct", product);

        view.addObject("editSupplier", supplier);

        view.addObject("editProductSupp", request);
        return view;

    }

    @PostMapping("/update")
    public ModelAndView update(@ModelAttribute ProductSupplierRequest request){
        productSupService.update(request, request.getId());
        return new ModelAndView("redirect:/productSupplier");
    }

    @GetMapping("/delete/{id}")
    public ModelAndView delete(@PathVariable("id") String id){
        productSupService.delete(id);
        return new ModelAndView("redirect:/productSupplier");
    }

    @GetMapping("/detail/{id}")
    public ModelAndView detail(@PathVariable("id") String id) {
        ModelAndView view = new ModelAndView("pages/productSupp/detail");
        ProductSupplierRequest request = productSupService.getById(id);
        if (request == null) {
            return new ModelAndView("redirect:/productSupplier");
        }

        view.addObject("detailProductSupp", request);
        return view;
    }
}
