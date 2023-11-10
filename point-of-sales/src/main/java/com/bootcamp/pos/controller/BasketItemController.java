package com.bootcamp.pos.controller;

import com.bootcamp.pos.model.request.BasketItemsRequest;
import com.bootcamp.pos.model.response.*;
import com.bootcamp.pos.service.BasketItemService;
import com.bootcamp.pos.service.CustomerService;
import com.bootcamp.pos.service.ProductService;
import com.bootcamp.pos.service.ShopBasketService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/basketitem")
public class BasketItemController {
    private final BasketItemService basketItemService;
    private final CustomerService customerService;
    private final ShopBasketService shopBasketService;
    private final ProductService productService;

    @GetMapping
    public ModelAndView index(){
        ModelAndView view = new ModelAndView("pages/basketitem/index");
        List<BasketItemsResponse> data = basketItemService.getAll();

        view.addObject("dataList", data);
        return view;
    }

    @GetMapping("/add")
    public ModelAndView add(){
        ModelAndView view = new ModelAndView("pages/basketitem/add");

        List<BasketItemsResponse> data = basketItemService.getAll();
        //---------------getAll data Customer------------//
        List<CustomerResponse> dataCus = this.customerService.getAll();
        view.addObject("dataCus", dataCus);
        //---------------------------//

        //---------------getAll data Shopping Basket------------//
        List<ShopBasketResponse> dataShop = this.shopBasketService.getAll();
        view.addObject("dataShop", dataShop);
        //---------------------------//

        //---------------getAll data Product------------//
        List<ProductResponse> dataProd = this.productService.getAll();
        view.addObject("dataProd", dataProd);
        //---------------------------//

        view.addObject("basketitm",data);
        return view;
    }

    @PostMapping("/save")
    public ModelAndView save(@ModelAttribute BasketItemsResponse request){
        if(request == null){
            return new ModelAndView("redirect:/basketitem");
        }
        if(request.getQuantity().isEmpty()){
            return new ModelAndView("redirect:/basketitem/add");
        }
        basketItemService.save(request);
        return new ModelAndView("redirect:/basketitem");
    }

    @GetMapping("/edit/{id}")
    public ModelAndView edit(@PathVariable("id")String id){
        ModelAndView view = new ModelAndView("pages/basketitem/edit");
        BasketItemsResponse response = this.basketItemService.getById(id).orElse(null);
        if(response == null){
            return new ModelAndView("redirect:/basketitem");
        }
        view.addObject("basketitem", response);
        //---------------getAll data Customer------------//
        List<CustomerResponse> dataCus = customerService.getAll();
        view.addObject("dataCus", dataCus);
        //---------------------------//

        //---------------getAll data Shopping Basket------------//
        List<ShopBasketResponse> dataShop = this.shopBasketService.getAll();
        view.addObject("dataShop", dataShop);
        //---------------------------//

        //---------------getAll data Product------------//
        List<ProductResponse> dataProd = this.productService.getAll();
        view.addObject("dataProd", dataProd);
        //---------------------------//

        return view;
    }

    @PostMapping("/update")
    public ModelAndView update(@ModelAttribute BasketItemsResponse request){
        basketItemService.update(request, request.getId());
        return new ModelAndView("redirect:/basketitem");
    }

    @GetMapping("/detail/{id}")
    public ModelAndView detail(@PathVariable("id")String id){
        ModelAndView view = new ModelAndView("pages/basketitem/detail");
        BasketItemsResponse basketitem = basketItemService.getById(id).orElse(null);
        if(basketitem == null){
            return new ModelAndView("redirect:/basketitem");
        }

        view.addObject("basketitem", basketitem );
        return view;
    }

    @GetMapping("/delete/{id}")
    public ModelAndView delete(@PathVariable("id")String id) {
        BasketItemsResponse response = basketItemService.getById(id).orElse(null);
        basketItemService.delete(id);

        return new ModelAndView("redirect:/basketitem");
    }
}
