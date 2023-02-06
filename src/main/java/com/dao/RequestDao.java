package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.common.ConnectionUtil;
import com.controller.RequestController;
import com.domain.RequestVO;

public class RequestDao {
	
	private DataSource dataSource;
	private RequestController con;
	
	public RequestDao() {
		dataSource = ConnectionUtil.getDataSource();
	}
	
	//요청 목록
	public List<RequestVO> requestResultList(){
		String query = "select b.requestNo, b.platoon, b.mrank, m.name, m.militaryNo, b.requestDate, b.reason, b.resultOR ";
				query+="from Mt_member m inner join board_request b on b.name = m.name ";
				query+="inner join board_request b on b.militaryNo = m.militaryNo";
		List<RequestVO> resultList = new ArrayList<RequestVO>();
		try (
			Connection conn = dataSource.getConnection();	
			PreparedStatement pstmt = conn.prepareStatement(query);
			ResultSet rs = pstmt.executeQuery();
			){
			while(rs.next()){
				RequestVO vo= RequestVO.builder()
						.requestNo(rs.getInt("requestNo"))
						.platoon(rs.getString("platoon"))
						.mrank(rs.getString("mrank"))
						.name(rs.getString("name"))
						.militaryNo(rs.getString("militaryNo"))
						.requestDate(rs.getString("requestDate"))
						.reason(rs.getString("reason"))
						.resultOR(rs.getString("resultOR"))
						.build(); 
				resultList.add(vo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resultList;
	}
	
	//새신청 번호
	public int getNewBno() {
		String query = "SELECT MAX(RequestNo) as newNo FROM BOARD_request";
		int newNumber = 0;
		try (
			Connection conn = dataSource.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(query);
			ResultSet rs = pstmt.executeQuery();
			){
			if(rs.next()) {
				newNumber = rs.getInt("newNo")+1;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return newNumber; 
	}
	//휴가신청처리
	public int addRequest(RequestVO vo) {
		String query ="INSERT INTO Board_request(RequestNo,name,militaryNo,RequestDate,Reason,resultOR) values(?,?,?,?,?,?)";
		int newNo = getNewBno();
		try (
				Connection conn = dataSource.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(query);
				){
				pstmt.setInt(1, newNo);
				pstmt.setString(2, vo.getName());
				pstmt.setString(3, vo.getMilitaryNo());
				pstmt.setString(4, vo.getRequestDate());
				pstmt.setString(5, vo.getReason());
				pstmt.setString(6, vo.getResultOR());
				pstmt.executeUpdate();
			} catch (Exception e) {
				e.printStackTrace();
			}
		
		return newNo;
	}

//승인처리
	public void updateGo(RequestVO vo) {
		String GoQuery ="update BOARD_request set resultOR ='승인' where requestNo=?";
		try (
			Connection conn = dataSource.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(GoQuery);
				){
			pstmt.setInt(1, vo.getRequestNo());
			pstmt.executeUpdate();
		}catch (Exception e) {
			e.printStackTrace();
		}

	}
//거절처리
	public void updateNo(RequestVO vo) {
		String NoQuery ="update BOARD_request set resultOR ='반려' where requestNo=?";
		try (
			Connection conn = dataSource.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(NoQuery);
				){
			pstmt.setInt(1, vo.getRequestNo());
			pstmt.executeUpdate();
		}catch (Exception e) {
			e.printStackTrace();
		}
	
	}
//승인대기인 요청자 목록 (미결)
	public List<RequestVO> resultORList() {
		String query = "select * from board_request where resultOR='승인대기'";
		List<RequestVO> resultORList = new ArrayList<RequestVO>();
		try (
			Connection conn = dataSource.getConnection();	
			PreparedStatement pstmt = conn.prepareStatement(query);
			ResultSet rs = pstmt.executeQuery();
			){
			while(rs.next()){
				RequestVO vo= RequestVO.builder()
						.requestNo(rs.getInt("requestNo"))
						.platoon(rs.getString("platoon"))
						.mrank(rs.getString("mrank"))
						.name(rs.getString("name"))
						.militaryNo(rs.getString("militaryNo"))
						.requestDate(rs.getString("requestDate"))
						.reason(rs.getString("reason"))
						.resultOR(rs.getString("resultOR"))
						.build(); 
				resultORList.add(vo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resultORList;
	}	
}
