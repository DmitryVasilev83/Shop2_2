package com.geekbrains.geekmarketwinter.controllers;

import com.geekbrains.geekmarketwinter.entities.Order;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.Objects;

@Controller
@RequestMapping("/paypal/buy")
public class PayPalController {

	//TODO сделать оплату
	@GetMapping
	public String pay(Model model, HttpServletRequest httpServletRequest) {
		Order order = (Order)model.getAttribute("order");
		order.getPhoneNumber();
		System.out.println("test order 3");
		System.out.println(order.getId());
		System.out.println("test order 4");
		return "redirect:/order/result/".concat(order.getId().toString());

	}

}
