package com.bytecode.test;
import static com.bytecode.utils.HibernateUtils.getFactory;

import java.util.Scanner;

import org.hibernate.SessionFactory;

import com.bytecode.dao.TeamDao;
import com.bytecode.dao.TeamDaoImpl;
public class GetTeamById {
	public static void main(String[] args) {
		try (SessionFactory sf = getFactory();
				Scanner sc = new Scanner(System.in)) {
				TeamDao dao = new TeamDaoImpl();
				System.out.println("Enter the Team id");
				System.out.println(dao.getTeamById(sc.nextLong()));
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
