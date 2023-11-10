package com.bootcamp.pos.controller;

import com.bootcamp.pos.model.response.CustomerResponse;
import com.bootcamp.pos.model.response.RefProductTypeResponse;
import com.bootcamp.pos.model.response.ShopBasketResponse;
import com.bootcamp.pos.service.CustomerService;
import com.bootcamp.pos.service.ShopBasketService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/shopbasket")
@RequiredArgsConstructor
public class ShopBasketController {
    private final ShopBasketService shopBasketService;
    private final CustomerService customerService;


    @GetMapping
    public ModelAndView index(){
        ModelAndView view = new ModelAndView("pages/shopbasket/index");

        List<ShopBasketResponse> data = shopBasketService.getAll();

        view.addObject("dataList", data);
        return view;
    }

    @GetMapping("/add")
    public ModelAndView add(){
        ModelAndView view = new ModelAndView("pages/shopbasket/add");

        List<ShopBasketResponse> data = shopBasketService.getAll();

        view.addObject("sbasket",data);

        List<CustomerResponse> customer = customerService.getAll();
        view.addObject("dataCustomer",customer);
        return view;
    }

    @PostMapping("/save")
    public ModelAndView save(@ModelAttribute ShopBasketResponse request){
        if(request == null){
            return new ModelAndView("redirect:/shopbasket");
        }
        if(request.getTotalCost().isEmpty()){
            return new ModelAndView("redirect:/shopbasket/add");
        }
        shopBasketService.save(request);
        return new ModelAndView("redirect:/shopbasket");
    }

    @GetMapping("/edit/{id}")
    public ModelAndView edit(@PathVariable("id")String id){
        ModelAndView view = new ModelAndView("pages/shopbasket/edit");
        ShopBasketResponse response = this.shopBasketService.getById(id).orElse(null);
        if(response == null){
            return new ModelAndView("redirect:/shopbasket");
        }
        view.addObject("shopbasket", response);

        List<CustomerResponse> customer = customerService.getAll();
        view.addObject("dataCustomer", customer);
        return view;
    }
    @PostMapping("/update")
    public ModelAndView update(@ModelAttribute ShopBasketResponse request){
        shopBasketService.update(request, request.getId());
        return new ModelAndView("redirect:/shopbasket");
    }


    @GetMapping("/delete/{id}")
    public ModelAndView delete(@PathVariable("id")String id){
        ShopBasketResponse response = shopBasketService.getById(id).orElse(null);
        shopBasketService.delete(id);

        return new ModelAndView("redirect:/shopbasket");
    }

    @GetMapping("/detail/{id}")
    public ModelAndView detail(@PathVariable("id")String id){
        ModelAndView view = new ModelAndView("pages/shopbasket/detail");
        ShopBasketResponse response = shopBasketService.getById(id).orElse(null);
        if(response == null){
            return new ModelAndView("redirect:/shopbasket");
        }
        view.addObject("detail",response);
        return view;
    }
}
