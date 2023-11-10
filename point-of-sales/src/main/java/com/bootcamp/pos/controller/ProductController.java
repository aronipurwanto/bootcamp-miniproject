package com.bootcamp.pos.controller;

import com.bootcamp.pos.model.response.ProductResponse;
import com.bootcamp.pos.model.response.RefAddressTypeResponse;
import com.bootcamp.pos.model.response.RefProductTypeResponse;
import com.bootcamp.pos.service.ProductService;
import com.bootcamp.pos.service.RefProductTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;
    private final RefProductTypeService refProductTypeService;
    @GetMapping
    public ModelAndView index(){
        ModelAndView view = new ModelAndView("pages/product/index");

        List<ProductResponse> data = productService.getAll();

        view.addObject("dataList", data);
        return view;

    }

    @GetMapping("/add")
    public ModelAndView add(){
        ModelAndView view = new ModelAndView("pages/product/add");

        List<ProductResponse> data = productService.getAll();
        view.addObject("product",data);

        //---------------getAll data Ref Product------------//
        List<RefProductTypeResponse> refproduct = refProductTypeService.getAll();
        view.addObject("dataref",refproduct);
        //--------------------------//

        return view;
    }
    @PostMapping("/save")
    public ModelAndView save(@ModelAttribute ProductResponse request){
        if(request == null){
            return new ModelAndView("redirect:/product");
        }
        if(request.getDetails().isEmpty()){
            return new ModelAndView("redirect:/product/add");
        }
        productService.save(request);
        return new ModelAndView("redirect:/product");
    }

    @GetMapping("/edit/{id}")
    public ModelAndView edit(@PathVariable("id")String id){
        ModelAndView view = new ModelAndView("pages/product/edit");
        ProductResponse response = this.productService.getById(id).orElse(null);
        if(response == null){
            return new ModelAndView("redirect:/product");
        }

        view.addObject("product", response);

        //---------------getAll data Ref Product------------//
        List<RefProductTypeResponse> refproduct = refProductTypeService.getAll();
        view.addObject("dataref",refproduct);
        //--------------------------//
        
        return view;
    }
    @PostMapping("/update")
    public ModelAndView update(@ModelAttribute ProductResponse request){
        productService.update(request, request.getId());
        return new ModelAndView("redirect:/product");
    }

    @GetMapping("/delete/{id}")
    public ModelAndView delete(@ModelAttribute ProductResponse request) {
        Optional<ProductResponse> response = productService.getById(request.getId());
        if (response == null) {
            return new ModelAndView("redirect:/product");
        }
        productService.delete(request.getId());
        return new ModelAndView("redirect:/product");
    }
    @GetMapping("/detail/{id}")
    public ModelAndView detail(@PathVariable("id")String id){
        ModelAndView view = new ModelAndView("pages/product/detail");
        ProductResponse data = productService.getById(id).orElse(null);
        if(data == null){
            return new ModelAndView("redirect:/product");
        }

        view.addObject("product", data );
        return view;
    }
}
