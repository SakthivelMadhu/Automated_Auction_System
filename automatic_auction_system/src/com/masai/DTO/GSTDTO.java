package com.masai.DTO;


public class GSTDTO {
    private int id;
    private double rate;
    
    public GSTDTO(int id, double rate) {
        this.id = id;
        this.rate = rate;
    }
    
    public GSTDTO(String string, float float1) {
		// TODO Auto-generated constructor stub
	}

	public int getId() {
        return id;
    }
    
    public double getRate() {
        return rate;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public void setRate(double rate) {
        this.rate = rate;
    }

	public String getCategory() {
		// TODO Auto-generated method stub
		return null;
	}
}


