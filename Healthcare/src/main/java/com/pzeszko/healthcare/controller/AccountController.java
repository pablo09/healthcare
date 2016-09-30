package com.pzeszko.healthcare.controller;

import com.pzeszko.healthcare.model.CurrentUser;
import com.pzeszko.healthcare.service.CartService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

/**

 * Created by Pawel on 2016-09-18.
 */
@Controller()
@RequestMapping("/account")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class AccountController {

    private final CartService cartService;

    @RequestMapping(method = RequestMethod.GET, value = "/")
    public String account(Model model, @AuthenticationPrincipal CurrentUser user) {
        if(user != null) {
            model.addAttribute("username", user.getUsername());
            return "account/account";
        }

        else return "redirect:/account/login";
    }
    @RequestMapping(method = RequestMethod.GET, value = "/login")
    public ModelAndView account(@RequestParam Optional<String> error) {
        return new ModelAndView("account/signForm", "error", error);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/cart")
    public String cart(Model model, @AuthenticationPrincipal CurrentUser loggedUser) {
        model.addAttribute("items", cartService.getOrders(loggedUser.getUser()));
        return "account/cart";
    }
}
