package com.bootcamp.pos.controller;

import com.bootcamp.pos.model.entity.BasketItemEntity;
import com.bootcamp.pos.model.request.BasketItemRequest;
import com.bootcamp.pos.model.request.CustomerRequest;
import com.bootcamp.pos.model.request.ProductRequest;
import com.bootcamp.pos.service.BasketItemService;
import com.bootcamp.pos.service.CustomerService;
import com.bootcamp.pos.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/basketItem")
public class BasketItemController {
    private final BasketItemService basketItemService;
    private final ProductService productService;
    private final CustomerService customerService;

    @GetMapping
    public ModelAndView index(){
        ModelAndView view = new ModelAndView("pages/basketItem/index");
        List<BasketItemRequest> basketItem = basketItemService.getAll();

        view.addObject("basketItem", basketItem);
        return view;
    }

    @GetMapping("/add")
    public ModelAndView add(){
        ModelAndView view = new ModelAndView("pages/basketItem/add");

        List<CustomerRequest> customer = customerService.getAll();
        List<ProductRequest> product = productService.getAll();

        view.addObject("addCustomer", customer);
        view.addObject("addProduct", product);
        return view;
    }

    @PostMapping("/save")
    public ModelAndView save(@ModelAttribute BasketItemRequest request){
        if (request == null){
            return new ModelAndView("redirect:/basketItem/add");
        }

        if (request.getCustomerId().isEmpty()){
            return new ModelAndView("redirect:/basketItem/add");
        }

        basketItemService.save(request);
        return new ModelAndView("redirect:/basketItem");
    }

    @GetMapping("/edit/{id}")
    public ModelAndView edit(@PathVariable("id") String id){
        ModelAndView view = new ModelAndView("pages/basketItem/edit");
        BasketItemRequest basketItem = basketItemService.getById(id);
        if (basketItem == null){
            return new ModelAndView("redirect:/basketItem");
        }

        List<CustomerRequest> customer = customerService.getAll();
        List<ProductRequest> product = productService.getAll();

        view.addObject("editCustomer", customer);

        view.addObject("editProduct", product);

        view.addObject("basketItem", basketItem);
        return view;
    }

    @PostMapping("/update")
    public ModelAndView update(@ModelAttribute BasketItemRequest request){
        basketItemService.update(request, request.getId());
        return new ModelAndView("redirect:/basketItem");
    }

    @GetMapping("/delete/{id}")
    public ModelAndView delete(@PathVariable("id") String id){
        basketItemService.delete(id);
        return new ModelAndView("redirect:/basketItem");
    }

    @GetMapping("/detail/{id}")
    public ModelAndView detail(@PathVariable("id") String id) {
        ModelAndView view = new ModelAndView("pages/basketItem/detail");
        BasketItemRequest basketItem = basketItemService.getById(id);
        if (basketItem == null) {
            return new ModelAndView("redirect:/basketItem");
        }

        view.addObject("basketItem", basketItem);
        return view;
    }
}
