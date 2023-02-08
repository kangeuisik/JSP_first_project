package com.dao;


import java.sql.Array;
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
	//member의 mno받기
	public int getMno(int mno){
		int getMno = 0;
		String query = "select *from mt_member where mno = ?";
		try (
			Connection conn = dataSource.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(query);
			){
			pstmt.setInt(1, mno);
			try(
				ResultSet rs = pstmt.executeQuery();
				){
				if(rs.next()) {
					getMno= rs.getInt("mno");		
				}				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return getMno;
	}

	public void addResult(Category vo) {
		String query = "insert into subject_score(mno,subject,scoreRank) values (?,?,?)";
		try (
			Connection conn = dataSource.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(query);
			){
			pstmt.setInt(1, vo.getMno());
		}
	}






	


}
	





