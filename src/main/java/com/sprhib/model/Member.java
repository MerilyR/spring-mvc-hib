package com.sprhib.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="members")
public class Member {
	@Id
	@GeneratedValue
	private Integer id;
	
	private String name;
	
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
