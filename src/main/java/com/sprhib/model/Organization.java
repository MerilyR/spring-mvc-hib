package com.sprhib.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="organizations")
public class Organization {

	@Id
	@GeneratedValue
	private Integer id;
	
	private String name;

	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="organization_id")	
	private List<Team> teams;
	
//	/**
//	 * For testing Organization, Teams, Members and team-member relations arriving to database
//	 */
//	public Organization() {
//		Team team = new Team();
//		team.setName("default");
//		team.setRating(1);
//		Member member = new Member();
//		member.setName("member1");	
//		team.setMembers(Arrays.asList(member));
//		setTeams(Arrays.asList(team));
//	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Team> getTeams() {
		return teams;
	}

	public void setTeams(List<Team> teams) {
		this.teams = teams;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Organization) {
			Organization that = (Organization) obj;
			return getId()==that.getId() && 
					getName() == that.getName() &&
					getTeams() != null &&
					getTeams().containsAll(that.getTeams());
		}
		return false;
	}	
	
	@Override
	public int hashCode() {
		return ( id.hashCode()+name.hashCode() + (teams != null ? teams.hashCode() : 0 ) );
	}
	
	@Override
	public String toString() {
		return getName();
	}
	
}
