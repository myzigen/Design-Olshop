package com.github.dapitramdhan;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.ColorStateListDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;

import android.view.Menu;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.core.content.res.ColorStateListInflaterCompat;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.ViewCompat;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.button.MaterialButton;
import com.squareup.picasso.Picasso;
import android.view.View;
import androidx.core.widget.NestedScrollView;

public class DetailActivity extends AppCompatActivity {

	public static final String EXTRA_URL = "imageUrl";
	public static final String EXTRA_CREATOR = "creatorName";
	public static final String EXTRA_LIKES = "likeCount";
	private Toolbar toolbar;
	private Drawable drawableToolbar, iconBack;
	private View mHeader;
	private AppBarLayout appBarLayout;
	private ImageButton buttonBack1, buttonBack2, buttonBack3;
	private ToolbarFadeOnScrolling scrool;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_detail);

		toolbar = findViewById(R.id.produkToolbar);
		toolbar.setTitle("");
		setSupportActionBar(toolbar);
		//getSupportActionBar().setDisplayHomeAsUpEnabled(true);
		//getSupportActionBar().setDisplayShowHomeEnabled(true);
		//toolbar.getNavigationIcon().setColorFilter(getResources().getColor(R.color.black), PorterDuff.Mode.SRC_ATOP);

		drawableToolbar = getResources().getDrawable(R.drawable.warna_utama);
		toolbar.setBackgroundDrawable(drawableToolbar);
		drawableToolbar.setAlpha(0);
		mHeader = findViewById(R.id.image_view_detail);
		appBarLayout = findViewById(R.id.appbar);
		buttonBack1 = findViewById(R.id.button_back1);
		buttonBack2 = findViewById(R.id.button_back2);
		buttonBack3 = findViewById(R.id.button_back3);
		iconBack = getResources().getDrawable(R.drawable.oval_rounded);
		buttonBack1.setBackgroundDrawable(iconBack);
		buttonBack2.setBackgroundDrawable(iconBack);
		buttonBack3.setBackgroundDrawable(iconBack);
		iconBack.setAlpha(0);

		((ToolbarFadeOnScrolling) findViewById(R.id.scroll_produk_detail))
				.setOnScrollChangedListener(mOnScrollChangedListener);

		Intent intent = getIntent();
		String imageUrl = intent.getStringExtra(EXTRA_URL);
		String creatorName = intent.getStringExtra(EXTRA_CREATOR);
		int likeCount = intent.getIntExtra(EXTRA_LIKES, 0);

		ImageView imageView = findViewById(R.id.image_view_detail);
		TextView textViewCreator = findViewById(R.id.text_view_creator_detail);
		TextView textViewLikes = findViewById(R.id.text_view_like_detail);

		Picasso.with(this).load(imageUrl).fit().centerInside().into(imageView);
		textViewCreator.setText(creatorName);
		textViewLikes.setText("Likes:" + likeCount);

	}

	// github dapitramdhan Toolbar Fade

	private ToolbarFadeOnScrolling.OnScrollChangedListener mOnScrollChangedListener = new ToolbarFadeOnScrolling.OnScrollChangedListener() {
		public void onScrollChanged(NestedScrollView who, int l, int t, int oldl, int oldt) {
			final int headerHeight = toolbar.getHeight();
			final float ratio = (float) Math.min(Math.max(t, 0), headerHeight) / headerHeight;
			final int newAlpha = (int) (ratio * 255);

			updateIconBar(ratio);
			drawableToolbar.setAlpha(newAlpha);
			iconBack.setAlpha(newAlpha);

		}
	};

	private void updateIconBar(float scrollRatio) {
		boolean isVisible = true;
		int scrollRange = -2;
		final int iconAlpha = (int) (scrollRatio * 255);

		if (scrollRange == -2) {
			scrollRange = appBarLayout.getTotalScrollRange();
		}
		if (scrollRange + scrollRatio == 0) {
			buttonBack1.setAlpha(200);
			buttonBack2.setAlpha(200);
			buttonBack3.setAlpha(200);
			buttonBack1.setColorFilter(getResources().getColor(R.color.black), PorterDuff.Mode.SRC_ATOP);
			buttonBack2.setColorFilter(getResources().getColor(R.color.black), PorterDuff.Mode.SRC_ATOP);
			buttonBack3.setColorFilter(getResources().getColor(R.color.black), PorterDuff.Mode.SRC_ATOP);

		} else if (isVisible) {
			buttonBack1.setAlpha(iconAlpha);
			buttonBack2.setAlpha(iconAlpha);
			buttonBack3.setAlpha(iconAlpha);
			buttonBack1.setColorFilter(getResources().getColor(R.color.white), PorterDuff.Mode.SRC_ATOP);
			buttonBack2.setColorFilter(getResources().getColor(R.color.white), PorterDuff.Mode.SRC_ATOP);
			buttonBack3.setColorFilter(getResources().getColor(R.color.white), PorterDuff.Mode.SRC_ATOP);

		}
	}

	@Override
	public boolean onSupportNavigateUp() {
		onBackPressed();
		return true;
	}

	//	@Override
	//	public boolean onCreateOptionsMenu(Menu menu) {
	//		getMenuInflater().inflate(R.menu.menu_detail_produk, menu);

	//		for (int i = 0; i < menu.size(); i++) {
	//			Drawable drawable = menu.getItem(i).getIcon();
	//			if (drawable != null) {
	//				drawable.mutate();
	//		drawable.setColorFilter(getResources().getColor(R.color.black), PorterDuff.Mode.SRC_ATOP);
	//			}
	//		}
	//		return true;
}

//toolbar.getNavigationIcon().setColorFilter(getResources().getColor(R.color.white),
//					PorterDuff.Mode.SRC_ATOP);
//	if (t > 0 && headerHeight > 0)
//				ratio = (float) Math.min(Math.max(t, 0), headerHeight) / headerHeight;
//	if (t > 0 && appbarHeight > 0)
//ratio = (float) Math.min(Math.max(t, 0), appbarHeight) / appbarHeight;
