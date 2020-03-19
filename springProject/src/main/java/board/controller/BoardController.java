package board.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import board.bean.BoardDTO;
import board.bean.BoardPaging;
import board.service.BoardService;

@Controller
@RequestMapping(value="/board")
public class BoardController {

	@Autowired
	private BoardService boardService;
	
	@RequestMapping(value="/boardWriteForm", method=RequestMethod.GET)
	public String boardWriteForm(Model model) {
		model.addAttribute("display", "/board/boardWriteForm.jsp");
		return "/main/index";
	}
	
	@RequestMapping(value="/boardWrite", method=RequestMethod.POST)
	public String boardWrite(@RequestParam Map<String, String> map, Model model) {		
		
		boardService.boardWrite(map);
		
		model.addAttribute("display", "/board/boardWrite.jsp");
		return "/main/index";
	}
	
	@RequestMapping(value="/boardList", method=RequestMethod.GET)
	public String boardList(@RequestParam (required=false, defaultValue = "1") String pg, Model model) {
		//error 400: 매개변수를 제대로 주지않았다
		model.addAttribute("pg", pg);
		model.addAttribute("display", "/board/boardList.jsp");
		
		return "/main/index";
	}
	
	@RequestMapping(value="/getBoardList", method=RequestMethod.POST)
	public ModelAndView getBoardList (@RequestParam (required=false, defaultValue = "1") String pg, Model model, HttpSession session) {
		List<BoardDTO> list = boardService.getBoardList(pg);
		//페이징 처리
		BoardPaging boardPaging = boardService.boardPaging(pg);
			
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("list", list);
		mav.addObject("memId", session.getAttribute("memId"));
		mav.addObject("pg", pg);
		mav.addObject("boardPaging", boardPaging);
		mav.setViewName("jsonView");
		return mav;
	}
	
	@RequestMapping(value= "boardView", method=RequestMethod.GET)
	public String boardView(@RequestParam String seq, String pg, Model model) {
		model.addAttribute("seq", seq);
		model.addAttribute("pg", pg);
		model.addAttribute("display", "/board/boardView.jsp");
		return "/main/index";
	}
	
	@RequestMapping(value="getBoard", method=RequestMethod.POST)
	public ModelAndView getBoard(@RequestParam String seq, @RequestParam(required = false, defaultValue="1") String pg, HttpSession session) {
		
		BoardDTO boardDTO = boardService.getBoard(seq);
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("boardDTO", boardDTO);
		mav.addObject("memId", session.getAttribute("memId"));
		mav.setViewName("jsonView");
		return mav;
	}
	
//	답글 - 항상 원글의 번호를 가지고 원글의 페이지번호로 돌아가야함. 
	@RequestMapping(value ="boardReplyForm", method=RequestMethod.POST)
	public String boardReplyForm(@RequestParam String seq, 
								 @RequestParam String pg,
								 Model model) {
		
		model.addAttribute("pseq", seq); //원글번호
		model.addAttribute("pg", pg); //페이지번호
		model.addAttribute("display", "/board/boardReplyForm.jsp");
		
		return "/main/index";
	}
	
	@RequestMapping(value ="boardReply", method=RequestMethod.POST)
	public String boardReply(@RequestParam Map<String, String> map, Model model) {
		
		boardService.boardReply(map);
		
		model.addAttribute("pg", map.get("pg"));
		model.addAttribute("display", "/board/boardReplyForm.jsp");
		
		return "/main/index";
	}

}
