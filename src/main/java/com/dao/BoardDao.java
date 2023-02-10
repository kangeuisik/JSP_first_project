package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.common.ConnectionUtil;
import com.domain.BoardVO;

public class BoardDao {

	private DataSource dataSource;
	
	public BoardDao() {
		dataSource = ConnectionUtil.getDataSource();
	}
	
	//글목록
	public List<BoardVO> BoardList() {
		String query = "select * from BOARD_TBL order by bno desc";
		List<BoardVO> list = new ArrayList<>();
		try (
			Connection conn = dataSource.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(query);
			ResultSet rs = pstmt.executeQuery();
			){
			while(rs.next()) {
				BoardVO vo = BoardVO.builder()
						.bno(rs.getInt("bno"))
						.title(rs.getString("title"))
						.content(rs.getString("content"))
						.writer(rs.getString("writer"))
						.imageFileName(rs.getString("imageFileName"))
						.writeDate(rs.getDate("writeDate"))
						.build();
				list.add(vo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	//글번호 생성
	public int getNewBno() {
		int boardNo = 0;
		String query = "SELECT MAX(BNO)+1 as boardNO FROM BOARD_TBL";
		try (
			Connection conn = dataSource.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(query);
			ResultSet rs = pstmt.executeQuery();
			){
			if(rs.next()) {
				boardNo = rs.getInt("boardNO");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return boardNo;
	}

	//글상세보기
	public BoardVO detailBoard(int bno) {
		BoardVO vo = null;
		String query = "select * from BOARD_TBL where bno=?";
		try (
			Connection conn = dataSource.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(query);
			){
			pstmt.setInt(1, bno);
			try (
				ResultSet rs = pstmt.executeQuery();
				){
				if(rs.next()) {
					vo=BoardVO.builder()
							.bno(rs.getInt("bno"))
							.bid(rs.getString("bid"))
							.title(rs.getString("title"))
							.content(rs.getString("content"))
							.writer(rs.getString("writer"))
							.writeDate(rs.getDate("writeDate"))
							.imageFileName(rs.getString("imageFileName"))
							.build();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return vo;
	}
//글쓰기
	public int insertBoard(BoardVO vo) {
		//수정 필요
		//특정 조건 : bid 분류가 notice, admin, parents, sergant의 경우에 해당 카테고리에 업로드
//		String query= "insert into BOARD_TBL(bno,Bid,title,content,writer,imageFileName) values (?,?,?,?,?,?)";
		String query= "INSERT INTO BOARD_TBL (bno,Bid,title,content,writer,imageFileName) ";
				query+= "SELECT ?,?,?,?,?,?";
				query+= "FROM DUAL WHERE EXISTS(SELECT * FROM BOARD_TBL ";
				query+= "WHERE bid = 'notice' or bid='admin' or bid='sergant' or bid='parents')";
		int boardNo=getNewBno();
		try (
			Connection conn = dataSource.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(query);
			){
			pstmt.setInt(1, boardNo);
			pstmt.setString(2, vo.getBid());
			pstmt.setString(3,vo.getTitle());
			pstmt.setString(4, vo.getContent());
			pstmt.setString(5, vo.getWriter());
			pstmt.setString(6, vo.getImageFileName());
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return boardNo;
	}
	//수정
	public void modBoard(BoardVO vo) {
		String imageFileName = vo.getImageFileName();
		int bno = vo.getBno();
		String query = "update BOARD_TBL set title=?,content=?";

		if(imageFileName!=null) { // 이미지 파일이 있을 때
			query+=",imageFileName=? where bno=?";
		} else { // 이미지 파일이 없을 때 
			query+=" where bno=?";
		}
		
		try (
			Connection conn = dataSource.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(query);
		){
			pstmt.setString(1, vo.getTitle());
			pstmt.setString(2, vo.getContent());
			if(imageFileName!=null) { // 이미지 파일이 있을 때
				pstmt.setString(3, imageFileName);
				pstmt.setInt(4, bno);
			} else { // 이미지 파일이 없을 때
				pstmt.setInt(3, bno);
			}
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	
		
	}
	//삭제
	public void removeBoard(int bno) {
		String query = "delete from board_tbl where bno=?";
		try (
			Connection conn = dataSource.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(query);	
		){
			pstmt.setInt(1, bno);
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	//공지사항
	public List<BoardVO> noticeList() {
		String query = "select * from board_tbl where bid='notice'";
		List<BoardVO> noticeList = new ArrayList<>();
		try (
			Connection conn = dataSource.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(query);
			ResultSet rs = pstmt.executeQuery();
			){
			while(rs.next()) {
				BoardVO vo = BoardVO.builder()
						.bno(rs.getInt("bno"))
						.title(rs.getString("title"))
						.content(rs.getString("content"))
						.writer(rs.getString("writer"))
						.imageFileName(rs.getString("imageFileName"))
						.writeDate(rs.getDate("writeDate"))
						.build();
					noticeList.add(vo);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		return noticeList;
	}
	//병사게시판
	public List<BoardVO> sergantList() {
		String query = "select * from board_tbl where bid='sergant'";
		List<BoardVO> sergantList = new ArrayList<>();
		try (
			Connection conn = dataSource.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(query);
			ResultSet rs = pstmt.executeQuery();
			){
			while(rs.next()) {
				BoardVO vo = BoardVO.builder()
						.bno(rs.getInt("bno"))
						.title(rs.getString("title"))
						.content(rs.getString("content"))
						.writer(rs.getString("writer"))
						.imageFileName(rs.getString("imageFileName"))
						.writeDate(rs.getDate("writeDate"))
						.build();
					sergantList.add(vo);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		return sergantList;
	}
	//가족게시판
	public List<BoardVO> parentsList() {
		String query = "select * from board_tbl where bid='parents'";
		List<BoardVO> parentsList = new ArrayList<>();
		try (
			Connection conn = dataSource.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(query);
			ResultSet rs = pstmt.executeQuery();
			){
			while(rs.next()) {
				BoardVO vo = BoardVO.builder()
						.bno(rs.getInt("bno"))
						.title(rs.getString("title"))
						.content(rs.getString("content"))
						.writer(rs.getString("writer"))
						.imageFileName(rs.getString("imageFileName"))
						.writeDate(rs.getDate("writeDate"))
						.build();
				parentsList.add(vo);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		return parentsList;
	}
	//간부 업무참고게시판
	public List<BoardVO> adminList() {
		String query = "select * from board_tbl where bid='admin'";
		List<BoardVO> adminList = new ArrayList<>();
		try (
			Connection conn = dataSource.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(query);
			ResultSet rs = pstmt.executeQuery();
			){
			while(rs.next()) {
				BoardVO vo = BoardVO.builder()
						.bno(rs.getInt("bno"))
						.title(rs.getString("title"))
						.content(rs.getString("content"))
						.writer(rs.getString("writer"))
						.imageFileName(rs.getString("imageFileName"))
						.writeDate(rs.getDate("writeDate"))
						.build();
				adminList.add(vo);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		return adminList;
	}
	
}
