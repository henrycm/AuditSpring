package com.auditing.view;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.auditing.backend.model.User;
import com.auditing.backend.service.UserService;

@Controller
public class UserController {

	@Resource
	UserService uservice;

	@RequestMapping(value = "/")
	public String init() {
		return "redirect:list";
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(final User user, BindingResult result, ModelMap model) {
		uservice.save(user);
		return "redirect:list";
	}

	@RequestMapping(value = "/list")
	public String list(ModelMap model) {
		model.addAttribute("users", uservice.list());
		model.addAttribute("user", new User());
		return "user";
	}
}
