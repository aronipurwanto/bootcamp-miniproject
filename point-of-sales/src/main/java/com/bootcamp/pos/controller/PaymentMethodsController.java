package com.bootcamp.pos.controller;

import com.bootcamp.pos.model.request.PaymentMethodsModel;
import com.bootcamp.pos.service.PaymentMethodsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/payment-methods")
public class PaymentMethodsController {
    private final PaymentMethodsService paymentMethodsService;

    @GetMapping
    public ModelAndView index(){
        ModelAndView view = new ModelAndView("pages/payment-methods/index");
        List<PaymentMethodsModel> data  = this.paymentMethodsService.getAll();
        view.addObject("listDataPaymentMethods", data);

        return view;
    }

    @GetMapping("/add")
    public ModelAndView add(){
        ModelAndView view = new ModelAndView("pages/payment-methods/add");
        return view;
    }

    @PostMapping("/save")
    public ModelAndView save(@ModelAttribute PaymentMethodsModel request){
        // validasi
        if (request == null){
            return new ModelAndView("redirect:/payment-methods/add");
        }
        if (request.getPaymentCode().isEmpty()){
            return new ModelAndView("redirect:/payment-methods/add");
        }
        if (request.getCreditCardName().isEmpty()){
            return new ModelAndView("redirect:/payment-methods/add");
        }
        if (request.getPaymentDesc().isEmpty()){
            return new ModelAndView("redirect:/payment-methods/add");
        }
        // call save dari service
        this.paymentMethodsService.save(request);
        // kirim ke index
        return new ModelAndView("redirect:/payment-methods");
    }

    @GetMapping("/edit/{id}")
    public ModelAndView edit(@PathVariable("id") String id){
        ModelAndView view = new ModelAndView("pages/payment-methods/edit");
        PaymentMethodsModel data = this.paymentMethodsService.getById(id).orElse(null);
        if (data == null){
            return new ModelAndView("redirect:/payment-methods");
        }
        // data kirim ke view
        view.addObject("dataPayment", data);
        return view;
    }

    @PostMapping("/update")
    public ModelAndView update(@ModelAttribute PaymentMethodsModel request){
        if (request == null){
            return new ModelAndView("redirect:/payment-methods/edit/"+ request.getId());
        }
        if (request.getPaymentCode().isEmpty()){
            return new ModelAndView("redirect:/payment-methods/edit/"+ request.getId());
        }
        if (request.getCreditCardName().isEmpty()){
            return new ModelAndView("redirect:/payment-methods/edit/" + request.getId());
        }
        if (request.getPaymentDesc().isEmpty()){
            return new ModelAndView("redirect:/payment-methods/edit/" + request.getId());
        }
        // memanggil save dari service
        this.paymentMethodsService.update(request, request.getId());
        // redirect ke index
        return new ModelAndView("redirect:/payment-methods");
    }

    @GetMapping("/detail/{id}")
    public ModelAndView detail(@PathVariable("id") String id){
        ModelAndView view = new ModelAndView("pages/payment-methods/detail");
        // ambil data dari service
        PaymentMethodsModel data = this.paymentMethodsService.getById(id).orElse(null);
        if ( data == null){
            return new ModelAndView("redirect:/payment-methods");
        }

        // kirim data to view
        view.addObject("dataPayment", data);
        return view;
    }

    @GetMapping("/delete/{id}")
    public ModelAndView delete(@PathVariable("id") String id){
        // ambil data dari servie
        this.paymentMethodsService.delete(id);
        // kirim data ke view
        return new ModelAndView("redirect:/payment-methods");
    }
}
