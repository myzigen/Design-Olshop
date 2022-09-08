package com.github.dapitramdhan.ProdukActivity;

public class Produk {

	private String mImageUrl;
	private String mCreator;
	private int mLikes;

	public Produk(String imageUrl, String creator, int likes) {
		mImageUrl = imageUrl;
		mCreator = creator;
		mLikes = likes;

	}

	public String getImageUrl() {
		return mImageUrl;
	}

	public String getCreator() {
		return mCreator;
	}

	public int getLikesCount() {
		return mLikes;
	}

}