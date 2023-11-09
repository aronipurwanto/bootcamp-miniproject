package com.bootcamp.pos.controller;

import com.bootcamp.pos.model.request.CustomerRequest;
import com.bootcamp.pos.model.request.ShoppingBasketRequest;
import com.bootcamp.pos.service.CustomerService;
import com.bootcamp.pos.service.ShoppingBasketService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/shopping")
public class ShoppingBasketController {
    private final ShoppingBasketService shoppingBasketService;
    private final CustomerService customerService;

    @GetMapping
    public ModelAndView index(){
        ModelAndView view = new ModelAndView("pages/shopping/index");
        List<ShoppingBasketRequest> shopping = shoppingBasketService.getAll();

        view.addObject("shoppingBasket", shopping);
        return view;
    }

    @GetMapping("/add")
    public ModelAndView add(){
        ModelAndView view = new ModelAndView("pages/shopping/add");
        List<CustomerRequest> requests = customerService.getAll();

        view.addObject("dataCustomer", requests);
        return view;
    }

    @PostMapping("/save")
    public ModelAndView save(@ModelAttribute ShoppingBasketRequest request){
        if (request == null){
            return new ModelAndView("redirect:/shopping/add");
        }

        if (request.getOtherBasketDetail().isEmpty()){
            return new ModelAndView("redirect:/shopping/add");
        }

        shoppingBasketService.save(request);
        return new ModelAndView("redirect:/shopping");
    }

    @GetMapping("/edit/{id}")
    public ModelAndView edit(@PathVariable("id") String id){
        ModelAndView view = new ModelAndView("pages/shopping/edit");
        ShoppingBasketRequest request = shoppingBasketService.getById(id);
        if (request == null){
            return new ModelAndView("redirect:/shopping");
        }

        List<CustomerRequest> customer = customerService.getAll();

        view.addObject("editCustomer", customer);

        view.addObject("shopping", request);
        return view;
    }

    @PostMapping("/update")
    public ModelAndView update(@ModelAttribute ShoppingBasketRequest request){
        shoppingBasketService.update(request, request.getId());
        return new ModelAndView("redirect:/shopping");
    }

    @GetMapping("/delete/{id}")
    public ModelAndView delete(@PathVariable("id") String id){
        shoppingBasketService.delete(id);
        return new ModelAndView("redirect:/shopping");
    }

    @GetMapping("/detail/{id}")
    public ModelAndView detail(@PathVariable("id") String id){
        ModelAndView view = new ModelAndView("pages/shopping/detail");
        ShoppingBasketRequest request = shoppingBasketService.getById(id);
        if (request == null){
            return new ModelAndView("redirect:/shopping");
        }

        view.addObject("shopping", request);
        return view;
    }
}
