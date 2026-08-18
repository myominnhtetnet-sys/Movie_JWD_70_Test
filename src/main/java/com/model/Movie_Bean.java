package com.model;

import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter@Setter@ToString
public class Movie_Bean {
	
	public int id;
	public String title;
	public String preShow;
	public LocalDate releseYear;
	public String duction;
	public int categoryId;
	

}
