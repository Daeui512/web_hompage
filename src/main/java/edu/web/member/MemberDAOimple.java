package edu.web.member;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import oracle.jdbc.driver.OracleDriver;

public class MemberDAOimple implements MemberDAO,DBConnectionQuery{
	
	private static MemberDAOimple instance = null;
	
	private MemberDAOimple() {
		try {
			DriverManager.registerDriver(new OracleDriver());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static MemberDAOimple getInstance() {
		if (instance == null) {
			instance = new MemberDAOimple();
		}
		return instance;
		
	}
	@Override
	public int insert(MemberVO vo) {
		System.out.println("insert() CALL");
		int result = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			System.out.println("ORACLE 연결 성공");
			pstmt = conn.prepareStatement(SQL_INSERT);
			pstmt.setString(1, vo.getUserid());
			pstmt.setString(2, vo.getPassword());
			pstmt.setString(3, vo.getEmail());
			pstmt.setString(4, vo.getEmailAgree());
			pstmt.setString(5, vo.getInterestJoin());
			pstmt.setString(6, vo.getPhone());
			pstmt.setString(7, vo.getIntroduce());

			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;	
	}

	@Override
	public MemberVO select(String userid) {
		System.out.println("select() CALL");
		MemberVO vo = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		
		try {
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			System.out.println("ORACLE 연결 성공");
			pstmt = conn.prepareStatement(SQL_SELECT_BY_USERID);
			pstmt.setString(1, userid); // 쿼리의 ? 개수에 맞게 설정(순서)
			rs = pstmt.executeQuery(); // 쿼리를 실행한 결과를 저장
			if(rs.next()) {
				userid = rs.getString(COL_USERID); // DB 컬럼 인덱스 or 컬럼 이름과 매치
				String password = rs.getString(COL_PASSWORD);
				String email = rs.getString(COL_EMAIL);
				String emailAgree = rs.getString(COL_EMAILAGREE);
				String[] interest = null;
				if (!rs.getString(COL_INTEREST).equals("없음")) {
					//interest 데이터가 없음이 아니면
					// 그 값을 "," 기준으로 나워서 배열로 저장
					interest = rs.getString(COL_INTEREST).split(",");
				}
				String phone = rs.getString(COL_PHONE);
				String introduce = rs.getString(COL_INTRODUCE);
				
				vo = new MemberVO(userid, password, email, emailAgree, interest, phone, introduce);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return vo;
	}

	@Override
	public int update(MemberVO vo) {
		System.out.println("update() CALL");
		int result = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			System.out.println("ORACLE 연결 성공");
			pstmt = conn.prepareStatement(SQL_UPDATE_BY_USERID);
			pstmt.setString(1, vo.getPassword());
			pstmt.setString(2, vo.getEmail());
			pstmt.setString(3, vo.getEmailAgree());
			pstmt.setString(4, vo.getInterestJoin());
			pstmt.setString(5, vo.getPhone());
			pstmt.setString(6, vo.getIntroduce());
			pstmt.setString(7, vo.getUserid());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public int delete(String userid) {
		System.out.println("delete() CALL");
		int result = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			System.out.println("ORACLE 연결 성공");
			pstmt = conn.prepareStatement(SQL_DELETE_BY_USERID);
			pstmt.setString(1, userid);
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public MemberVO select(String userid, String password) {
		System.out.println("select()/userid,password CALL");
		MemberVO vo = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			System.out.println("ORACLE 연결 성공");
			pstmt = conn.prepareStatement(SQL_SELECT_BY_USERID_PASSWORD);
			pstmt.setString(1, userid); // 쿼리의 ? 개수에 맞게 설정(순서)
			pstmt.setString(2, password);
			rs = pstmt.executeQuery(); // 쿼리를 실행한 결과를 저장
			if(rs.next()) {
				userid = rs.getString(COL_USERID); // DB 컬럼 인덱스 or 컬럼 이름과 매치
				password = rs.getString(COL_PASSWORD);
				vo = new MemberVO();
				vo.setUserid(userid);
				vo.setPassword(password);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return vo;
	}
}