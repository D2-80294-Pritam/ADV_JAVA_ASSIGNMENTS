package com.bytecode.dao;

import static com.bytecode.utils.HibernateUtils.getFactory;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.bytecode.Model.Team;

public class TeamDaoImpl implements TeamDao {

	@Override
	public String addNewTeam(Team team) {
		String msg = "Adding new team failed!!!";
		
		// 1. Open session from SF
		Session session = getFactory().openSession();
		// 2. Begin a transaction
		Transaction tx = session.beginTransaction();
		try {
			Serializable teamId = session.save(team);
			// Success 
			tx.commit();
			msg = "Added new team with ID : " + teamId;
		}
		catch (RuntimeException ex) {
			// => Error
			if (tx != null) {
				tx.rollback();
			}
			// re throw the same exception to the caller
			throw ex;		
		}
		finally {
			// close session : L1 cache gets destroyed and pooled out db cn returns to the pool
			if (session != null)
				session.close();
		}
		return msg;
	}
	
	@Override
	public List<Team> displayTeamIdAbbreviation() {
		List<Team> teams = null;
		String jpql = "select new com.bytecode.Model.Team(teamId, abbreviation) from Team ";
		Session session = getFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		try {
			teams = session.createQuery(jpql, Team.class)
					.getResultList();
			System.out.println(teams.size());
			tx.commit();
		}
		catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}
		return teams;
	}

	@Override
	public Team getTeamById(Long id) {
		Team team = null;
		Session session = getFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		try {
			team = session.get(Team.class, id);
			tx.commit();
		}
		catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}
		return team;
	}

	@Override
	public List<Team> getTeamsByMaxAgeMinWickets(Integer maxAge, Integer minWickets) {
		List<Team> list = null;
		Session session = getFactory().getCurrentSession();
		String jpql = "select T from Team T where T.maxAge < :a and T.wicketsTaken > :b order by T.maxAge desc";
		Transaction tx = session.beginTransaction();
		try {
			list = session.createQuery(jpql, Team.class)
					.setParameter("a", maxAge)
					.setParameter("b", minWickets)
					.getResultList();
			tx.commit();
		}
		catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}
		return list;
	}
	

}
