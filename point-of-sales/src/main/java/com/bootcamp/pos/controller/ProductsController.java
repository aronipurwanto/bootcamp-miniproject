package com.bootcamp.pos.controller;

import com.bootcamp.pos.model.request.ProductTypeModel;
import com.bootcamp.pos.model.request.ProductsModel;
import com.bootcamp.pos.service.ProductTypeService;
import com.bootcamp.pos.service.ProductsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/products")
public class ProductsController {
    private final ProductsService productsService;
    private final ProductTypeService productTypeService;

    @GetMapping
    public ModelAndView index(){
        ModelAndView view = new ModelAndView("pages/products/index");
        List<ProductsModel> data  = this.productsService.getAll();
        view.addObject("listDataProducts", data);

        return view;
    }

    @GetMapping("/add")
    public ModelAndView add(){
        ModelAndView view = new ModelAndView("pages/products/add");
        // take data from service
        List<ProductTypeModel> productType = this.productTypeService.getAll();

        // send to view
        view.addObject("dataProductType", productType);
        return view;
    }

    @PostMapping("/save")
    public ModelAndView save(@ModelAttribute ProductsModel request){
        // validsi
        if (request == null){
            return new ModelAndView("redirect:/products/add");
        }
        if (request.getProductDetails().isEmpty()){
            return new ModelAndView("redirect:/products/add");
        }
        if (request.getProductName().isEmpty()){
            return new ModelAndView("redirect:/products/add");
        }
        if (request.getProductPrice() == null){
            return new ModelAndView("redirect:/products/add");
        }
        if (request.getProductDescription().isEmpty()){
            return new ModelAndView("redirect:/products/add");
        }
        // call save dari service
        this.productsService.save(request);
        // kirim ke index
        return new ModelAndView("redirect:/products");
    }

    @GetMapping("/edit/{id}")
    public ModelAndView edit(@PathVariable("id") String id){
        ModelAndView view = new ModelAndView("pages/products/edit");
        ProductsModel data = this.productsService.getById(id).orElse(null);
        if (data == null){
            return new ModelAndView("redirect:/products");
        }
        // take data from service
        List<ProductTypeModel> productType = this.productTypeService.getAll();

        view.addObject("dataProductType", productType);
        // data kirim ke view
        view.addObject("dataProducts", data);
        return view;
    }

    @PostMapping("/update")
    public ModelAndView update(@ModelAttribute ProductsModel request){
        // validsi
        if (request == null){
            return new ModelAndView("redirect:/products/edit/"+ request.getId());
        }
        if (request.getProductDetails().isEmpty()){
            return new ModelAndView("redirect:/products/edit/"+ request.getId());
        }
        if (request.getProductName().isEmpty()){
            return new ModelAndView("redirect:/products/edit/"+ request.getId());
        }
        if (request.getProductPrice() == null){
            return new ModelAndView("redirect:/products/edit/"+ request.getId());
        }
        if (request.getProductDescription().isEmpty()){
            return new ModelAndView("redirect:/products/edit/"+ request.getId());
        }
        // memanggil save dari service
        this.productsService.update(request, request.getId());
        // redirect ke index
        return new ModelAndView("redirect:/products");
    }

    @GetMapping("/detail/{id}")
    public ModelAndView detail(@PathVariable("id") String id){
        ModelAndView view = new ModelAndView("pages/products/detail");
        // ambil data dari service
        ProductsModel data = this.productsService.getById(id).orElse(null);
        if ( data == null){
            return new ModelAndView("redirect:/products");
        }

        // kirim data to view
        view.addObject("dataProducts", data);
        return view;
    }

    @GetMapping("/delete/{id}")
    public ModelAndView delete(@PathVariable("id") String id){
        // ambil data dari servie
        this.productsService.delete(id);
        // kirim data ke view
        return new ModelAndView("redirect:/products");
    }
}
