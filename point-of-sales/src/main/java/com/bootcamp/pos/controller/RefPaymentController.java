package com.bootcamp.pos.controller;

import com.bootcamp.pos.model.request.RefPaymentRequest;
import com.bootcamp.pos.service.RefPaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/refPayment")
public class RefPaymentController {
    private final RefPaymentService refPaymentService;

    @GetMapping
    public ModelAndView index(){
        ModelAndView view = new ModelAndView("pages/refPayment/index");
        List<RefPaymentRequest> requests = refPaymentService.getAll();

        view.addObject("dataRefPayment", requests);
        return view;
    }

    @GetMapping("/add")
    public ModelAndView add(){
        ModelAndView view = new ModelAndView("pages/refPayment/add");
        return view;
    }

    @PostMapping("/save")
    public ModelAndView save(@ModelAttribute RefPaymentRequest request){
        if (request == null){
            return new ModelAndView("redirect:/refPayment/add");
        }

        if (request.getDesc().isEmpty()){
            return new ModelAndView("redirect:/refPayment/add");
        }
        refPaymentService.save(request);
        return new ModelAndView("redirect:/refPayment");
    }

    @GetMapping("/edit/{id}")
    public ModelAndView edit(@PathVariable("id") String id){
        ModelAndView view = new ModelAndView("pages/refPayment/edit");
        RefPaymentRequest request = refPaymentService.getById(id);
        if (request == null){
            return new ModelAndView("redirect:/refPayment");
        }

        view.addObject("editRefPayment", request);
        return view;
    }

    @PostMapping("/update")
    public ModelAndView update(@ModelAttribute RefPaymentRequest request){
        refPaymentService.update(request, request.getId());
        return new ModelAndView("redirect:/refPayment");
    }

    @GetMapping("/delete/{id}")
    public ModelAndView delete(@PathVariable("id") String id){
        refPaymentService.delete(id);
        return new ModelAndView("redirect:/refPayment");
    }

    @GetMapping("/detail/{id}")
    public ModelAndView detail(@PathVariable("id") String id) {
        ModelAndView view = new ModelAndView("pages/refPayment/detail");
        RefPaymentRequest request = refPaymentService.getById(id);
        if (request == null) {
            return new ModelAndView("redirect:/refPayment");
        }

        view.addObject("detailRefPayment", request);
        return view;
    }
}
