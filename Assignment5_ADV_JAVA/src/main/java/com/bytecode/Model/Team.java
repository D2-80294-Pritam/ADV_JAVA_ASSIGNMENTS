package com.bytecode.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="teams")
public class Team {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long teamId;
	@Column (unique = true, length=100)
	private String name;
	@Column (unique = true, length=10)
	private String abbreviation;
	@Column (length=20, name="owner")
	private String owner;
	@Column (name="max_age")
	private Integer maxAge;
	@Column (name="batting_avg")
	private Double battingAvg;
	@Column (name="wickets_taken")
	private Integer wicketsTaken;
	
	public Team() {
		
	}
	
	public Team(Long id, String abbreviation) {
		this.teamId = id;
		this.abbreviation = abbreviation;
	}

	public Team(String name, String abbreviation, String owner, Integer maxAge, Double battingAvg,
			Integer wicketsTaken) {
		super();
		this.name = name;
		this.abbreviation = abbreviation;
		this.owner = owner;
		this.maxAge = maxAge;
		this.battingAvg = battingAvg;
		this.wicketsTaken = wicketsTaken;
	}



	public Long getTeamId() {
		return teamId;
	}

	public void setTeamId(Long teamId) {
		this.teamId = teamId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAbbreviation() {
		return abbreviation;
	}

	public void setAbbreviation(String abbreviation) {
		this.abbreviation = abbreviation;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public Integer getMaxAge() {
		return maxAge;
	}

	public void setMaxAge(Integer maxAge) {
		this.maxAge = maxAge;
	}

	public Double getBattingAvg() {
		return battingAvg;
	}

	public void setBattingAvg(Double battingAvg) {
		this.battingAvg = battingAvg;
	}

	public Integer getWicketsTaken() {
		return wicketsTaken;
	}

	public void setWicketsTaken(Integer wicketsTaken) {
		this.wicketsTaken = wicketsTaken;
	}

	@Override
	public String toString() {
		return "Team [teamId=" + teamId + ", name=" + name + ", abbreviation=" + abbreviation + ", owner=" + owner
				+ ", maxAge=" + maxAge + ", battingAvg=" + battingAvg + ", wicketsTaken=" + wicketsTaken + "]";
	}
	
	
}
