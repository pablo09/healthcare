package com.pzeszko.healthcare.controller;

import com.pzeszko.healthcare.dto.MedicineOrderDto;
import com.pzeszko.healthcare.model.CurrentUser;
import com.pzeszko.healthcare.service.CartService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Pawel on 2016-09-22.
 */
@RestController
@RequestMapping("/api/cart")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class CartController {

    private CartService cartService;

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity addToCart(@AuthenticationPrincipal CurrentUser loggedUser, MedicineOrderDto dto) {
        cartService.addToCart(loggedUser.getUser(), dto);
        return ResponseEntity.ok().build();
    };

}
