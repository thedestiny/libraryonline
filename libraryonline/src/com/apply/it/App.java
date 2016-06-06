package com.apply.it;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.dao.it.AdminDAO;
import com.dao.it.BookDAO;
import com.dao.it.RecordDAO;
import com.entity.it.Book;

public class App {
	Scanner rece = new Scanner(System.in);

	public void launch() {
		do {
			menu();
			String chose = rece.next();
			if ("1".equals(chose)) {
				// ����
				borrowbook();
			} else if ("2".equals(chose)) {
				// ����
				returnbook();
			} else if ("3".equals(chose)) {
				// ����鼮
				addnewbook();
			} else if ("4".equals(chose)) {
				// �޸��鼮
				update();
			} else if ("5".equals(chose)) {
				// ɾ���鼮
				removebook();
			} else if ("6".equals(chose)) {
				// �鿴�����鼮
				showall();
			} else if ("7".equals(chose)) {
				// ����ָ���鼮
				index();
			} else if ("8".equals(chose)) {
				// �½����鿨
				newcard();
			} else if ("9".equals(chose)) {
				System.out.println("�˳��ɹ���");
				break;
			} else {
				System.out.println("����ѡ����������ѡ��");
			}
		} while (true);

	}

	private void newcard() {
		// TODO Auto-generated method stub

	}

	private void update() {
		// �޸��鼮
		BookDAO bdao = new BookDAO();
		String code = getstr("ͼ��ţ�");
		if (bdao.find(code) != null) {
			System.out.println(bdao.find(code));
		} else {
			System.out.println("ͼ�����������");
		}
		if (bdao.revise(code)) {
			System.out.println("�޸ĳɹ���");
		} else {
			System.out.println("δ�ҵ��鼮���޸�ʧ�ܣ�");
		}

	}

	private void index() {
		// ����ָ���鼮
		BookDAO bdao = new BookDAO();
		String code = getstr("ͼ��ţ�");
		Book bo = new Book();
		bo = bdao.find(code);
		if (bo != null) {
			String str = bo.getCode() + "\t" + bo.getTitle() + "\t" + bo.getAuthor() + "\t" + bo.getPress() + "\t"
					+ bo.getStation() + "\t" + bo.getBtime();
			System.out.println("���\t����\t����\t������\t״̬\t���Ĵ���");
			System.out.println(str);
		} else {
			System.out.println("ͼ�����������");
		}

	}

	private void showall() {
		// �鿴�����鼮
		BookDAO bdao = new BookDAO();
		List<Book> list = new ArrayList<>();
		list = bdao.show();
		System.out.println("����\t\t����\t   ������      \t����      \t�ɽ���");
		System.out.print("================================");
		System.out.println("==============================");
		for (Book book : list) {
			System.out.println(book);
		}
		System.out.print("================================");
		System.out.println("==============================");

	}

	private void removebook() {
		// ɾ���鼮 Ҫ���ж��鼮�Ƿ��Ѿ������¼ �м�¼ʱ����ɾ��
		BookDAO bdao = new BookDAO();
		String code = getstr("ͼ��ţ�");
		if (bdao.delete(code)) {
			System.out.println("ɾ���ɹ�");
		} else {
			System.out.println("ͼ�����������");
		}

	}

	private void addnewbook() {
		// ����鼮
		BookDAO bdao = new BookDAO();
		String code = getstr("ͼ���ţ�����λ���֣���1001��");
		// code = code + "01";
		if (bdao.find(code + "01") == null) {
			int num = getint("����������");
			int re = bdao.insert(code, num);
			if (re > 0) {
				System.out.println(re + "��ӳɹ�");
			} else {
				System.out.println("���ʧ��");
			}
		} else {
			System.out.println("ͼ���ű�ռ�ã����������룺");
			addnewbook();
		}

	}

	private void returnbook() {
		// ����
		RecordDAO rdao = new RecordDAO();
		String bcode = getstr("ͼ��ţ�");
		String ccode = getstr("���鿨�ţ�");
		if (rdao.update(bcode, ccode)) {
			System.out.println("����ɹ�");
		} else {
			System.out.println("recordʧ��");
			returnbook();
		}
	}

	private void borrowbook() {
		// ����
		RecordDAO rdao = new RecordDAO();
		String bcode = getstr("ͼ��ţ�");
		String ccode = getstr("���鿨�ţ�");
		// �жϽ��鿨�Ƿ�����ҽ�������ﵽ���� �жϽ��鿨�Ƿ����
		if (rdao.insert(bcode, ccode)) {
			System.out.println("����ɹ�");
			if (getstr("�Ƿ�������飺y������������˳���").equals("y")) {
				borrowbook();
			}
		} else {
			System.out.println("recordʧ��");
			borrowbook();
		}

	}

	public boolean login() {
		System.out.println("�������û�����");
		String user = rece.next();
		System.out.println("���������룺");
		String pwd = rece.next();
		AdminDAO dao = new AdminDAO();
		return dao.find(user, pwd);
	}

	private void menu() {
		System.out.println("    ��ӭʹ��ͼ�����ϵͳ  ");
		System.out.println("======================");
		System.out.println("    1. ����");
		System.out.println("    2. ����");
		System.out.println("    3. ����鼮");
		System.out.println("    4. �޸��鼮");
		System.out.println("    5. ɾ���鼮");
		System.out.println("    6. �鿴�����鼮");
		System.out.println("    7. ����ָ���鼮");
		System.out.println("    8. �½����鿨");
		System.out.println("    9. �˳�ϵͳ");
		System.out.println("=======================");
		System.out.print("����ѡ��");
	}

	private String getstr(String msg) {
		System.out.println("������" + msg);
		return rece.next();
	}

	private int getint(String msg) {
		System.out.println("������" + msg);
		if (rece.hasNextInt()) {
			return rece.nextInt();
		} else {
			System.out.println(msg + "���з����֣����������룺");
			return getint(msg);
		}
	}

}
