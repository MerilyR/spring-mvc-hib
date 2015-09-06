package com.sprhib.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="teams")
public class Team {
	
	@Id
	@GeneratedValue
	private Integer id;
	
	private String name;
	
	private Integer rating;
	
	@Column (name="organization_id", updatable = false)
	private Integer organization_id;
	
	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(name="teammembers",
			joinColumns=@JoinColumn(name="team_id"),
			inverseJoinColumns=@JoinColumn(name="member_id"))	
	private List<Member> members;
	
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
	public Integer getRating() {
		return rating;
	}
	public void setRating(Integer rating) {
		this.rating = rating;
	}

	public List<Member> getMembers() {
		return members;
	}
	public void setMembers(List<Member> members) {
		this.members = members;
	}

	public Integer getOrganization_id() {
		return organization_id;
	}
	
	public void setOrganization_id(Integer organization_id) {
		this.organization_id = organization_id;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Team) {
			Team that = (Team) obj;
			return getId()==that.getId() && 
					getName() == that.getName() &&
					getRating() == that.getRating() &&
					getMembers() != null &&
					getMembers().containsAll(that.getMembers())
					;
		}
		return false;
	}
	
	@Override
	public int hashCode() {
		return (id.hashCode()+name.hashCode()+rating.hashCode()
				+ (members != null ? members.hashCode() : 0 )
				);
	}
	
	@Override
	public String toString() {
		return getName();
	}

}
