package com.bytecode.test;
import static com.bytecode.utils.HibernateUtils.getFactory;

import java.util.Scanner;

import org.hibernate.SessionFactory;

import com.bytecode.Model.Team;
import com.bytecode.dao.TeamDao;
import com.bytecode.dao.TeamDaoImpl;

public class AddNewTeam {
	public static void main(String[] args) {
		try (SessionFactory sf = getFactory();
			 Scanner sc = new Scanner(System.in);
			) {
			//create dao
			TeamDao dao = new TeamDaoImpl();
			System.out.println("String name, String abbreviation, String owner, Integer maxAge, Double battingAvg,\r\n"
					+ "			Integer wicketsTaken");
			Team team = new Team(sc.next(), sc.next(), sc.next(), sc.nextInt(), sc.nextDouble(), sc.nextInt());
			System.out.println(dao.addNewTeam(team));
		} // JVM : sf.close() --> DBCP cleaned up!
		catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
