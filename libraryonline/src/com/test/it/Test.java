package com.test.it;

import java.util.List;
import java.util.Scanner;

import com.apply.it.App;
import com.dao.it.BookDAO;
import com.dao.it.RealationDAO;
import com.entity.it.Book;
import com.entity.it.Realation;
import com.helper.it.BRMsuper;

public class Test {

	public static void main(String[] args) {

		App app = new App();
		Scanner rece = new Scanner(System.in);

//		do {
//			if (app.login()) {
//				app.launch();
//				System.out.println("�Ƿ����ʹ�ã�y������������˳���");
//				if (!rece.next().equals("y")) {
//					break;
//				}
//			} else {
//				System.out.println("�û������������");
//			}
//		} while (true);
//		BookDAO dao = new BookDAO();
//		List<Book> list = dao.showall("��");
//		for (Book b : list) {
//			System.out.println(b);
//		}
//		
		
		
//		app.launch();
//		rece.close();
		// BRMsuper<Book> brm = new BRMsuper<>(Book.class);
		// brm.build();
		RealationDAO dao = new RealationDAO();
		Realation real = new Realation();
		List<Realation> list = dao.findccode("3001");
		for (Realation rea : list) {
			System.out.println("������  " + rea.getBday() + "�黹ʱ�䣺" + rea.getRetime());
		}
		
	}

}
