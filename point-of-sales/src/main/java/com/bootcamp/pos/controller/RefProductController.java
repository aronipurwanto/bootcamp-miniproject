package com.bootcamp.pos.controller;

import com.bootcamp.pos.model.request.RefProductRequest;
import com.bootcamp.pos.service.RefProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/refProduct")
public class RefProductController {
    private final RefProductService refProductService;

    @GetMapping
    public ModelAndView index(){
        ModelAndView view = new ModelAndView("pages/refProduct/index");
        List<RefProductRequest> refProduct = refProductService.getAll();

        view.addObject("refProduct", refProduct);
        return view;
    }

    @GetMapping("/add")
    public ModelAndView add(){
        ModelAndView view = new ModelAndView("pages/refProduct/add");
        return view;
    }

    @PostMapping("/save")
    public ModelAndView save(@ModelAttribute RefProductRequest request){
        if (request == null){
            return new ModelAndView("redirect:/refProduct/add");
        }

        if (request.getDesc().isEmpty()){
            return new ModelAndView("redirect:/refProduct/add");
        }
        refProductService.save(request);
        return new ModelAndView("redirect:/refProduct");
    }

    @GetMapping("/edit/{id}")
    public ModelAndView edit(@PathVariable("id") String id){
        ModelAndView view = new ModelAndView("pages/refProduct/edit");
        RefProductRequest request = refProductService.getById(id);
        if (request == null){
            return new ModelAndView("redirect:/refProduct");
        }

        view.addObject("refProduct", request);
        return view;
    }

    @PostMapping("/update")
    public ModelAndView update(@ModelAttribute RefProductRequest request){
        refProductService.update(request, request.getId());
        return new ModelAndView("redirect:/refProduct");
    }

    @GetMapping("/delete/{id}")
    public ModelAndView delete(@PathVariable("id") String id){
        refProductService.delete(id);
        return new ModelAndView("redirect:/refProduct");
    }

    @GetMapping("/detail/{id}")
    public ModelAndView detail(@PathVariable("id") String id){
        ModelAndView view = new ModelAndView("pages/refProduct/detail");
        RefProductRequest request = refProductService.getById(id);
        if (request == null){
            return new ModelAndView("redirect:/refProduct");
        }

        view.addObject("refProduct", request);
        return view;
    }
}
