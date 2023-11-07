package com.bootcamp.pos.controller;

import com.bootcamp.pos.model.entity.InventoryLocationEntity;
import com.bootcamp.pos.model.response.InventoryLocationResponse;
import com.bootcamp.pos.service.InventoryLocationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/inlocal")
@RequiredArgsConstructor
public class InventoryLocationController {
    private final InventoryLocationService inventoryLocationService;

    @GetMapping
    public ModelAndView index() {
        ModelAndView view = new ModelAndView("pages/inlocal/index");

        List<InventoryLocationResponse> data = inventoryLocationService.getAll();

        view.addObject("dataList", data);
        return view;
    }

    @GetMapping("/add")
    public ModelAndView add() {
        ModelAndView view = new ModelAndView("pages/inlocal/add");

        List<InventoryLocationResponse> data = inventoryLocationService.getAll();

        view.addObject("dataList", data);
        return view;
    }

    @PostMapping("/save")
    public ModelAndView save(@ModelAttribute InventoryLocationResponse request) {
        if (request == null) {
            return new ModelAndView("redirect:/inlocal");
        }
        inventoryLocationService.save(request);
        return new ModelAndView("redirect:/inlocal");
    }

    @GetMapping("/edit/{id}")
    public ModelAndView edit(@PathVariable("id") String id) {
        ModelAndView view = new ModelAndView("pages/inlocal/edit");
        InventoryLocationResponse data = inventoryLocationService.getById(id).orElse(null);
        if (data == null) {
            return new ModelAndView("redirect:/inlocal");
        }
        view.addObject("data", data);
        return view;
    }

    @PostMapping("/update")
    public ModelAndView update(@ModelAttribute InventoryLocationResponse request) {
        inventoryLocationService.update(request, request.getLocationId());
        return new ModelAndView("redirect:/inlocal");
    }

    @GetMapping("/detail/{id}")
    public ModelAndView detail(@PathVariable("id") String id) {
        ModelAndView view = new ModelAndView("pages/inlocal/detail");
        InventoryLocationResponse response = inventoryLocationService.getById(id).orElse(null);
        if (response == null) {
            return new ModelAndView("redirect:/inlocal");
        }
        view.addObject("data", response);
        return view;
    }

    @GetMapping("/delete/{id}")
    public ModelAndView delete(@PathVariable("id") String id){
        InventoryLocationResponse response = this.inventoryLocationService.getById(id).orElse(null);
        inventoryLocationService.delete(id);

        return new ModelAndView("redirect:/inlocal");

    }
}
