package user.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import user.bean.UserDTO;
import user.service.UserService;

@Controller
public class UserController {
	@Autowired
	private UserService userService;
	
	@RequestMapping(value="/user/writeForm", method=RequestMethod.GET)
	public String writeForm() {
		return "/user/writeForm";
	}
	
	@RequestMapping(value="/user/write", method=RequestMethod.POST)
	@ResponseBody
//	메소드에 @ResponseBody 로 어노테이션이 되어 있다면 메소드에서 리턴되는 값은 View 를 통해서 
//	출력되지 않고 HTTP Response Body 에 직접 쓰여지게 된다.
	public void write(@ModelAttribute UserDTO userDTO) {
		userService.write(userDTO);
	}
	
	@RequestMapping(value="/user/list", method=RequestMethod.GET)
	public String list() {
		return "/user/list";
	}
	
//	@RequestMapping(value="/user/getUserList", method=RequestMethod.POST)
//	@ResponseBody
//	public JSONObject getUserList() {
//		List<UserDTO> list = userService.getUserList();
//		JSONObject json = new JSONObject();
//		
//		if(list!=null) {
//			JSONArray array = new JSONArray();
//			JSONObject temp = new JSONObject();
//			
//			for(UserDTO userDTO : list) {
//				temp.put("name", userDTO.getName());
//				temp.put("id", userDTO.getId());
//				temp.put("pwd", userDTO.getPwd());
//				
//				array.add(0, temp);
//				json.put("list", array);
//			}//for
//		}
//		
//		return json;
//	}
	
//	@RequestMapping(value="/user/getUserList", method=RequestMethod.POST)
//	@ResponseBody
//	public Map getUserList() {
//		List<UserDTO> list = userService.getUserList();
//		
//		JSONArray array = JSONArray.fromObject(list);
//		Map map = new HashMap();
//		map.put("list", array);
//		return map;
//	} //이건됨
	
	@RequestMapping(value="/user/getUserList", method=RequestMethod.POST)
	@ResponseBody
	public ModelAndView getUserList() {
		List<UserDTO> list = userService.getUserList();
		System.out.println(list);
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("list", list);
		mav.setViewName("jsonView");
		return mav;
	}
} 
