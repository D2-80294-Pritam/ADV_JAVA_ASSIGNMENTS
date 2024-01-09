package com.bytecode.test;
import static com.bytecode.utils.HibernateUtils.getFactory;

import java.util.Scanner;

import org.hibernate.SessionFactory;

import com.bytecode.dao.TeamDao;
import com.bytecode.dao.TeamDaoImpl;

public class GetTeamByMaxAgeByOrder {
	public static void main(String[] args) {
		try (SessionFactory sf = getFactory()) {
			System.out.println("Enter the max age");
			Scanner sc = new Scanner(System.in);
			Integer maxAge = sc.nextInt();
			System.out.println("Enter the Min Wikcets");
			Integer minWickets = sc.nextInt();
			TeamDao dao = new TeamDaoImpl();
			dao.getTeamsByMaxAgeMinWickets(	maxAge, minWickets).forEach(t -> System.out.println(t));
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
