package com.team.crud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team.dao.UserDAO;
import com.team.vo.UserVO;

@Service
public class UserServiceImpl {
	@Autowired
	UserDAO userDAO;

	public UserVO getUser(UserVO vo) {
		return userDAO.getUser(vo);
	}
}