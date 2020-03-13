package main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import user.service.UserService;

@Controller
public class IndexController {
	
	@RequestMapping(value="/main/index", method=RequestMethod.GET)
	public String index() {
		return "/main/index";
	}
}
