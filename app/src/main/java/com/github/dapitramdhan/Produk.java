package com.github.dapitramdhan;

public class Produk {
	private int id;
	private String title;
	private String shortDesc;
	private double rating;
	private double price;
	private int image;

	public Produk(int id, String title, double price, double rating, int image) {
		this.id = id;
		this.title = title;
		this.price = price;
		this.rating = rating;
		this.image = image;
	}

	public int getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public double getPrice() {
		return price;
	}

	public double getRating() {
		return rating;
	}

	public int getImage() {
		return image;
	}
}