package com.controller;

import java.util.Map; 

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.bean.SumDTO;

@Controller
public class SumController {

//	@RequestMapping(value="/input.do", method = RequestMethod.GET)
//	public ModelAndView input() {
//		ModelAndView mav = new ModelAndView();
//		mav.setViewName("/sum/input");
//		return mav;
//	}
	
	@RequestMapping(value="/input.do", method = RequestMethod.GET)
	//return이 String이면 단순 문자열이 아니라, view의 이름(jsp파일의 이름)으로 사용된다.
	//view 이름이 아니라 실제 문자열을 리턴하고 싶을때는 @ResponseBody를 사용한다.
 //@ResponseBody
	public String input() {
		return "/sum/input";
	}
	
	//----------------------------------------------------------------
	
//	@RequestMapping(value="/result.do", method = RequestMethod.GET)
//	public ModelAndView result() {
//		ModelAndView mav = new ModelAndView();
//		mav.setViewName("/sum/result");
//		return mav;
//	}
	
//	@RequestMapping(value="/result.do", method = RequestMethod.GET)
//	public ModelAndView result(@RequestParam int xVal, @RequestParam int yVal) { //이것의 변수명은 input의 name과 같아야한다. 
//		ModelAndView mav = new ModelAndView();
//		mav.addObject("xVal", xVal);
//		mav.addObject("yVal", yVal);
//		mav.setViewName("/sum/result");
//		return mav;
//	}
	
//	@RequestMapping(value="/result.do", method = RequestMethod.GET)
//	public ModelAndView result(@RequestParam(required=false, defaultValue = "0") String xVal, @RequestParam(required = false, defaultValue = "0") String yVal) {
//		ModelAndView mav = new ModelAndView();
//		mav.addObject("x", xVal);
//		mav.addObject("y", yVal);
//		mav.setViewName("/sum/result");
//		return mav;
//	}
	
//	@RequestMapping(value="/result.do", method = RequestMethod.GET)
//	public String result (@RequestParam Map<String, String> map, ModelMap modelMap) {
//		ModelAndView mav = new ModelAndView();
//		
//		modelMap.put("x", map.get("xVal"));
//		modelMap.put("y", map.get("yVal"));
//		
//		return "/sum/result";
//	}
	
	@RequestMapping(value="/result.do", method = RequestMethod.GET)
	public String result (@ModelAttribute SumDTO sumDTO, Model model) {
		model.addAttribute("sumDTO", sumDTO);
		return "/sum/result";
	}
	
}
