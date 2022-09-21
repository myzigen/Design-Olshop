package com.github.dapitramdhan.ProdukActivity;

public class ProdukFlashsale {
	private String mImageUrlFlashsale;
	private String mNamaProdukFlashsale;
	private int mLikes2;

	public ProdukFlashsale(String imageUrlFlashsale, String namaProdukFlashsale, int likes2) {
		mImageUrlFlashsale = imageUrlFlashsale;
		mNamaProdukFlashsale = namaProdukFlashsale;
		mLikes2 = likes2;

	}

	public String getImageUrlFlashsale() {
		return mImageUrlFlashsale;
	}

	public String getNamaProdukFlashsale() {
		return mNamaProdukFlashsale;
	}

	public int getLikesCount() {
		return mLikes2;
	}
}