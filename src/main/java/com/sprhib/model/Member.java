package com.sprhib.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="members")
public class Member {
	@Id
	@GeneratedValue
	private Integer id;
	
	private String name;
	
//	@ManyToMany(
//	        cascade = {CascadeType.PERSIST, CascadeType.MERGE},
//	        mappedBy = "teams",
//	        targetEntity = Team.class
//    )
	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(name="teammembers",
			joinColumns=@JoinColumn(name="member_id"),
			inverseJoinColumns=@JoinColumn(name="team_id"))	
	private List<Team> teams;
	
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
	
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Member) {
			Member that = (Member) obj;
			return this.getId()==that.getId() && 
					this.getName() == that.getName();
		}
		return false;
	}
	
	@Override
	public int hashCode() {
		return (id.hashCode()+name.hashCode());
	}
	
	@Override
	public String toString() {
		return "Member [name="+this.getName()+"]";
	}
}
