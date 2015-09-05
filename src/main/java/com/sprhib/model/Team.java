package com.sprhib.model;

import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
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
	
	private ArrayList<Member> members;
	
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

	@ManyToMany
	public ArrayList<Member> getMembers() {
		return members;
	}
	public void setMembers(ArrayList<Member> members) {
		this.members = members;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Team) {
			Team that = (Team) obj;
			return this.getId()==that.getId() && 
					this.getName() == that.getName() &&
					this.getRating() == that.getRating() &&
					this.getMembers() != null &&
					this.getMembers().containsAll(that.getMembers());
		}
		return false;
	}
	
	@Override
	public int hashCode() {
		return (id.hashCode()+name.hashCode()+rating.hashCode()+members.hashCode());
	}
	
	@Override
	public String toString() {
		return "Team [name="+this.getName()+
				"; rating="+this.getRating()+ 
				"; Number of Members = "+this.getMembers().size()+"]";
	}
}
