package com.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.common.ConnectionUtil;
import com.domain.BoardVO;
import com.domain.Category;
import com.domain.MemberVO;


public class EduDao {

	private DataSource dataSource;
	
	public EduDao() {
		dataSource = ConnectionUtil.getDataSource();
	}

	public List<Category> subList() {
		String query = "select * from subject_score";
		List<Category> cateList = new ArrayList<Category>();
		try (
				Connection conn = dataSource.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(query);
				ResultSet rs = pstmt.executeQuery();
				){
				while(rs.next()) {
					Category vo = Category.builder()
							.mno(rs.getInt("mno"))
							.subject(rs.getString("subject"))
							.scoreRank(rs.getString("scoreRank"))
							.build();
					cateList.add(vo);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			return cateList;
	}	
}

	
	





