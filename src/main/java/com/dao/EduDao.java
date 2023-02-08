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
import com.domain.RequestVO;


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
	//과목별 시험 점수 인서트
	public void addResult(Category vo) {
//		List<Category> cateList = new ArrayList<Category>();
		String query = "insert into subject_score(mno,subject,scoreRank) values (?,?,?)";
		try (
			Connection conn = dataSource.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(query);
			){
			pstmt.setInt(1, vo.getMno());
			pstmt.setString(2, vo.getSubject());
			pstmt.setString(3, vo.getScoreRank());
			pstmt.executeUpdate();
		} catch (Exception e) {
		e.printStackTrace();
	}
	 
}

	public List<MemberVO> testResult(int mno) {
		int getMno = getMno(mno);
		String query = "select m.mno, m.platoon, m.mrank, m.name,m.militaryNo, s.subject, s.scoreRank ";
				query+= "from Mt_member m ";
				query+= "inner join subject_score s on s.mno = m.mno ";
				query+= "where m.mno = ?";
		List<MemberVO> testResult = new ArrayList<MemberVO>();
		try (
			Connection conn = dataSource.getConnection();	
			PreparedStatement pstmt = conn.prepareStatement(query);
			){
			pstmt.setInt(1, getMno);
			pstmt.executeUpdate();
			try(
				ResultSet rs = pstmt.executeQuery();
				){
				while(rs.next()) {
					MemberVO vo = MemberVO.builder()
							.platoon(rs.getString("platoon"))
							.mrank(rs.getString("mrank"))
							.name(rs.getString("name"))
							.militaryNo(rs.getString("militaryNo"))
							.category(Category.builder()
									.mno(getMno)
									.subject(rs.getString("subject"))
									.scoreRank(rs.getString("scoreRank"))
									.build())
							.build(); 
					testResult.add(vo);
				}
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return testResult;
	}






	


}
	





