package com.masai.DTO;

//name, price, quantity, description, sold_status, category, seller_id 

public class ItemDTO {
    
    private int id;
    private String name;
    private double price;
    @SuppressWarnings("unused")
	private int quantity;
    private String description;
    private int sold_status;
    private String category;
    private int seller_id;
    
    

    public ItemDTO(int id, String name, double price, int quantity, String description, int sold_status,
			String category, int seller_id) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.quantity = quantity;
		this.description = description;
		this.sold_status = sold_status;
		this.category = category;
		this.seller_id = seller_id;
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

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getSold_status() {
		return sold_status;
	}

	public void setSold_status(int sold_status) {
		this.sold_status = sold_status;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public int getSeller_id() {
		return seller_id;
	}

	public void setSeller_id(int seller_id) {
		this.seller_id = seller_id;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
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

	public int getSellerId() {
		// TODO Auto-generated method stub
		return 0;
	}



	public void setSellerId(int userId) {
		// TODO Auto-generated method stub
		
	}



//	@Override
//	public String toString() {
//		return "ItemDTO [id=" + id + ", name=" + name + ", price=" + price + ", quantity=" + quantity + ", description="
//				+ description + ", sold_status=" + sold_status + ", category=" + category + ", seller_id=" + seller_id
//				+ "]";
//	}
//	
	
	
	
}

