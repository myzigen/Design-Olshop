package com.github.dapitramdhan;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.LayoutInflater;
import android.view.WindowInsets;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.ViewCompat;
import androidx.fragment.app.Fragment;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.FragmentContainerView;
import androidx.recyclerview.widget.RecyclerView;
import com.github.dapitramdhan.productlist.ModelPerson;
import java.util.ArrayList;
import java.util.List;

public class HomeUtama extends Fragment {

	private Toolbar toolbar;
	private Drawable mActionBarBackgroundDrawable;
	private View mHeader;
	

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.home_utama, container, false);
		return view;
	}

	@Override
	public void onViewCreated(View view, Bundle savedInstanceState) {
		super.onViewCreated(view, savedInstanceState);

		toolbar = view.findViewById(R.id.toolbar);
		getActivity().getWindow().setStatusBarColor(getActivity().getColor(R.color.colorPrimary));
		((AppCompatActivity) getActivity()).getDelegate().setSupportActionBar(toolbar);
		mActionBarBackgroundDrawable = getResources().getDrawable(R.drawable.warna_utama);
		toolbar.setBackgroundDrawable(mActionBarBackgroundDrawable);
		mActionBarBackgroundDrawable.setAlpha(0);
		((ToolbarFadeOnScrolling) view.findViewById(R.id.scrollview))
				.setOnScrollChangedListener(mOnScrollChangedListener);
		

		// 

	}

	// github dapitramdhan Toolbar Fade
	private ToolbarFadeOnScrolling.OnScrollChangedListener mOnScrollChangedListener = new ToolbarFadeOnScrolling.OnScrollChangedListener() {
		public void onScrollChanged(NestedScrollView who, int l, int t, int oldl, int oldt) {
			final int headerHeight = toolbar.getHeight();
			final float ratio = (float) Math.min(Math.max(t, 0), headerHeight) / headerHeight;
			final int newAlpha = (int) (ratio * 255);
			mActionBarBackgroundDrawable.setAlpha(newAlpha);

		}
	};

}