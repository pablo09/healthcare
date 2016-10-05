package com.pzeszko.healthcare.controller;

import com.pzeszko.healthcare.dto.MedicineOrderDto;
import com.pzeszko.healthcare.model.CurrentUser;
import com.pzeszko.healthcare.service.CartService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;

import static org.springframework.http.ResponseEntity.ok;

/**
 * Created by Pawel on 2016-09-22.
 */
@Controller
@RequestMapping("/cart")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class CartController {

    private CartService cartService;

    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity addToCart(@AuthenticationPrincipal CurrentUser loggedUser, @Valid MedicineOrderDto dto) {
        cartService.addToCart(loggedUser.getUser(), dto);
        return ok().build();
    };

    @RequestMapping(method = RequestMethod.POST, value = "/finalize", params = "page")
    public String finalize(Model model, @AuthenticationPrincipal CurrentUser loggedUser, Pageable pageable) {
        cartService.finalizeOrder(loggedUser.getUser());
        model.addAttribute("history", cartService.getOrderHistory(loggedUser.getUser(), pageable));
        return "account/order_history";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/history", params = "page")
    public String history(Model model, @AuthenticationPrincipal CurrentUser loggedUser, Pageable pageable) {
        model.addAttribute("history", cartService.getOrderHistory(loggedUser.getUser(), pageable));
        return "account/order_history";
    }

}
