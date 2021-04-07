package edu.web.member;

//DB와 데이터 송수신을 위한 메소드 선언 인터페이스
//insert, select, update, delete
public interface MemberDAO {
	
	//회원가입
	public abstract int insert(MemberVO vo);

	//회원 정보 보기
	public abstract MemberVO select(String userid);
	
	//회원 정보 수정
	public abstract int update(MemberVO vo);
	
	//회원 탈퇴
	public abstract int delete(String userid);
	
	//로그인 아이디 비밀번호 확인
	public abstract MemberVO select(String userid,String password);
	
}