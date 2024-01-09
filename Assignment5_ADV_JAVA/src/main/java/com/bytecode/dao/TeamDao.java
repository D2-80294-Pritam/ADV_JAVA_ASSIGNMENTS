package com.bytecode.dao;

import java.util.List;

import com.bytecode.Model.Team;

public interface TeamDao {
//add a method to add new team
	String addNewTeam(Team team);
	List<Team> displayTeamIdAbbreviation();
	Team getTeamById(Long id);
}
