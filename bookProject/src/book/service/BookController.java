package book.service;

import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;

import book.model.BookDAO;
import book.model.BookOrderDAO;
import book.model.MemberDAO;
import book.model.dto.BookDTO;
import book.model.dto.BookOrderDTO;
import book.model.dto.MemberDTO;
import book.view.EndView;
import book.exception.NotExistException;

public class BookController {
	// 새로운 주문 저장 로직
	public static boolean addMember(MemberDTO member) {
		boolean result = false;

		try {
			result = MemberDAO.addMember(member);
		} catch (SQLException s) {
			s.printStackTrace();
			EndView.showError("새로운 주문정보 저장 시 에러 발생");
		}
		return result;
	}

	// 모든 주문 조회 로직
	public static ArrayList<BookOrderDTO> getAllBookOrder() {
		ArrayList<BookOrderDTO> allorder = null;
		try {
			allorder = BookOrderDAO.getAllBookOrder();
		} catch (SQLException s) {
			s.printStackTrace();
			EndView.showError("모든 프로젝트 검색시 에러 발생");
		}
		return allorder;
	}

	// 모든 회원 검색 로직
	public static ArrayList<MemberDTO> getAllMember() {
		ArrayList<MemberDTO> allmember = null;
		try {
			allmember = MemberDAO.getAllMembers();
		} catch (SQLException s) {
			s.printStackTrace();
			EndView.showError("모든 재능 기부자 검색시 에러 발생");
		}
		return allmember;
	}

	// 모든 책 정보 조회 로직
	public static ArrayList<BookDTO> getAllBooks() {
		ArrayList<BookDTO> allbooks = null;
		try {
			allbooks = BookDAO.getAllBook();
		} catch (SQLException s) {
			s.printStackTrace();
			EndView.showError("모든 재능 기부자 검색시 에러 발생");
		}
		return allbooks;
	}

	// 책코드로 책 정보 수정하기
	public static boolean updateBook(String bname, int price, String publish, String writer, String date, String code) {
		boolean result = false;
		try {
			result = BookDAO.updateBook(bname, price, publish, writer, date, code);
		} catch (SQLException s) {
			s.printStackTrace();
			EndView.showError("책변경 오류");
		}
		return result;
	}

	public static void deleteMember(String memberid) {
		try {
			MemberDAO.deleteMember(memberid);
		} catch (SQLException s) {
			EndView.showError("현재 도서 배송중");
		} catch (NotExistException n) {
			EndView.showError(n.getMessage());
		}
	}
}
