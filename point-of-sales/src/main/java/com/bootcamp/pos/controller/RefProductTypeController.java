package com.bootcamp.pos.controller;

import com.bootcamp.pos.model.response.RefProductTypeResponse;
import com.bootcamp.pos.service.RefProductTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/refproduct")
public class RefProductTypeController {
    private final RefProductTypeService refProductTypeService;

    @GetMapping
    public ModelAndView index(){
        ModelAndView view = new ModelAndView("pages/refproduct/index");
        List<RefProductTypeResponse> data = refProductTypeService.getAll();

        view.addObject("dataList", data);
        return view;
    }
    @GetMapping("/add")
    public ModelAndView add(){
        ModelAndView view = new ModelAndView("pages/refproduct/add");

        List<RefProductTypeResponse> data = refProductTypeService.getAll();

        view.addObject("refproduct",data);
        return view;
    }

    @PostMapping("/save")
    public ModelAndView save(@ModelAttribute RefProductTypeResponse request){
        if(request == null){
            return new ModelAndView("redirect:/refproduct");
        }
        refProductTypeService.save(request);
        return new ModelAndView("redirect:/refproduct");
    }

    @GetMapping("/edit/{id}")
    public ModelAndView edit(@PathVariable("id")String id){
        ModelAndView view = new ModelAndView("pages/refproduct/edit");
        RefProductTypeResponse response = this.refProductTypeService.getById(id).orElse(null);
        if(response == null){
            return new ModelAndView("redirect:/refproduct");
        }
        view.addObject("refproduct", response);
        return view;
    }
    @PostMapping("/update")
    public ModelAndView update(@ModelAttribute RefProductTypeResponse request){
        refProductTypeService.update(request, request.getId());
        return new ModelAndView("redirect:/refproduct");
    }

    @GetMapping("/delete/{id}")
    public ModelAndView delete(@PathVariable("id")String id){
        RefProductTypeResponse response = refProductTypeService.getById(id).orElse(null);
        refProductTypeService.delete(id);

        return new ModelAndView("redirect:/refproduct");
    }

    @GetMapping("/detail/{id}")
    public ModelAndView detail(@PathVariable("id")String id){
        ModelAndView view = new ModelAndView("pages/refproduct/detail");
        RefProductTypeResponse response = refProductTypeService.getById(id).orElse(null);
        if(response == null){
            return new ModelAndView("redirect:/refproduct");
        }
        view.addObject("detail",response);
        return view;
    }
}


