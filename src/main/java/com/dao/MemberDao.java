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
import com.domain.MemberVO.MemberGrade;

public class MemberDao {
	
	private DataSource dataSource;
	
	public MemberDao() {
		dataSource = ConnectionUtil.getDataSource();
	}
	//회원추가
	public void insertMember(MemberVO vo) {
		String query="INSERT INTO MT_MEMBER(mno,ID,PWD,NAME,personNo,militaryNo,addr,EMAIL,birth) VALUES(MNO_SEQ.nextval,?,?,?,?,?,?,?,?)";
		try (
			Connection conn = dataSource.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(query);
			){
				pstmt.setString(1, vo.getId());
				pstmt.setString(2, vo.getPwd());
				pstmt.setString(3, vo.getName());
				pstmt.setString(4, vo.getPersonNo());
				pstmt.setString(5, vo.getMilitaryNo());
				pstmt.setString(6, vo.getAddr());
				pstmt.setString(7, vo.getEmail());
				pstmt.setString(8, vo.getBirth());
				
				pstmt.executeUpdate();
			} catch (Exception e) {
				e.printStackTrace();
		}
	}
	//로그인처리
	public boolean loginService(MemberVO vo) {
		boolean result =false;
		String query = "SELECT DECODE(COUNT(*),1,'TRUE','FALSE') AS RESULT FROM MT_MEMBER WHERE ID=? AND PWD=?";
		
		try (
			Connection conn = dataSource.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(query);
		){
			pstmt.setString(1, vo.getId());
			pstmt.setString(2, vo.getPwd());
			try(ResultSet rs = pstmt.executeQuery();){
				if(rs.next()) {
					result = Boolean.parseBoolean(rs.getString("RESULT"));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
	//등급조회
	public MemberGrade findMemberGradeById(String id) {
		MemberGrade grade = null;
		String query = "SELECT GRADE FROM MT_MEMBER WHERE ID=?"; 
		try(
			Connection conn = dataSource.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(query);
		){
			pstmt.setString(1, id);
			try(ResultSet rs = pstmt.executeQuery()){
				if(rs.next()) grade = MemberGrade.valueOf(rs.getString("grade"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return grade;
	}
	//회원정보보기
	public List<MemberVO> memberList() {
		String query = "SELECT * FROM MT_MEMBER order by mno desc";
		List<MemberVO> memberList = new ArrayList<MemberVO>();
		try (
			Connection conn = dataSource.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(query);
			ResultSet rs = pstmt.executeQuery();
			){
			while(rs.next()) {
				MemberVO vo = MemberVO.builder()
						.mno(rs.getInt("mno"))
						.id(rs.getString("id"))
						.platoon(rs.getString("platoon"))
						.mrank(rs.getString("mrank"))
						.name(rs.getString("name"))
						.personNo(rs.getString("personNo"))
						.militaryNo(rs.getString("militaryNo"))
						.addr(rs.getString("addr"))
						.email(rs.getString("email"))
						.birth(rs.getString("birth"))
						.joinDate(rs.getDate("joinDate"))
								
						.build();
				memberList.add(vo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return memberList;
	}
}


