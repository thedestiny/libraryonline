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
				// 借书
				borrowbook();
			} else if ("2".equals(chose)) {
				// 还书
				returnbook();
			} else if ("3".equals(chose)) {
				// 添加书籍
				addnewbook();
			} else if ("4".equals(chose)) {
				// 修改书籍
				update();
			} else if ("5".equals(chose)) {
				// 删除书籍
				removebook();
			} else if ("6".equals(chose)) {
				// 查看所有书籍
				showall();
			} else if ("7".equals(chose)) {
				// 查找指定书籍
				index();
			} else if ("8".equals(chose)) {
				// 新建借书卡
				newcard();
			} else if ("9".equals(chose)) {
				System.out.println("退出成功：");
				break;
			} else {
				System.out.println("您的选择有误，请重选：");
			}
		} while (true);

	}

	private void newcard() {
		// TODO Auto-generated method stub

	}

	private void update() {
		// 修改书籍
		BookDAO bdao = new BookDAO();
		String code = getstr("图书号：");
		if (bdao.find(code) != null) {
			System.out.println(bdao.find(code));
		} else {
			System.out.println("图书号输入有误");
		}
		if (bdao.revise(code)) {
			System.out.println("修改成功！");
		} else {
			System.out.println("未找到书籍或修改失败！");
		}

	}

	private void index() {
		// 查找指定书籍
		BookDAO bdao = new BookDAO();
		String code = getstr("图书号：");
		Book bo = new Book();
		bo = bdao.find(code);
		if (bo != null) {
			String str = bo.getCode() + "\t" + bo.getTitle() + "\t" + bo.getAuthor() + "\t" + bo.getPress() + "\t"
					+ bo.getStation() + "\t" + bo.getBtime();
			System.out.println("书号\t书名\t作者\t出版社\t状态\t借阅次数");
			System.out.println(str);
		} else {
			System.out.println("图书号输入有误");
		}

	}

	private void showall() {
		// 查看所有书籍
		BookDAO bdao = new BookDAO();
		List<Book> list = new ArrayList<>();
		list = bdao.show();
		System.out.println("书名\t\t作者\t   出版社      \t总数      \t可借数");
		System.out.print("================================");
		System.out.println("==============================");
		for (Book book : list) {
			System.out.println(book);
		}
		System.out.print("================================");
		System.out.println("==============================");

	}

	private void removebook() {
		// 删除书籍 要先判断书籍是否已经借出记录 有记录时不能删除
		BookDAO bdao = new BookDAO();
		String code = getstr("图书号：");
		if (bdao.delete(code)) {
			System.out.println("删除成功");
		} else {
			System.out.println("图书号输入有误");
		}

	}

	private void addnewbook() {
		// 添加书籍
		BookDAO bdao = new BookDAO();
		String code = getstr("图书编号：【四位数字：例1001】");
		// code = code + "01";
		if (bdao.find(code + "01") == null) {
			int num = getint("本书数量：");
			int re = bdao.insert(code, num);
			if (re > 0) {
				System.out.println(re + "添加成功");
			} else {
				System.out.println("添加失败");
			}
		} else {
			System.out.println("图书编号被占用，请重新输入：");
			addnewbook();
		}

	}

	private void returnbook() {
		// 还书
		RecordDAO rdao = new RecordDAO();
		String bcode = getstr("图书号：");
		String ccode = getstr("借书卡号：");
		if (rdao.update(bcode, ccode)) {
			System.out.println("还书成功");
		} else {
			System.out.println("record失败");
			returnbook();
		}
	}

	private void borrowbook() {
		// 借书
		RecordDAO rdao = new RecordDAO();
		String bcode = getstr("图书号：");
		String ccode = getstr("借书卡号：");
		// 判断借书卡是否存在且借出数量达到上限 判断借书卡是否存在
		if (rdao.insert(bcode, ccode)) {
			System.out.println("借书成功");
			if (getstr("是否继续借书：y继续，任意键退出：").equals("y")) {
				borrowbook();
			}
		} else {
			System.out.println("record失败");
			borrowbook();
		}

	}

	public boolean login() {
		System.out.println("请输入用户名：");
		String user = rece.next();
		System.out.println("请输入密码：");
		String pwd = rece.next();
		AdminDAO dao = new AdminDAO();
		return dao.find(user, pwd);
	}

	private void menu() {
		System.out.println("    欢迎使用图书管理系统  ");
		System.out.println("======================");
		System.out.println("    1. 借书");
		System.out.println("    2. 还书");
		System.out.println("    3. 添加书籍");
		System.out.println("    4. 修改书籍");
		System.out.println("    5. 删除书籍");
		System.out.println("    6. 查看所有书籍");
		System.out.println("    7. 查找指定书籍");
		System.out.println("    8. 新建借书卡");
		System.out.println("    9. 退出系统");
		System.out.println("=======================");
		System.out.print("您的选择：");
	}

	private String getstr(String msg) {
		System.out.println("请输入" + msg);
		return rece.next();
	}

	private int getint(String msg) {
		System.out.println("请输入" + msg);
		if (rece.hasNextInt()) {
			return rece.nextInt();
		} else {
			System.out.println(msg + "含有非数字，请重新输入：");
			return getint(msg);
		}
	}

}
