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
	// ���ο� �ֹ� ���� ����
	public static boolean addMember(MemberDTO member) {
		boolean result = false;

		try {
			result = MemberDAO.addMember(member);
		} catch (SQLException s) {
			s.printStackTrace();
			EndView.showError("���ο� �ֹ����� ���� �� ���� �߻�");
		}
		return result;
	}

	// ��� �ֹ� ��ȸ ����
	public static ArrayList<BookOrderDTO> getAllBookOrder() {
		ArrayList<BookOrderDTO> allorder = null;
		try {
			allorder = BookOrderDAO.getAllBookOrder();
		} catch (SQLException s) {
			s.printStackTrace();
			EndView.showError("��� ������Ʈ �˻��� ���� �߻�");
		}
		return allorder;
	}

	// ��� ȸ�� �˻� ����
	public static ArrayList<MemberDTO> getAllMember() {
		ArrayList<MemberDTO> allmember = null;
		try {
			allmember = MemberDAO.getAllMembers();
		} catch (SQLException s) {
			s.printStackTrace();
			EndView.showError("��� ��� ����� �˻��� ���� �߻�");
		}
		return allmember;
	}

	// ��� å ���� ��ȸ ����
	public static ArrayList<BookDTO> getAllBooks() {
		ArrayList<BookDTO> allbooks = null;
		try {
			allbooks = BookDAO.getAllBook();
		} catch (SQLException s) {
			s.printStackTrace();
			EndView.showError("��� ��� ����� �˻��� ���� �߻�");
		}
		return allbooks;
	}

	// å�ڵ�� å ���� �����ϱ�
	public static boolean updateBook(String bname, int price, String publish, String writer, String date, String code) {
		boolean result = false;
		try {
			result = BookDAO.updateBook(bname, price, publish, writer, date, code);
		} catch (SQLException s) {
			s.printStackTrace();
			EndView.showError("å���� ����");
		}
		return result;
	}

	public static void deleteMember(String memberid) {
		try {
			MemberDAO.deleteMember(memberid);
		} catch (SQLException s) {
			EndView.showError("���� ���� �����");
		} catch (NotExistException n) {
			EndView.showError(n.getMessage());
		}
	}
}
