package com.sprhib.model;

import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="organizations")
public class Organization {

	@Id
	@GeneratedValue
	private Integer id;
	
	private String name;
	
	private ArrayList<Team> teams;

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

	@OneToMany
	public ArrayList<Team> getTeams() {
		return teams;
	}

	public void setTeams(ArrayList<Team> teams) {
		this.teams = teams;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Organization) {
			Organization that = (Organization) obj;
			return this.getId()==that.getId() && 
					this.getName() == that.getName() &&
					this.getTeams() != null &&
					this.getTeams().containsAll(that.getTeams());
		}
		return false;
	}	
	
	@Override
	public int hashCode() {
		return (id.hashCode()+name.hashCode()+teams.hashCode());
	}
	
	@Override
	public String toString() {
		return "Organization [name="+this.getName()+
				"; Number of teams = "+this.getTeams().size()+"]";
	}
	
}
