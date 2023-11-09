package com.bootcamp.pos.controller;

import com.bootcamp.pos.model.request.ProductSuppliersModel;
import com.bootcamp.pos.model.request.ProductsModel;
import com.bootcamp.pos.model.request.SuppliersModel;
import com.bootcamp.pos.service.ProductsService;
import com.bootcamp.pos.service.ProductSuppliersService;
import com.bootcamp.pos.service.SuppliersService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/products-suppliers")
public class ProductsSuppliersController {
    private final ProductSuppliersService productSuppliersService;
    private final ProductsService productsService;
    private final SuppliersService suppliersService;

    @GetMapping
    public ModelAndView index(){
        ModelAndView view = new ModelAndView("pages/products-suppliers/index");
        List<ProductSuppliersModel> data  = this.productSuppliersService.getAll();
        view.addObject("listDataProductsSuppliers", data);

        return view;
    }

    @GetMapping("/add")
    public ModelAndView add(){
        ModelAndView view = new ModelAndView("pages/products-suppliers/add");
        // ambil data dari service product
        List<ProductsModel> products = this.productsService.getAll();
        // ambil data dari service suppliers
        List<SuppliersModel> suppliers = this.suppliersService.getAll();

        // kirim data product ke view
        view.addObject("dataProducts", products);
        // kirim data suppliers ke view
        view.addObject("dataSuppliers", suppliers);

        return view;
    }

    @PostMapping("/save")
    public ModelAndView save(@ModelAttribute ProductSuppliersModel request){
        // validsi
        if (request == null){
            return new ModelAndView("redirect:/products-suppliers/add");
        }
        if (request.getTotalQtySupToDate().isEmpty()){
            return new ModelAndView("redirect:/products-suppliers/add");
        }
        if (request.getItemSuppliersDetails().isEmpty()){
            return new ModelAndView("redirect:/product-suppliers/add");
        }
        // call save dari service
        this.productSuppliersService.save(request);
        // kirim ke index
        return new ModelAndView("redirect:/products-suppliers");
    }

    @GetMapping("/edit/{id}")
    public ModelAndView edit(@PathVariable("id") String id){
        ModelAndView view = new ModelAndView("pages/products-suppliers/edit");
        ProductSuppliersModel data = this.productSuppliersService.getById(id).orElse(null);
        if (data == null){
            return new ModelAndView("redirect:/products");
        }
        // ambil data dari service products
        List<ProductsModel> products = this.productsService.getAll();
        // ambil data dari service suppliers
        List<SuppliersModel> suppliers = this.suppliersService.getAll();

        // kirim data ke view
        view.addObject("dataProducts", products);
        // kirim data ke view
        view.addObject("dataSuppliers", suppliers);

        // data kirim ke view
        view.addObject("dataProductsSuppliers", data);
        return view;
    }

    @PostMapping("/update")
    public ModelAndView update(@ModelAttribute ProductSuppliersModel request){
        // validsi
        if (request == null){
            return new ModelAndView("redirect:/products-suppliers/edit/"+ request.getId());
        }
        // memanggil save dari service
        this.productSuppliersService.update(request, request.getId());
        // redirect ke index
        return new ModelAndView("redirect:/products-suppliers");
    }

    @GetMapping("/detail/{id}")
    public ModelAndView detail(@PathVariable("id") String id){
        ModelAndView view = new ModelAndView("pages/products-suppliers/detail");
        // ambil data dari service
        ProductSuppliersModel data = this.productSuppliersService.getById(id).orElse(null);
        if ( data == null){
            return new ModelAndView("redirect:/products-suppliers");
        }

        // kirim data to view
        view.addObject("dataProductsSuppliers", data);
        return view;
    }

    @GetMapping("/delete/{id}")
    public ModelAndView delete(@PathVariable("id") String id){
        // ambil data dari servie
        this.productSuppliersService.delete(id);
        // kirim data ke view
        return new ModelAndView("redirect:/products-suppliers");
    }
}
