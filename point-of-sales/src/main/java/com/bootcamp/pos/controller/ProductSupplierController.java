package com.bootcamp.pos.controller;

import com.bootcamp.pos.model.response.*;
import com.bootcamp.pos.service.ProductService;
import com.bootcamp.pos.service.ProductSupplierService;
import com.bootcamp.pos.service.SupllierService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
@RequestMapping("/productsupplier")
public class ProductSupplierController {
    private final ProductSupplierService productSupplierService;
    private final ProductService productService;
    private final SupllierService supllierService;
    @GetMapping
    public ModelAndView index(){
        ModelAndView view = new ModelAndView("pages/productsupplier/index");

        List<ProductSuppliersResponse> data = productSupplierService.getAll();

        view.addObject("dataList",data);
        return view;
    }
    @GetMapping("/add")
    public ModelAndView add(){
        ModelAndView view = new ModelAndView("pages/productsupplier/add");

        List<ProductSuppliersResponse> data = productSupplierService.getAll();
        view.addObject("data",data);

        //---------------getAll data Product------------//
        List<ProductResponse> dataProd = productService.getAll();
        view.addObject("dataProd", dataProd);

        //---------------getAll data Supplier------------//
        List<SupllierResponse> dataSup = supllierService.getAll();
        view.addObject("dataSup", dataSup);

        return view;
    }
    @PostMapping("/save")
    public ModelAndView save(@ModelAttribute ProductSuppliersResponse request){
        if(request == null){
            return new ModelAndView("redirect:/productsupplier");
        }
        if(request.getValueSupplierToDate().isEmpty()){
            return new ModelAndView("redirect:/productsupplier/add");
        }
        productSupplierService.save(request);
        return new ModelAndView("redirect:/productsupplier");
    }

    @GetMapping("/edit/{id}")
    public ModelAndView edit(@PathVariable("id")String id){
        ModelAndView view = new ModelAndView("pages/productsupplier/edit");
        ProductSuppliersResponse response = this.productSupplierService.getById(id).orElse(null);
        if(response == null){
            return new ModelAndView("redirect:/productsupplier");
        }
        view.addObject("data", response);

        //---------------getAll data Product------------//
        List<ProductResponse> dataProd = productService.getAll();
        view.addObject("dataProd", dataProd);

        //---------------getAll data Supplier------------//
        List<SupllierResponse> dataSup = supllierService.getAll();
        view.addObject("dataSup", dataSup);

        return view;
    }

    @PostMapping("/update")
    public ModelAndView update(@ModelAttribute ProductSuppliersResponse request){
        productSupplierService.update(request, request.getId());
        return new ModelAndView("redirect:/productsupplier");
    }

    @GetMapping("/delete/{id}")
    public ModelAndView delete(@ModelAttribute ProductSuppliersResponse request) {
        Optional<ProductSuppliersResponse> response = productSupplierService.getById(request.getId());
        if (response == null) {
            return new ModelAndView("redirect:/productsupplier");
        }
        productSupplierService.delete(request.getId());
        return new ModelAndView("redirect:/productsupplier");
    }

    @GetMapping("/detail/{id}")
    public ModelAndView detail(@PathVariable("id")String id){
        ModelAndView view = new ModelAndView("pages/productsupplier/detail");
        ProductSuppliersResponse data = productSupplierService.getById(id).orElse(null);
        if(data == null){
            return new ModelAndView("redirect:/productsupplier");
        }

        view.addObject("data", data );
        return view;
    }
}
