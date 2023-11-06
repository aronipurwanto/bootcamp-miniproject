package com.bootcamp.pos.controller;

import com.bootcamp.pos.model.response.CustomerResponse;
import com.bootcamp.pos.model.response.RefPaymentResponse;
import com.bootcamp.pos.service.RefPaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
@RequestMapping("/payment")
public class PaymentController {
    private final RefPaymentService refPaymentService;

    @GetMapping
    public ModelAndView index(){
        ModelAndView view = new ModelAndView("pages/payment/index");

        List<RefPaymentResponse> data = refPaymentService.getAll();

        view.addObject("dataList", data);
        return view;
    }
    @GetMapping("/add")
    public ModelAndView add(){
        ModelAndView view = new ModelAndView("pages/payment/add");

        List<RefPaymentResponse> payment = refPaymentService.getAll();

        view.addObject("payment",payment);
        return view;
    }

    @PostMapping("/save")
    public ModelAndView save(@ModelAttribute RefPaymentResponse request){
        if(request == null){
            return new ModelAndView("redirect:/payment");
        }
        refPaymentService.save(request);
        return new ModelAndView("redirect:/payment");
    }

    @GetMapping("/edit/{id}")
    public ModelAndView edit(@PathVariable("id")String id){
        ModelAndView view = new ModelAndView("pages/payment/edit");
        RefPaymentResponse response = refPaymentService.getById(id).orElse(null);
        if(response == null){
            return new ModelAndView("redirect:/payment");
        }
        view.addObject("payment",response);
        return view;
    }

    @PostMapping("/update")
    public ModelAndView update(@ModelAttribute RefPaymentResponse request){
        refPaymentService.update(request, request.getId());
        return new ModelAndView("redirect:/payment");
    }

    @GetMapping("/delete/{id}")
    public ModelAndView delete(@ModelAttribute RefPaymentResponse request){
        Optional<RefPaymentResponse> response = refPaymentService.getById(request.getId());
        if(response == null){
            return new ModelAndView("redirect:/payment");
        }
        refPaymentService.delete(request.getId());
        return new ModelAndView("redirect:/payment");

    }

    @GetMapping("/detail/{id}")
    public ModelAndView detail(@PathVariable("id")String id){
        ModelAndView view = new ModelAndView("pages/payment/detail");
        RefPaymentResponse payment = refPaymentService.getById(id).orElse(null);
        if(payment == null){
            return new ModelAndView("redirect:/payment");
        }
        view.addObject("payment", payment);
        return view;
    }
}
