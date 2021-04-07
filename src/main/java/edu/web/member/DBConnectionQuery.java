package edu.web.member;

public interface DBConnectionQuery {

	// DB 접속에 필요한 상수 정의
	public static final String URL = "jdbc:oracle:thin:@localhost:1521:ee";
	public static final String USER = "scott";
	public static final String PASSWORD = "tiger";
	
	// DB테이블 컬럼 상수 정의
	public static final String TABLE_NAME = "MEMBER";
	public static final String COL_USERID = "USERID";
	public static final String COL_PASSWORD = "PASSWORD";
	public static final String COL_EMAIL = "EMAIL";
	public static final String COL_EMAILAGREE = "EMAILAGREE";
	public static final String COL_INTEREST = "INTEREST";
	public static final String COL_PHONE = "PHONE";
	public static final String COL_INTRODUCE = "INTRODUCE";
	
	//INSERT INTO MEMBER VALUES
	//(?,?,?,?,?,?,?);
	public static final String SQL_INSERT = "INSERT INTO " + TABLE_NAME + " VALUES (?,?,?,?,?,?,?)";
	
	//SELECT * FROM MEMBER WHERE USERID = 'TEST';
	public static final String SQL_SELECT_BY_USERID = "SELECT * FROM " + TABLE_NAME + " WHERE " + COL_USERID + " = ?";
	
	//UPDATE MEMBER SET PASSWORD = ?, EMAIL = ?, EMAILAGREE = ?,
	//interest = ?, phone = ?, introduce = ?
	//where userid = ?;
	public static final String SQL_UPDATE_BY_USERID = "UPDATE " + TABLE_NAME + " SET " 
													+ COL_PASSWORD + " = ?, " 
													+ COL_EMAIL +" = ?, "
													+ COL_EMAILAGREE + "= ?, "
													+ COL_INTEREST + " = ?, " 
													+ COL_PHONE + " = ?, " 
													+ COL_INTRODUCE + " = ? WHERE " 
													+ COL_USERID + " = ?";
													
	//DELETE FROM MEMBER WHERE USERID = ?
	public static final String SQL_DELETE_BY_USERID = "DELETE FROM " + TABLE_NAME + " WHERE "
														+ COL_USERID + " = ?";
	
	//SELECT * FROM MEMBER WHERE USERID = ?, AND PASSWORD= ?
	public static final String SQL_SELECT_BY_USERID_PASSWORD = "SELECT * FROM " + TABLE_NAME + " WHERE " 
																+ COL_USERID + " = ? AND " 
																+ COL_PASSWORD + " = ?";

	
}