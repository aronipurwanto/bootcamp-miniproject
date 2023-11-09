package com.bootcamp.pos.controller;

import com.bootcamp.pos.model.request.ProductTypeModel;
import com.bootcamp.pos.service.ProductTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/product-type")
public class ProductTypeController {
    private final ProductTypeService productTypeService;

    @GetMapping
    public ModelAndView index(){
        ModelAndView view = new ModelAndView("pages/product-type/index");
        List<ProductTypeModel> data = this.productTypeService.getAll();
        view.addObject("listDataProductType", data);

        return view;
    }

    @GetMapping("/add")
    public ModelAndView add(){
        ModelAndView view = new ModelAndView("pages/product-type/add");
        return view;
    }

    @PostMapping("/save")
    public ModelAndView save(@ModelAttribute ProductTypeModel request){
        if (request == null){
            return new ModelAndView("pages/product-type/add");
        }
        if (request.getProductTypeCode().isEmpty()){
            return new ModelAndView("pages/product-type/add");
        }
        if (request.getDescription().isEmpty()){
            return new ModelAndView("pages/product-type/add");
        }
        // call from service
        this.productTypeService.save(request);
        // send to view
        return new ModelAndView("redirect:/product-type");
    }

    @GetMapping("/edit/{id}")
    public ModelAndView edit(@PathVariable("id") String id){
        ModelAndView view = new ModelAndView("pages/product-type/edit");
        ProductTypeModel data = this.productTypeService.getById(id).orElse(null);
        if (data == null){
            return new ModelAndView("redirect:/product-type");
        }
        // data send to view
        view.addObject("dataProductType", data);
        return view;
    }

    @PostMapping("/update")
    public ModelAndView update(@ModelAttribute ProductTypeModel request){
        if (request == null){
            return new ModelAndView("pages/product-type/edit/"+ request.getId());
        }
        if (request.getProductTypeCode().isEmpty()){
            return new ModelAndView("pages/product-type/edit/"+ request.getId());
        }
        if (request.getDescription().isEmpty()){
            return new ModelAndView("pages/product-type/add/"+ request.getId());
        }
        // data call from service
        this.productTypeService.update(request, request.getId());
        // send to view
        return new ModelAndView("redirect:/product-type");
    }

    @GetMapping("/detail/{id}")
    public ModelAndView detail(@PathVariable("id") String id){
        ModelAndView view = new ModelAndView("pages/product-type/detail");
        ProductTypeModel data = this.productTypeService.getById(id).orElse(null);
        if (data == null){
            return new ModelAndView("redirect:/product-type");
        }

        view.addObject("dataProductType", data);
        return view;
    }

    @GetMapping("/delete/{id}")
    public ModelAndView delete(@PathVariable("id") String id){
        // take data from service
        this.productTypeService.delete(id);
        // send to view
        return new ModelAndView("redirect:/product-type");
    }
}
