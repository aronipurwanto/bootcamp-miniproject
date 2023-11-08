package com.bootcamp.pos.controller;

import com.bootcamp.pos.model.request.BasketItemsRequest;
import com.bootcamp.pos.model.response.AddressesResponse;
import com.bootcamp.pos.model.response.BasketItemsResponse;
import com.bootcamp.pos.service.BasketItemService;
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

        view.addObject("basketitm",data);
        return view;
    }

    @PostMapping("/save")
    public ModelAndView save(@ModelAttribute BasketItemsResponse request){
        if(request == null){
            return new ModelAndView("redirect:/basketitem");
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
