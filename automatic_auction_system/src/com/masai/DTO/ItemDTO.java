package com.masai.DTO;



public class ItemDTO {
    private int id;
    private String name;
    private String description;
    private String category;
    private int sellerId;
    private int buyerId;
    private double price;
    private boolean available;

    public ItemDTO(int id, String name, String description, String category, int sellerId, int buyerId, double price, boolean available) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.category = category;
        this.sellerId = sellerId;
        this.buyerId = buyerId;
        this.price = price;
        this.available = available;
    }

    public ItemDTO(int int1, String string, float float1, int int2, String string2, int int3, String string3, int int4,
			int int5) {
		// TODO Auto-generated constructor stub
	}

	public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getSellerId() {
        return sellerId;
    }

    public void setSellerId(int sellerId) {
        this.sellerId = sellerId;
    }

    public int getBuyerId() {
        return buyerId;
    }

    public void setBuyerId(int buyerId) {
        this.buyerId = buyerId;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

	public int getItemId() {
		// TODO Auto-generated method stub
		return 0;
	}

	public int getSoldStatus() {
		// TODO Auto-generated method stub
		return 0;
	}

	public int getQuantity() {
		// TODO Auto-generated method stub
		return 0;
	}
}

