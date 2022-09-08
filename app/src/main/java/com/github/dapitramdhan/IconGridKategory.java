package com.github.dapitramdhan;

public class IconGridKategory {
	private int id;
	private String title;
	private int image;

	public IconGridKategory(int id, String title, int image) {
		this.id = id;
		this.title = title;
		this.image = image;
	}

	public int getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public int getImage() {
		return image;
	}
}