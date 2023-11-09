package com.bootcamp.pos.controller;

import com.bootcamp.pos.model.request.BasketItemModel;
import com.bootcamp.pos.model.request.CustomerRequest;
import com.bootcamp.pos.model.request.ProductsModel;
import com.bootcamp.pos.service.AddressTypeService;
import com.bootcamp.pos.service.BasketItemService;
import com.bootcamp.pos.service.CustomerService;
import com.bootcamp.pos.service.ProductsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/basket-item")
public class BasketItemController {
    private final BasketItemService basketItemService;
    private final CustomerService customerService;
    private final ProductsService productsService;

    @GetMapping
    public ModelAndView index(){
        ModelAndView view = new ModelAndView("pages/basket-item/index");
        List<BasketItemModel> data  = this.basketItemService.getAll();
        view.addObject("listDataBasketItem", data);

        return view;
    }

    @GetMapping("/add")
    public ModelAndView add(){
        ModelAndView view = new ModelAndView("pages/basket-item/add");
        // take data from service
        List<CustomerRequest> customer = this.customerService.getAll();
        // take data from service
        List<ProductsModel> products = this.productsService.getAll();

        // send to view
        view.addObject("dataCustomer", customer);
        // send to vieew
        view.addObject("dataProducts", products);
        return view;
    }

    @PostMapping("/save")
    public ModelAndView save(@ModelAttribute BasketItemModel request){
        if (request == null){
            return new ModelAndView("pages/basket-item/add");
        }
        if (request.getBasketDatetime() == null){
            return new ModelAndView("pages/basket-item/add");
        }
        if (request.getQuantity() == null){
            return new ModelAndView("pages/basket-item/add");
        }
        if (request.getCost() == null){
            return new ModelAndView("pages/basket-item/add");
        }
        // call save dari service
        this.basketItemService.save(request);
        // kirim ke index
        return new ModelAndView("redirect:/basket-item");
    }

    @GetMapping("/edit/{id}")
    public ModelAndView edit(@PathVariable("id") String id){
        ModelAndView view = new ModelAndView("pages/basket-item/edit");
        BasketItemModel data = this.basketItemService.getById(id).orElse(null);
        if (data == null){
            return new ModelAndView("redirect:/basket-item");
        }
        // take data from service
        List<CustomerRequest> customer = this.customerService.getAll();
        // take data from service
        List<ProductsModel> products = this.productsService.getAll();

        // send to view
        view.addObject("dataCustomer", customer);
        // send to vieew
        view.addObject("dataProducts", products);
        // data kirim ke view
        view.addObject("dataBasketItem", data);
        return view;
    }

    @PostMapping("/update")
    public ModelAndView update(@ModelAttribute BasketItemModel request){
        if (request == null){
            return new ModelAndView("pages/basket-item/edit/"+ request.getId());
        }
        if (request.getBasketDatetime() == null){
            return new ModelAndView("pages/basket-item/edit/"+ request.getId());
        }
        if (request.getQuantity() == null){
            return new ModelAndView("pages/basket-item/edit/"+ request.getId());
        }
        if (request.getCost() == null){
            return new ModelAndView("pages/basket-item/edit/"+ request.getId());
        }
        // memanggil save dari service
        this.basketItemService.update(request, request.getId());
        // redirect ke index
        return new ModelAndView("redirect:/basket-item");
    }

    @GetMapping("/detail/{id}")
    public ModelAndView detail(@PathVariable("id") String id){
        ModelAndView view = new ModelAndView("pages/basket-item/detail");
        // ambil data dari service
        BasketItemModel data = this.basketItemService.getById(id).orElse(null);
        if ( data == null){
            return new ModelAndView("redirect:/basket-item");
        }

        // kirim data to view
        view.addObject("dataBasketItem", data);
        return view;
    }

    @GetMapping("/delete/{id}")
    public ModelAndView delete(@PathVariable("id") String id){
        // ambil data dari servie
        this.basketItemService.delete(id);
        // kirim data ke view
        return new ModelAndView("redirect:/basket-item");
    }
}
