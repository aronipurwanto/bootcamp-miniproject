package com.bootcamp.pos.controller;

import com.bootcamp.pos.model.request.AddressRequest;
import com.bootcamp.pos.model.request.RefPaymentMethodsRequest;
import com.bootcamp.pos.service.RefPaymentMethodsService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/refPaymentMethods")
public class RefPaymentMethodsController {
    private final RefPaymentMethodsService refPaymentMethodsService;

    public RefPaymentMethodsController(RefPaymentMethodsService refPaymentMethodsService) {
        this.refPaymentMethodsService = refPaymentMethodsService;
    }

    @GetMapping
    public ModelAndView index() {
        ModelAndView view = new ModelAndView("pages/refPaymentMethods/index");
        List<RefPaymentMethodsRequest> data = refPaymentMethodsService.getAll();

        view.addObject("refPaymentMethodsList", data);
        return view;
    }

    @GetMapping("/add")
    public ModelAndView add() {
        ModelAndView view = new ModelAndView("pages/refPaymentMethods/add");
        return view;
    }
    @PostMapping("/save")
    public ModelAndView save(@ModelAttribute RefPaymentMethodsRequest request) {
        if (request == null) {
            return new ModelAndView("redirect:/refPaymentMethods/add");
        }
        if (request.getPaymentMethodCode().isEmpty()){
            return new ModelAndView("redirect:/refPaymentMethods/add");
        }
        if (request.getPaymentMethodDescription().isEmpty()){
            return new ModelAndView("redirect:/refPaymentMethods/add");
        }
        //call save from service
        this.refPaymentMethodsService.save(request);
        //redirect to index
        return new ModelAndView("redirect:/refPaymentMethods");
    }
    @GetMapping("/edit/{id}")
    public ModelAndView edit(@PathVariable("id") String id) {
        ModelAndView view = new ModelAndView("pages/refPaymentMethods/edit");
        RefPaymentMethodsRequest refPaymentMethodsRequest = this.refPaymentMethodsService.getById(id);
        if (refPaymentMethodsRequest == null) {
            return new ModelAndView("redirect:/edit");
        }

        view.addObject("refPaymentMethods", refPaymentMethodsRequest);
        return view;
    }
    @PostMapping("/update")
    public ModelAndView update(@ModelAttribute RefPaymentMethodsRequest request) {
        if (request == null) {
            return new ModelAndView("redirect:/refPaymentMethods/edit" + request.getId());
        }
        if (request.getPaymentMethodCode().isEmpty()) {
            return new ModelAndView("redirect:/refPaymentMethods/edit" + request.getId());
        }
        if (request.getPaymentMethodDescription().isEmpty()) {
            return new ModelAndView("redirect:/refPaymentMethods/edit" + request.getId());
        }
        this.refPaymentMethodsService.update(request, request.getId());
        return new ModelAndView("redirect:/refPaymentMethods");
    }
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") String id) {
        this.refPaymentMethodsService.delete(id);
        return "redirect:/refPaymentMethods";
    }
    @GetMapping("/detail/{id}")
    public ModelAndView detail(@PathVariable("id") String id) {
        ModelAndView view = new ModelAndView("pages/refPaymentMethods/detail");
        //get data from service
        RefPaymentMethodsRequest refPaymentMethodsRequest = this.refPaymentMethodsService.getById(id);
        if (refPaymentMethodsRequest == null) {
            return new ModelAndView("redirect:/refPaymentMethods");
        }

        view.addObject("refPaymentMethods", refPaymentMethodsRequest);
        return view;
    }
}
