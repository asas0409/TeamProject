package com.team.crud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.team.dao.BoardDAO;
import com.team.vo.BoardVO;
import com.team.crud.BoardService;
@Controller
public class BoardController {
   @Autowired
   BoardDAO boardDAO;
   BoardService boardService;
   @RequestMapping(value="/crud/list", method = RequestMethod.GET)
   public String boardlist(Model model) {
      model.addAttribute("list",boardDAO.getBoardList());
      return "list";
   }
   
   @RequestMapping(value="/crud/add", method = RequestMethod.GET)
   public String addPost() {
      return "addpostform";
   }
   
   
   @RequestMapping(value="/crud/addok", method = RequestMethod.POST)
   public String addPostOK(BoardVO vo) {
      int i = boardDAO.insertBoard(vo);
      if(i==0) System.out.println("데이터 추가 실패");
      else System.out.println("데이터 추가 성공!!!" + vo.getContent());
      return "redirect:list";
   }
   
   @RequestMapping(value="/crud/editform/{id}", method = RequestMethod.GET)
   public String editPost(@PathVariable("id") int id, Model model) {
      BoardVO boardVO = boardDAO.getBoard(id);
      model.addAttribute("boardVO",boardVO);
      return "editform";
   }
   
   @RequestMapping(value="/crud/editok", method = RequestMethod.GET)
   public String editPostOK(BoardVO vo) {
      int i = boardDAO.updateBoard(vo);
      if(i==0) System.out.println("데이터 수정 실패");
      else System.out.println("데이터 수정 성공!!!");
      return "redirect:list";
   }
   
   @RequestMapping(value="/crud/deletepost/{id}", method = RequestMethod.GET)
   public String deletePost(@PathVariable("id") int id, Model model) {
      int i = boardDAO.deleteBoard(id);
      if(i==0) System.out.println("데이터 삭제 실패");
      else System.out.println("데이터 삭제 성공!!!");
      return "redirect:../list";
   }

}