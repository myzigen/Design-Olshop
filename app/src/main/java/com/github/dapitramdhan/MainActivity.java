package com.github.dapitramdhan;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.badge.BadgeDrawable;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import androidx.fragment.app.Fragment;

public class MainActivity extends AppCompatActivity {

	private BottomNavigationView bottomNavigationView;
	private BadgeDrawable badge;
	private String updateStatusBarColor;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		bottomNavigationView = findViewById(R.id.bottomnavigation);
	//	CoordinatorLayout.LayoutParams layoutParams = (CoordinatorLayout.LayoutParams) bottomNavigationView.getLayoutParams();
	//	layoutParams.setBehavior(new BottomNavigationBehavior());
		badge = bottomNavigationView.getOrCreateBadge(R.id.transaksiNav);
		badge.setVisible(true);
		badge.setNumber(9);
		badge.setMaxCharacterCount(3);
		badge.setVerticalOffset(dpToPx(this, 3));
		badge.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark));
		getSupportFragmentManager().beginTransaction().replace(R.id.container, new HomeUtama()).commit();
		bottomNavigationView
				.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
					@Override
					public boolean onNavigationItemSelected(MenuItem item) {
						Fragment pilihFragment = null;
						switch (item.getItemId()) {
						case R.id.homeNav:
							pilihFragment = new HomeUtama();
							break;
						case R.id.feedNav:
							pilihFragment = new FragmentKategori();
							break;
						case R.id.KategoriNav:
							pilihFragment = new FragmentFeed();
							break;
						case R.id.transaksiNav:
							pilihFragment = new FragmentPesanan();
							break;
						case R.id.akunNav:
							pilihFragment = new FragmentAkun();
							break;
						}
						getSupportFragmentManager().beginTransaction().replace(R.id.container, pilihFragment).commit();
						return true;
					}
				});
	}

	public int dpToPx(Context c, int dp) {
		Resources r = c.getResources();
		return Math.round(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, r.getDisplayMetrics()));
	}

	

}