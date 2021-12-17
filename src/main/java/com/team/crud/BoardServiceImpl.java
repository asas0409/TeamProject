package com.team.crud;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.team.dao.BoardDAO;
import com.team.vo.BoardVO;

@Service
public class BoardServiceImpl implements BoardService{
	  @Autowired
	   BoardDAO boardDAO;
	  
	  @Override
	  public int insertBoard(BoardVO vo) {
		  return boardDAO.insertBoard(vo);
	  }
	  
	  @Override
	  public BoardVO getBoard(int seq) {
			return boardDAO.getBoard(seq);
		}
	  
	  @Override
	  public List<BoardVO> getBoardList(){
			return boardDAO.getBoardList();
		}
	  
	  @Override
	  public List<BoardVO> getSearchList(String name){
			return boardDAO.getSearchList(name);
	  }

	@Override
	public int deleteBoard(int seq) {
		return boardDAO.deleteBoard(seq);
	}

	@Override
	public int updateBoard(BoardVO vo) {
		return boardDAO.updateBoard(vo);
	}

}
