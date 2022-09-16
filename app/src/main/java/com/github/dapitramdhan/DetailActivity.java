package com.github.dapitramdhan;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.ColorStateListDrawable;
import android.graphics.drawable.Drawable;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;

import android.view.Menu;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
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
import com.google.android.material.snackbar.Snackbar;
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
	private WebView webView;

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

		drawableToolbar = getResources().getDrawable(R.drawable.warna_utama_white);
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
		buttonBack1.setColorFilter(getResources().getColor(R.color.white), PorterDuff.Mode.SRC_ATOP);
		buttonBack2.setColorFilter(getResources().getColor(R.color.white), PorterDuff.Mode.SRC_ATOP);
		buttonBack3.setColorFilter(getResources().getColor(R.color.white), PorterDuff.Mode.SRC_ATOP);

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
		
		webView = findViewById(R.id.deskripsi_produk);
		// Deskripsi WebView
		ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);

		// Check internet Connection 
		if (connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE)
				.getState() == NetworkInfo.State.CONNECTED
				|| connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI)
						.getState() == NetworkInfo.State.CONNECTED) {

			webView.setWebViewClient(new WebViewClient());
			webView.loadUrl("file:///android_asset/deskripsi_produk.html");
			//webView.loadUrl("https://google.com");

			//LOADING .html FILE WITH ANDROID WebView 

			WebSettings webSetting = webView.getSettings();
			webSetting.setJavaScriptEnabled(true);

			/*
			 *  Solve this
			 *
			 *  net::ERR_CLEARTEXT_NOT_PERMITTED
			 *
			 * Add this Code to Manifest File
			 *
			 * <application
			 * ....
			 * android:usesCleartextTraffic="true"
			 * ....>
			 *
			 * */

		} else {

			// if no internet
			Snackbar.make(findViewById(R.id.deskripsi_produk), "Tidak Ada Koneksi Internet", Snackbar.LENGTH_SHORT).show();

		}

		buttonBack1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent back = new Intent(DetailActivity.this, MainActivity.class);
				back.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
				startActivity(back);
				finish();
			}
		});

		buttonBack3.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent share = new Intent(Intent.ACTION_SEND);
				share.putExtra(share.EXTRA_TEXT, "Aku Share Ya");
				share.setType("text/plain");
				startActivity(Intent.createChooser(share, "share to"));
			}
		});

	}

	// github dapitramdhan Toolbar Fade

	private ToolbarFadeOnScrolling.OnScrollChangedListener mOnScrollChangedListener = new ToolbarFadeOnScrolling.OnScrollChangedListener() {
		public void onScrollChanged(NestedScrollView who, int l, int t, int oldl,int oldt) {
			View decor = getWindow().getDecorView();
			final int headerHeight = mHeader.getHeight() - toolbar.getHeight() - appBarLayout.getTotalScrollRange();
			final float ratio = (float) Math.min(Math.max(t, 0), headerHeight) / headerHeight;
			final float ratioRange = (float) Math.min(Math.max(300f - t, + 0.0f), headerHeight) / headerHeight;
			final int newAlpha = (int) (ratio * 255);
			final int newAlphaIcon = (int) (ratioRange * 300f);

			if (t + ratio == 0) {

				iconBack.setAlpha(300);
				buttonBack1.setAlpha(255);
				buttonBack2.setAlpha(255);
				buttonBack3.setAlpha(255);
				buttonBack1.setColorFilter(getResources().getColor(R.color.white), PorterDuff.Mode.SRC_ATOP);
				buttonBack2.setColorFilter(getResources().getColor(R.color.white), PorterDuff.Mode.SRC_ATOP);
				buttonBack3.setColorFilter(getResources().getColor(R.color.white), PorterDuff.Mode.SRC_ATOP);
				decor.setSystemUiVisibility(0);

			} else {
				iconBack.setAlpha(newAlphaIcon);
				buttonBack1.setAlpha(newAlpha);
				buttonBack2.setAlpha(newAlpha);
				buttonBack3.setAlpha(newAlpha);
				buttonBack1.setColorFilter(getResources().getColor(R.color.colorPrimary), PorterDuff.Mode.SRC_ATOP);
				buttonBack2.setColorFilter(getResources().getColor(R.color.colorPrimary), PorterDuff.Mode.SRC_ATOP);
				buttonBack3.setColorFilter(getResources().getColor(R.color.colorPrimary), PorterDuff.Mode.SRC_ATOP);
				//getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
				decor.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);

			}

			drawableToolbar.setAlpha(newAlpha);

		}
	};

	@Override
	public boolean onSupportNavigateUp() {
		onBackPressed();
		return true;
	}

	/*	@Override
		public boolean onCreateOptionsMenu(Menu menu) {
			getMenuInflater().inflate(R.menu.menu_detail_produk, menu);

			for (int i = 0; i < menu.size(); i++) {
				Drawable drawable = menu.getItem(i).getIcon();
				if (drawable != null) {
					drawable.mutate();
			drawable.setColorFilter(getResources().getColor(R.color.black), PorterDuff.Mode.SRC_ATOP);
				}
			}
			return true; 
	*/
}

/* toolbar.getNavigationIcon().setColorFilter(getResources().getColor(R.color.white),
					PorterDuff.Mode.SRC_ATOP);
	if (t > 0 && headerHeight > 0)
				ratio = (float) Math.min(Math.max(t, 0), headerHeight) / headerHeight;
	if (t > 0 && appbarHeight > 0)
ratio = (float) Math.min(Math.max(t, 0), appbarHeight) / appbarHeight; 
*/