package com.bytecode.test;
import static com.bytecode.utils.HibernateUtils.getFactory;

import org.hibernate.SessionFactory;

import com.bytecode.dao.TeamDao;
import com.bytecode.dao.TeamDaoImpl;

public class DisplayTeamIdAbbreviation {
	public static void main(String[] args) {
		try (SessionFactory sf = getFactory()) {
			TeamDao dao = new TeamDaoImpl();
			dao.displayTeamIdAbbreviation()
			.forEach(e -> System.out.println(e.getTeamId() + " : " + e.getAbbreviation()));
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
