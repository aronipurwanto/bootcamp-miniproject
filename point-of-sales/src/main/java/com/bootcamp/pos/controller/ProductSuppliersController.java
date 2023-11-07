package com.bootcamp.pos.controller;

import com.bootcamp.pos.model.request.ProductSupplierRequest;
import com.bootcamp.pos.model.request.ProductsRequest;
import com.bootcamp.pos.model.request.SupplierRequest;
import com.bootcamp.pos.service.ProductSupplierService;
import com.bootcamp.pos.service.ProductsService;
import com.bootcamp.pos.service.SupplierService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/productSuppliers")
@RequiredArgsConstructor
public class ProductSuppliersController {

    private final ProductSupplierService ProductSupplierService;
    private final ProductsService productsService;
    private final SupplierService supplierService;

    @GetMapping
    public ModelAndView index(){
        ModelAndView view = new ModelAndView("/pages/productSuppliers/index");
        List<ProductSupplierRequest> products = this.ProductSupplierService.getAll();

        view.addObject("productSupplierList", products);
        return view;
    }

    @GetMapping("/add")
    public ModelAndView add(){
        ModelAndView view = new ModelAndView("pages/productSuppliers/add");
        List<ProductsRequest> product = this.productsService.getAll();
        List<SupplierRequest> supplier = this.supplierService.getAll();

        view.addObject("productList", product);
        view.addObject("supplierList", supplier);
        return view;
    }

    @PostMapping("/save")
    public ModelAndView save (@ModelAttribute ProductSupplierRequest request){
        ModelAndView view = new ModelAndView("pages/productSuppliers/add");
        List<ProductsRequest> product = this.productsService.getAll();
        List<SupplierRequest> supplier = this.supplierService.getAll();

        view.addObject("productList", product);
        view.addObject("supplierList", supplier);
        this.ProductSupplierService.save(request);
        return new ModelAndView("redirect:/productSuppliers");
    }

    @GetMapping("/edit/{id}")
    public ModelAndView edit(@PathVariable("id") String id){
        ModelAndView view = new ModelAndView("pages/productSuppliers/edit");
        ProductSupplierRequest products = this.ProductSupplierService.getById(id).orElse(null);
        if (products == null){
            return new ModelAndView("redirect:/productSuppliers");
        }

        List<ProductsRequest> product = this.productsService.getAll();
        List<SupplierRequest> supplier = this.supplierService.getAll();

        view.addObject("productList", product);
        view.addObject("supplierList", supplier);
        view.addObject("productSupplier", products);
        return view;
    }

    @PostMapping("/update")
    public ModelAndView update(@ModelAttribute ProductSupplierRequest request){
        this.ProductSupplierService.update(request, request.getId());
        return new ModelAndView("redirect:/productSuppliers");
    }

    @GetMapping("/delete/{id}")
    public ModelAndView delete(@PathVariable("id") String id){
        this.ProductSupplierService.delete(id);
        return new ModelAndView("redirect:/productSuppliers");
    }

    @GetMapping("/detail/{id}")
    public ModelAndView detail(@PathVariable("id") String id){
        ModelAndView view = new ModelAndView("pages/productSuppliers/detail");
        ProductSupplierRequest products = this.ProductSupplierService.getById(id).orElse(null);
        if (products == null){
            return new ModelAndView("redirect:/productSuppliers");
        }

        view.addObject("productSuppliers", products);
        return view;
    }
}
