package com.pzeszko.healthcare.controller;

import com.pzeszko.healthcare.service.MedicineService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Pawel on 2016-09-15.
 */
@Controller
@RequestMapping("/medicine")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class MedicineController {

    private final MedicineService medicineService;

    @RequestMapping(method = RequestMethod.GET, params = "page")
    public String medicines(Model model, Pageable pageable) {
        model.addAttribute("medicines", medicineService.findAll(pageable));
        return "medicines";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/details/{id:^[0-9]+$}")
    public String details(@PathVariable Long id, Model model) {
        model.addAttribute("item", medicineService.findById(id));
        return "medicineDetails";
    }
}
