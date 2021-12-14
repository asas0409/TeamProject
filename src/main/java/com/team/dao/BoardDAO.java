package com.team.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.team.vo.BoardVO;

public class BoardDAO {
	
	private JdbcTemplate template;
	
	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}

	private final String BOARD_INSERT = "insert into restaurant (category, writer, visitdate, score, content, pw, name) values (?,?,?,?,?,?,?)";
	private final String BOARD_UPDATE = "update restaurant set category=?, writer=?, visitdate=?, score=?, content=?, name=? where id=?";
	private final String BOARD_DELETE = "delete from restaurant  where id=?";
	private final String BOARD_GET = "select * from restaurant  where id=?";
	private final String BOARD_LIST = "select * from restaurant order by id desc";
	private final String BOARD_SEARCH = "select * from restaurant where name=? order by id desc";

	public int insertBoard(BoardVO vo) {
		return template.update(BOARD_INSERT,new
				Object[] {vo.getCategory(),vo.getWriter(),vo.getVisitdate(),vo.getScore(),vo.getContent(),vo.getPw(),vo.getName()});
	}

	public int deleteBoard(int id) {
		return template.update(BOARD_DELETE,
				new Object[]{id});
	}
	public int updateBoard(BoardVO vo) {
		return template.update(BOARD_UPDATE,
				new Object[]{vo.getCategory(),vo.getWriter(),vo.getVisitdate(),vo.getScore(),vo.getContent(),vo.getName(),vo.getId()});
	}	
	
	public BoardVO getBoard(int seq) {
		return template.queryForObject(BOARD_GET,
				new Object[] {seq},
				new BeanPropertyRowMapper<BoardVO>(BoardVO.class));
	}
	
	public List<BoardVO> getBoardList(){
		return template.query(BOARD_LIST, new RowMapper<BoardVO>() {
			@Override
			public BoardVO mapRow(ResultSet rs, int rowNum) throws SQLException{
				BoardVO data = new BoardVO();
				data.setId(rs.getInt("id"));
				data.setCategory(rs.getString("category"));
				data.setName(rs.getString("name"));
				data.setWriter(rs.getString("writer"));
				data.setWritedate(rs.getDate("writedate"));
				data.setVisitdate(rs.getString("visitdate"));
				data.setScore(rs.getInt("score"));
				data.setContent(rs.getString("content"));
				data.setPw(rs.getString("pw"));
				return data;
			}
		});
	}
	
	public List<BoardVO> getSearchList(String name){
		return template.query(BOARD_SEARCH, new RowMapper<BoardVO>() {
			@Override
			public BoardVO mapRow(ResultSet rs, int rowNum) throws SQLException{
				BoardVO data = new BoardVO();
				data.setId(rs.getInt("id"));
				data.setCategory(rs.getString("category"));
				data.setName(rs.getString("name"));
				data.setWriter(rs.getString("writer"));
				data.setWritedate(rs.getDate("writedate"));
				data.setVisitdate(rs.getString("visitdate"));
				data.setScore(rs.getInt("score"));
				data.setContent(rs.getString("content"));
				data.setPw(rs.getString("pw"));
				return data;
			}
		},name);
	}
}
