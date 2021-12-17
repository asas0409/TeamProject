package com.team.crud;

import java.util.List;

import com.team.vo.BoardVO;

public interface BoardService {
	public int insertBoard(BoardVO vo);
	public int deleteBoard(int seq);
	public int updateBoard(BoardVO vo);
	public BoardVO getBoard(int seq);
	public List<BoardVO> getBoardList();
	public List<BoardVO> getSearchList(String name);
}
