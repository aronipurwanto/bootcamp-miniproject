package com.bootcamp.pos.controller;

import com.bootcamp.pos.model.request.ProductRequest;
import com.bootcamp.pos.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/product")
public class ProductController {
    private final ProductService productService;

    @GetMapping
    public ModelAndView index(){
        ModelAndView view = new ModelAndView("pages/product/index");
        List<ProductRequest> requests = productService.getAll();

        view.addObject("dataProduct", requests);
        return view;
    }

    @GetMapping("/add")
    public ModelAndView add(){
        ModelAndView view = new ModelAndView("pages/product/add");
        return view;
    }

    @PostMapping("/save")
    public ModelAndView save(@ModelAttribute ProductRequest request){
        if (request == null){
            return new ModelAndView("redirect:/product/add");
        }

        if (request.getName().isEmpty()){
            return new ModelAndView("redirect:/product/add");
        }
        productService.save(request);
        return new ModelAndView("redirect:/product");
    }

    @GetMapping("/edit/{id}")
    public ModelAndView edit(@PathVariable("id") String id){
        ModelAndView view = new ModelAndView("pages/product/edit");
        ProductRequest request = productService.getById(id);
        if (request == null){
            return new ModelAndView("redirect:/product");
        }
        view.addObject("editProduct", request);
        return view;
    }

    @PostMapping("/update")
    public ModelAndView update(@ModelAttribute ProductRequest request){
        productService.update(request, request.getId());
        return new ModelAndView("redirect:/product");
    }

    @GetMapping("/delete/{id}")
    public ModelAndView delete(@PathVariable("id") String id){
        productService.delete(id);
        return new ModelAndView("redirect:/product");
    }

    @GetMapping("/detail/{id}")
    public ModelAndView detail(@PathVariable("id") String id) {
        ModelAndView view = new ModelAndView("pages/product/detail");
        ProductRequest request = productService.getById(id);
        if (request == null) {
            return new ModelAndView("redirect:/product");
        }
        view.addObject("detailProduct", request);
        return view;
    }
}
