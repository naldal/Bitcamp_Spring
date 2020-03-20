package board.service;

import java.util.List;
import java.util.Map;

import board.bean.BoardDTO;
import board.bean.BoardPaging;

public interface BoardService {

	public void boardWrite(Map<String, String> map);

	public List<BoardDTO> getBoardList(String pg);

	public BoardPaging boardPaging(String pg);
	public BoardPaging boardPaging(Map<String, String> map);

	public BoardDTO getBoard(String seq);

	public void boardReply(Map<String, String> map);

	public List<BoardDTO> getBoardSearch(Map<String, String> map);


}
