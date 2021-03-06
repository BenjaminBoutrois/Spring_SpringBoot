package com.example.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Formation
{
	// Fields
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String theme;
	private String description;
	
	// Constructors
	
	public Formation()
	{
		super();
	}
	
	// Properties
	
	public Long getId()
	{
		return id;
	}
	public void setId(Long id)
	{
		this.id = id;
	}
	public String getTheme()
	{
		return theme;
	}
	public void setTheme(String theme)
	{
		this.theme = theme;
	}
	public String getDescription()
	{
		return description;
	}
	public void setDescription(String description)
	{
		this.description = description;
	}

	@Override
	public String toString()
	{
		return "Formation [id=" + id + ", theme=" + theme + ", description=" + description + "]";
	}
}
