package com.masai.DTO;


public class GSTDTO {
    private int id;
    private String category;
    private double rate;
    
    
    public GSTDTO(int id, String category, double rate) {
    	super();
    	this.id = id;
    	this.category = category;
    	this.rate = rate;
    }
    
    public GSTDTO(String string, float float1) {
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public double getRate() {
		return rate;
	}

	public void setRate(double rate) {
		this.rate = rate;
	}

	@Override
	public String toString() {
		return "GSTDTO [id=" + id + ", category=" + category + ", rate=" + rate + "]";
	}


	
	
}


