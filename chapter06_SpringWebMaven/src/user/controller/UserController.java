package user.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import user.bean.UserDTO;
import user.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserService userService;

	@RequestMapping(value = "/writeForm", method = RequestMethod.GET)
	public String writeForm() {
		return "/user/writeForm";
	}

	@RequestMapping(value = "/write", method = RequestMethod.POST)
	@ResponseBody
//	메소드에 @ResponseBody 로 어노테이션이 되어 있다면 메소드에서 리턴되는 값은 View 를 통해서 
//	출력되지 않고 HTTP Response Body 에 직접 쓰여지게 된다.
	public void write(@ModelAttribute UserDTO userDTO) {
		userService.write(userDTO);
	}

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String list() {
		return "/user/list";
	}

//	@RequestMapping(value="/getUserList", method=RequestMethod.POST)
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

//	@RequestMapping(value="/getUserList", method=RequestMethod.POST)
//	@ResponseBody
//	public Map getUserList() {
//		List<UserDTO> list = userService.getUserList();
//		
//		JSONArray array = JSONArray.fromObject(list);
//		Map map = new HashMap();
//		map.put("list", array);
//		return map;
//	}

	@RequestMapping(value = "/getUserList", method = RequestMethod.POST)
	@ResponseBody
	public ModelAndView getUserList() {
		List<UserDTO> list = userService.getUserList();
		System.out.println(list);

		ModelAndView mav = new ModelAndView();
		mav.addObject("list", list);
		mav.setViewName("jsonView");
		return mav;
	}

	@RequestMapping(value = "/checkId", method = RequestMethod.POST)
	@ResponseBody
	public String checkId(@RequestParam String id) {
		UserDTO userDTO = userService.checkId(id);
		System.out.println(userDTO);
		if (userDTO == null) {
			return "non_exist";
		} else {
			return "exist";
		}
	}

	@RequestMapping(value = "/modifyForm", method = RequestMethod.GET)
	public String modifyForm() {
		return "/user/modifyForm";
	}

	@RequestMapping(value = "/getUser", method = RequestMethod.POST)
	@ResponseBody
	public JSONObject getUser(@RequestParam String id) {
		UserDTO userDTO = userService.getUser(id);

		JSONObject json = new JSONObject();

		if (userDTO != null) {
			json.put("name", userDTO.getName());
			json.put("id", userDTO.getId());
			json.put("pwd", userDTO.getPwd());
		}
		return json;
	}
	
	@RequestMapping(value = "/modify", method = RequestMethod.POST)
	@ResponseBody
	public void modify(@ModelAttribute UserDTO userDTO) {
		userService.modify(userDTO);
	}
	
	@RequestMapping(value = "/deleteForm", method = RequestMethod.GET)
	public String deleteForm() {
		return "/user/deleteForm";
	}
	
	@RequestMapping(value = "/delete", method=RequestMethod.POST)
	@ResponseBody
	public String delete(@RequestParam String id) {
		
		int num = userService.delete(id);
		if(num < 1) {
			return "non_exist";
		} else {
			return "exist";
		}
		
	}
}
