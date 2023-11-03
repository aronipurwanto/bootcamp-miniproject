package com.bootcamp.pos.controller;

import com.bootcamp.pos.model.request.ProductRequest;
import com.bootcamp.pos.service.ProductsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductsController {
    private final ProductsService productsService;

    @GetMapping
    public ModelAndView index(){
        ModelAndView view = new ModelAndView("/pages/products/index");
        List<ProductRequest> products = this.productsService.getAll();

        view.addObject("productsList", products);
        return view;
    }
}
