package com.bootcamp.pos.controller;


import com.bootcamp.pos.model.request.CustomerRequest;
import com.bootcamp.pos.model.request.ShoppingBasketModel;
import com.bootcamp.pos.model.request.SuppliersModel;
import com.bootcamp.pos.service.CustomerService;
import com.bootcamp.pos.service.ShoppingBasketService;
import com.bootcamp.pos.service.SuppliersService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/shopping-basket")
public class ShoppingBasketController {
    private final ShoppingBasketService shoppingBasketService;
    private final CustomerService customerService;


    @GetMapping
    public ModelAndView index(){
        ModelAndView view = new ModelAndView("pages/shopping-basket/index");
        List<ShoppingBasketModel> data = this.shoppingBasketService.getAll();
        view.addObject("listShoppingBasket", data);

        return view;
    }

    @GetMapping("add")
    public ModelAndView add(){
        ModelAndView view = new ModelAndView("pages/shopping-basket/add");
        // ambil data dari service customer
        List<CustomerRequest> customer = this.customerService.getAll();

        // send to view
        view.addObject("dataCustomer", customer);
        return view;
    }

    @PostMapping("/save")
    public ModelAndView save(@ModelAttribute ShoppingBasketModel request){
        if (request == null){
            return new ModelAndView("pages/shopping-basket/add");
        }
        if (request.getBasketDatetime() == null){
            return new ModelAndView("pages/shopping-basket/add");
        }
        if (request.getTotalCost() == null){
            return new ModelAndView("pages/shopping-basket/add");
        }
        if (request.getBasketDetail() == null){
            return new ModelAndView("pages/shopping-basket/add");
        }
        // panggil dari service
        this.shoppingBasketService.save(request);
        // kirim ke view
        return new ModelAndView("redirect:/shopping-basket");
    }

    @GetMapping("/edit/{id}")
    public ModelAndView edit(@PathVariable("id") String id){
        ModelAndView view = new ModelAndView("pages/shopping-basket/edit");
        ShoppingBasketModel data = this.shoppingBasketService.getById(id).orElse(null);
        if (data == null){
            return new ModelAndView("redirect:/shopping-basket");
        }
        // ambil data dari service customer
        List<CustomerRequest> customer = this.customerService.getAll();

        // send to view
        view.addObject("dataCustomer", customer);
        // data kirim ke view
        view.addObject("dataShoppingBasket", data);
        return view;
    }

    @PostMapping("/update")
    public ModelAndView update(@ModelAttribute ShoppingBasketModel request){
        if (request == null){
            return new ModelAndView("pages/shopping-basket/edit/"+ request.getId());
        }
        if (request.getBasketDatetime() == null){
            return new ModelAndView("pages/shopping-basket/edit/"+ request.getId());
        }
        if (request.getTotalCost() == null){
            return new ModelAndView("pages/shopping-basket/edit/"+ request.getId());
        }
        if (request.getBasketDetail() == null){
            return new ModelAndView("pages/shopping-basket/edit/"+ request.getId());
        }
        // memanggil dari service
        this.shoppingBasketService.update(request, request.getId());
        // data krim ke view
        return new ModelAndView("redirect:/shopping-basket");
    }

    @GetMapping("/detail/{id}")
    public ModelAndView detail(@PathVariable("id") String id){
        ModelAndView view = new ModelAndView("pages/shopping-basket/detail");
        ShoppingBasketModel data = this.shoppingBasketService.getById(id).orElse(null);
        if ( data == null){
            return  new ModelAndView("redirect:/shopping-basket");
        }

        // kirim data ke view
        view.addObject("dataShoppingBasket", data);
        return view;
    }

    @GetMapping("/delete/{id}")
    public ModelAndView delete(@PathVariable("id") String id){
        // ambil data dari servie
        this.shoppingBasketService.delete(id);
        // kirim data ke view
        return new ModelAndView("redirect:/shopping-basket");
    }
}
