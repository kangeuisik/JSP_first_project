package com.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.common.ConnectionUtil;
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
	//결과처리
	public void eduResultList(List<MemberVO> vo, Category cateList) {
		String query = "select m.mno, m.platoon, m.mrank, m.name, s.subject, s.scoreRank";
				query+= "from Mt_member m ";
				query+= "inner join subject_score s on s.subject = m.subject";
				query+= "inner join subject_score s on s.scoreRank = m.scoreRank";
				
				try (
					Connection conn = dataSource.getConnection();
					PreparedStatement pstmt = conn.prepareStatement(query);
					){
//						pstmt.setInt(1, vo);
//						pstmt.setString(2, );
						pstmt.executeUpdate();
					} catch (Exception e) {
						e.printStackTrace();
					}
	}
	
	

}



